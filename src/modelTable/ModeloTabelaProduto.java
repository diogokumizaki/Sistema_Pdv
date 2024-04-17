package modelTable;


import dao.ProdutoDao;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelClasse.Produto;


public class ModeloTabelaProduto extends AbstractTableModel {

    // Atributos e objetos
    private DecimalFormat formato;
    private ProdutoDao dao;
    private int numLinhas;
    private int numColunas;
    private List<Produto> lista;

    // Construtor recebe a lista de produtos
    public ModeloTabelaProduto() {
        dao = new ProdutoDao();
        formato = new DecimalFormat("#.00");
        lista = dao.listAll();
        this.numLinhas = lista.size();
        this.numColunas = Produto.class.getDeclaredFields().length;
    }

    // Retorna a quantidade de linhas
    @Override
    public int getRowCount() {
        return this.numLinhas;
    }

    // Retorna a quantidade de colunas
    @Override
    public int getColumnCount() {
        return this.numColunas;
    }

    // Retorna um produto da lista
    public Produto getProdutoRow(int index) {
        return lista.get(index);
    }

    // Retorna os nomes das colunas da tabela
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Codigo";
            case 1:
                return "Descriçao";
            case 2:
                return "Unidade";
            case 3:
                return "Preço";
            case 4:
                return "Estoque";
        }
        return null;
    }

    // Retorna os valores para as colunas
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return (Object) lista.get(rowIndex).getCodigo();
            case 1:
                return (Object) lista.get(rowIndex).getDescricao();
            case 2:
                return (Object) lista.get(rowIndex).getUnidade();
            case 3:
                return (Object) formato.format(lista.get(rowIndex).getPreco_un());
            case 4:
                return (Object) lista.get(rowIndex).getEstoque();
            default:
                return null;
        }
    }

    // Atualiza a tabela
    public void atualizar() {
        lista = dao.listAll();
        this.numLinhas = lista.size();
        this.fireTableDataChanged();
    }

    // Inseri um produto no banco de dados
    public void inserir(Produto obj) {
        //ProdutoDao produto = new ProdutoDao();
        dao.insert(obj);
        atualizar();
    }
    
    // Altera um produto no banco de dados
    public void alterar(Produto obj) {
       // ProdutoDao produto = new ProdutoDao();
        dao.update(obj);
        atualizar();
    }

    // Deleta um produto no banco de dados
    public void deletar(int codigo) {
        //ProdutoDao produto = new ProdutoDao();
        dao.delete(codigo);
        atualizar();
    }

}
