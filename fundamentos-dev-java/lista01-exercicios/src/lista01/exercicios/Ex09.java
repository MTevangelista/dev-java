package lista01.exercicios;

import java.util.Scanner;

/*
    09) Faça um algoritmo que calcule a área de uma esfera, sendo que o comprimento do
    raio é informado pelo usuário. A área da esfera é calculada multiplicando-se 4 vezes
    Pi ao raio ao quadrado.
*/

public class Ex09 {
    public static void main(String[] args) {
        final double PI = 3.14;
        double raio, area;
        
        raio = Double.parseDouble(entraValor("Entre com o valor do raio: "));
        area = (PI * 4) * (raio * raio);
        
        System.out.println("A área da esfera é: " + area);
    }
    
    public static String entraValor(String msg) {
        Scanner entrada = new Scanner(System.in);
        String data;
        
        System.out.print(msg);
        data = entrada.nextLine();
        return data;
    }
}
