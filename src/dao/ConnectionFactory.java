package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionFactory {

    // Objeto do tipo Connection.
    private static Connection connection;

    // Atributos para conexao.
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost/MercadoBD";
    private static final String user = "root";
    private static final String password = "admin";

    // Este metodo retorna a conexao e lança a excessao para ser tratada. 
    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /* Este metodo verifica se ha conexao, e caso tenha eh fechada.
     * Lança a excessao para ser tratada.
     */
    public static void ClosedConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    /* Este metodo verifica se o objeto do Tipo PreparedStatement esta "funcionando", e caso esteja eh fechado.
     * Chama o metodo para fechar conexao.
     * Lança a excessao para ser tratada.
     */
    public static void ClosedConnection(Connection connection, PreparedStatement command) throws SQLException {
        if (command != null) {
            command.close();
            ClosedConnection(connection);
        }

    }

    /* Este metodo verifica se o objeto do Tipo ResultSet esta "funcionando", e caso esteja eh fechado.
     * Chama o metodo para fechar conexao e o PreparedStatement.
     * Lança a excessao para ser tratada.
     */
    public static void ClosedConnection(Connection connection, PreparedStatement command, ResultSet results) throws SQLException {
        if (results != null) {
            results.close();
            ClosedConnection(connection, command);
        }

    }

}
