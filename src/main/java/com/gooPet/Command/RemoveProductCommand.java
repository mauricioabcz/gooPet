package com.gooPet.Command;

import com.gooPet.Com.Database.ComercialDatabaseManager;
import com.gooPet.Com.Database.Entities.Cart;
import com.gooPet.Com.Database.Entities.CartProduct;

/**
 *
 * @author mauricio.rodrigues
 */
// Concrete Command - Remover Produto do Carrinho
public class RemoveProductCommand implements Command {
    private Cart cart;
    private CartProduct cartProduct;
    private ComercialDatabaseManager banco;

    public RemoveProductCommand(Cart cart, CartProduct cartProduct) {
        banco = ComercialDatabaseManager.getInstance();
        this.cart = cart;
        this.cartProduct = cartProduct;
    }

    @Override
    public void execute() {
        banco.deleteCartProduct(cartProduct);
    }
}
