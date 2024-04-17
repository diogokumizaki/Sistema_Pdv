package modelTable;

import dao.VendaDao;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelClasse.ClienteVenda;


public class ModeloTabelaVendaVinculada extends AbstractTableModel {

    private DecimalFormat formato;
    private List<ClienteVenda> list;
    private VendaDao dao;
    private int numLinhas;
    private int numColunas;

    public ModeloTabelaVendaVinculada() {
        dao = new VendaDao();
        formato = new DecimalFormat("#.00");
        list = new ArrayList<>();
        this.list = dao.vendas();
        this.numLinhas = list.size();
        this.numColunas = ClienteVenda.class.getDeclaredFields().length;
    }

    @Override
    public int getRowCount() {
        return this.numLinhas;
    }

    @Override
    public int getColumnCount() {
        return this.numColunas;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Codigo";
            case 1:
                return "Nome";
            case 2:
                return "Pagamento";
            case 3:
                return "Valor";
            case 4:
                return "Data";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return (Object) this.list.get(rowIndex).getCodigo_cliente();
            case 1:
                return (Object) this.list.get(rowIndex).getNome();
            case 2:
                return (Object) this.list.get(rowIndex).getForma_pagamento();
            case 3:
                return (Object) formato.format(this.list.get(rowIndex).getValor());
            case 4:
                return (Object) this.list.get(rowIndex).getData_compra();
            default:
                return null;
        }
    }

    public void listagemRapida(String nome) {
        this.list = dao.listagemVendasRapida(nome);
        this.numLinhas = this.list.size();
        this.fireTableDataChanged();
    }

}
