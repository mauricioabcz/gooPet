package com.gooPet.View.Client;

import com.gooPet.Com.Database.ComercialDatabaseManager;
import com.gooPet.Com.Database.Entities.Product;
import com.gooPet.Service.ImageUpdateService;
import com.gooPet.View.Janela;
import com.gooPet.View.ReturnMessagePane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauricio.rodrigues
 */
public class JanelaCarrinho extends javax.swing.JPanel {

    private ComercialDatabaseManager banco;
    private ImageUpdateService image; 
    private List <Product> listaProdutos;
    
    public JanelaCarrinho(String actualUserName) throws IOException {
        initComponents();
        lb_ActualUser.setText(actualUserName);
        banco = ComercialDatabaseManager.getInstance();
        atualizaTabela();
        
        setColor(btn_Carrinho); 
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{btn_Shopping,btn_Home,btn_4, btn_JanelaSettings}, new JPanel[]{ind_3,ind_1, ind_4, ind_5});
        
//        ajeitaImagem();
//        testeImagem();
    }
    
    public void testeImagem() throws IOException{
        lb_ProductImage.setText("");
        lb_ProductImage.setIcon(new javax.swing.ImageIcon(".\\images\\Teste2.jpg"));
        
        lb_ProductName.setText("Jogo do Bicho");
        lb_ProductMarca.setText("Caixa Econômica Federal");
        lb_ProductValue.setText("R$ 3,00");
    }
    
    public void ajeitaImagem() {
        try {
            BufferedImage originalImage = ImageIO.read(new File(".\\images\\Teste.jpg"));
            int newWidth = 470;
            int newHeight = 370;
            BufferedImage resizedImage = resizeImage(originalImage, newWidth, newHeight);
            File outputFile = new File(".\\images\\Teste2.jpg");
            ImageIO.write(resizedImage, "jpg", outputFile);
            System.out.println("Imagem redimensionada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
        g2d.dispose();
        return resizedImage;
    }
    
    public void gotoJanelaShopping() throws IOException{
        Janela.p5 = new JanelaShopping(lb_ActualUser.getText());
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p7);
        janela.getContentPane().remove(Janela.p7);
        janela.add((Component) Janela.p5, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaAgendaHorario(){
        Janela.p4 = new JanelaAgendaHorario(lb_ActualUser.getText());
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p7);
        janela.getContentPane().remove(Janela.p7);
        janela.add(Janela.p4, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void emObras(){
        ReturnMessagePane.informationPainel("Função em desenvolvimento.");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_pane = new javax.swing.JPanel();
        btn_Home = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        lb_Home = new javax.swing.JLabel();
        btn_Carrinho = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        lb_Carrinho = new javax.swing.JLabel();
        btn_Shopping = new javax.swing.JPanel();
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
        bt_AtualizarTabelaProdutos = new javax.swing.JButton();
        lb_DadosProduto = new javax.swing.JLabel();
        bt_SalvarCarrinho = new javax.swing.JButton();
        lb_Produtos = new javax.swing.JLabel();
        lb_Nome = new javax.swing.JLabel();
        bt_Pesquisar = new javax.swing.JButton();
        tf_Pesquisar = new javax.swing.JTextField();
        lb_ProductName = new javax.swing.JLabel();
        lb_ProductValue = new javax.swing.JLabel();
        sp_Quantidade = new javax.swing.JSpinner();
        lb_ProductMarca = new javax.swing.JLabel();
        pn_ProductImage = new javax.swing.JPanel();
        lb_ProductImage = new javax.swing.JLabel();
        lb_ProductName1 = new javax.swing.JLabel();
        lb_Total = new javax.swing.JLabel();
        lb_Nome1 = new javax.swing.JLabel();
        bt_Limpar = new javax.swing.JButton();
        bt_Remover = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lb_Logout = new javax.swing.JLabel();
        lb_TelaRotasTitle = new javax.swing.JLabel();
        lb_ActualUser = new javax.swing.JLabel();

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

        btn_Carrinho.setBackground(new java.awt.Color(23, 35, 51));
        btn_Carrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_CarrinhoMouseReleased(evt);
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

        javax.swing.GroupLayout btn_CarrinhoLayout = new javax.swing.GroupLayout(btn_Carrinho);
        btn_Carrinho.setLayout(btn_CarrinhoLayout);
        btn_CarrinhoLayout.setHorizontalGroup(
            btn_CarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_CarrinhoLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Carrinho)
                .addGap(0, 36, Short.MAX_VALUE))
        );
        btn_CarrinhoLayout.setVerticalGroup(
            btn_CarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_CarrinhoLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_CarrinhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Carrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_Carrinho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 120, -1));

        btn_Shopping.setBackground(new java.awt.Color(23, 35, 51));
        btn_Shopping.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ShoppingMousePressed(evt);
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

        javax.swing.GroupLayout btn_ShoppingLayout = new javax.swing.GroupLayout(btn_Shopping);
        btn_Shopping.setLayout(btn_ShoppingLayout);
        btn_ShoppingLayout.setHorizontalGroup(
            btn_ShoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ShoppingLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Shopping)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_ShoppingLayout.setVerticalGroup(
            btn_ShoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ShoppingLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_ShoppingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Shopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_Shopping, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 120, -1));

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

        bt_AtualizarTabelaProdutos.setBackground(new java.awt.Color(255, 255, 255));
        bt_AtualizarTabelaProdutos.setText("Atualizar");
        bt_AtualizarTabelaProdutos.setFocusPainted(false);
        bt_AtualizarTabelaProdutos.setFocusable(false);
        bt_AtualizarTabelaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AtualizarTabelaProdutosActionPerformed(evt);
            }
        });

        lb_DadosProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_DadosProduto.setText("Detalhes do Produto");

        bt_SalvarCarrinho.setBackground(new java.awt.Color(255, 255, 255));
        bt_SalvarCarrinho.setText("Salvar");
        bt_SalvarCarrinho.setFocusPainted(false);
        bt_SalvarCarrinho.setFocusable(false);
        bt_SalvarCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SalvarCarrinhoActionPerformed(evt);
            }
        });

        lb_Produtos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_Produtos.setText("Produtos");

        lb_Nome.setText("Nome:");

        bt_Pesquisar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Pesquisar.setText("Pesquisar");
        bt_Pesquisar.setFocusPainted(false);
        bt_Pesquisar.setFocusable(false);
        bt_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_PesquisarActionPerformed(evt);
            }
        });

        lb_ProductName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_ProductName.setText("<Product_Name>");

        lb_ProductValue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_ProductValue.setText("<Product_Value>");

        sp_Quantidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sp_QuantidadeStateChanged(evt);
            }
        });
        sp_Quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sp_QuantidadeKeyReleased(evt);
            }
        });

        lb_ProductMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_ProductMarca.setText("<Product_Marca>");

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

        lb_ProductName1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_ProductName1.setText("Total:");

        lb_Total.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_Total.setText("<Valor_Total>");

        lb_Nome1.setText("Imagem do produto:");

        bt_Limpar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Limpar.setText("Limpar");
        bt_Limpar.setFocusPainted(false);
        bt_Limpar.setFocusable(false);
        bt_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_LimparActionPerformed(evt);
            }
        });

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
                        .addComponent(lb_Nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_Pesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Pesquisar))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lb_Produtos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(bt_AtualizarTabelaProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Remover)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lb_DadosProduto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pn_ProductImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(lb_ProductName1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_Total)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_Limpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_SalvarCarrinho))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(lb_ProductName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_ProductMarca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_ProductValue))
                            .addComponent(sp_Quantidade)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lb_Nome1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_DadosProduto)
                    .addComponent(lb_Produtos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Nome)
                    .addComponent(bt_Pesquisar)
                    .addComponent(tf_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Nome1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(pn_ProductImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_ProductValue)
                            .addComponent(lb_ProductName)
                            .addComponent(lb_ProductMarca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sp_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_AtualizarTabelaProdutos)
                    .addComponent(bt_SalvarCarrinho)
                    .addComponent(lb_ProductName1)
                    .addComponent(lb_Total)
                    .addComponent(bt_Limpar)
                    .addComponent(bt_Remover))
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
        lb_TelaRotasTitle.setText("PetShop > Carrinho");

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

    
    public void atualizaTabela(){
        limpaCampos();
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
    
    public void pesquisa(){
        limpaCampos();
        String textoPesquisa = tf_Pesquisar.getText();
        //Atualiza tabela
        ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
        //Busca Produtos
        listaProdutos = banco.productSearch(textoPesquisa);
        for (Product produto : listaProdutos) {
           ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
            produto.getNome(),
            produto.getMarca(),
            "R$ " + produto.getValor()
        }); 
        }
    }
    
    public void limpaCampos(){
        lb_ProductImage.setIcon(null);
        lb_ProductImage.setText("<Product_Image>");
        lb_ProductName.setText("");
        lb_ProductMarca.setText("");
        lb_ProductValue.setText("");
        sp_Quantidade.setValue(0);
        lb_Total.setText("0.00");
    }
    
    public void preencheProduto(){
        String nome, marca;
        nome = tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,0).toString();
        marca = tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,1).toString();
        for (Product produto : listaProdutos) {
            if (produto.getNome().equals(nome) && produto.getMarca().equals(marca)) {
                lb_ProductName.setText(produto.getNome());
                lb_ProductMarca.setText(produto.getMarca());
                lb_ProductValue.setText(Double.toString(produto.getValor()));
                
                //Processa imagem a ser exibida nessa tela
                lb_ProductImage.setText("");
                lb_ProductImage.setIcon(null);
                lb_ProductImage.setIcon(new javax.swing.ImageIcon("." + produto.getImagem()));
            }
        }
    }
    
    public void processaImagem(String imagePath, String imageName, String imageType, int width, int height){
        image = ImageUpdateService.getInstance();
        image.ajeitaImagem(imagePath, imageName, imageType, width, height);
    }
    
    public void calculaTotal() {
        if (!lb_ProductValue.getText().equals("")) {
            int qtde = Integer.parseInt(sp_Quantidade.getValue().toString());
            double valor = Double.parseDouble(lb_ProductValue.getText());
            double total = qtde * valor;

            String totalFormatted = String.format("%.2f", total);

            lb_Total.setText(totalFormatted);
        }
    }
    
    private void btn_HomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMousePressed
        // TODO add your handling code here:
        setColor(btn_Home);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_Carrinho,btn_Shopping,btn_4, btn_JanelaSettings}, new JPanel[]{ind_2,ind_3, ind_4, ind_5});
        emObras();
    }//GEN-LAST:event_btn_HomeMousePressed

    private void btn_CarrinhoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CarrinhoMouseReleased
        // TODO add your handling code here:
        setColor(btn_Carrinho);
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{btn_Home,btn_Shopping,btn_4, btn_JanelaSettings}, new JPanel[]{ind_1,ind_3, ind_4, ind_5});
        emObras();
    }//GEN-LAST:event_btn_CarrinhoMouseReleased

    private void btn_ShoppingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ShoppingMousePressed
        // TODO add your handling code here:
        setColor(btn_Shopping);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_Carrinho,btn_Home,btn_4, btn_JanelaSettings}, new JPanel[]{ind_2,ind_1, ind_4, ind_5});
        try {
            gotoJanelaShopping();
        } catch (IOException ex) {
            Logger.getLogger(JanelaCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ShoppingMousePressed

    private void btn_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MousePressed
        // TODO add your handling code here:
        setColor(btn_4);
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{btn_Carrinho,btn_Shopping,btn_Home, btn_JanelaSettings}, new JPanel[]{ind_2,ind_3, ind_1, ind_5});
        gotoJanelaAgendaHorario();
    }//GEN-LAST:event_btn_4MousePressed

    private void btn_JanelaSettingsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaSettingsMouseReleased
        // TODO add your handling code here:
        setColor(btn_JanelaSettings);
        ind_5.setOpaque(true);
        resetColor(new JPanel[]{btn_Home,btn_Shopping,btn_4, btn_Carrinho}, new JPanel[]{ind_1,ind_3, ind_4, ind_2});
        emObras();
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

    private void bt_SalvarCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SalvarCarrinhoActionPerformed
        
    }//GEN-LAST:event_bt_SalvarCarrinhoActionPerformed

    private void bt_AtualizarTabelaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AtualizarTabelaProdutosActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_bt_AtualizarTabelaProdutosActionPerformed

    private void tb_ProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ProdutosKeyReleased
        preencheProduto();
    }//GEN-LAST:event_tb_ProdutosKeyReleased

    private void tb_ProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ProdutosMouseClicked
        preencheProduto();
    }//GEN-LAST:event_tb_ProdutosMouseClicked

    private void bt_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_PesquisarActionPerformed
        pesquisa();
    }//GEN-LAST:event_bt_PesquisarActionPerformed

    private void sp_QuantidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sp_QuantidadeStateChanged
        calculaTotal();
    }//GEN-LAST:event_sp_QuantidadeStateChanged

    private void bt_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_LimparActionPerformed
        limpaCampos();
    }//GEN-LAST:event_bt_LimparActionPerformed

    private void sp_QuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sp_QuantidadeKeyReleased
        calculaTotal();
    }//GEN-LAST:event_sp_QuantidadeKeyReleased

    private void bt_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RemoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_RemoverActionPerformed

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
    private javax.swing.JButton bt_AtualizarTabelaProdutos;
    private javax.swing.JButton bt_Limpar;
    private javax.swing.JButton bt_Pesquisar;
    private javax.swing.JButton bt_Remover;
    private javax.swing.JButton bt_SalvarCarrinho;
    private javax.swing.JPanel btn_4;
    private javax.swing.JPanel btn_Carrinho;
    private javax.swing.JPanel btn_Home;
    private javax.swing.JPanel btn_JanelaSettings;
    private javax.swing.JPanel btn_Shopping;
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
    private javax.swing.JLabel lb_Home;
    private javax.swing.JLabel lb_Logout;
    private javax.swing.JLabel lb_Nome;
    private javax.swing.JLabel lb_Nome1;
    private javax.swing.JLabel lb_ProductImage;
    private javax.swing.JLabel lb_ProductMarca;
    private javax.swing.JLabel lb_ProductName;
    private javax.swing.JLabel lb_ProductName1;
    private javax.swing.JLabel lb_ProductValue;
    private javax.swing.JLabel lb_Produtos;
    private javax.swing.JLabel lb_Settings;
    private javax.swing.JLabel lb_Shopping;
    private javax.swing.JLabel lb_TelaRotasTitle;
    private javax.swing.JLabel lb_Total;
    private javax.swing.JPanel pn_ProductImage;
    private javax.swing.JPanel side_pane;
    private javax.swing.JSpinner sp_Quantidade;
    private javax.swing.JTable tb_Produtos;
    private javax.swing.JTextField tf_Pesquisar;
    // End of variables declaration//GEN-END:variables
}
