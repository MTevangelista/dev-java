package lista01.exercicios;

import java.util.Scanner;

/*
    07) Faça um algoritmo que calcule a área de um retângulo, sendo que os comprimentos
    da altura e da base são informados pelo usuário. A área do retângulo é calculada
    multiplicando-se a altura pela base.
*/

public class Ex07 {
    public static void main(String[] args) {
        double altura, base, area;
        
        altura = Double.parseDouble(entraValor("Entre com a altura do retângulo: "));
        base = Double.parseDouble(entraValor("Entre coom a base do retângulo: "));
        
        area = altura * base;
        
        System.out.println("A área do retângulo é: " + area);
    }
    
    public static String entraValor(String msg) {
        Scanner entrada = new Scanner(System.in);
        String data;
        
        System.out.print(msg);
        data = entrada.nextLine();
        return data;
    }
}
