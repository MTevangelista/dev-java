package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDados {
    public static void main(String[] args) {
        Connection conn;
        
        conn = ConexaoBD.abrirConexao();   
        if (conn == null) {
            System.out.println("Erro: conexão");
            return;
        }
        
        System.out.println(listarAlunos(conn));
        System.out.println(listarAluno(conn));
        //incluirAluno(conn);
        alterarAluno(conn);
        apagarAluno(conn);

        ConexaoBD.fecharConexao();
    }
    
    public static String listarAlunos(Connection conn) {
        String response = "";
        String comando = "SELECT * FROM alunos";
        
        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id_aluno");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                response += id +" "+ nome +" "+ telefone +"\n";
            }    
        } catch (SQLException e) {
            System.out.println("Erro: conexão");
        }
        return response;
    }
    
    public static String listarAluno(Connection conn) {
        String response = "";
        String comando = "SELECT * FROM alunos WHERE id_aluno='3'";
        
        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id_aluno");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                response += id +" "+ nome +" "+ telefone +"\n";
            }   
        } catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }
        return response;
    }
    
    public static void incluirAluno(Connection conn) {
        String comando = "INSERT INTO alunos(nome, telefone) values('Matheus', '21123456789')";
        
        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            ResultSet rs = ps.executeQuery();
            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Atualização realizada");
            } else {
                System.out.println("Atualização não realizada");
            }
        } catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }
    }
    
    public static void alterarAluno(Connection conn) {
        String comando = "UPDATE alunos SET telefone='11111111111' WHERE id_aluno=4";
        
        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            ResultSet rs = ps.executeQuery();
            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Atualização realizada");
            } else {
                System.out.println("Atualização não realizada");
            }
        } catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }
    }
    
    public static void apagarAluno(Connection conn) {
        String comando = "DELETE FROM alunos WHERE id_aluno=1";
        
        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            ResultSet rs = ps.executeQuery();
            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Exclusão realizada");
            } else {
                System.out.println("Exclusão não realizada");
            }
        } catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }
    }
}