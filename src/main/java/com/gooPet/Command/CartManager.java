package com.gooPet.Command;

/**
 *
 * @author mauricio.rodrigues
 */
// Invoker
public class CartManager {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
