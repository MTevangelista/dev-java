package lista01.exercicios;

import java.util.Scanner;

/*
    02) Faça um algoritmo para calcular a média de duas notas digitadas pelo usuário.
*/

public class Ex02 {
    public static void main(String[] args) {
        double nota1, nota2;
        double media;
        
        nota1 = Double.parseDouble(entraNota());
        nota2 = Double.parseDouble(entraNota());
        
        media = (nota1 + nota2) / 2;
        System.out.println("A sua média foi: " + media);
    }
    
    public static String entraNota() {
        Scanner entrada = new Scanner(System.in);
        String data;
        
        System.out.print("Entre com a nota: ");
        data = entrada.nextLine();
        return data;
    }
}
