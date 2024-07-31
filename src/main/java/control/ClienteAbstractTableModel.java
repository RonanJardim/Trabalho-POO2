package control;

import javax.swing.table.AbstractTableModel;

import domain.Cliente;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteAbstractTableModel extends AbstractTableModel {

    private List<Cliente> listaItens = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = { "Nome", "Dt. Nasc", "Celular", "Endereço", "Cidade" };
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Cliente item = listaItens.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return item.getNome();
            case 1:
                return item.getEndereco().getBairro();
            case 2:
                return item.getEndereco().getCidade();
            case 3:
                return item.getDtNasc();
            case 4:
                return item.getTelefone();
            default:
                
                throw new IllegalArgumentException("Invalid column index: " + columnIndex);
        }
    }

    public void adicionar(Cliente item) {
        listaItens.add(item);
        fireTableRowsInserted(listaItens.size() - 1, listaItens.size() - 1);
    }

    public void remover(int indice) {
        listaItens.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public Cliente getCliente(int linha) {
        return listaItens.get(linha);
    }

    public void setLista(List<Cliente> novaLista) {
        if (novaLista == null || novaLista.isEmpty()) {
            if (!listaItens.isEmpty()) {
                listaItens.clear();
                fireTableRowsDeleted(0, 0);
            }
        } else {
            listaItens = novaLista;
            fireTableRowsInserted(0, listaItens.size() - 1);
        }
    }
}