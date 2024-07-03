package windows;

import control.GerenciaDeInterface;


public class jFrmTelaInicial extends javax.swing.JFrame {

    private GerenciaDeInterface gerI;
    
   public jFrmTelaInicial(GerenciaDeInterface newGerI) {
       initComponents();
       setLocationRelativeTo(null);
        gerI = newGerI;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemPesqVoos = new javax.swing.JMenuItem();
        menuItemReservar = new javax.swing.JMenuItem();
        menuItemGerIti = new javax.swing.JMenuItem();
        menuItenCheck_in = new javax.swing.JMenuItem();
        menuItemCadCli = new javax.swing.JMenuItem();
        menuItemCadAviao = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(450, 350));
        setMinimumSize(new java.awt.Dimension(448, 301));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setText("Voo Certo Linhas Aéreas");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 30, 130, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Design sem nome.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 450, 280);

        jMenu1.setText("Menu");

        menuItemPesqVoos.setText("Pesquisar Voos");
        menuItemPesqVoos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPesqVoosActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemPesqVoos);

        menuItemReservar.setText("Reservar");
        menuItemReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemReservarActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemReservar);

        menuItemGerIti.setText("Gerenciar Itinerário");
        menuItemGerIti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerItiActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemGerIti);

        menuItenCheck_in.setText("Check-in");
        menuItenCheck_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItenCheck_inActionPerformed(evt);
            }
        });
        jMenu1.add(menuItenCheck_in);

        menuItemCadCli.setText("Cadastrar Cliente");
        menuItemCadCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCadCliActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemCadCli);

        menuItemCadAviao.setText("Cadastrar Aviao");
        menuItemCadAviao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCadAviaoActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemCadAviao);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemPesqVoosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPesqVoosActionPerformed
        gerI.abrirPesquisarVoos();
    }//GEN-LAST:event_menuItemPesqVoosActionPerformed

    private void menuItemReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemReservarActionPerformed
        gerI.abrirPaginaReservas();
    }//GEN-LAST:event_menuItemReservarActionPerformed

    private void menuItemGerItiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerItiActionPerformed
        gerI.abrirJanelaInformacoes();
    }//GEN-LAST:event_menuItemGerItiActionPerformed

    private void menuItenCheck_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItenCheck_inActionPerformed
        gerI.abrirJanelaCheckin();
    }//GEN-LAST:event_menuItenCheck_inActionPerformed

    private void menuItemCadCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCadCliActionPerformed
        gerI.abrirJanelaCadCliente();
    }//GEN-LAST:event_menuItemCadCliActionPerformed

    private void menuItemCadAviaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCadAviaoActionPerformed
        gerI.abrirJanelaCadAviao();
    }//GEN-LAST:event_menuItemCadAviaoActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem menuItemCadAviao;
    private javax.swing.JMenuItem menuItemCadCli;
    private javax.swing.JMenuItem menuItemGerIti;
    private javax.swing.JMenuItem menuItemPesqVoos;
    private javax.swing.JMenuItem menuItemReservar;
    private javax.swing.JMenuItem menuItenCheck_in;
    // End of variables declaration//GEN-END:variables
}
