package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelClasse.ClienteVenda;
import modelClasse.Venda;


public class VendaDao {

    // Atributos para consultas no banco de dados 
    private final String inserirVendaClienteVinculado = "insert into tb_venda(valor, forma_pagamento, codigo_cliente) values(?,?,?)";
    private final String inserirClienteNaoVinculado = "insert into tb_venda(valor, forma_pagamento) values(?,?)";
    private final String listarVendas = "select * from tb_venda";
    private final String listarIntervaloVendas = "select * from tb_venda where data_venda >= ? and data_venda <= ?";
    private final String listarVendasHoje = "select * from tb_venda where data_venda = current_date";
    private final String listarTotalVenda = "select sum(valor) as total from tb_venda";
    private final String listarTotalVendaHoje = "select sum(valor) as total from tb_venda where data_venda = current_date";
    private final String listarTotalVendasIntervalo = "select sum(valor) as total from tb_venda where data_venda >= ? and data_venda <= ?";
    private final String vendas = "select C.codigo_cliente,C.nome, V.valor, V.forma_pagamento,V.data_venda from tb_cliente as C inner join tb_venda as V on C.codigo_cliente = V.codigo_cliente";
    private final String listagemRapida = "select C.codigo_cliente,C.nome, V.valor, V.forma_pagamento,V.data_venda from tb_cliente as C inner join tb_venda as V on C.codigo_cliente = V.codigo_cliente where nome like ?";

    // Construtor Vazio
    public VendaDao() {

    }

    // Registra venda com um cliente vinculado 
    public void inserirVendaVinculada(Venda obj) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(inserirVendaClienteVinculado);
            ps.setDouble(1, obj.getValor());
            ps.setString(2, obj.getTipo_pagamento());
            ps.setInt(3, obj.getCodigo_cliente());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!", "Venda", JOptionPane.OK_OPTION, new ImageIcon("src//image//confirmado.png"));
            ConnectionFactory.ClosedConnection(conexao, ps);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar venda vinculada = " + ex.getMessage(), "Venda", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }

    }

    // Registra uma venda sem cliente vinculado
    public void inserirVendaNaoVinculada(Venda obj) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(inserirClienteNaoVinculado);
            ps.setDouble(1, obj.getValor());
            ps.setString(2, obj.getTipo_pagamento());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!", "Venda", JOptionPane.OK_OPTION, new ImageIcon("src//image//confirmado.png"));
            ConnectionFactory.ClosedConnection(conexao, ps);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar venda nao vinculada = " + ex.getMessage(), "Venda", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }
    }

    // Lista informaçoes sobre todas as vendas (codigo, data da venda, valor total, forma de pagamento)
    public List<Venda> listarVendas() {
        List<Venda> lista = new ArrayList<>();
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(listarVendas);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Venda(rs.getInt("codigo_venda"), rs.getString("data_venda"), rs.getFloat("valor"), rs.getString("forma_pagamento")));
            }
            ConnectionFactory.ClosedConnection(conexao, ps, rs);
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar vendas = " + ex.getMessage(), "Venda", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }
        return null;
    }

    // Lista informaçoes sobre a venda em um intervalo de datas (codigo, data da venda, valor total, forma de pagamento)
    public List<Venda> listarIntervaloVendas(String data_inicio, String data_fim) {
        List<Venda> lista = new ArrayList<>();
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(listarIntervaloVendas);
            ps.setString(1, data_inicio);
            ps.setString(2, data_fim);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Venda(rs.getInt("codigo_venda"), rs.getString("data_venda"), rs.getFloat("valor"), rs.getString("forma_pagamento")));
            }
            ConnectionFactory.ClosedConnection(conexao, ps, rs);
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar intervalo de vendas = " + ex.getMessage(), "Venda", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }
        return null;
    }

    // Lista informaçoes sobre a venda do dia atual (codigo, data da venda, valor total, forma de pagamento)
    public List<Venda> listarVendasHoje() {
        List<Venda> lista = new ArrayList<>();
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(listarVendasHoje);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Venda(rs.getInt("codigo_venda"), rs.getString("data_venda"), rs.getFloat("valor"), rs.getString("forma_pagamento")));
            }
            ConnectionFactory.ClosedConnection(conexao, ps, rs);
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar vendas hoje = " + ex.getMessage(), "Venda", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }
        return null;
    }

    // Mostra o valor total de todas as vendas feitas
    public float listarTotalVendas() {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(listarTotalVenda);
            ResultSet rs = ps.executeQuery();
            float total_venda = 0;
            while (rs.next()) {
                total_venda = rs.getFloat("total");
            }
            ConnectionFactory.ClosedConnection(conexao, ps, rs);
            return total_venda;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar total de vendas = " + ex.getMessage(), "Venda", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }
        return 0;
    }

    // Mostra o valor total vendido na data atual
    public float listarTotalVendasHoje() {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(listarTotalVendaHoje);
            ResultSet rs = ps.executeQuery();
            float total_venda = 0;
            while (rs.next()) {
                total_venda = rs.getFloat("total");
            }
            ConnectionFactory.ClosedConnection(conexao, ps, rs);
            return total_venda;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar total de vendas hoje = " + ex.getMessage(), "Venda", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }
        return 0;
    }

    // Mostra o valor total vendido entre um intervalo de data
    public float listarTotalVendasIntervalo(String data_inicio, String data_fim) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(listarTotalVendasIntervalo);
            ps.setString(1, data_inicio);
            ps.setString(2, data_fim);
            ResultSet rs = ps.executeQuery();
            float total_venda = 0;
            while (rs.next()) {
                total_venda = rs.getFloat("total");
            }
            ConnectionFactory.ClosedConnection(conexao, ps, rs);
            return total_venda;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar total de vendas no intervalo de datas = " + ex.getMessage(), "Venda", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }
        return 0;
    }

    // Lista os dados sobre o cliente vinculado ou nao e sua compra(codigo, nome do cliente, valor total, forma de pagamento, data da compra)
    public List<ClienteVenda> vendas() {
        List<ClienteVenda> lista = new ArrayList<>();
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(vendas);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new ClienteVenda(rs.getInt("codigo_cliente"), rs.getString("nome"), rs.getFloat("valor"), rs.getString("forma_pagamento"), rs.getString("data_venda")));
            }
            ConnectionFactory.ClosedConnection(conexao, ps, rs);
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar vendas = " + ex.getMessage(), "Venda", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }
        return null;
    }
    // Lista os dados sobre o cliente vinculado ou nao e sua compra(codigo, nome do cliente, valor total, forma de pagamento, data da compra) por nome
    public List<ClienteVenda> listagemVendasRapida(String nome) {
        List<ClienteVenda> lista = new ArrayList<>();
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(listagemRapida);
            ps.setString(1,"%"+nome+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new ClienteVenda(rs.getInt("codigo_cliente"), rs.getString("nome"), rs.getFloat("valor"), rs.getString("forma_pagamento"), rs.getString("data_venda")));
            }
            ConnectionFactory.ClosedConnection(conexao, ps, rs);
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar vendas = " + ex.getMessage(), "Venda", JOptionPane.ERROR_MESSAGE, new ImageIcon("src//image//erro.png"));
        }
        return null;
    }

}
