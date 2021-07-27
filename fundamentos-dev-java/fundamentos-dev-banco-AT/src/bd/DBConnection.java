package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    
    public static Connection openConnection() {
        try
        {
            System.out.println("Tentando conexao com o banco");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String servidor = "localhost";
            String bd = "fundamentosdevat";
            String url = "jdbc:mysql://" + servidor + "/" + bd;
            String usuario = "root";
            String senha = "root";
            connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Banco conectado");
        } catch (ClassNotFoundException e){
            System.out.println(e);
        }
        catch(SQLException f){
            System.out.println(f);
        }
        return connection;
    }
    
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro: fechar conexão BD");
        }
    }
}
