package lista02.exercicios;

import java.util.Scanner;

/*
    02) Faça um algoritmo que leia um número e mostre se o mesmo é par ou ímpar.
*/

public class Ex02 {
    public static void main(String[] args) {
        double numero;
        
        numero = Double.parseDouble(entraValor("Entre com um número: "));
        
        if (numero % 2 == 0) {
            System.out.println("Número par");
        } else {
            System.out.println("Número ímpar");
        }
    }
    
    public static String entraValor(String msg) {
        Scanner entrada = new Scanner(System.in);
        String data;
        
        System.out.print(msg);
        data = entrada.nextLine();
        return data;
    }
}
