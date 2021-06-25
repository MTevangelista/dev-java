package arquivo;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ArquivoApp {
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
        }
        else {
            System.out.println("Erro: leitura");
        }
        exibeAlunos(alunos);
//        Aluno aluno = new Aluno("Cayo", "219090909");;
//        alunos.add(aluno);
        saida = Arquivo.abrirGravacao();
        Arquivo.gravarAlunos(saida, alunos);
        Arquivo.fecharArquivo(saida);
    }
    
    public static void exibeAlunos(ArrayList<Aluno> alunos) {
        
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    public static void criaAlunos(ArrayList<Aluno> alunos) {
        
        alunos.add(new Aluno("LP", "2199999999"));
        alunos.add(new Aluno("FM", "2188888888"));
        alunos.add(new Aluno("ML", "2177777777"));
    }
    
    public static void verificaArquivo() {
        final String NOMEARQ = "C:\\Users\\lpmaia\\Desktop\\arq.txt";
        File arq = new File(NOMEARQ);
        
        if (arq.exists()) {
            System.out.println(arq.getName());
            System.out.println(arq.getPath());
            System.out.println(arq.length() + " bytes");
            System.out.println(arq.isFile());
        }
        else {
            System.out.println("Arquivo não existe");
        }
    }
}
