package com.gooPet.View.Funcionario;

import com.gooPet.Com.Database.ComercialDatabaseManager;
import com.gooPet.Com.Database.Entities.Product;
import com.gooPet.Service.ImageUpdateService;
import com.gooPet.View.Client.*;
import com.gooPet.View.Janela;
import com.gooPet.View.ReturnMessagePane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.text.Normalizer;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mauricio.rodrigues
 */
public class JanelaCadastroProdutos extends javax.swing.JPanel {

    private ComercialDatabaseManager banco;
    private ImageUpdateService image; 
    private List <Product> listaProdutos;
    
    public JanelaCadastroProdutos(String actualUserName) {
        initComponents();
        lb_ActualUser.setText(actualUserName);
        banco = ComercialDatabaseManager.getInstance();
        atualizaTabela();
        
        setColor(btn_4); 
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_Home,btn_JanelaShopping, btn_JanelaSettings}, new JPanel[]{ind_2,ind_1, ind_3, ind_5});
        
    }
    
    public void gotoJanelaShopping() throws IOException{
        Janela.p5 = new JanelaShopping(lb_ActualUser.getText());
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p4);
        janela.getContentPane().remove(Janela.p4);
        janela.add(Janela.p5, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_ProductImage = new javax.swing.JPanel();
        lb_ProductImage = new javax.swing.JLabel();
        side_pane = new javax.swing.JPanel();
        btn_Home = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        lb_Home = new javax.swing.JLabel();
        btn_JanelaRelatorios = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        lb_Carrinho = new javax.swing.JLabel();
        btn_JanelaShopping = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        lb_Shopping = new javax.swing.JLabel();
        btn_4 = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        lb_Agenda = new javax.swing.JLabel();
        btn_JanelaSettings = new javax.swing.JPanel();
        ind_5 = new javax.swing.JPanel();
        lb_Settings = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_Produtos = new javax.swing.JTable();
        bt_Atualizar = new javax.swing.JButton();
        lb_DadosProduto = new javax.swing.JLabel();
        lb_NomeProduto = new javax.swing.JLabel();
        lb_MarcaProduto = new javax.swing.JLabel();
        bt_Limpar = new javax.swing.JButton();
        bt_Salvar = new javax.swing.JButton();
        bt_SelecionarImagem = new javax.swing.JButton();
        lb_ValorProduto = new javax.swing.JLabel();
        lb_ImagemProduto = new javax.swing.JLabel();
        tf_ImagemProduto = new javax.swing.JTextField();
        lb_PesquisarProduto = new javax.swing.JLabel();
        lb_Data = new javax.swing.JLabel();
        bt_Pesquisar = new javax.swing.JButton();
        tf_NomeProduto = new javax.swing.JTextField();
        tf_MarcaProduto = new javax.swing.JTextField();
        tf_Pesquisar = new javax.swing.JTextField();
        tf_ValorProduto = new javax.swing.JTextField();
        pn_ImagemProduto = new javax.swing.JPanel();
        lb_ProductImagem = new javax.swing.JLabel();
        bt_Remover = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lb_Logout = new javax.swing.JLabel();
        lb_TelaRotasTitle = new javax.swing.JLabel();
        lb_ActualUser = new javax.swing.JLabel();

        lb_ProductImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ProductImage.setText("<Product_Image>");
        lb_ProductImage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_ProductImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pn_ProductImageLayout = new javax.swing.GroupLayout(pn_ProductImage);
        pn_ProductImage.setLayout(pn_ProductImageLayout);
        pn_ProductImageLayout.setHorizontalGroup(
            pn_ProductImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ProductImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_ProductImage, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_ProductImageLayout.setVerticalGroup(
            pn_ProductImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ProductImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_ProductImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.setBackground(new java.awt.Color(23, 35, 51));
        side_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Home.setBackground(new java.awt.Color(23, 35, 51));
        btn_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_HomeMousePressed(evt);
            }
        });

        ind_1.setOpaque(false);
        ind_1.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        lb_Home.setForeground(new java.awt.Color(255, 255, 255));
        lb_Home.setText("Home");

        javax.swing.GroupLayout btn_HomeLayout = new javax.swing.GroupLayout(btn_Home);
        btn_Home.setLayout(btn_HomeLayout);
        btn_HomeLayout.setHorizontalGroup(
            btn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_HomeLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Home)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_HomeLayout.setVerticalGroup(
            btn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_HomeLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 120, -1));

        btn_JanelaRelatorios.setBackground(new java.awt.Color(23, 35, 51));
        btn_JanelaRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_JanelaRelatoriosMouseReleased(evt);
            }
        });

        ind_2.setOpaque(false);
        ind_2.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_2Layout = new javax.swing.GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_2Layout.setVerticalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        lb_Carrinho.setForeground(new java.awt.Color(255, 255, 255));
        lb_Carrinho.setText("Carrinho");

        javax.swing.GroupLayout btn_JanelaRelatoriosLayout = new javax.swing.GroupLayout(btn_JanelaRelatorios);
        btn_JanelaRelatorios.setLayout(btn_JanelaRelatoriosLayout);
        btn_JanelaRelatoriosLayout.setHorizontalGroup(
            btn_JanelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaRelatoriosLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Carrinho)
                .addGap(0, 36, Short.MAX_VALUE))
        );
        btn_JanelaRelatoriosLayout.setVerticalGroup(
            btn_JanelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaRelatoriosLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_JanelaRelatoriosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Carrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_JanelaRelatorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 120, -1));

        btn_JanelaShopping.setBackground(new java.awt.Color(23, 35, 51));
        btn_JanelaShopping.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_JanelaShoppingMousePressed(evt);
            }
        });

        ind_3.setOpaque(false);
        ind_3.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_3Layout = new javax.swing.GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        lb_Shopping.setForeground(new java.awt.Color(255, 255, 255));
        lb_Shopping.setText("Shopping");

        javax.swing.GroupLayout btn_JanelaShoppingLayout = new javax.swing.GroupLayout(btn_JanelaShopping);
        btn_JanelaShopping.setLayout(btn_JanelaShoppingLayout);
        btn_JanelaShoppingLayout.setHorizontalGroup(
            btn_JanelaShoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaShoppingLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Shopping)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_JanelaShoppingLayout.setVerticalGroup(
            btn_JanelaShoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaShoppingLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_JanelaShoppingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Shopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_JanelaShopping, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 120, -1));

        btn_4.setBackground(new java.awt.Color(23, 35, 51));
        btn_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_4MousePressed(evt);
            }
        });

        ind_4.setOpaque(false);
        ind_4.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_4Layout = new javax.swing.GroupLayout(ind_4);
        ind_4.setLayout(ind_4Layout);
        ind_4Layout.setHorizontalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_4Layout.setVerticalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        lb_Agenda.setForeground(new java.awt.Color(255, 255, 255));
        lb_Agenda.setText("Agenda");

        javax.swing.GroupLayout btn_4Layout = new javax.swing.GroupLayout(btn_4);
        btn_4.setLayout(btn_4Layout);
        btn_4Layout.setHorizontalGroup(
            btn_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_4Layout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Agenda)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        btn_4Layout.setVerticalGroup(
            btn_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_4Layout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Agenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 120, -1));

        btn_JanelaSettings.setBackground(new java.awt.Color(23, 35, 51));
        btn_JanelaSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_JanelaSettingsMouseReleased(evt);
            }
        });

        ind_5.setOpaque(false);
        ind_5.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_5Layout = new javax.swing.GroupLayout(ind_5);
        ind_5.setLayout(ind_5Layout);
        ind_5Layout.setHorizontalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_5Layout.setVerticalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        lb_Settings.setForeground(new java.awt.Color(255, 255, 255));
        lb_Settings.setText("Settings");

        javax.swing.GroupLayout btn_JanelaSettingsLayout = new javax.swing.GroupLayout(btn_JanelaSettings);
        btn_JanelaSettings.setLayout(btn_JanelaSettingsLayout);
        btn_JanelaSettingsLayout.setHorizontalGroup(
            btn_JanelaSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaSettingsLayout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Settings)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        btn_JanelaSettingsLayout.setVerticalGroup(
            btn_JanelaSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaSettingsLayout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_JanelaSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Settings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_JanelaSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 120, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tb_Produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Marca", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ProdutosMouseClicked(evt);
            }
        });
        tb_Produtos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_ProdutosKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tb_Produtos);

        bt_Atualizar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Atualizar.setText("Atualizar");
        bt_Atualizar.setFocusPainted(false);
        bt_Atualizar.setFocusable(false);
        bt_Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AtualizarActionPerformed(evt);
            }
        });

        lb_DadosProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_DadosProduto.setText("Dados do Produto");

        lb_NomeProduto.setText("Nome:");

        lb_MarcaProduto.setText("Marca");

        bt_Limpar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Limpar.setText("Limpar");
        bt_Limpar.setFocusPainted(false);
        bt_Limpar.setFocusable(false);
        bt_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_LimparActionPerformed(evt);
            }
        });

        bt_Salvar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Salvar.setText("Salvar");
        bt_Salvar.setFocusPainted(false);
        bt_Salvar.setFocusable(false);
        bt_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SalvarActionPerformed(evt);
            }
        });

        bt_SelecionarImagem.setBackground(new java.awt.Color(255, 255, 255));
        bt_SelecionarImagem.setText("Selecionar Imagem");
        bt_SelecionarImagem.setFocusPainted(false);
        bt_SelecionarImagem.setFocusable(false);
        bt_SelecionarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SelecionarImagemActionPerformed(evt);
            }
        });

        lb_ValorProduto.setText("Valor:");

        lb_ImagemProduto.setText("Imagem:");

        tf_ImagemProduto.setEditable(false);

        lb_PesquisarProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_PesquisarProduto.setText("Pesquisar Produto");

        lb_Data.setText("Data:");

        bt_Pesquisar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Pesquisar.setText("Pesquisar");
        bt_Pesquisar.setFocusPainted(false);
        bt_Pesquisar.setFocusable(false);
        bt_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_PesquisarActionPerformed(evt);
            }
        });

        lb_ProductImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ProductImagem.setText("<Product_Image>");
        lb_ProductImagem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_ProductImagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pn_ImagemProdutoLayout = new javax.swing.GroupLayout(pn_ImagemProduto);
        pn_ImagemProduto.setLayout(pn_ImagemProdutoLayout);
        pn_ImagemProdutoLayout.setHorizontalGroup(
            pn_ImagemProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ImagemProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_ProductImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_ImagemProdutoLayout.setVerticalGroup(
            pn_ImagemProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ImagemProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_ProductImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_Remover.setBackground(new java.awt.Color(255, 255, 255));
        bt_Remover.setText("Remover");
        bt_Remover.setFocusPainted(false);
        bt_Remover.setFocusable(false);
        bt_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lb_Data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_Pesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Pesquisar))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lb_PesquisarProduto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(bt_Atualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Remover)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(bt_Limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                        .addComponent(bt_SelecionarImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Salvar))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_DadosProduto)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_ImagemProduto)
                                    .addComponent(lb_ValorProduto)
                                    .addComponent(lb_MarcaProduto)
                                    .addComponent(lb_NomeProduto))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_NomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                                    .addComponent(tf_MarcaProduto)
                                    .addComponent(tf_ImagemProduto)
                                    .addComponent(tf_ValorProduto)))
                            .addComponent(pn_ImagemProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_DadosProduto)
                    .addComponent(lb_PesquisarProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Data)
                            .addComponent(bt_Pesquisar)
                            .addComponent(tf_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Atualizar))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(pn_ImagemProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_NomeProduto)
                            .addComponent(tf_NomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_MarcaProduto)
                            .addComponent(tf_MarcaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_ValorProduto)
                            .addComponent(tf_ValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_ImagemProduto)
                            .addComponent(tf_ImagemProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Salvar)
                            .addComponent(bt_SelecionarImagem)
                            .addComponent(bt_Limpar)
                            .addComponent(bt_Remover))))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(71, 120, 197));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        lb_Logout.setForeground(new java.awt.Color(255, 255, 255));
        lb_Logout.setIcon(new javax.swing.ImageIcon(".\\images\\iconExit.png"));
        lb_Logout.setText("Logout");
        lb_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_LogoutMousePressed(evt);
            }
        });

        lb_TelaRotasTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_TelaRotasTitle.setForeground(new java.awt.Color(255, 255, 255));
        lb_TelaRotasTitle.setText("PetShop > Cadastro de Produtos");

        lb_ActualUser.setForeground(new java.awt.Color(255, 255, 255));
        lb_ActualUser.setText("<actualUser>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_TelaRotasTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_ActualUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_Logout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_TelaRotasTitle)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_Logout)
                                .addComponent(lb_ActualUser)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void selecionaArquivo(){
        final JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        System.out.println("Diretório atual: " + System.getProperty("user.dir"));
        File initialDir = new File("./");
        fc.setCurrentDirectory(initialDir);
        fc.setDialogTitle("Abrir arquivo de texto");
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            String nomeArquivo = file.getName();
            tf_ImagemProduto.setText(nomeArquivo);
            
            String caminhoArquivo = file.getPath();
            String extensaoArquivo = "";

            int posicaoPonto = nomeArquivo.lastIndexOf(".");
            if (posicaoPonto >= 0 && posicaoPonto < nomeArquivo.length() - 1) {
                extensaoArquivo = nomeArquivo.substring(posicaoPonto + 1);
            }
            
            //Processa imagem a ser armazenada na pasta
            processaImagem(caminhoArquivo, nomeArquivo, extensaoArquivo, 470, 370);
            //Processa imagem a ser exibida nessa tela
            processaImagem(caminhoArquivo, "temp." + extensaoArquivo , extensaoArquivo, 470, 300);
            lb_ProductImagem.setText("");
            lb_ProductImagem.setIcon(new javax.swing.ImageIcon(".\\images\\temp." + extensaoArquivo));
        }
    }
    
    public void processaImagem(String imagePath, String imageName, String imageType, int width, int height){
        image = ImageUpdateService.getInstance();
        image.ajeitaImagem(imagePath, imageName, imageType, width, height);
    }
    
    public void atualizaTabela(){
        //Atualiza tabela
        ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
        //Busca Produtos
        listaProdutos = banco.getProducts();
        for (Product produto : listaProdutos) {
           ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
            produto.getNome(),
            produto.getMarca(),
            "R$ " + produto.getValor()
        }); 
        }
    }
    
    public void limpaCampos(){
        lb_ProductImagem.setIcon(null);
        tf_NomeProduto.setText("");
        tf_MarcaProduto.setText("");
        tf_ValorProduto.setText("");
        tf_ImagemProduto.setText("");
    }
    
    public boolean verificaCamposProduto(){
        if (tf_NomeProduto.getText().isEmpty()) {
            ReturnMessagePane.informationPainel("Campo Nome não preenchido.");
            return false;
        }
        if (tf_MarcaProduto.getText().isEmpty()) {
            ReturnMessagePane.informationPainel("Campo Marca não preenchido.");
            return false;
        }
        if (tf_ValorProduto.getText().isEmpty()) {
            ReturnMessagePane.informationPainel("Campo Valor não preenchido.");
            return false;
        }
        try {
            double testeDouble = Double.parseDouble(tf_ValorProduto.getText());
        } catch (NumberFormatException e) {
            ReturnMessagePane.informationPainel("O campo Valor deve ser numérico.");
            return false;
        }
        return true;
    }
    
    public void salvaProduto(Product produto){
        int status = banco.createProduct(produto);
        if (status == 0) {
            limpaCampos();
            ReturnMessagePane.informationPainel("Produto salvo com sucesso.");
        }
        if (status == -1) {
            ReturnMessagePane.errorPainel("Produto já cadastrado.");
        }
    }
    
    public void processaSalvarProduto(){
        if (verificaCamposProduto()) {
            String nome, marca, imagem;
            double valor;
            if (tf_ImagemProduto.getText().isEmpty()) {
                nome = tf_NomeProduto.getText();
                marca = tf_MarcaProduto.getText();
                valor = Double.parseDouble(tf_ValorProduto.getText());
                imagem = null;
            } else {
                nome = tf_NomeProduto.getText();
                marca = tf_MarcaProduto.getText();
                valor = Double.parseDouble(tf_ValorProduto.getText());
                imagem = "\\images\\" + tf_ImagemProduto.getText();
            }
            Product novoProduto = new Product(nome, marca, valor, imagem, new Date());
            salvaProduto(novoProduto);
        }
    }
    
    private void btn_HomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMousePressed
        // TODO add your handling code here:
        setColor(btn_Home);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_JanelaShopping,btn_4, btn_JanelaSettings}, new JPanel[]{ind_2,ind_3, ind_4, ind_5});
        //gotoJanelaHome();
    }//GEN-LAST:event_btn_HomeMousePressed

    private void btn_JanelaRelatoriosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaRelatoriosMouseReleased
        // TODO add your handling code here:
        setColor(btn_JanelaRelatorios);
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{btn_Home,btn_JanelaShopping,btn_4, btn_JanelaSettings}, new JPanel[]{ind_1,ind_3, ind_4, ind_5});
        //gotoJanelaRelatorios();
    }//GEN-LAST:event_btn_JanelaRelatoriosMouseReleased

    private void btn_JanelaShoppingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaShoppingMousePressed
        // TODO add your handling code here:
        setColor(btn_JanelaShopping);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_Home,btn_4, btn_JanelaSettings}, new JPanel[]{ind_2,ind_1, ind_4, ind_5});
        try {
            gotoJanelaShopping();
        } catch (IOException ex) {
            Logger.getLogger(JanelaCadastroProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_JanelaShoppingMousePressed

    private void btn_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MousePressed
        // TODO add your handling code here:
        setColor(btn_4);
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_JanelaShopping,btn_Home, btn_JanelaSettings}, new JPanel[]{ind_2,ind_3, ind_1, ind_5});
    }//GEN-LAST:event_btn_4MousePressed

    private void btn_JanelaSettingsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaSettingsMouseReleased
        // TODO add your handling code here:
        setColor(btn_JanelaSettings);
        ind_5.setOpaque(true);
        resetColor(new JPanel[]{btn_Home,btn_JanelaShopping,btn_4, btn_JanelaRelatorios}, new JPanel[]{ind_1,ind_3, ind_4, ind_2});
        //ReturnMessagePane.informationPainel(Janela.traducao.getString("alert_EmObras"));
    }//GEN-LAST:event_btn_JanelaSettingsMouseReleased

    private void lb_LogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_LogoutMousePressed
        System.exit(0);
    }//GEN-LAST:event_lb_LogoutMousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:

        //source to drag
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        Janela.j.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        //drag this pane
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void bt_SelecionarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SelecionarImagemActionPerformed
        selecionaArquivo();
    }//GEN-LAST:event_bt_SelecionarImagemActionPerformed

    private void bt_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_LimparActionPerformed
        
    }//GEN-LAST:event_bt_LimparActionPerformed

    private void bt_AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AtualizarActionPerformed
       
    }//GEN-LAST:event_bt_AtualizarActionPerformed

    private void tb_ProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ProdutosKeyReleased
        //        selecionarVeiculo();
        //        atualizaVinculoComTransportadores();
    }//GEN-LAST:event_tb_ProdutosKeyReleased

    private void tb_ProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ProdutosMouseClicked
        //        selecionarVeiculo();
        //        atualizaVinculoComTransportadores();
    }//GEN-LAST:event_tb_ProdutosMouseClicked

    private void bt_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_PesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_PesquisarActionPerformed

    private void bt_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RemoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_RemoverActionPerformed

    private void bt_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SalvarActionPerformed
        processaSalvarProduto();
    }//GEN-LAST:event_bt_SalvarActionPerformed

    int xx, xy;
        private void setColor(JPanel pane)
    {
        pane.setBackground(new Color(41,57,80));
    }
    
    private void resetColor(JPanel [] pane, JPanel [] indicators)
    {
        for(int i=0;i<pane.length;i++){
           pane[i].setBackground(new Color(23,35,51));
           
        } for(int i=0;i<indicators.length;i++){
           indicators[i].setOpaque(false);           
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Atualizar;
    private javax.swing.JButton bt_Limpar;
    private javax.swing.JButton bt_Pesquisar;
    private javax.swing.JButton bt_Remover;
    private javax.swing.JButton bt_Salvar;
    private javax.swing.JButton bt_SelecionarImagem;
    private javax.swing.JPanel btn_4;
    private javax.swing.JPanel btn_Home;
    private javax.swing.JPanel btn_JanelaRelatorios;
    private javax.swing.JPanel btn_JanelaSettings;
    private javax.swing.JPanel btn_JanelaShopping;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_4;
    private javax.swing.JPanel ind_5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_ActualUser;
    private javax.swing.JLabel lb_Agenda;
    private javax.swing.JLabel lb_Carrinho;
    private javax.swing.JLabel lb_DadosProduto;
    private javax.swing.JLabel lb_Data;
    private javax.swing.JLabel lb_Home;
    private javax.swing.JLabel lb_ImagemProduto;
    private javax.swing.JLabel lb_Logout;
    private javax.swing.JLabel lb_MarcaProduto;
    private javax.swing.JLabel lb_NomeProduto;
    private javax.swing.JLabel lb_PesquisarProduto;
    private javax.swing.JLabel lb_ProductImage;
    private javax.swing.JLabel lb_ProductImagem;
    private javax.swing.JLabel lb_Settings;
    private javax.swing.JLabel lb_Shopping;
    private javax.swing.JLabel lb_TelaRotasTitle;
    private javax.swing.JLabel lb_ValorProduto;
    private javax.swing.JPanel pn_ImagemProduto;
    private javax.swing.JPanel pn_ProductImage;
    private javax.swing.JPanel side_pane;
    private javax.swing.JTable tb_Produtos;
    private javax.swing.JTextField tf_ImagemProduto;
    private javax.swing.JTextField tf_MarcaProduto;
    private javax.swing.JTextField tf_NomeProduto;
    private javax.swing.JTextField tf_Pesquisar;
    private javax.swing.JTextField tf_ValorProduto;
    // End of variables declaration//GEN-END:variables
}
