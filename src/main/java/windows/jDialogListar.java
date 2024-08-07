package windows;

import control.ChekinAbstractTableModel;
import control.GerenciaDeInterface;
import control.ClienteAbstractTableModel;
import control.EmpresaAbstractTableModel;
import control.FuncoesUteis;
import control.GerenciaDeDados;
import control.GerenciadordeRelatorios;
import domain.Check_in;
import domain.Cliente;
import domain.Empresa;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class jDialogListar extends javax.swing.JDialog {
    
    private ClienteAbstractTableModel cliTableModel = null;
    private EmpresaAbstractTableModel empTableModel = null;
    
    private Empresa empresaEdit = null;
    private Cliente clienteEdit = null;

    public jDialogListar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        comboTipoPesq = new javax.swing.JComboBox<>();
        btnPesquisar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        painelEmpresa = new javax.swing.JPanel();
        txtNomeEditEmpresa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtCnpjEditEmpresa = new javax.swing.JTextField();
        txtCelularEditEmpresa = new javax.swing.JTextField();
        painelCliente = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        txtNomeEditCliente = new javax.swing.JTextField();
        txtDataEditCliente = new javax.swing.JTextField();
        txtCelullarEditCliente = new javax.swing.JTextField();
        txtEstadoEditCliente = new javax.swing.JTextField();
        txtCidadeEditCliente = new javax.swing.JTextField();

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

        jButton3.setText("Relatórios");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboTipoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPesquisar)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(jButton3))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        painelEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder("Edição Empresa"));

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelEmpresaLayout = new javax.swing.GroupLayout(painelEmpresa);
        painelEmpresa.setLayout(painelEmpresaLayout);
        painelEmpresaLayout.setHorizontalGroup(
            painelEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEmpresaLayout.createSequentialGroup()
                .addGroup(painelEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEmpresaLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jButton1))
                    .addGroup(painelEmpresaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(painelEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomeEditEmpresa)
                            .addComponent(txtCnpjEditEmpresa)
                            .addComponent(txtCelularEditEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        painelEmpresaLayout.setVerticalGroup(
            painelEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEmpresaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtNomeEditEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCnpjEditEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCelularEditEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        painelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Edição Cliente"));

        jButton2.setText("Confirmar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelClienteLayout = new javax.swing.GroupLayout(painelCliente);
        painelCliente.setLayout(painelClienteLayout);
        painelClienteLayout.setHorizontalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButton2)
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addComponent(txtNomeEditCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDataEditCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCelullarEditCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEstadoEditCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCidadeEditCliente, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        painelClienteLayout.setVerticalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelClienteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtNomeEditCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDataEditCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCelullarEditCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEstadoEditCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCidadeEditCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GerenciaDeInterface gerI = GerenciaDeInterface.getInstance();
        String nome = this.txtNomeEditEmpresa.getText();
        String cnpj = this.txtCnpjEditEmpresa.getText();
        String numero = this.txtCelularEditEmpresa.getText();
        
        int id = gerI.getGerenciadorDominio().atualizarEmpresa(this.empresaEdit, nome, cnpj, numero);
        
        //LIMPAR CAMPOS
        this.empresaEdit = null; 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            GerenciaDeInterface gerI = GerenciaDeInterface.getInstance();
            String nome = this.txtNomeEditCliente.getText();
            String data = this.txtDataEditCliente.getText();
            String numero = this.txtCelullarEditCliente.getText();
            String estado = this.txtEstadoEditCliente.getText();
            String cidade = this.txtCidadeEditCliente.getText();
            
            int id = gerI.getGerenciadorDominio().atualizarCliente(this.clienteEdit, nome, FuncoesUteis.strToDate(data), numero, estado, cidade);
            
            //LIMPAR CAMPOS
            this.clienteEdit = null;
        } catch (ParseException ex) {
            Logger.getLogger(jDialogListar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        GerenciaDeInterface gerI = GerenciaDeInterface.getInstance();

        String tipoPesq = comboTipoPesq.getSelectedItem().toString();

        switch (tipoPesq) {
            case "Clientes":
                List<Cliente> clientes = gerI.getGerenciadorDominio().listaClientes(Cliente.class);
                gerI.getGerRel().relComLista(clientes, "relClientes.jasper");
                break;
            case "Check-in":
                List<Check_in> checkIns = gerI.getGerenciadorDominio().listaCheckin(Check_in.class);
                
                break;
            case "Empresas":
                List<Empresa> empresas = gerI.getGerenciadorDominio().listaEmpresas(Empresa.class);
                gerI.getGerRel().relComLista(empresas, "relEmpresas.jasper");
                break;
            default:
                JOptionPane.showMessageDialog(this, "Tipo de pesquisa desconhecido.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                break;
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void comboTipoPesqActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_comboTipoPesqActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_comboTipoPesqActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPesquisarActionPerformed
        GerenciaDeInterface gerI = GerenciaDeInterface.getInstance();

        String tipoPesq = comboTipoPesq.getSelectedItem().toString();

        switch (tipoPesq) {
            case "Clientes":
                List<Cliente> clientes = gerI.getGerenciadorDominio().listaClientes(Cliente.class);
                cliTableModel = new ClienteAbstractTableModel();
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
                empTableModel = new EmpresaAbstractTableModel();
                empTableModel.setLista(empresas);
                gerI.carregarTabela(jTable1, empTableModel);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Tipo de pesquisa desconhecido.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                break;
        }

    }// GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExcluirActionPerformed
        int linha = jTable1.getSelectedRow();
        if (linha >= 0) {
            if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Excluir item",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
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
                    JOptionPane.showMessageDialog(this, "Erro ao excluir o item: " + e.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        GerenciaDeInterface gerI = GerenciaDeInterface.getInstance();

        //jTable1.setModel(new DefaultTableModel());
        dispose();

    }// GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditarActionPerformed
        GerenciaDeInterface gerI = GerenciaDeInterface.getInstance();

        int selectedRow = jTable1.getSelectedRow();

        if (jTable1.getSelectedRow() >= 0) {
            try {
                int linha = selectedRow;
                
                String tipoPesq = comboTipoPesq.getSelectedItem().toString();
                
                switch (tipoPesq) {
                    case "Clientes":
                        Cliente cliente = this.cliTableModel.getCliente(linha);
                        this.clienteEdit = cliente;
                        this.txtNomeEditCliente.setText(cliente.getNome());                        
                        this.txtDataEditCliente.setText(FuncoesUteis.dateToStr(cliente.getDtNasc()));  
                        this.txtCelullarEditCliente.setText(cliente.getTelefone());
                        this.txtEstadoEditCliente.setText(cliente.getEndereco().getEstado());
                        this.txtCidadeEditCliente.setText(cliente.getEndereco().getCidade());
                        
                        break;
                        
                    case "Check-in":
                        JOptionPane.showMessageDialog(this, "Não é possivel alterar um Check-in",
                                "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                        
                    case "Empresas":
                        Empresa empresa = this.empTableModel.getEmpresa(linha);
                        this.empresaEdit = empresa;
                        this.txtNomeEditEmpresa.setText(empresa.getNomeEmpresa());
                        this.txtCnpjEditEmpresa.setText(empresa.getCnpj());
                        this.txtCelularEditEmpresa.setText(empresa.getTelefone());
                        
                        break;
                    default:
                        break;
                }
            } catch (ParseException ex) {
                Logger.getLogger(jDialogListar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    // GEN-LAST:event_btnEditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> comboTipoPesq;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel painelCliente;
    private javax.swing.JPanel painelEmpresa;
    private javax.swing.JTextField txtCelularEditEmpresa;
    private javax.swing.JTextField txtCelullarEditCliente;
    private javax.swing.JTextField txtCidadeEditCliente;
    private javax.swing.JTextField txtCnpjEditEmpresa;
    private javax.swing.JTextField txtDataEditCliente;
    private javax.swing.JTextField txtEstadoEditCliente;
    private javax.swing.JTextField txtNomeEditCliente;
    private javax.swing.JTextField txtNomeEditEmpresa;
    // End of variables declaration//GEN-END:variables
}
