package lista01.exercicios;

import java.util.Scanner;

/*
    08) Faça um algoritmo que calcule a área de um círculo, sendo que o comprimento do
    raio é informado pelo usuário. A área do círculo é calculada multiplicando-se Pi ao
    raio ao quadrado.
*/

public class Ex08 {
    public static void main(String[] args) {
        final double PI = 3.14;
        double raio, area;
        
        raio = Double.parseDouble(entraValor("Entre com o valor do raio do círculo:"));
        area = PI * (raio * raio);
        
        System.out.println("A área do círculo é: " + area);
    }
    
    public static String entraValor(String msg) {
        Scanner entrada = new Scanner(System.in);
        String data;
        
        System.out.print(msg);
        data = entrada.nextLine();
        return data;
    }
}
