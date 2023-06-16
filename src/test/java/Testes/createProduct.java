package Testes;

import com.gooPet.Com.Database.ComercialDatabaseManager;
import com.gooPet.Com.Database.Entities.Product;
import java.util.Date;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author mauricio.rodrigues
 */
public class createProduct {
    
    public createProduct() {
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
