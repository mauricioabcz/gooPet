package com.gooPet.View;

import com.gooPet.Auth.Database.DatabaseManager;
import com.gooPet.Auth.Database.Entities.UserType;
import com.gooPet.Auth.Log.Log;
import java.awt.BorderLayout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author mauricio.rodrigues
 */
public final class JanelaCadastro extends javax.swing.JPanel {

    private DatabaseManager banco;
    private List<UserType> listaGrupos;
    
    public JanelaCadastro(String actualUserName) {
        initComponents();
        lb_ActualUser.setText(actualUserName);
        banco = DatabaseManager.getInstance();
        getGrupos();
    }

    public void logout() throws Exception{
        Janela.p1 = new JanelaLogin();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p2);
        janela.getContentPane().remove(Janela.p2);
        janela.add(Janela.p1, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void getGrupos(){
        listaGrupos = banco.getUserType();
        for (UserType grupo : listaGrupos) {
            cb_CriaGrupo.addItem(grupo.getNome());
            cb_EditaGrupo.addItem(grupo.getNome());
        }
    }
    
    public void limpaGrupos(){
        //Limpeza
        cb_CriaGrupo.removeAllItems();
        cb_CriaGrupo.addItem("Selecione");
        cb_CriaGrupo.setSelectedIndex(0);
        cb_EditaGrupo.removeAllItems();
        cb_EditaGrupo.addItem("Selecione");
        cb_EditaGrupo.setSelectedIndex(0);
        tf_EditaNomeGrupo.setText("");
        tf_EditaDescriçãoGrupo.setText("");
        listaGrupos.clear();
    }
    
    public void limpaUser(){
        tf_CriaUser.setText("");
        tf_CriaEmail.setText("");
        pf_CriaSenha.setText("");
        cb_CriaGrupo.setSelectedIndex(0);
    }
    
    public void limpaGrupo(){
        tf_CriaGrupo.setText("");
        tf_CriaDescricao.setText("");
    }
    
    public void preencheGrupo() {
        Object itemSelecionado = cb_EditaGrupo.getSelectedItem();
        if (itemSelecionado != null && !itemSelecionado.toString().equals("Selecione")) {
            String grupoSelecionado = itemSelecionado.toString();
            for (UserType grupo : listaGrupos) {
                if (grupoSelecionado.equals(grupo.getNome())) {
                    tf_EditaNomeGrupo.setText(grupo.getNome());
                    tf_EditaDescriçãoGrupo.setText(grupo.getDescricao());
                    break; // Se já encontrou o grupo, pode interromper o loop
                }
            }
        }
    }
    
    public boolean verificaCamposCriaUsuario(){
        if (tf_CriaUser.getText().isEmpty()) {
            ReturnMessagePane.errorPainel("Insira o Nome."); 
            return false;
        }
        if (tf_CriaEmail.getText().isEmpty()) {
            ReturnMessagePane.errorPainel("Insira o E-mail."); 
            return false;
        }
        char[] password = pf_CriaSenha.getPassword();
        String senha = new String(password);
        if (senha.isEmpty()) {
            ReturnMessagePane.errorPainel("Insira a Senha."); 
            return false;
        }
        if (cb_CriaGrupo.getSelectedItem().toString().equals("Selecione")) {
            ReturnMessagePane.errorPainel("Selecione um grupo."); 
            return false;
        }
        return true;
    }
    
    public boolean verificaCamposCriaGrupo(){
        if (tf_CriaGrupo.getText().isEmpty()) {
            ReturnMessagePane.errorPainel("Insira o Nome."); 
            return false;
        }
        if (tf_CriaDescricao.getText().isEmpty()) {
            ReturnMessagePane.errorPainel("Insira a Descrição."); 
            return false;
        }
        return true;
    }
    
    public boolean verificaCamposEditaGrupo(){
        if (cb_EditaGrupo.getSelectedItem().toString().equals("Selecione")) {
            ReturnMessagePane.errorPainel("Selecione um grupo."); 
            return false;
        }
        return true;
    }
    
    public void processaCriacaoDeUsuario() throws Exception{
        Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Iniciando processo de criação de usuário.");
        String nome, email, senha, grupo;
        nome = tf_CriaUser.getText();
        email = tf_CriaEmail.getText();
        char[] password = pf_CriaSenha.getPassword();
        senha = new String(password);
        grupo = cb_CriaGrupo.getSelectedItem().toString();
        Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Usuário a ser criado: " + nome + " - " + email + " - " + grupo);
        Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Usuário responsável pela criação: " + lb_ActualUser.getText());
        banco.createUser(nome, email, senha, grupo);
    }
    
    public void processaCriacaoDeGrupo(){
        Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Iniciando processo de criação de grupo.");
        String nome, descricao;
        nome = tf_CriaGrupo.getText();
        descricao = tf_CriaDescricao.getText();
        Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Grupo a ser criado: " + nome + " - " + descricao);
        Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Usuário responsável pela criação: " + lb_ActualUser.getText());
        banco.createUserType(nome, descricao);
    }
    
    public void processaAlteracaoDeGrupo(){
        Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Iniciando processo de alteração de grupo.");
        UserType grupoAlterado = null;
        String grupoAlteradoNome = cb_EditaGrupo.getSelectedItem().toString();
        
        for (UserType grupo : listaGrupos) {
            if (grupoAlteradoNome.equals(grupo.getNome())) {
                Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Grupo a ser alterado: " + grupo.toString());
                grupoAlterado = grupo;
                grupoAlterado.setNome(tf_EditaNomeGrupo.getText());
                grupoAlterado.setDescricao(tf_EditaDescriçãoGrupo.getText());
                Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Alteração realizada: " + grupoAlterado.toString());
            }
        }
        Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Usuário responsável pela alteração: " + lb_ActualUser.getText());
        banco.alterarGrupoUsuario(grupoAlterado);
    }
    
    public void processaDeleteDeGrupo(){
        Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Iniciando processo de exclusão de grupo.");
        UserType grupoDelete = null;
        String grupoAlteradoNome = cb_EditaGrupo.getSelectedItem().toString();
        
        for (UserType grupo : listaGrupos) {
            if (grupoAlteradoNome.equals(grupo.getNome())) {
                Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Grupo a ser excluído: " + grupo.toString());
                grupoDelete = grupo;
            }
        }
        Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Usuário responsável pela exclusão: " + lb_ActualUser.getText());
        banco.deleteGrupoUsuario(grupoDelete);
    }
    
    public void criaUsuario() throws Exception{
        if (verificaCamposCriaUsuario()) {
            processaCriacaoDeUsuario();
            limpaUser();
            ReturnMessagePane.informationPainel("Usuário criado com sucesso.");
        }
    }
    
    public void criaGrupo(){
        if (verificaCamposCriaGrupo()) {
            processaCriacaoDeGrupo();
            limpaGrupo();
            limpaGrupos();
            getGrupos();
            ReturnMessagePane.informationPainel("Grupo criado com sucesso.");
        }
    }
    
    public void editaGrupo(){
        if (verificaCamposEditaGrupo()) {
            processaAlteracaoDeGrupo();
            limpaGrupos();
            getGrupos();
            ReturnMessagePane.informationPainel("Grupo excluído com sucesso.");
        }
    }
    
    public void deletaGrupo(){
        if (verificaCamposEditaGrupo()) {
            processaDeleteDeGrupo();
            limpaGrupos();
            getGrupos();
            ReturnMessagePane.informationPainel("Grupo excluído com sucesso.");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_ActualUser = new javax.swing.JLabel();
        lb_Logout = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_CriaGrupo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_CriaDescricao = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        bt_CriaGrupo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_CriaUser = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_CriaEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cb_CriaGrupo = new javax.swing.JComboBox<>();
        bt_CriaUser = new javax.swing.JButton();
        pf_CriaSenha = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        cb_EditaGrupo = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tf_EditaNomeGrupo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tf_EditaDescriçãoGrupo = new javax.swing.JTextField();
        bt_EditaGrupo = new javax.swing.JButton();
        bt_ExcluiGrupo = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tf_Email8 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tf_Email9 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        bt_AtualizaUser = new javax.swing.JButton();
        bt_ExcluirUser = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        bt_Sair = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

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
        jLabel1.setText("Gestão de Usuários");

        lb_ActualUser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lb_ActualUser.setForeground(new java.awt.Color(255, 255, 255));
        lb_ActualUser.setText("<actualUser>");

        lb_Logout.setBackground(new java.awt.Color(255, 255, 255));
        lb_Logout.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lb_Logout.setForeground(new java.awt.Color(255, 255, 255));
        lb_Logout.setIcon(new javax.swing.ImageIcon(".\\images\\iconExit.png"));
        lb_Logout.setText("Logout");
        lb_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_LogoutMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_ActualUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_Logout)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lb_ActualUser)
                    .addComponent(lb_Logout))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Criar Grupo de Permissão");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nome:");

        tf_CriaGrupo.setBackground(new java.awt.Color(255, 255, 255));
        tf_CriaGrupo.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Descrição:");

        tf_CriaDescricao.setBackground(new java.awt.Color(255, 255, 255));
        tf_CriaDescricao.setForeground(new java.awt.Color(0, 0, 0));

        bt_CriaGrupo.setBackground(new java.awt.Color(204, 204, 204));
        bt_CriaGrupo.setForeground(new java.awt.Color(0, 0, 0));
        bt_CriaGrupo.setText("Criar");
        bt_CriaGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CriaGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_CriaGrupo)
                            .addComponent(tf_CriaDescricao)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_CriaGrupo)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_CriaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_CriaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_CriaGrupo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Cria Usuário");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Nome:");

        tf_CriaUser.setBackground(new java.awt.Color(255, 255, 255));
        tf_CriaUser.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Email:");

        tf_CriaEmail.setBackground(new java.awt.Color(255, 255, 255));
        tf_CriaEmail.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Senha:");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Grupo:");

        cb_CriaGrupo.setBackground(new java.awt.Color(255, 255, 255));
        cb_CriaGrupo.setForeground(new java.awt.Color(0, 0, 0));
        cb_CriaGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        bt_CriaUser.setBackground(new java.awt.Color(204, 204, 204));
        bt_CriaUser.setForeground(new java.awt.Color(0, 0, 0));
        bt_CriaUser.setText("Criar");
        bt_CriaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CriaUserActionPerformed(evt);
            }
        });

        pf_CriaSenha.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_CriaUser)
                            .addComponent(tf_CriaEmail)
                            .addComponent(pf_CriaSenha)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel8)
                        .addGap(0, 112, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_CriaGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_CriaUser)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(3, 3, 3)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_CriaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_CriaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(pf_CriaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_CriaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_CriaUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Editar Grupo de Permissão");

        cb_EditaGrupo.setBackground(new java.awt.Color(255, 255, 255));
        cb_EditaGrupo.setForeground(new java.awt.Color(0, 0, 0));
        cb_EditaGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cb_EditaGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_EditaGrupoActionPerformed(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Grupo:");

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Nome:");

        tf_EditaNomeGrupo.setBackground(new java.awt.Color(255, 255, 255));
        tf_EditaNomeGrupo.setForeground(new java.awt.Color(0, 0, 0));

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Descrição:");

        tf_EditaDescriçãoGrupo.setBackground(new java.awt.Color(255, 255, 255));
        tf_EditaDescriçãoGrupo.setForeground(new java.awt.Color(0, 0, 0));

        bt_EditaGrupo.setBackground(new java.awt.Color(204, 204, 204));
        bt_EditaGrupo.setForeground(new java.awt.Color(0, 0, 0));
        bt_EditaGrupo.setText("Alterar");
        bt_EditaGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_EditaGrupoActionPerformed(evt);
            }
        });

        bt_ExcluiGrupo.setBackground(new java.awt.Color(204, 204, 204));
        bt_ExcluiGrupo.setForeground(new java.awt.Color(0, 0, 0));
        bt_ExcluiGrupo.setText("Excluir");
        bt_ExcluiGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ExcluiGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel13)
                .addContainerGap(75, Short.MAX_VALUE))
            .addComponent(jSeparator3)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(bt_ExcluiGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_EditaGrupo))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_EditaGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_EditaDescriçãoGrupo)
                            .addComponent(tf_EditaNomeGrupo))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_EditaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_EditaNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_EditaDescriçãoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_ExcluiGrupo)
                    .addComponent(bt_EditaGrupo))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setForeground(new java.awt.Color(0, 0, 0));

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Cria Usuário");

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Nome:");

        tf_Email8.setBackground(new java.awt.Color(255, 255, 255));
        tf_Email8.setForeground(new java.awt.Color(0, 0, 0));

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Email:");

        tf_Email9.setBackground(new java.awt.Color(255, 255, 255));
        tf_Email9.setForeground(new java.awt.Color(0, 0, 0));

        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Senha:");

        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Grupo:");

        jComboBox3.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox3.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Usuário:");

        jComboBox4.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox4.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        bt_AtualizaUser.setBackground(new java.awt.Color(204, 204, 204));
        bt_AtualizaUser.setForeground(new java.awt.Color(0, 0, 0));
        bt_AtualizaUser.setText("Alterar");
        bt_AtualizaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AtualizaUserActionPerformed(evt);
            }
        });

        bt_ExcluirUser.setBackground(new java.awt.Color(204, 204, 204));
        bt_ExcluirUser.setForeground(new java.awt.Color(0, 0, 0));
        bt_ExcluirUser.setText("Excluir");
        bt_ExcluirUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ExcluirUserActionPerformed(evt);
            }
        });

        jPasswordField1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(bt_ExcluirUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_AtualizaUser))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_Email9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_Email8)
                            .addComponent(jPasswordField1))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(3, 3, 3)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Email8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Email9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_ExcluirUser)
                    .addComponent(bt_AtualizaUser))
                .addContainerGap())
        );

        bt_Sair.setBackground(new java.awt.Color(255, 255, 255));
        bt_Sair.setForeground(new java.awt.Color(0, 0, 0));
        bt_Sair.setText("Sair");
        bt_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SairActionPerformed(evt);
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_Sair)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_Sair)
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

    private void bt_CriaGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CriaGrupoActionPerformed
        criaGrupo();
    }//GEN-LAST:event_bt_CriaGrupoActionPerformed

    private void bt_CriaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CriaUserActionPerformed
        try {
            criaUsuario();
        } catch (Exception ex) {
            Logger.getLogger(JanelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_CriaUserActionPerformed

    private void bt_EditaGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_EditaGrupoActionPerformed
        editaGrupo();
    }//GEN-LAST:event_bt_EditaGrupoActionPerformed

    private void bt_ExcluiGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ExcluiGrupoActionPerformed
        deletaGrupo();
    }//GEN-LAST:event_bt_ExcluiGrupoActionPerformed

    private void bt_ExcluirUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ExcluirUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_ExcluirUserActionPerformed

    private void bt_AtualizaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AtualizaUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_AtualizaUserActionPerformed

    private void bt_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bt_SairActionPerformed

    private void cb_EditaGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_EditaGrupoActionPerformed
        preencheGrupo();
    }//GEN-LAST:event_cb_EditaGrupoActionPerformed

    private void lb_LogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_LogoutMousePressed
        try {
            Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Realizando logout do usuário.");
            logout();
            Log.LogAuthenticationComponent("JanelaCadastro", "INFO", "Logout realizado com sucesso.");
        } catch (Exception ex) {
            Logger.getLogger(JanelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lb_LogoutMousePressed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_AtualizaUser;
    private javax.swing.JButton bt_CriaGrupo;
    private javax.swing.JButton bt_CriaUser;
    private javax.swing.JButton bt_EditaGrupo;
    private javax.swing.JButton bt_ExcluiGrupo;
    private javax.swing.JButton bt_ExcluirUser;
    private javax.swing.JButton bt_Sair;
    private javax.swing.JComboBox<String> cb_CriaGrupo;
    private javax.swing.JComboBox<String> cb_EditaGrupo;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lb_ActualUser;
    private javax.swing.JLabel lb_Logout;
    private javax.swing.JPasswordField pf_CriaSenha;
    private javax.swing.JTextField tf_CriaDescricao;
    private javax.swing.JTextField tf_CriaEmail;
    private javax.swing.JTextField tf_CriaGrupo;
    private javax.swing.JTextField tf_CriaUser;
    private javax.swing.JTextField tf_EditaDescriçãoGrupo;
    private javax.swing.JTextField tf_EditaNomeGrupo;
    private javax.swing.JTextField tf_Email8;
    private javax.swing.JTextField tf_Email9;
    // End of variables declaration//GEN-END:variables
}
