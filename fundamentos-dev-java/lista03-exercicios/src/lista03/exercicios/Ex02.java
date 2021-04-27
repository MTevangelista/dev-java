package lista03.exercicios;

import java.util.Scanner;

/*
    02) Faça um algoritmo que calcule a soma dos números de 1 a 100.
*/

public class Ex02 {
    public static void main(String[] args) {
        double soma = 0;
        
        for (int i = 1; i <= 100; i++) {
            soma += i;
        }
        
        System.out.println("A soma dos inteiros de 1 à 100 é: "+soma);
    }
}
