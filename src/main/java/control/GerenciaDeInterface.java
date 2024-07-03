package control;

import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.hibernate.HibernateException;
import windows.jDialogCadAviao;
import windows.jDialogCadCliente;
import windows.jDialogCheckin;
import windows.jDialogInformacoesVoo;
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
    
    private static GerenciaDeInterface myInstance = new GerenciaDeInterface();
    private GerenciaDeDados gerDom;    // NÃO PODE ser static
    
    private GerenciaDeInterface(){
        gerDom = new GerenciaDeDados();
    }
    
    public static GerenciaDeInterface getInstance() {
        return myInstance;       
    }
    
    public GerenciaDeDados getGerenciadorDominio() {
        return gerDom;       
    }
    
   private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe){
        if(dlg == null){
            try {
                try {
                    dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, GerenciaDeInterface.class).newInstance(parent,true,this);
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    JOptionPane.showMessageDialog(frmTelaInicial, "Erro!: "+ex);
                }
            } catch (NoSuchMethodException | SecurityException ex) {
                JOptionPane.showMessageDialog(frmTelaInicial, "Erro!: "+ex);
            }       
        }
        dlg.setVisible(true);
        return dlg;
    }
    
    public void abrirJanelaPrincipal(){
        if(frmTelaInicial == null){
         frmTelaInicial = new jFrmTelaInicial(this);
        }
        
        frmTelaInicial.setVisible(true);
    }
    
    public void abrirJanelaCadCliente(){
        cadCliente = (jDialogCadCliente) abrirJanela(frmTelaInicial, cadCliente, jDialogCadCliente.class  );
    }
    
    public void abrirJanelaCadAviao(){
        cadAviao = (jDialogCadAviao) abrirJanela(frmTelaInicial, cadAviao, jDialogCadAviao.class);
    }
    
    public void abrirJanelaCheckin(){
        jCheckin = (jDialogCheckin)abrirJanela(frmTelaInicial, jCheckin, jDialogCheckin.class);
    }
    
    public void abrirJanelaInformacoes(){
        infoVoo = (jDialogInformacoesVoo)abrirJanela(frmTelaInicial, infoVoo, jDialogInformacoesVoo.class);
    }
    
    public void abrirPaginaReservas(){
        pagReserva = (jDialogPaginaReserva)abrirJanela(frmTelaInicial, pagReserva, jDialogPaginaReserva.class);
    }
    
    public void abrirPesquisarVoos(){
        pesqVoos = (jDialogPesquisarVoos)abrirJanela(frmTelaInicial, pesqVoos, jDialogPesquisarVoos.class);
    }
    
    public <T> void carregarComboBox(JComboBox combo, JDialog janela, Class<T> classe) {
        try {
            List<T> lista = (List<T>) this.gerDom.list(classe);
            combo.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(janela, "Erro carregar Combo Box: " + ex);
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
