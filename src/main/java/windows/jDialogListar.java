package windows;

import control.ChekinAbstractTableModel;
import control.GerenciaDeInterface;
import control.ClienteAbstractTableModel;
import control.EmpresaAbstractTableModel;
import control.GerenciaDeDados;
import domain.Check_in;
import domain.Cliente;
import domain.Empresa;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class jDialogListar extends javax.swing.JDialog {

    public jDialogListar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        comboTipoPesq = new javax.swing.JComboBox<>();
        btnPesquisar = new javax.swing.JButton();
        txtPesq = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboTipoPesq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clientes", "Check-in", "Empresas" }));
        comboTipoPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoPesqActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboTipoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPesq)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(txtPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboTipoPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoPesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoPesqActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        GerenciaDeInterface gerI = GerenciaDeInterface.getInstance();

        String tipoPesq = comboTipoPesq.getSelectedItem().toString();

        switch (tipoPesq) {
            case "Clientes":
                List<Cliente> clientes = gerI.getGerenciadorDominio().listaClientes(Cliente.class);
                ClienteAbstractTableModel cliTableModel = new ClienteAbstractTableModel();
                cliTableModel.setLista(clientes);
                gerI.carregarTabela(jTable1, cliTableModel);
                break;
            case "Check-in":
                List<Check_in> checkIns = gerI.getGerenciadorDominio().listaCheckin(Check_in.class);
                ChekinAbstractTableModel checkInTableModel = new ChekinAbstractTableModel();
                checkInTableModel.setLista(checkIns);
                gerI.carregarTabela(jTable1, checkInTableModel);
                break;
            case "Empresas":
                List<Empresa> empresas = gerI.getGerenciadorDominio().listaEmpresas(Empresa.class);
                EmpresaAbstractTableModel empTableModel = new EmpresaAbstractTableModel();
                empTableModel.setLista(empresas);
                gerI.carregarTabela(jTable1, empTableModel);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Tipo de pesquisa desconhecido.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = jTable1.getSelectedRow();
        if (linha >= 0) {
            if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Excluir item", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                linha = jTable1.convertRowIndexToModel(linha);
                try {
                    // Excluir do banco de dados e da tabela
                    GerenciaDeDados gerenciaDeDados = new GerenciaDeDados();

                    if (jTable1.getModel() instanceof ClienteAbstractTableModel) {
                        ClienteAbstractTableModel model = (ClienteAbstractTableModel) jTable1.getModel();
                        Cliente cliente = model.getCliente(linha);
                        gerenciaDeDados.excluirCliente(cliente);
                        model.remover(linha);
                    } else if (jTable1.getModel() instanceof ChekinAbstractTableModel) {
                        ChekinAbstractTableModel model = (ChekinAbstractTableModel) jTable1.getModel();
                        Check_in checkIn = model.getChekin(linha);
                        gerenciaDeDados.excluirReservasPorCheckin(checkIn); // Excluir dependentes
                        gerenciaDeDados.excluirCheckin(checkIn); // Excluir check-in
                        model.remover(linha);
                    } else if (jTable1.getModel() instanceof EmpresaAbstractTableModel) {
                        EmpresaAbstractTableModel model = (EmpresaAbstractTableModel) jTable1.getModel();
                        Empresa empresa = model.getEmpresa(linha);
                        gerenciaDeDados.excluirEmpresa(empresa);
                        model.remover(linha);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir o item: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
//        int linha = jTable1.getSelectedRow();
//        if (linha >= 0) {
//            linha = jTable1.convertRowIndexToModel(linha);
//
//            GerenciaDeDados gerenciaDeDados = new GerenciaDeDados();
//
//            if (jTable1.getModel() instanceof ClienteAbstractTableModel) {
//                ClienteAbstractTableModel model = (ClienteAbstractTableModel) jTable1.getModel();
//                Cliente cliente = model.getCliente(linha);
//                // Carregar os valores atuais nos campos de edição
//                txtNome.setText(cliente.getNome());
//                txtEndereco.setText(cliente.getEndereco().getEndereco());
//                txtTelefone.setText(cliente.getTelefone());
//
//                // Exibir diálogo para edição ou campos de edição
//                int result = JOptionPane.showConfirmDialog(this, new Object[]{txtNome, txtEndereco, txtTelefone}, "Editar Cliente", JOptionPane.OK_CANCEL_OPTION);
//                if (result == JOptionPane.OK_OPTION) {
//                    // Atualizar cliente com os novos valores dos campos de texto
//                    cliente.setNome(txtNome.getText());
//                    cliente.getEndereco().setEndereco(txtEndereco.getText());
//                    cliente.setTelefone(txtTelefone.getText());
//                    // Atualizar cliente no banco de dados
//                    gerenciaDeDados.atualizarCliente(cliente);
//                    // Atualizar a tabela
//                    model.fireTableRowsUpdated(linha, linha);
//                }
//            } else if (jTable1.getModel() instanceof ChekinAbstractTableModel) {
//                ChekinAbstractTableModel model = (ChekinAbstractTableModel) jTable1.getModel();
//                Check_in checkIn = model.getChekin(linha);
//                // Carregar os valores atuais nos campos de edição
//                txtNome.setText(checkIn.getReserva().getReserva()); // Exemplo
//
//                // Exibir diálogo para edição ou campos de edição
//                int result = JOptionPane.showConfirmDialog(this, new Object[]{txtNome}, "Editar Check-in", JOptionPane.OK_CANCEL_OPTION);
//                if (result == JOptionPane.OK_OPTION) {
//                    // Atualizar check-in com os novos valores dos campos de texto
//                    checkIn.getReserva().setReserva(txtNome.getText()); // Exemplo
//                    // Atualizar check-in no banco de dados
//                    gerenciaDeDados.atualizarCheckin(checkIn);
//                    // Atualizar a tabela
//                    model.fireTableRowsUpdated(linha, linha);
//                }
//            } else if (jTable1.getModel() instanceof EmpresaAbstractTableModel) {
//                EmpresaAbstractTableModel model = (EmpresaAbstractTableModel) jTable1.getModel();
//                Empresa empresa = model.getEmpresa(linha);
//                // Carregar os valores atuais nos campos de edição
//                txtNome.setText(empresa.getNomeEmpresa());
//                txtEndereco.setText(empresa.getEndereco().getEndereco());
//                txtTelefone.setText(empresa.getTelefone());
//
//                // Exibir diálogo para edição ou campos de edição
//                int result = JOptionPane.showConfirmDialog(this, new Object[]{txtNome, txtEndereco, txtTelefone}, "Editar Empresa", JOptionPane.OK_CANCEL_OPTION);
//                if (result == JOptionPane.OK_OPTION) {
//                    // Atualizar empresa com os novos valores dos campos de texto
//                    empresa.setNomeEmpresa(txtNome.getText());
//                    empresa.getEndereco().setEndereco(txtEndereco.getText());
//                    empresa.setTelefone(txtTelefone.getText());
//                    // Atualizar empresa no banco de dados
//                    gerenciaDeDados.atualizarEmpresa(empresa);
//                    // Atualizar a tabela
//                    model.fireTableRowsUpdated(linha, linha);
//                }
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> comboTipoPesq;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtPesq;
    // End of variables declaration//GEN-END:variables
}