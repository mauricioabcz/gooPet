package com.gooPet.Command;

import com.gooPet.Com.Database.ComercialDatabaseManager;
import com.gooPet.Com.Database.Entities.Cart;
import com.gooPet.Com.Database.Entities.CartProduct;

/**
 *
 * @author mauricio.rodrigues
 */
// Concrete Command - Editar Produto do Carrinho
public class UpdateProductCommand implements Command{
    private Cart cart;
    private CartProduct cartProduct;
    private ComercialDatabaseManager banco;
    
    public UpdateProductCommand(Cart cart, CartProduct cartProduct) {
        banco = ComercialDatabaseManager.getInstance();
        this.cart = cart;
        this.cartProduct = cartProduct;
    }

    @Override
    public void execute() {
        banco.updateCartProduct(cartProduct);
    }
    
}
