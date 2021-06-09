package arq;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Arquivo {
    private static String nomeArq;
    
    public static void setNomeArq(String nome) {
        nomeArq = nome;
    }
    
    public static Scanner abrirLeitura() {
        Scanner entrada = null;
        
        try {
            entrada = new Scanner(new File(nomeArq));
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: abertura do arquivo");
        }
        return entrada;
    }
    
    public static void lerArquivo(Scanner entrada, ArrayList<Aluno> alunos) {
        String linha;
        String[] campos;
        
        while (entrada.hasNext()) {
            linha = entrada.nextLine();
            campos = linha.split(";");
            Aluno aluno = new Aluno(campos[0], campos[1]);
            alunos.add(aluno);
        }
    }
    
    public static Formatter abrirGravacao() {
        Formatter saida = null;
        
        try {
            saida = new Formatter(nomeArq);
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: arquivo não encontrado");
        }
        return saida;
    }
    
    public static void gravarAlunos(Formatter saida, ArrayList<Aluno> alunos) {
        for (Aluno aluno: alunos) {
            saida.format("$s;$s\n", aluno.getNome(), aluno.getTelefone());
        }
//        alunos.forEach(aluno -> {
//            saida.format("$s;$s\n", aluno.getNome(), aluno.getTelefone());
//        });       
    }
    
    public static void fecharArquivo(Formatter saida) {
        if (saida != null) {
            saida.close();
        }
    }
    
    public static void fecharArquivo(Scanner entrada) {
        if (entrada != null) {
            entrada.close();
        }        
    }
}
