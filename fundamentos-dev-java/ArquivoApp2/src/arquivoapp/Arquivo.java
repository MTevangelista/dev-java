package arquivoapp;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList; 

public class Arquivo {
    private static String NOMEARQ;
    
    public static void setNomeArq(String nome) {
        NOMEARQ = nome;
    }
    
    private static ObjectOutputStream abreArquivo(String nome) {
        ObjectOutputStream saida = null;
        
        try {
            saida = new ObjectOutputStream(new FileOutputStream(nome));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return saida;
    }
    
    private static ObjectInputStream abreArquvio(String nome) {
        ObjectInputStream entrada = null;
        
        try {
            entrada = new ObjectInputStream(new FileInputStream(nome));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return entrada;
    }
    
    private static void fechaArquivo(ObjectOutputStream saida) {
        try {
            saida.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    private static void fechaArquivo(ObjectInputStream entrada) {
        try {
            entrada.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public static void gravaAlunos(ArrayList<Aluno> alunos) {
        ObjectOutputStream saida;
        
        saida = abreArquivo(NOMEARQ);
        
        for (Aluno aluno : alunos) {
            try {
                saida.writeObject(aluno);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        fechaArquivo(saida);
    }
    
    public static void leAlunos(ArrayList<Aluno> alunos) {
        ObjectInputStream entrada;
        boolean fim = false;
        
        entrada = abreArquvio(NOMEARQ);
        do {
            try {
                Aluno aluno = (Aluno) entrada.readObject();
                alunos.add(aluno);
            } catch (EOFException ex) {
                fim = true;
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex);
            }
        } while (!fim);
        fechaArquivo(entrada);
    }
}
