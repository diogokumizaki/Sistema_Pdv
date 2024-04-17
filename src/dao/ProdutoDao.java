package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelClasse.Produto;


public class ProdutoDao implements PatternDao<Produto> {

    // Atributos para CRUD.
    private final String insertRegister = "insert into tb_produto(descricao,unidade,preco_unitario,estoque) values(?,?,?,?)";
    private final String listall = "select * from tb_produto";
    private final String deleteRegister = "delete from tb_produto where codigo_produto = ?";
    private final String updateRegister = "update tb_produto set descricao = ?, unidade = ?, preco_unitario = ?, estoque = ? where codigo_produto = ?";
    private final String listValor = "select codigo_produto,descricao,preco_unitario from tb_produto where codigo_produto = ?";
    private final String baixaNoEstoque = "update tb_produto set estoque = (estoque - ?) where codigo_produto = ?";
    private final String quantidadeEstoque = "select estoque from tb_produto where codigo_produto = ?";
  
    // Recebe um objeto como parametro e faz a inserçao.    
    @Override
    public void insert(Produto obj) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement command = connection.prepareStatement(insertRegister);
            command.setString(1, obj.getDescricao());
            command.setString(2, obj.getUnidade());
            command.setDouble(3, obj.getPreco_un());
            command.setInt(4, obj.getEstoque());
            command.executeUpdate();
            ConnectionFactory.ClosedConnection(connection, command);
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto = " + ex.getMessage(), "Atençao", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Retorna a lista completa de todas as linhas e colunas com os dados.
    @Override
    public List<Produto> listAll() {
        try {
            List<Produto> list = new ArrayList<>();
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement command = connection.prepareStatement(listall);
            ResultSet results = command.executeQuery();
            while (results.next()) {
                list.add(new Produto(results.getInt("codigo_produto"), results.getString("descricao"), results.getString("unidade"), results.getDouble("preco_unitario"), results.getInt("estoque")));
            }
            ConnectionFactory.ClosedConnection(connection, command, results);
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos = " + ex.getMessage(), "Atençao", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    // Recebe uma variavel inteira como parametro e faz a exclusao do registro que possui como chave esse valor.
    @Override
    public void delete(int id) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement command = connection.prepareStatement(deleteRegister);
            command.setInt(1, id);
            command.executeUpdate();
            ConnectionFactory.ClosedConnection(connection, command);
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar produto = " + ex.getMessage(), "Atençao", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Recebe um objeto como parametro e atualiza os dados contidos.
    @Override
    public void update(Produto obj) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement command = connection.prepareStatement(updateRegister);
            command.setString(1, obj.getDescricao());
            command.setString(2, obj.getUnidade());
            command.setDouble(3, obj.getPreco_un());
            command.setInt(4, obj.getEstoque());
            command.setInt(5, obj.getCodigo());
            command.executeUpdate();
            ConnectionFactory.ClosedConnection(connection, command);
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto = " + ex.getMessage(), "Atençao", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Retorna o produto atraves da pesquisa pelo codigo
    public Produto listProduto(int codigo_produto) {
        try {
            Produto produto = null;
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement command = connection.prepareStatement(listValor);
            command.setInt(1, codigo_produto);
            ResultSet results = command.executeQuery();
            while (results.next()) {
                produto = new Produto();
                produto.setCodigo(Integer.parseInt(results.getString("codigo_produto")));
                produto.setDescricao(results.getString("descricao"));
                produto.setPreco_un(results.getDouble("preco_unitario"));
            }
            ConnectionFactory.ClosedConnection(connection, command, results);
            return produto;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar preço de produto = " + ex.getMessage(), "Atençao", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    // Baixa o estoque atraves do codigo do produto
    public void baixarEstoque(int codigo_produto, int quantidade) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement command = connection.prepareStatement(baixaNoEstoque);
            command.setInt(1, quantidade);
            command.setInt(2, codigo_produto);
            command.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao dar baixa no estoque =" + ex.getMessage(), "Atençao", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Verifica a quantidade em estoque de um determiando produto atraves do codigo
    public int verificarEstoque(int codigo) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement command = connection.prepareStatement(quantidadeEstoque);
            command.setInt(1, codigo);
            ResultSet results = command.executeQuery();
            int estoque = 0;
            while (results.next()) {
                estoque = results.getInt("estoque");
            }
            ConnectionFactory.ClosedConnection(connection, command, results);
            return estoque;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar quantidade disponivel no estoque =" + ex.getMessage(), "Atençao", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

}
