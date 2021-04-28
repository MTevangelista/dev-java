package lista03.exercicios;

import java.util.Scanner;

/*
    06) Faça um algoritmo que leia uma sequência de números terminada em zero e mostre
    para cada número lido se ele é primo ou não.
*/

public class Ex11 {
    public static void main(String[] args) {
        final int FIM = 0;
        int num;
        
        num = leInteiro("Entre com um número: ");
        while (num != FIM) {
            if (ePrimo(num)) {
                System.out.println("É primo");
            } else {
                System.out.println("Não é primo");
            }
            num = leInteiro("Entre com um número: ");
        }
    }
    
    public static boolean ePrimo(int num) {
        boolean primo = true;
        
        for (int i = 2; i < num-1; i++) {
            if ((num % i) == 0) {
                primo  = false;
                break;
            }
        }
        return primo;
    }
    
    public static int leInteiro(String msg) {
        Scanner entrada = new Scanner(System.in);
        int num;
        
        System.out.println(msg);
        num = entrada.nextInt();
        return num;
    }
}
