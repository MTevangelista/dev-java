package lista02.exercicios;

import java.util.Scanner;

/*
    02) Faça um algoritmo que leia dois números e mostre o maior número.
*/

public class Ex03 {
    public static void main(String[] args) {
        double num1, num2;
        
        num1 = Double.parseDouble(entraValor("Entre com o primeiro número: "));
        num2 = Double.parseDouble(entraValor("Entre com o segundo número: "));
    
        if (num1 > num2) {
            System.out.println("Número "+num1+" maior que "+num2);
        } else if (num2 > num1) {
            System.out.println("Número "+num2+" maior que "+num1);
        } else {
            System.out.println("Números iguais");
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
