
package modelTable;

import dao.ClienteDao;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelClasse.Cliente;


public class ModeloTabelaCliente extends AbstractTableModel{
    
    // Atributos e objetos
    private ClienteDao cliente;
    private List<Cliente> lista;
    private int numLinhas;
    private int numColunas;
    
    // Construtor recebendo a lista de clientes em um array
    public ModeloTabelaCliente(){
        cliente = new ClienteDao();
        this.lista = cliente.listAll();
        this.numLinhas = lista.size();
        this.numColunas = Cliente.class.getDeclaredFields().length;
    }
    
    // Metodo para retornar a quantidade de linhas
    @Override
    public int getRowCount() {
        return this.numLinhas;
    }

    // Metodo para retornar a quantidade de colunas
    @Override
    public int getColumnCount() {
        return this.numColunas;
    }
    
    // Metodo retorna um cliente do array 
    public Cliente getRowCliente(int rowIndex){
        return lista.get(rowIndex);
    }

    // Metodo para preencher a tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return (Object) lista.get(rowIndex).getCodigo_cliente();
            case 1: return (Object) lista.get(rowIndex).getNome();
            case 2: return (Object) lista.get(rowIndex).getSobrenome();
            case 3: return (Object) lista.get(rowIndex).getData_nasc();
            case 4: return (Object) lista.get(rowIndex).getCpf();
            case 5: return (Object) lista.get(rowIndex).getRg();
            case 6: return (Object) lista.get(rowIndex).getBairro();
            case 7: return (Object) lista.get(rowIndex).getEndereco();
            case 8: return (Object) lista.get(rowIndex).getNumero();
            case 9: return (Object) lista.get(rowIndex).getTelefone();
            case 10: return (Object) lista.get(rowIndex).getData_cadastro();
            default: return null;
        }
    }

    // Metodo para dar nome as colunas da tabela
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Codigo";
            case 1: return "Nome";
            case 2: return "Sobrenome";
            case 3: return "Data_Nasc";
            case 4: return "CPF";
            case 5: return "RG";
            case 6: return "Bairro";
            case 7: return "Endereço";
            case 8: return "Numero";
            case 9: return "Telefone";
            case 10: return "Data Cadastro";
            default: return null;
        }
    }

    // Atualiza a tabela
    public void atualizarTabela(){
        this.lista = cliente.listAll();
        this.numLinhas = lista.size();
        this.fireTableDataChanged();
    }
    
    // Inseri um cliente no banco de dados
    public void insert(Cliente obj){
        cliente.insert(obj);
    }
    
    // Atuzaliza um cliente no banco de dados
    public void update(Cliente obj){
        cliente.update(obj);
    }
    
    // Deleta um cliente no banco de dados
    public void delete(int index){
        cliente.delete(index);
    }
    
    // Busca cliente no banco de dados
    public void search(String nome){
        this.lista = cliente.listImediato(nome);
        this.numLinhas = this.lista.size();
        this.fireTableDataChanged();
    }
    
}
