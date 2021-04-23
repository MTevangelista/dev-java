package repeticoes.comandos;

import java.util.Scanner;

public class RepeticaoDoWhile {
    public static void main(String[] args) {
        int opcao;
        
        do {
            opcao = menu();
            if ((opcao < 0) || (opcao > 4)) {
               System.err.println("Operação inválida");
            }
        } while ((opcao < 0) || (opcao > 4));
    }
    
    public static int menu() {
        int oper;
        String opcoes = "Escolha a operação:\n"
                + "0 - Sair\n"
                + "1 - Soma\n"
                + "2 - Subtração\n" 
                + "3 - Multiplicação\n"
                + "4 - Divisão\n";
        oper = leInteiro(opcoes);
        return oper;
    }
    
    public static int leInteiro(String msg) {
        Scanner entrada = new Scanner(System.in);
        int num;
        
        System.out.print(msg);
        num = entrada.nextInt();
        return num;
    }
}
