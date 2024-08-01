package control;

import javax.swing.table.AbstractTableModel;
import domain.Empresa;
import java.util.ArrayList;
import java.util.List;

public class EmpresaAbstractTableModel extends AbstractTableModel {

    private List<Empresa> listaEmpresas = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listaEmpresas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = { "Nome", "CNPJ", "Telefone" };
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empresa empresa = listaEmpresas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return empresa.getNomeEmpresa();
            case 1:
                return empresa.getCnpj();
            case 2:
                return empresa.getTelefone();
            default:
                throw new IllegalArgumentException("Invalid column index: " + columnIndex);
        }
    }

    public void adicionar(Empresa empresa) {
        listaEmpresas.add(empresa);
        fireTableRowsInserted(listaEmpresas.size() - 1, listaEmpresas.size() - 1);
    }

    public void remover(int indice) {
        listaEmpresas.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public Empresa getEmpresa(int linha) {
        return listaEmpresas.get(linha);
    }

    public void setLista(List<Empresa> novaLista) {
        if (novaLista == null || novaLista.isEmpty()) {
            if (!listaEmpresas.isEmpty()) {
                listaEmpresas.clear();
                fireTableRowsDeleted(0, 0);
            }
        } else {
            listaEmpresas = novaLista;
            fireTableDataChanged();
        }
    }
    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
