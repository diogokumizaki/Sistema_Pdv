package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelClasse.Cliente;


public class ClienteDao implements PatternDao<Cliente> {

    // Atributos para as operaçoes Sql
    private final String inserir = "insert into tb_cliente(nome, sobrenome, data_nasc, cpf, rg, telefone, bairro, endereco, numero) values(?,?,?,?,?,?,?,?,?)";
    private final String delete = "delete from tb_cliente where codigo_cliente = ?";
    private final String atualizar = "update tb_cliente set nome = ?, sobrenome = ?, data_nasc = ?, cpf = ?, rg = ?, telefone = ?, bairro = ?, endereco = ?, numero = ? where codigo_cliente = ?";
    private final String listarTudo = "select * from tb_cliente";
    private final String apagarVinculo = "delete from tb_venda where codigo_cliente = ?";
    private final String listarImediato = "select * from tb_cliente where nome like ?";

    // Construtor Vazio
    public ClienteDao() {

    }

    // Metodo para inserir um novo cliente
    @Override
    public void insert(Cliente obj) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(inserir);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getSobrenome());
            ps.setString(3, obj.getData_nasc());
            ps.setString(4, obj.getCpf());
            ps.setString(5, obj.getRg());
            ps.setString(6, obj.getTelefone());
            ps.setString(7, obj.getBairro());
            ps.setString(8, obj.getEndereco());
            ps.setString(9, obj.getNumero());
            ps.executeUpdate();
            ConnectionFactory.ClosedConnection(conexao, ps);
            JOptionPane.showMessageDialog(null, "Cliente " + obj.getNome() + " foi gravado com sucesso!", "Cadastro", JOptionPane.OK_OPTION, new ImageIcon("src//image//confirmado.png"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar o cliente " + obj.getNome() + "! = " + ex.getLocalizedMessage(), "Cadastro", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }
    }

    // Metodo para atualizar um novo cliente
    @Override
    public void update(Cliente obj) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(atualizar);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getSobrenome());
            ps.setString(3, obj.getData_nasc());
            ps.setString(4, obj.getCpf());
            ps.setString(5, obj.getRg());
            ps.setString(6, obj.getTelefone());
            ps.setString(7, obj.getBairro());
            ps.setString(8, obj.getEndereco());
            ps.setString(9, obj.getNumero());
            ps.setInt(10, obj.getCodigo_cliente());
            ps.executeUpdate();
            ConnectionFactory.ClosedConnection(conexao, ps);
            JOptionPane.showMessageDialog(null, "Cliente " + obj.getNome() + " foi alterado com sucesso!", "Atualizaçao", JOptionPane.OK_OPTION, new ImageIcon("src//image//confirmado.png"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o cliente " + obj.getNome() + "!", "Atualizaçao", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }

    }

    // Metodo para deletar um cliente pelo seu codigo e suas compras relacionadas
    @Override
    public void delete(int codigo) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(apagarVinculo);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
            ps = conexao.prepareStatement(delete);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ConnectionFactory.ClosedConnection(conexao, ps);
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!", "Remoçao", JOptionPane.OK_OPTION, new ImageIcon("src//image//confirmado.png"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente ", "Remoçao", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }

    }

    // Metodo para retornar uma lista de clientes
    @Override
    public List<Cliente> listAll() {
        List<Cliente> lista = new ArrayList<>();
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(listarTudo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Cliente(rs.getInt("codigo_cliente"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("data_nasc"), rs.getString("rg"), rs.getString("cpf"), rs.getString("bairro"), rs.getString("endereco"), rs.getString("numero"), rs.getString("telefone"), rs.getString("data_cadastro")));
            }
            ConnectionFactory.ClosedConnection(conexao, ps, rs);
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes = " + ex.getMessage(), "Listagem", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }
        return null;
    }

    // Metodo para pesquisa com like, retorna os registros que atendem a condiçao
    public List<Cliente> listImediato(String nome) {
        List<Cliente> lista = new ArrayList<>();
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(listarImediato);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Cliente(rs.getInt("codigo_cliente"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("data_nasc"), rs.getString("rg"), rs.getString("cpf"), rs.getString("bairro"), rs.getString("endereco"), rs.getString("numero"), rs.getString("telefone"), rs.getString("data_cadastro")));
            }
            ConnectionFactory.ClosedConnection(conexao, ps, rs);
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes = " + ex.getMessage(), "Listagem", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }
        return null;
    }

}
