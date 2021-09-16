package br.edu.infnet.springmvc.model.repository;

import br.edu.infnet.springmvc.model.negocio.Aluno;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    public List<Aluno> consulta() {
        List<Aluno> lista = new ArrayList<>();
        Conexao conn = new Conexao();
        String sql = "SELECT * from alunos";

        try {
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id_aluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));
                lista.add(aluno);
            }
        }
        catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }
        return lista;
    }
    
    public void incluir(Aluno aluno) {
        Conexao conn = new Conexao();
        String sql = "INSERT INTO alunos(nome, telefone) values(?, ?)";
        
        try {
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getTelefone());
            ps.execute();
        }
        catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }                
    }
    
    public void excluir(int id) {
        Conexao conn = new Conexao();
        String sql = "DELETE FROM alunos WHERE id_aluno=?";
        
        try {
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }                        
    }
    
    public Aluno consultarPorId(int id) {
        Conexao conn = new Conexao();
        String sql = "SELECT * FROM alunos WHERE id_aluno=?";
        Aluno aluno = new Aluno();
        
        try {
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                aluno.setId(rs.getInt("id_aluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));
            }
        }
        catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }
        return aluno;        
    }
    
    public void alterar(Aluno aluno) {
        Conexao conn = new Conexao();
        String sql = "UPDATE alunos SET nome=?, telefone=? WHERE id_aluno=?";
        
        try {
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getTelefone());
            ps.setInt(3, aluno.getId());
            ps.execute();
        }
        catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }        
    }
}