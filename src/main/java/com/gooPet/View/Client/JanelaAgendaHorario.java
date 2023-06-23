package com.gooPet.View.Client;

import com.gooPet.View.Janela;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author mauricio.rodrigues
 */
public class JanelaAgendaHorario extends javax.swing.JPanel {

    public JanelaAgendaHorario(String actualUserName) {
        initComponents();
        lb_ActualUser.setText(actualUserName);
        
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
        tb_Horarios = new javax.swing.JTable();
        bt_AtualizarTabelaHorarios = new javax.swing.JButton();
        lb_DadosAgendamento = new javax.swing.JLabel();
        lb_Horario = new javax.swing.JLabel();
        lb_Cliente = new javax.swing.JLabel();
        bt_Limpar = new javax.swing.JButton();
        bt_SolicitarAgendamento = new javax.swing.JButton();
        lb_DestinosSelecionados = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_MeusHorarios = new javax.swing.JTable();
        bt_Salvar = new javax.swing.JButton();
        lb_Pet = new javax.swing.JLabel();
        lb_Observacao = new javax.swing.JLabel();
        tf_Observacao = new javax.swing.JTextField();
        bt_AtualizarMeusHorarios = new javax.swing.JButton();
        bt_Desce = new javax.swing.JButton();
        lb_HorariosDisponiveis = new javax.swing.JLabel();
        lb_Data = new javax.swing.JLabel();
        bt_Pesquisar = new javax.swing.JButton();
        tf_Horario = new javax.swing.JTextField();
        tf_Cliente = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        cb_Pet = new javax.swing.JComboBox<>();
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

        tb_Horarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Horário Início", "Horário Fim", "Status"
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
        tb_Horarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_HorariosMouseClicked(evt);
            }
        });
        tb_Horarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_HorariosKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tb_Horarios);

        bt_AtualizarTabelaHorarios.setBackground(new java.awt.Color(255, 255, 255));
        bt_AtualizarTabelaHorarios.setText("Atualizar");
        bt_AtualizarTabelaHorarios.setFocusPainted(false);
        bt_AtualizarTabelaHorarios.setFocusable(false);
        bt_AtualizarTabelaHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AtualizarTabelaHorariosActionPerformed(evt);
            }
        });

        lb_DadosAgendamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_DadosAgendamento.setText("Dados do Agendamento");

        lb_Horario.setText("Horário:");

        lb_Cliente.setText("Cliente:");

        bt_Limpar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Limpar.setText("Limpar");
        bt_Limpar.setFocusPainted(false);
        bt_Limpar.setFocusable(false);
        bt_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_LimparActionPerformed(evt);
            }
        });

        bt_SolicitarAgendamento.setBackground(new java.awt.Color(255, 255, 255));
        bt_SolicitarAgendamento.setText("Solicitar Agendamento");
        bt_SolicitarAgendamento.setFocusPainted(false);
        bt_SolicitarAgendamento.setFocusable(false);
        bt_SolicitarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SolicitarAgendamentoActionPerformed(evt);
            }
        });

        lb_DestinosSelecionados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_DestinosSelecionados.setText("Meus horários");

        tb_MeusHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Horário Início", "Horário Fim", "Pet"
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
        jScrollPane2.setViewportView(tb_MeusHorarios);

        bt_Salvar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Salvar.setText("Salvar");
        bt_Salvar.setFocusPainted(false);
        bt_Salvar.setFocusable(false);
        bt_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SalvarActionPerformed(evt);
            }
        });

        lb_Pet.setText("Pet:");

        lb_Observacao.setText("Observação:");

        bt_AtualizarMeusHorarios.setBackground(new java.awt.Color(255, 255, 255));
        bt_AtualizarMeusHorarios.setText("Atualizar");
        bt_AtualizarMeusHorarios.setFocusPainted(false);
        bt_AtualizarMeusHorarios.setFocusable(false);
        bt_AtualizarMeusHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AtualizarMeusHorariosActionPerformed(evt);
            }
        });

        bt_Desce.setBackground(new java.awt.Color(255, 255, 255));
        bt_Desce.setText("Desmarcar Agendamento");
        bt_Desce.setFocusPainted(false);
        bt_Desce.setFocusable(false);
        bt_Desce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DesceActionPerformed(evt);
            }
        });

        lb_HorariosDisponiveis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_HorariosDisponiveis.setText("Horários Disponíveis");

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

        tf_Horario.setEditable(false);

        tf_Cliente.setEditable(false);

        cb_Pet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

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
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Pesquisar))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_AtualizarTabelaHorarios)
                            .addComponent(lb_HorariosDisponiveis))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(bt_Limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_SolicitarAgendamento))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(bt_AtualizarMeusHorarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_Desce))
                            .addComponent(lb_DadosAgendamento)
                            .addComponent(lb_DestinosSelecionados)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_Observacao)
                                    .addComponent(lb_Pet)
                                    .addComponent(lb_Cliente)
                                    .addComponent(lb_Horario))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_Horario)
                                    .addComponent(tf_Cliente)
                                    .addComponent(tf_Observacao)
                                    .addComponent(cb_Pet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_DadosAgendamento)
                    .addComponent(lb_HorariosDisponiveis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_Horario)
                        .addComponent(lb_Data)
                        .addComponent(bt_Pesquisar)
                        .addComponent(tf_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Cliente)
                            .addComponent(tf_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Pet)
                            .addComponent(cb_Pet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Observacao)
                            .addComponent(tf_Observacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_SolicitarAgendamento)
                            .addComponent(bt_Salvar)
                            .addComponent(bt_Limpar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_DestinosSelecionados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_AtualizarTabelaHorarios)
                    .addComponent(bt_AtualizarMeusHorarios)
                    .addComponent(bt_Desce))
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
        lb_TelaRotasTitle.setText("PetShop > Agenda");

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
            Logger.getLogger(JanelaAgendaHorario.class.getName()).log(Level.SEVERE, null, ex);
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

    private void bt_DesceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DesceActionPerformed
        
    }//GEN-LAST:event_bt_DesceActionPerformed

    private void bt_AtualizarMeusHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AtualizarMeusHorariosActionPerformed
        
    }//GEN-LAST:event_bt_AtualizarMeusHorariosActionPerformed

    private void bt_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SalvarActionPerformed
        
    }//GEN-LAST:event_bt_SalvarActionPerformed

    private void bt_SolicitarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SolicitarAgendamentoActionPerformed
        
    }//GEN-LAST:event_bt_SolicitarAgendamentoActionPerformed

    private void bt_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_LimparActionPerformed
        
    }//GEN-LAST:event_bt_LimparActionPerformed

    private void bt_AtualizarTabelaHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AtualizarTabelaHorariosActionPerformed
       
    }//GEN-LAST:event_bt_AtualizarTabelaHorariosActionPerformed

    private void tb_HorariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_HorariosKeyReleased
        //        selecionarVeiculo();
        //        atualizaVinculoComTransportadores();
    }//GEN-LAST:event_tb_HorariosKeyReleased

    private void tb_HorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_HorariosMouseClicked
        //        selecionarVeiculo();
        //        atualizaVinculoComTransportadores();
    }//GEN-LAST:event_tb_HorariosMouseClicked

    private void bt_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_PesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_PesquisarActionPerformed

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
    private javax.swing.JButton bt_AtualizarMeusHorarios;
    private javax.swing.JButton bt_AtualizarTabelaHorarios;
    private javax.swing.JButton bt_Desce;
    private javax.swing.JButton bt_Limpar;
    private javax.swing.JButton bt_Pesquisar;
    private javax.swing.JButton bt_Salvar;
    private javax.swing.JButton bt_SolicitarAgendamento;
    private javax.swing.JPanel btn_4;
    private javax.swing.JPanel btn_Home;
    private javax.swing.JPanel btn_JanelaRelatorios;
    private javax.swing.JPanel btn_JanelaSettings;
    private javax.swing.JPanel btn_JanelaShopping;
    private javax.swing.JComboBox<String> cb_Pet;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_4;
    private javax.swing.JPanel ind_5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_ActualUser;
    private javax.swing.JLabel lb_Agenda;
    private javax.swing.JLabel lb_Carrinho;
    private javax.swing.JLabel lb_Cliente;
    private javax.swing.JLabel lb_DadosAgendamento;
    private javax.swing.JLabel lb_Data;
    private javax.swing.JLabel lb_DestinosSelecionados;
    private javax.swing.JLabel lb_Home;
    private javax.swing.JLabel lb_Horario;
    private javax.swing.JLabel lb_HorariosDisponiveis;
    private javax.swing.JLabel lb_Logout;
    private javax.swing.JLabel lb_Observacao;
    private javax.swing.JLabel lb_Pet;
    private javax.swing.JLabel lb_Settings;
    private javax.swing.JLabel lb_Shopping;
    private javax.swing.JLabel lb_TelaRotasTitle;
    private javax.swing.JPanel side_pane;
    private javax.swing.JTable tb_Horarios;
    private javax.swing.JTable tb_MeusHorarios;
    private javax.swing.JTextField tf_Cliente;
    private javax.swing.JTextField tf_Horario;
    private javax.swing.JTextField tf_Observacao;
    // End of variables declaration//GEN-END:variables
}
