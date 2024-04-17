package modelTable;

import dao.VendaDao;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelClasse.Venda;


public class ModeloTabelaVenda extends AbstractTableModel {

    private DecimalFormat formato;
    private VendaDao venda;
    private List<Venda> lista;
    private int numLinhas;
    private int numColunas;

    public ModeloTabelaVenda() {
        venda = new VendaDao();
        formato = new DecimalFormat("#.00");
        this.lista = venda.listarVendas();
        this.numLinhas = lista.size();
        this.numColunas = Venda.class.getDeclaredFields().length - 1;
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return (Object) lista.get(rowIndex).getCodigo_venda();
            case 1:
                return (Object) lista.get(rowIndex).getTipo_pagamento();
            case 2:
                return (Object) formato.format(this.lista.get(rowIndex).getValor());
            case 3:
                return (Object) lista.get(rowIndex).getData_venda();
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Codigo";
            case 1:
                return "Pagamento";
            case 2:
                return "Valor";
            case 3:
                return "Data";
            default:
                return null;
        }
    }

    public void listarHoje() {
        this.lista = venda.listarVendasHoje();
        this.numLinhas = lista.size();
        this.fireTableDataChanged();
    }

    public void listarIntervaloDatas(String data_inicio, String data_fim) {
        this.lista = venda.listarIntervaloVendas(data_inicio, data_fim);
        this.numLinhas = lista.size();
        this.fireTableDataChanged();
    }

    public void listarTudo() {
        this.lista = venda.listarVendas();
        this.numLinhas = lista.size();
        this.fireTableDataChanged();
    }

}
