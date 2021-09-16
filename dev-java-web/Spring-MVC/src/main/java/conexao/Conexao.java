package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Connection conn;
    
    private void conectar() {

        System.out.println("Conectando ao banco...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/infnet", "root", "root");
        } catch (ClassNotFoundException e) {
            System.out.println("O driver nao foi encontrado");
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao banco");
        }
    }
    
    public Connection getConexao() {
        
        conectar();
        return conn;
    }
}