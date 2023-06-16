package com.gooPet.View;

import com.gooPet.Auth.Database.DatabaseManager;
import com.gooPet.Auth.Security.Security;
import com.gooPet.Auth.Log.Log;
import com.gooPet.View.Client.JanelaAgendaHorario;
import com.gooPet.View.Funcionario.JanelaCadastroProdutos;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author mauricio.rodrigues
 */
public final class JanelaLogin extends javax.swing.JPanel {

    private DatabaseManager banco;
    private Security sec;
    
    public JanelaLogin() throws Exception {
        Log.LogAuthenticationComponent("JanelaLogin", "INFO", "Iniciando componente de autenticação.");
        initComponents();
        banco = DatabaseManager.getInstance();
        sec = Security.getInstance();
        Log.LogAuthenticationComponent("JanelaLogin", "INFO", "Componente de autenticação iniciado.");
    }
    
    public void gotoJanelaCadastro(String actualUserName){
        Janela.p2 = new JanelaCadastro(actualUserName);
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p1);
        janela.getContentPane().remove(Janela.p1);
        janela.add(Janela.p2, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaTeste(String actualUserName){
        Janela.p3 = new JanelaTeste(actualUserName);
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p1);
        janela.getContentPane().remove(Janela.p1);
        janela.add(Janela.p3, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaAgendaHorarioCliente(String actualUserName){
        Janela.p4 = new JanelaAgendaHorario(actualUserName);
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p1);
        janela.getContentPane().remove(Janela.p1);
        janela.add((Component) Janela.p4, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaCadastroProdutos(String actualUserName){
        Janela.p6 = new JanelaCadastroProdutos(actualUserName);
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p1);
        janela.getContentPane().remove(Janela.p1);
        janela.add(Janela.p6, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public boolean verificaCampos(){
        if (tf_Email.getText().isEmpty()) {
            ReturnMessagePane.errorPainel("Email não preenchido."); 
            return false;
        }
        char[] password = pf_Senha.getPassword();
        String senha = new String(password);
        if (senha.isEmpty()) {
            ReturnMessagePane.errorPainel("Senha não preenchida."); 
            return false;
        }
        return true;
    }
    
    public int processaLogin() throws Exception{
        Log.LogAuthenticationComponent("JanelaLogin", "INFO", "Iniciando processo de login.");
        String email, senha;
        email = tf_Email.getText();
        char[] password = pf_Senha.getPassword();
        senha = new String(password);
        String passwordHash = sec.encryptPassword(senha);
        Log.LogAuthenticationComponent("JanelaLogin", "INFO", "Criando requisição de login para o usuário: " + email);
        return banco.login(email, passwordHash);
    }
    
    public void login() throws Exception {
        if (verificaCampos()) {
            int status = processaLogin();
            Log.LogAuthenticationComponent("JanelaLogin", "INFO", "Finalizando processo de login.");
            switch (status) {
                case 1:
                    Log.LogAuthenticationComponent("JanelaLogin", "INFO", "Verificando tipo de usuário.");
                    String userType, email;
                    email = tf_Email.getText();
                    userType = banco.getUserTypeByEmail(email).getNome();
                    switch (userType) {
                        case "Administrador":
                            Log.LogAuthenticationComponent("JanelaLogin", "INFO", "Direcionando usuário para a visão de Administrador.");
                            gotoJanelaCadastroProdutos(email);
                            break;
                        default:
                            Log.LogAuthenticationComponent("JanelaLogin", "INFO", "Direcionando usuário para a visão de Teste.");
                            gotoJanelaAgendaHorarioCliente(email);
                            break;
                    }
                    break;
                case 4:
                    ReturnMessagePane.errorPainel("Email nao encontrado");
                    break;
                case 2:
                    ReturnMessagePane.errorPainel("Senha incorreta");
                    break;
                case 3:
                    ReturnMessagePane.errorPainel("Usuário nao encontrado");
                    break;
                default:
                    ReturnMessagePane.errorPainel("Erro desconhecido");
                    break;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tf_Email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bt_Entrar = new javax.swing.JButton();
        bt_Sair = new javax.swing.JButton();
        pf_Senha = new javax.swing.JPasswordField();

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tf_Email.setBackground(new java.awt.Color(255, 255, 255));
        tf_Email.setForeground(new java.awt.Color(0, 0, 0));
        tf_Email.setText("mauricio@gmail.com");
        tf_Email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_EmailKeyPressed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("E-mail:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Senha:");

        bt_Entrar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Entrar.setForeground(new java.awt.Color(0, 0, 0));
        bt_Entrar.setText("Entrar");
        bt_Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_EntrarActionPerformed(evt);
            }
        });

        bt_Sair.setBackground(new java.awt.Color(255, 255, 255));
        bt_Sair.setForeground(new java.awt.Color(0, 0, 0));
        bt_Sair.setText("Sair");
        bt_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SairActionPerformed(evt);
            }
        });

        pf_Senha.setBackground(new java.awt.Color(255, 255, 255));
        pf_Senha.setForeground(new java.awt.Color(0, 0, 0));
        pf_Senha.setText("teste123");
        pf_Senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pf_SenhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_Email)
                            .addComponent(pf_Senha)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(bt_Sair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Entrar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pf_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Entrar)
                    .addComponent(bt_Sair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_EntrarActionPerformed
        try {
            login();
        } catch (Exception ex) {
            Logger.getLogger(JanelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_EntrarActionPerformed

    private void bt_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bt_SairActionPerformed

    int xx, xy;
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        Janela.j.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void pf_SenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_SenhaKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            try {
                login();
            } catch (Exception ex) {
                Logger.getLogger(JanelaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_pf_SenhaKeyPressed

    private void tf_EmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_EmailKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            try {
                login();
            } catch (Exception ex) {
                Logger.getLogger(JanelaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tf_EmailKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Entrar;
    private javax.swing.JButton bt_Sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pf_Senha;
    private javax.swing.JTextField tf_Email;
    // End of variables declaration//GEN-END:variables
}
