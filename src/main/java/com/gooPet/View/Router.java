package com.gooPet.View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Router {
    
    private static Router router;
    
    private Router() {
        
    }
    
    public static Router getInstance() {
        if(Router.router == null)
            Router.router = new Router();
        return Router.router;
    }
    
}
