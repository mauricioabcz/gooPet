package Testes;

import com.gooPet.Auth.Database.DatabaseManager;
import com.gooPet.Auth.Database.Entities.User;
import com.gooPet.Com.Database.ComercialDatabaseManager;
import com.gooPet.Com.Database.Entities.Cart;
import com.gooPet.Com.Database.Entities.CartProduct;
import com.gooPet.Com.Database.Entities.Product;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import com.gooPet.Command.UpdateProductCommand;
import com.gooPet.Command.*;

/**
 *
 * @author mauricio.rodrigues
 */
public class createProduct {
    
    public createProduct() {
    }
    
    @Test
    public void geraCarrinhoCommand(){
        //Pega dados do banco
        ComercialDatabaseManager bancoCom = ComercialDatabaseManager.getInstance();
        DatabaseManager bancoAuth = DatabaseManager.getInstance();
        List<Product> listaProdutos = bancoCom.getProducts();
        List<User> listaUsers = bancoAuth.getUser();
        
        Cart cart = bancoCom.getCartByUser(listaUsers.get(0));
        
        // Criar comandos para adicionar e remover produtos
        CartProduct cartProduct = new CartProduct(cart, listaProdutos.get(2), 20);
        Command addProductCommand = new AddProductCommand(cart, cartProduct);
//        cartProduct = new CartProduct(cart, listaProdutos.get(0), 3);
//        Command removeProductCommand = new RemoveProductCommand(cart, cartProduct);

        // Gerenciar os comandos
        CartManager cartManager = new CartManager();
        cartManager.setCommand(addProductCommand);
        cartManager.executeCommand();
    }
    
    @Test
    public void geraCarrinho(){
        ComercialDatabaseManager bancoCom = ComercialDatabaseManager.getInstance();
        DatabaseManager bancoAuth = DatabaseManager.getInstance();
        List<Product> listaProdutos = bancoCom.getProducts();
        List<User> listaUsers = bancoAuth.getUser();
        
        Cart cart = new Cart(listaUsers.get(0), 0, 3.00, null, new Date());
        bancoCom.createCart(cart);
        
        cart = bancoCom.getCartByUser(listaUsers.get(0));
        
        CartProduct cartProduct = new CartProduct(cart, listaProdutos.get(0), 3);
        bancoCom.createCartProduct(cartProduct);
        
        cartProduct = new CartProduct(cart, listaProdutos.get(0), 5);
        bancoCom.createCartProduct(cartProduct);
    }
    
    @Test
    public void editaCarrinho(){
        ComercialDatabaseManager bancoCom = ComercialDatabaseManager.getInstance();
        DatabaseManager bancoAuth = DatabaseManager.getInstance();
        List<User> listaUsers = bancoAuth.getUser();
        List<Product> listaProdutos = bancoCom.getProducts();
        
        Cart cart = bancoCom.getCartByUser(listaUsers.get(0));
        List<CartProduct> cartProductList = bancoCom.getCartProductByCart(cart);
        
        cartProductList.get(0).setQuantidade(10);
        
        bancoCom.updateCartProduct(cartProductList.get(0));
        
        CartProduct cartProduct = new CartProduct(cart, listaProdutos.get(2), 9);
        bancoCom.createCartProduct(cartProduct);
        
    }
    
    @Test
    public void removeCarrinho(){
        ComercialDatabaseManager bancoCom = ComercialDatabaseManager.getInstance();
        DatabaseManager bancoAuth = DatabaseManager.getInstance();
        List<User> listaUsers = bancoAuth.getUser();
        
        Cart cart = bancoCom.getCartByUser(listaUsers.get(0));
        List<CartProduct> cartProductList = bancoCom.getCartProductByCart(cart);
        
        bancoCom.deleteCartProduct(cartProductList.get(0));
        bancoCom.deleteCartProduct(cartProductList.get(1));
        
        bancoCom.deleteCart(cart);
    }
    
    @Test
    public void fechaCarrinho(){
        ComercialDatabaseManager bancoCom = ComercialDatabaseManager.getInstance();
        DatabaseManager bancoAuth = DatabaseManager.getInstance();
        List<User> listaUsers = bancoAuth.getUser();
        
        Cart cart = bancoCom.getCartByUser(listaUsers.get(0));
        
        cart.setIsClosed(1);
        cart.setCloseDate(new Date());
        
        bancoCom.updateCart(cart);
    }
    
    @Test
    public void criaProduto(){
        ComercialDatabaseManager banco = ComercialDatabaseManager.getInstance();
        Product produto = new Product("Produto2", "Marca", 3.50, "/images...", new Date());
        banco.createProduct(produto);
    }
    
    @Test
    public void editaProduto(){
        ComercialDatabaseManager banco = ComercialDatabaseManager.getInstance();
        List <Product> listaProdutos = banco.getProducts();
        listaProdutos.get(1).setNome("ProdutoEditado");
        banco.updateProduct(listaProdutos.get(1));
    }
    
    @Test
    public void excluiProduto(){
        ComercialDatabaseManager banco = ComercialDatabaseManager.getInstance();
        List <Product> listaProdutos = banco.getProducts();
        banco.deleteProduct(listaProdutos.get(1));
    }
}
