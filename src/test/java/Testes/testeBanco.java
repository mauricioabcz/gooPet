package Testes;

import com.gooPet.Auth.Database.DatabaseManager;
import com.gooPet.Auth.Database.Entities.User;
import com.gooPet.Auth.Database.Entities.UserType;
import com.gooPet.Auth.Security.Security;
import java.security.spec.InvalidKeySpecException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import org.junit.Test;

/**
 *
 * @author mauricio.rodrigues
 */
public class testeBanco {
    
    public testeBanco() {
    }
    
    @Test
    public void getUserTypeByEmail(){
        DatabaseManager banco = DatabaseManager.getInstance();
        UserType retorno = banco.getUserTypeByEmail("mauricio@gmail.com");
        System.out.println(retorno.getNome());
    }
    
    @Test
    public void testeCriarConfig(){
        Security sec = Security.getInstance();
        sec.generateKeyPair();
    }
    
    @Test
    public void testeCriaUserAndUserType() {
        // Cria uma instância do EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");

        // Cria uma instância do EntityManager
        EntityManager em = emf.createEntityManager();

        // Inicia uma transação
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Cria um objeto UserType e define seus atributos
        UserType userType = new UserType("Administrador", "Usuário com acesso total ao sistema", new Date());

        // Salva o objeto UserType no banco de dados
        em.persist(userType);

        // Cria um objeto User e define seus atributos, incluindo o userTypeId como o id do objeto UserType criado anteriormente
        User user = new User("João da Silva", "joao.silva@example.com", "123456", userType, new Date());

        // Salva o objeto User no banco de dados
        em.persist(user);

        // Finaliza a transação
        tx.commit();

        // Fecha o EntityManager
        em.close();

        // Fecha o EntityManagerFactory
        emf.close();
    }
    
    @Test
    public void criaUserType(){
        DatabaseManager banco = DatabaseManager.getInstance();
        banco.createUserType("Aluno", "Usuário com acesso de Aluno");
    }
    
    @Test
    public void criaUser() throws Exception{
        DatabaseManager banco = DatabaseManager.getInstance();
        banco.createUser("Maurício", "mauricio@gmail.com", "teste123", "Aluno");
    }
    
    @Test
    public void login() throws Exception{
        DatabaseManager banco = DatabaseManager.getInstance();
        int st = banco.login("mauricio@gmail.com", "teste123");

        switch (st) {
            case 1:
                System.out.println("Login bem sucedido");
                break;
            case 4:
                System.out.println("Email nao encontrado");
                break;
            case 2:
                System.out.println("Senha incorreta");
                break;
            case 3:
                System.out.println("Usuário nao encontrado");
                break;
            default:
                System.out.println("Erro desconhecido");
        }
    }
    
    @Test
    public void testeCript() throws InvalidKeySpecException, Exception{
        Security sec = Security.getInstance();
        DatabaseManager banco = DatabaseManager.getInstance();
        String senha = "teste123";
        
        String passwordHash = sec.encryptPassword(senha);
        
        String passwordHash2 = sec.decryptPassword(passwordHash);
        
        System.out.println(passwordHash);
        System.out.println(passwordHash2);
        
        System.out.println(passwordHash.equals(passwordHash2));
    }
    
}
