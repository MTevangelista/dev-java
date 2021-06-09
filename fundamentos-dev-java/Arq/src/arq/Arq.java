package arq;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Arq {
    public static void main(String[] args) {
        final String NOMEARQ = "alunos.txt";
        ArrayList<Aluno> alunos = new ArrayList<>();
        Formatter saida;
        Scanner entrada;
        
        Arquivo.setNomeArq(NOMEARQ);
        entrada = Arquivo.abrirLeitura();
        if (entrada != null) {
            Arquivo.lerArquivo(entrada, alunos);
            Arquivo.fecharArquivo(entrada);
        } else {
            System.out.println("Erro: leitura");
        }
        exibeAlunos(alunos);
        //Aluno aluno = new Aluno("Matheus", "2194932932423");
        //alunos.add(aluno);
        saida = Arquivo.abrirGravacao();
        Arquivo.gravarAlunos(saida, alunos);
        Arquivo.fecharArquivo(saida);
    }
    
    public static void exibeAlunos(ArrayList<Aluno> alunos) {
        alunos.forEach(aluno -> {
            System.out.println(aluno.toString());
        });
    }
    
    public static void criarAlunos(ArrayList<Aluno> aluno) {}
}
