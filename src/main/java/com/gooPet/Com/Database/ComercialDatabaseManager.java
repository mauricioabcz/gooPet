package com.gooPet.Com.Database;

import com.gooPet.Auth.Database.Entities.User;
import com.gooPet.Com.Database.Entities.Cart;
import com.gooPet.Com.Database.Entities.CartProduct;
import com.gooPet.Com.Database.Entities.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
 
    //Gerenciamento de Produto
    
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
    
    public List<Product> productSearch(String textSearch) {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        try {
            String jpql = "SELECT ut FROM Product ut WHERE ut.nome LIKE :name";
            TypedQuery<Product> query = em.createQuery(jpql, Product.class);
            query.setParameter("name", "%" + textSearch + "%");
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
                // Excluir o produto
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
    
    //Gerenciamento de Carrinho
    
    public int createCart(Cart cart){
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // Consulta para verificar se já existe um carrinho com o mesmo user e aberto
            String jpql = "SELECT COUNT(t) FROM Cart t WHERE t.user.id = :userid and t.isClosed = :closestatus";
            TypedQuery<Long> query = em.createQuery(jpql, Long.class);
            System.out.println(cart.getUser().getId());
            query.setParameter("userid", cart.getUser().getId());
            query.setParameter("closestatus", 0);

            Long count = query.getSingleResult();

            if (count > 0) {
                // Já existe um carrinho com o mesmo user e aberto, lançar exceção
                return -1;
            }

            // Não existe carrinho com o mesmo user e aberto, criar um novo
            tx.begin();
            em.persist(cart);
            tx.commit();
            return 0;
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public int createCartProduct(CartProduct cartProduct){
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(cartProduct);
            tx.commit();
            return 0;
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public Cart getCartByUser(User user) {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        try {
            Query cartQuery = em.createQuery("SELECT u FROM Cart u WHERE u.user.id = :userId");
            cartQuery.setParameter("userId", user.getId());
            List<Cart> listCarts = cartQuery.getResultList();
            for (Cart cart : listCarts) {
                if (cart.getIsClosed() == 0) {
                    return cart;
                }
            }
            return null;
        } finally {
            em.close();
        }
    }
    
    public List<CartProduct> getCartProductByCart(Cart cart) {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        try {
            Query cartQuery = em.createQuery("SELECT u FROM CartProduct u WHERE u.cart.id = :cartId");
            cartQuery.setParameter("cartId", cart.getId());
            List<CartProduct> cartProducts = cartQuery.getResultList();
            return cartProducts;
            
        } finally {
            em.close();
        }
    }
    
    public void updateCart(Cart cart) {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            emf = Persistence.createEntityManagerFactory("myPU");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // Atualizar o carrinho na tabela
            em.merge(cart);

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
    
    public void updateCartProduct(CartProduct cartProduct) {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            emf = Persistence.createEntityManagerFactory("myPU");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // Atualizar o carrinho/produto na tabela
            em.merge(cartProduct);

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
     
    public void deleteCart(Cart cart) {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            emf = Persistence.createEntityManagerFactory("myPU");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // Carregar o carrinho pelo ID
            Cart cartId = em.find(Cart.class, cart.getId());
            
            if (cartId != null) {
                // Excluir o carrinho
                em.remove(cartId);
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
    
    public void deleteCartProduct(CartProduct cartProduct) {
        emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            emf = Persistence.createEntityManagerFactory("myPU");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // Carregar o carrinho pelo ID
            CartProduct cartProductId = em.find(CartProduct.class, cartProduct.getId());
            
            if (cartProductId != null) {
                // Excluir o carrinho
                em.remove(cartProductId);
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
