package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static Connection connection;
    
    public static Connection abrirConexao() {
        try {
            System.out.println("Tentando conexão com BD");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String servidor = "localhost";
            String bd = "infnet";
            String url = "jdbc:mysql://" + servidor + "/" + bd;
            String usuario = "root";
            String senha = "root";
            connection = DriverManager.getConnection(url, url, senha);
            System.out.println("Banco conectado");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado");
        } catch (SQLException e) {
            System.out.println("Erro: conexão ao BD");
        }
        return connection;
    }
    
    public static void fecharConexao() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro: fechar conexão BD");
        }
    }
}
