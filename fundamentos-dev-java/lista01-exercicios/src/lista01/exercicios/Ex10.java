package lista01.exercicios;

import java.util.Scanner;

/*
    10) Faça um algoritmo que calcule o volume de uma caixa de água cilíndrica, sendo que
    os comprimentos do raio e a altura são informados pelo usuário. O volume é
    calculado multiplicando-se Pi, ao raio ao quadrado, a altura.
*/

public class Ex10 {
    public static void main(String[] args) {
        final double PI = 3.14;
        double raio, altura, volume;
        
        raio = Double.parseDouble(entraValor("Entre com o valor do raio: "));
        altura = Double.parseDouble(entraValor("Entre com o valor da altura: "));
        
        volume = PI * (raio * raio) * altura;
        System.out.println("A o volume de uma caixa de água cilíndrica é: "+volume+" m3");
    }
    
    public static String entraValor(String msg) {
        Scanner entrada = new Scanner(System.in);
        String data;
        
        System.out.print(msg);
        data = entrada.nextLine();
        return data;
    }
}
