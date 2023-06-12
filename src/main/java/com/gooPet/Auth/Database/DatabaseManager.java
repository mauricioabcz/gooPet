package com.gooPet.Auth.Database;

import com.gooPet.Auth.Database.Entities.Config;
import com.gooPet.Auth.Database.Entities.User;
import com.gooPet.Auth.Database.Entities.UserType;
import com.gooPet.Auth.Security.Security;
import com.gooPet.Auth.Log.Log;
import com.gooPet.View.ReturnMessagePane;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Date;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author mauricio.rodrigues
 */
public class DatabaseManager {
    
    private EntityManagerFactory emf;
    private Security security;
    private static DatabaseManager banco;
    
    private DatabaseManager() {
        emf = Persistence.createEntityManagerFactory("myPU");
        security = Security.getInstance();
    }
    
    public static DatabaseManager getInstance() {
        if(DatabaseManager.banco == null)
            DatabaseManager.banco = new DatabaseManager();
        return DatabaseManager.banco;
      }
    
    public void createUserType(String name, String description){
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // Consulta para verificar se já existe um UserType com o mesmo nome
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Verificando se já existe um grupo de usuário de mesmo nome na base de dados.");
            String jpql = "SELECT COUNT(t) FROM UserType t WHERE t.nome = :name";
            TypedQuery<Long> query = em.createQuery(jpql, Long.class);
            query.setParameter("name", name);

            Long count = query.getSingleResult();

            if (count > 0) {
                // Já existe um UserType com o mesmo nome, lançar exceção
                Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Verificando se já existe um grupo de usuário com o nome " + name + "na base de dados.");
                ReturnMessagePane.errorPainel("Já existe um Grupo com esse nome.");
                throw new IllegalArgumentException("Já existe um Grupo com esse nome." + name);
            }

            // Não existe UserType com o mesmo nome, criar um novo
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "UserType não encontrado, será incluído na base de dados.");
            tx.begin();
            UserType userType = new UserType(name, description, new Date());
            em.persist(userType);
            tx.commit();
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "UserType criado com sucesso " + userType.toString());
        } finally {
            em.close();
            emf.close();
        }
    }

    
    public void createUser(String nome, String email, String passwordHash, String userTypeName) throws InvalidKeySpecException, Exception {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        try {
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Verificando se já existe um usuário com o mesmo email na base de dados.");
            // Verificar se já existe um usuário com o mesmo e-mail
            Query emailQuery = em.createQuery("SELECT u FROM User u WHERE u.email = :email");
            emailQuery.setParameter("email", email);
            List<User> usersWithEmail = emailQuery.getResultList();
            if (!usersWithEmail.isEmpty()) {
                Log.LogAuthenticationComponent("DatabaseManager", "INFO", "O email " + email + "já pertence a um usuário.");
                ReturnMessagePane.errorPainel("E-mail já está em uso.");
                throw new IllegalArgumentException("E-mail já está em uso.");
            }
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Usuário não encontrado na base de dados, será feita a inclusão.");

            // Obter o ID do tipo de usuário pelo nome
            Query typeQuery = em.createQuery("SELECT t.id FROM UserType t WHERE t.nome = :userTypeName");
            typeQuery.setParameter("userTypeName", userTypeName);
            UUID userTypeId = (UUID) typeQuery.getSingleResult();
            UserType userType = em.find(UserType.class, userTypeId);
            
            // Criar o objeto User e persistir no banco de dados
            User user = new User(nome, email, passwordHash, userType, new Date());
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Usuário criado com sucesso: " + user.toString());
        } finally {
            em.close();
        }
    }
    
    public void updateUser(User user) {
        Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Alterando User existente.");
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            emf = Persistence.createEntityManagerFactory("myPU");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // Atualizar o grupo de usuário na tabela
            em.merge(user);

            tx.commit();
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "User alterado com sucesso.");
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
    
    public void deleteUser(User user) {
        Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Excluindo User da base de dados.");
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            emf = Persistence.createEntityManagerFactory("myPU");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            User userRemove = em.find(User.class, user.getId());
            em.remove(userRemove);
            
            tx.commit();
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "User excluído com sucesso.");
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
    
    public int login(String email, String passwordHash) throws InvalidKeySpecException, Exception {
        //Inicializa
        emf = Persistence.createEntityManagerFactory("myPU");
        // Obter a instância do EntityManager a partir do EntityManagerFactory
        EntityManager em = emf.createEntityManager();
        try {
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Recuperando usuário do banco de dados.");
            // Consulta para buscar o usuário pelo email fornecido
            String jpql = "SELECT u FROM User u WHERE u.email = :email";
            TypedQuery<User> query = em.createQuery(jpql, User.class);
            query.setParameter("email", email);

            User user = query.getSingleResult(); // tenta obter o usuário

            // Verifica se o usuário foi encontrado
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Verificando usuário.");
            if (user != null) {
                // Se o usuário foi encontrado, verificar a senha
                if (security.decryptPassword(user.getPasswordHash()).equals(security.decryptPassword(passwordHash))) {
                    // Se a senha estiver correta, retorna SUCCESS
                    Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Login autorizado para o usuário: " + email);
                    return 1;
                } else {
                    // Senha incorreta
                    Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Senha incorreta para o usuário: " + email);
                    return 2;
                }
            } else {
                // Usuário não encontrado
                Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Usuário '" + email + "' não encontrado");
                return 3;
            }
        } catch (NoResultException e) {
            // Email não encontrado
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Email não encontrado.");
            return 4;
        } finally {
            // Fechar o EntityManager e o EntityManagerFactory
            em.close();
            emf.close();
        }
    }
    
    public UserType getUserTypeByEmail(String email) {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        try {
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Recuperando tipo do usuário: " + email);
            Query userQuery = em.createQuery("SELECT u FROM User u WHERE u.email = :email");
            userQuery.setParameter("email", email);
            List<User> usersWithEmail = userQuery.getResultList();

            if (!usersWithEmail.isEmpty()) {
                User user = usersWithEmail.get(0);
                UserType userType = user.getUserType();
                Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Usuário do tipo: " + userType.getNome());
                return userType;
            } else {
                Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Tipo de usuário não encontrado.");
                ReturnMessagePane.errorPainel("Tipo de usuário não encontrado.");
                throw new IllegalArgumentException("Tipo de usuário não encontrado.");
            }
        } finally {
            em.close();
        }
    }
    
    public List<User> getUser() {
        Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Buscando usuários da aplicação.");
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        try {
            String jpql = "SELECT ut FROM User ut";
            TypedQuery<User> query = em.createQuery(jpql, User.class);
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Retornando usuários da aplicação.");
            return query.getResultList();
            
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public List<UserType> getUserType() {
        Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Buscando grupos de usuários da aplicação.");
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        try {
            String jpql = "SELECT ut FROM UserType ut";
            TypedQuery<UserType> query = em.createQuery(jpql, UserType.class);
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Retornando grupos de usuários da aplicação.");
            return query.getResultList();
            
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public void alterarGrupoUsuario(UserType userType) {
        Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Alterando UserType existente.");
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            emf = Persistence.createEntityManagerFactory("myPU");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // Atualizar o grupo de usuário na tabela
            em.merge(userType);

            tx.commit();
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "UserType alterado com sucesso.");
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
    
    public void deleteGrupoUsuario(UserType userType) {
        Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Excluindo UserType da base de dados.");
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            emf = Persistence.createEntityManagerFactory("myPU");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // Carregar o grupo de usuário pelo ID
            UserType grupoUsuario = em.find(UserType.class, userType.getId());
            
            if (grupoUsuario != null) {
                // Excluir o grupo de usuário
                em.remove(grupoUsuario);
            }
            
            tx.commit();
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "UserType excluído com sucesso.");
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
    
    public void createConfig(Config config) {
        Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Verificando tabela Config");
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Verificar se já existe um registro na tabela
            TypedQuery<Config> query = em.createQuery("SELECT c FROM Config c", Config.class);
            List<Config> results = query.getResultList();

            if (!results.isEmpty()) {
                Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Atualizando registro da tabela Config");
                // Recuperar o ID do registro existente
                UUID configId = results.get(0).getId();
                config.setId(configId);

                // Atualizar o registro existente
                config = em.merge(config);
                Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Registro atualizado com sucesso");
            } else {
                Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Criando registro na tabela Config");
                // Inserir um novo registro
                em.persist(config);
                Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Registro criado com sucesso");
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public String getPrivateKey() {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        try {
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Recuperando PrivateKey na base de dados.");
            TypedQuery<Config> query = em.createQuery("SELECT c FROM Config c", Config.class);
            List<Config> results = query.getResultList();

            if (!results.isEmpty()) {
                Config config = results.get(0);
                Log.LogAuthenticationComponent("DatabaseManager", "INFO", "PrivateKey encontrada.");
                return config.getPrivateKey();
            }
        } finally {
            em.close();
        }

        return null; // ou lançar uma exceção informando que a chave privada não foi encontrada
    }

    public String getPublicKey() {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        try {
            Log.LogAuthenticationComponent("DatabaseManager", "INFO", "Recuperando PublicKey na base de dados.");
            TypedQuery<Config> query = em.createQuery("SELECT c FROM Config c", Config.class);
            List<Config> results = query.getResultList();

            if (!results.isEmpty()) {
                Config config = results.get(0);
                Log.LogAuthenticationComponent("DatabaseManager", "INFO", "PublicKey encontrada.");
                return config.getPublicKey();
            }
        } finally {
            em.close();
        }

        return null; // ou lançar uma exceção informando que a chave pública não foi encontrada
    }

}
