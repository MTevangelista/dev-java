package arquivoapp;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        final String NOMEARQ = "alunos.obj";
        Aluno aluno = new Aluno();
        ArrayList<Aluno> alunos = new ArrayList();
        
        alunos.add(new Aluno("MT", "213242332423"));
        alunos.add(new Aluno("LP", "23324233232"));
        alunos.add(new Aluno("FL", "22234243243"));
        alunos.add(new Aluno("SOUZA", "21432423432"));

        Arquivo.setNomeArq(NOMEARQ);
//        Arquivo.gravaAlunos(alunos);
        Arquivo.leAlunos(alunos);
        for (Aluno al: alunos) {
            System.out.println(al);
        }
    }
}
