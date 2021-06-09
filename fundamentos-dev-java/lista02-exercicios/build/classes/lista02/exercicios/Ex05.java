package lista02.exercicios;

import java.util.Arrays;
import java.util.Scanner;

/*
    05) Faça um algoritmo que leia três números e mostre-os em ordem crescente.
*/

public class Ex05   {
    public static void main(String[] args) {
        double num;
        double[] numeros = new double[3];
        
        for (int index = 0; index <= 2; index++) {
            num = Double.parseDouble(entraValor("Entre com um número: "));
            numeros[index] = num;
        }
        
        System.out.println("Array normal: "+Arrays.toString(numeros));
        Arrays.sort(numeros);
        System.out.println("Array em ordem crescente: "+Arrays.toString(numeros));
    }
    
    public static String entraValor(String msg) {
        Scanner entrada = new Scanner(System.in);
        String data;
        
        System.out.print(msg);
        data = entrada.nextLine();
        return data;
    }
}
