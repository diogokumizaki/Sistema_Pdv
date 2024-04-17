package modelTable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelClasse.PassarVenda;


public class ModeloTabelaVendaCompras extends AbstractTableModel {

    private DecimalFormat formato;
    private PassarVenda venda;
    private List<PassarVenda> lista;
    private int numLinhas;
    private int numColunas;

    public ModeloTabelaVendaCompras() {
        formato = new DecimalFormat("#.00");
        lista = new ArrayList<>();
        this.numLinhas = 0;
        this.numColunas = 3;
    }

    public void insertLista(PassarVenda obj) {
        lista.add(obj);
        this.numLinhas = lista.size();
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.numLinhas;
    }

    @Override
    public int getColumnCount() {
        return this.numColunas;
    }

    public void limparTabela() {
        lista.clear();
        this.numLinhas = lista.size();
        this.fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return (Object) lista.get(rowIndex).getProduto();
            case 1:
                return (Object) lista.get(rowIndex).getQuantidade();
            case 2:
                return (Object) formato.format(lista.get(rowIndex).getValor());
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Produto";
            case 1:
                return "Quantidade";
            case 2:
                return "Valor";
            default:
                return null;
        }
    }

    public PassarVenda getItem(int numLinha) {
        return this.lista.get(numLinha);
    }

    public void retirarCompra(int numLinha) {
        this.lista.remove(numLinha);
        this.numLinhas = lista.size();
        this.fireTableDataChanged();
    }
    
    public void alterarArray(int linha, int quantidade, double valor){
        this.lista.get(linha).setQuantidade(quantidade);
        this.lista.get(linha).setValor(valor);
        this.numLinhas = lista.size();
        this.fireTableDataChanged();   
    }

}
