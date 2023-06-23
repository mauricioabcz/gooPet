package com.gooPet.Command;

import com.gooPet.Com.Database.ComercialDatabaseManager;
import com.gooPet.Com.Database.Entities.Cart;
import com.gooPet.Com.Database.Entities.CartProduct;
import com.gooPet.View.ReturnMessagePane;

/**
 *
 * @author mauricio.rodrigues
 */
// Concrete Command - Adicionar Produto ao Carrinho
public class AddProductCommand implements Command {
    private Cart cart;
    private CartProduct cartProduct;
    private ComercialDatabaseManager banco;

    public AddProductCommand(Cart cart, CartProduct cartProduct) {
        banco = ComercialDatabaseManager.getInstance();
        this.cart = cart;
        this.cartProduct = cartProduct;
    }

    @Override
    public void execute() {
        int status = banco.createCartProduct(cartProduct);
        if (status == 0) {
            ReturnMessagePane.informationPainel("Produto inserido com sucesso.");
        }
        if (status == -1) {
            ReturnMessagePane.errorPainel("Esse produto já existe no Carrinho.");
        }
    }
}
