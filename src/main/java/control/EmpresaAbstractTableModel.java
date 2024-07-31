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
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = { "ID", "Nome", "Endereço", "Telefone" };
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empresa empresa = listaEmpresas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return empresa.getIdEmpresa();
            case 1:
                return empresa.getNomeEmpresa();
            case 2:
                return empresa.getEndereco();
            case 3:
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
}
