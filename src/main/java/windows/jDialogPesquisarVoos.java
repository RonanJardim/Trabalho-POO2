package windows;

import control.GerenciaDeInterface;
import domain.Cidade;
import domain.Estado;
import domain.Regiao;

public class jDialogPesquisarVoos extends javax.swing.JDialog {

    
    public jDialogPesquisarVoos(java.awt.Frame parent, boolean modal) {   
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboRegDest = new javax.swing.JComboBox<>();
        comboEstDest = new javax.swing.JComboBox<>();
        comboCidDest = new javax.swing.JComboBox<>();
        btnVoltar = new javax.swing.JButton();
        btnPesquisarVoos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboRegOrigem = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboEstOrigem = new javax.swing.JComboBox<>();
        comboCidOrigem = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Destino"));

        jLabel5.setText("Região");

        jLabel6.setText("Estado");

        jLabel7.setText("Cidade");

        comboRegDest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboRegDestMouseClicked(evt);
            }
        });

        comboEstDest.setActionCommand("");
        comboEstDest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboEstDestMouseClicked(evt);
            }
        });

        comboCidDest.setActionCommand("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(comboEstDest, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(comboRegDest, 0, 157, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(comboCidDest, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboRegDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboEstDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboCidDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnPesquisarVoos.setText("Pesquisar");
        btnPesquisarVoos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarVoosActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Origem"));

        jLabel1.setText("Região");

        comboRegOrigem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboRegOrigemMouseClicked(evt);
            }
        });

        jLabel3.setText("Estado");

        jLabel4.setText("Cidade");

        comboEstOrigem.setActionCommand("");
        comboEstOrigem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboEstOrigemMouseClicked(evt);
            }
        });

        comboCidOrigem.setActionCommand("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(comboRegOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(comboEstOrigem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(comboCidOrigem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboRegOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboEstOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboCidOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(btnVoltar)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisarVoos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnPesquisarVoos))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        comboRegOrigem.setSelectedIndex(0);
        comboRegDest.setSelectedIndex(0);
        
        comboCidDest.removeAllItems();
        comboCidOrigem.removeAllItems();
        
        comboEstDest.removeAllItems();
        comboEstOrigem.removeAllItems();
        
       
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnPesquisarVoosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarVoosActionPerformed
        GerenciaDeInterface gerI = GerenciaDeInterface.getInstance();
        Cidade cidOrigem = (Cidade) this.comboCidOrigem.getSelectedItem();
        Cidade cidDestino = (Cidade) this.comboCidDest.getSelectedItem();
        
        gerI.getGerCid().setCidOrigem(cidOrigem);
        gerI.getGerCid().setCidDestino(cidDestino);
        
        if((cidOrigem != null) && (cidDestino != null)){
            gerI.abrirVoosDisponiveis();
            return;
        }
        System.out.println("n");
    }//GEN-LAST:event_btnPesquisarVoosActionPerformed

    private void comboEstOrigemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboEstOrigemMouseClicked
        GerenciaDeInterface gerI = GerenciaDeInterface.getInstance();
        
        Estado estado = (Estado) this.comboEstOrigem.getSelectedItem();
        gerI.carregarComboBox(comboCidOrigem, this, Cidade.class, estado, "estado");
    }//GEN-LAST:event_comboEstOrigemMouseClicked

    private void comboEstDestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboEstDestMouseClicked
        GerenciaDeInterface gerI = GerenciaDeInterface.getInstance();
        
        Estado estado = (Estado) this.comboEstDest.getSelectedItem();
        gerI.carregarComboBox(comboCidDest, this, Cidade.class, estado, "estado");
    }//GEN-LAST:event_comboEstDestMouseClicked

    private void comboRegOrigemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboRegOrigemMouseClicked
        GerenciaDeInterface gerI = GerenciaDeInterface.getInstance();
        
        Regiao regiao = (Regiao) this.comboRegOrigem.getSelectedItem();
        gerI.carregarComboBox(comboEstOrigem, this, Estado.class, regiao, "regiao");
    }//GEN-LAST:event_comboRegOrigemMouseClicked

    private void comboRegDestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboRegDestMouseClicked
        GerenciaDeInterface gerI = GerenciaDeInterface.getInstance();
        
        Regiao regiao = (Regiao) this.comboRegDest.getSelectedItem();
        gerI.carregarComboBox(comboEstDest, this, Estado.class, regiao, "regiao");
    }//GEN-LAST:event_comboRegDestMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        GerenciaDeInterface gerI = GerenciaDeInterface.getInstance();
        
        gerI.carregarComboBox(comboRegOrigem, this, Regiao.class);
        gerI.carregarComboBox(comboRegDest, this, Regiao.class);
    }//GEN-LAST:event_formWindowGainedFocus


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisarVoos;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> comboCidDest;
    private javax.swing.JComboBox<String> comboCidOrigem;
    private javax.swing.JComboBox<String> comboEstDest;
    private javax.swing.JComboBox<String> comboEstOrigem;
    private javax.swing.JComboBox<String> comboRegDest;
    private javax.swing.JComboBox<String> comboRegOrigem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
