package repeticoes.comandos;

import java.util.Scanner;

public class RepeticaoWhile {
    public static void main(String[] args) {
        final int FIM = 0;
        int num, cont, soma;
        double media;
        
        soma = cont = 0;
        num = leInteiro("Entre com um número: ");
        while (num != FIM) {
            soma += num;
            cont++;
            num = leInteiro("Entre com um número: ");
        }
        if (cont > 0) {
            media = (double) soma / cont;
            System.out.printf("Média = %.1f ", media);    
        }
    }
    
    public static int leInteiro(String msg) {
        Scanner entrada = new Scanner(System.in);
        int num;
        
        System.out.print(msg);
        num = entrada.nextInt();
        return num;
    }
}
