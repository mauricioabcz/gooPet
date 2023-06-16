package com.gooPet.Com.Database;

import com.gooPet.Com.Database.Entities.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author mauricio.rodrigues
 */

public class ComercialDatabaseManager {
    
    private EntityManagerFactory emf;
    private static ComercialDatabaseManager banco;
    
    private ComercialDatabaseManager() {
        emf = Persistence.createEntityManagerFactory("myPU");
    }
    
    public static ComercialDatabaseManager getInstance() {
        if(ComercialDatabaseManager.banco == null)
            ComercialDatabaseManager.banco = new ComercialDatabaseManager();
        return ComercialDatabaseManager.banco;
      }
 
    public List<Product> getProducts() {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        try {
            String jpql = "SELECT ut FROM Product ut";
            TypedQuery<Product> query = em.createQuery(jpql, Product.class);
            return query.getResultList();
            
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public int createProduct(Product product){
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // Consulta para verificar se já existe um Produto com o mesmo nome e marca
            String jpql = "SELECT COUNT(t) FROM Product t WHERE t.nome = :name and t.marca = :marca";
            TypedQuery<Long> query = em.createQuery(jpql, Long.class);
            query.setParameter("name", product.getNome());
            query.setParameter("marca", product.getMarca());

            Long count = query.getSingleResult();

            if (count > 0) {
                // Já existe um Produto com o mesmo nome e marca, lançar exceção
                return -1;
            }

            // Não existe produto com o mesmo nome e marca, criar um novo
            tx.begin();
            em.persist(product);
            tx.commit();
            return 0;
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateProduct(Product product) {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            emf = Persistence.createEntityManagerFactory("myPU");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // Atualizar o produto na tabela
            em.merge(product);

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
     
    public void deleteProduct(Product product) {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            emf = Persistence.createEntityManagerFactory("myPU");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // Carregar o produto pelo ID
            Product productId = em.find(Product.class, product.getId());
            
            if (productId != null) {
                // Excluir o grupo o produto
                em.remove(productId);
            }
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
     
}
