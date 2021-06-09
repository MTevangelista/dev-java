package lista02.exercicios;

import java.util.Scanner;

/*
    01) Faça um algoritmo que leia um número e mostre se o mesmo é positivo, negativo ou
    zero.
*/

public class Ex01 {
    public static void main(String[] args) {
        double numero;
        
        numero = Double.parseDouble(entraValor("Entre com um número: "));
        
        if (numero > 0) {
            System.out.println("Número positivo");
        } else if (numero == 0) {
            System.out.println("Número neutro");
        } else {
            System.out.println("Número negativo");
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
