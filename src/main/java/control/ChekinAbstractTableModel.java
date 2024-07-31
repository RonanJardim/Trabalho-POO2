package control;

import javax.swing.table.AbstractTableModel;
import domain.Check_in;
import java.util.ArrayList;
import java.util.List;

public class ChekinAbstractTableModel extends AbstractTableModel {

    private List<Check_in> listaItens = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = { "ID", "Reserva" };
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Check_in item = listaItens.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getIdCheck_in();
            case 1:
                return item.getReserva();
            default:
                throw new IllegalArgumentException("Invalid column index: " + columnIndex);
        }
    }

    public void adicionar(Check_in item) {
        listaItens.add(item);
        fireTableRowsInserted(listaItens.size() - 1, listaItens.size() - 1);
    }

    public void remover(int indice) {
        listaItens.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public Check_in getChekin(int linha) {
        return listaItens.get(linha);
    }

    public void setLista(List<Check_in> novaLista) {
        if (novaLista == null || novaLista.isEmpty()) {
            if (!listaItens.isEmpty()) {
                listaItens.clear();
                fireTableRowsDeleted(0, 0);
            }
        } else {
            listaItens = novaLista;
            fireTableDataChanged();
        }
    }
}
