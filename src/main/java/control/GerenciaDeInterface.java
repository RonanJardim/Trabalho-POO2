package control;

import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.HibernateException;
import windows.jDialogVoosDisponiveis;
import windows.jDialogCadAviao;
import windows.jDialogCadCliente;
import windows.jDialogCheckin;
import windows.jDialogInformacoesVoo;
import windows.jDialogListar;
import windows.jDialogPaginaReserva;
import windows.jDialogPesquisarVoos;
import windows.jFrmTelaInicial;

public class GerenciaDeInterface {
    private jFrmTelaInicial frmTelaInicial = null;
    private jDialogCadAviao cadAviao = null;
    private jDialogCadCliente cadCliente = null;
    private jDialogCheckin jCheckin = null;
    private jDialogInformacoesVoo infoVoo = null;
    private jDialogPaginaReserva pagReserva = null;
    private jDialogPesquisarVoos pesqVoos = null;
    private jDialogVoosDisponiveis voosDisponiveis = null;
    private jDialogListar listar = null;

    private static GerenciaDeInterface myInstance = new GerenciaDeInterface();
    private GerenciaDeDados gerDom;    // NÃO PODE ser static
    private GerenciaDeCidades gerCid;
    
    private GerenciaDeInterface() {
        gerDom = new GerenciaDeDados();
        gerCid = new GerenciaDeCidades();
    }

    public static GerenciaDeInterface getInstance() {
        return myInstance;
    }

    public GerenciaDeDados getGerenciadorDominio() {
        return gerDom;
    }

    public GerenciaDeCidades getGerCid() {
        return gerCid;
    }

    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null){     
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class).newInstance(parent,true);                
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() + ". " + ex.getMessage() );
            } 
        }       
        dlg.setVisible(true); 
        
        return dlg;
    }

    public void abrirJanelaPrincipal() {
        if (frmTelaInicial == null) {
            frmTelaInicial = new jFrmTelaInicial(this);
        }

        frmTelaInicial.setVisible(true);
    }

    public void abrirJanelaCadCliente() {
        cadCliente = (jDialogCadCliente) abrirJanela(frmTelaInicial, cadCliente, jDialogCadCliente.class);
    }

    public void abrirJanelaCadAviao() {
        cadAviao = (jDialogCadAviao) abrirJanela(frmTelaInicial, cadAviao, jDialogCadAviao.class);
    }

    public void abrirJanelaCheckin() {
        jCheckin = (jDialogCheckin) abrirJanela(frmTelaInicial, jCheckin, jDialogCheckin.class);
    }

    public void abrirJanelaInformacoes() {
        infoVoo = (jDialogInformacoesVoo) abrirJanela(frmTelaInicial, infoVoo, jDialogInformacoesVoo.class);
    }

    public void abrirPaginaReservas() {
        pagReserva = (jDialogPaginaReserva) abrirJanela(frmTelaInicial, pagReserva, jDialogPaginaReserva.class);
    }

    public void abrirPesquisarVoos() {
        pesqVoos = (jDialogPesquisarVoos) abrirJanela(frmTelaInicial, pesqVoos, jDialogPesquisarVoos.class);
    }

    public void abrirVoosDisponiveis() {
        voosDisponiveis = (jDialogVoosDisponiveis) abrirJanela(frmTelaInicial, voosDisponiveis, jDialogVoosDisponiveis.class);
    }
    
    public void abrirListar(){
        listar = (jDialogListar) abrirJanela(frmTelaInicial, listar, jDialogListar.class);
    }

    public void fecharJanela(JDialog janela) {
        janela.dispose();
    }

    public <T> void carregarComboBox(JComboBox combo, JDialog janela, Class<T> classe) {
        try {
            List<T> lista = (List<T>) this.gerDom.list(classe);
            combo.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(janela, "Erro carregar Combo Box: " + ex);
        }
    }

    public <T> void carregarComboBox(JComboBox combo, JDialog janela, Class<T> classe, Object id, String nome) {
        try {
            List<T> lista = (List<T>) this.gerDom.listById(classe, id, nome);
            combo.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(janela, "Erro carregar Combo Box: " + ex);
        }
    }
    
//    public void carregarTabela(JTable tabela, JDialog janela, Class<?> classe){
//        try{
//            List<?> lista = (List<?>) this.gerDom.list(classe);
//            ((DefaultTableModel) tabela.getModel()).setNumRows(0);            
//            for (Object obj : lista){
//                // ADICIONAR LINHA NA TABELA        
//                ((DefaultTableModel)tabela.getModel()).addRow((Object[]) obj.getClass().getMethod("toArray").invoke(obj));                
//            }
//        }catch(HibernateException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex){
//            JOptionPane.showMessageDialog(janela, "Erro carregar Tabela: "+ ex);
//        }  
//    }
    
    public void carregarTabela(JTable tabela, TableModel modelo) {
        tabela.setModel(modelo);
    }
    
    public void excluirTabela(JTable tabela, JDialog janela){
        int linha = tabela.getSelectedRow();
        if ( linha >= 0 ) {  
            if ( JOptionPane.showConfirmDialog(janela, "Deseja realmente excluir?", "Título", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ) {
                try{
                    this.gerDom.excluir(tabela.getValueAt(linha, 0));
                    ((DefaultTableModel)tabela.getModel()).removeRow(linha);
                    JOptionPane.showMessageDialog(janela, "excluído com sucesso.");
                }catch(HibernateException ex){
                    JOptionPane.showMessageDialog(janela, "Erro: Nao pode ser excluido");
                }
            }             
        }else{
            JOptionPane.showMessageDialog(janela,"Selecione uma linha." ,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFrmTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrmTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrmTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrmTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // TRADUÇÃO
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");

        // Abrir o FrmPrincipal
        GerenciaDeInterface.getInstance().abrirJanelaPrincipal();

    }
}
