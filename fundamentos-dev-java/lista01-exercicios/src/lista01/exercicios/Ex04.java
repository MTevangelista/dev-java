package lista01.exercicios;

import java.util.Scanner;

/*
    04) Faça um algoritmo que calcule a gorjeta a ser paga de uma conta de restaurante. A
    gorjeta é calculada como sendo 10% do valor da conta, que deve ser informado pelo
    usuário.
*/

public class Ex04 {
    public static void main(String[] args) {
        final double GORJETA = 0.10;
        double valorDaConta, valorDaGorjeta;
        
        valorDaConta = Double.parseDouble(entraValor());
        valorDaGorjeta = valorDaConta * GORJETA;
        
        System.out.println("O valor da conta foi de: R$ " + valorDaConta);
        System.out.println("A gorjeta é: R$ " + valorDaGorjeta);
    }
    
    public static String entraValor() {
        Scanner entrada = new Scanner(System.in);
        String data;
        
        System.out.print("Entre com o valor da conta: ");
        data = entrada.nextLine();
        return data;
    }
}
