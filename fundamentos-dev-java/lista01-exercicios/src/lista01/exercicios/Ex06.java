package lista01.exercicios;

import java.util.Scanner;

/*
    06) Faça um algoritmo que calcule a área de um quadrado, sendo que o comprimento do
    lado é informado pelo usuário. A área do quadrado é calculada elevando-se o lado
    ao quadrado.
*/

public class Ex06 {
    public static void main(String[] args) {
        double lado, area;
        
        lado = Double.parseDouble(entraValor("Entre o comprimento do lado do quadrado: "));
        area = lado * lado;
        System.out.println("A área do quadrado é: " + area);
    }
    
    public static String entraValor(String msg) {
        Scanner entrada = new Scanner(System.in);
        String data;
        
        System.out.print(msg);
        data = entrada.nextLine();
        return data;
    }
}
