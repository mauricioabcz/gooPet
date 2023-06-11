package com.gooPet.View;

import javax.swing.JOptionPane;

public class ReturnMessagePane {
    
    public static void errorPainel(String message) {
       JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void informationPainel(String message) {
        JOptionPane.showMessageDialog(null, message, "Infomação", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
