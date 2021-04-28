package lista03.exercicios;

import java.util.Scanner;

/*
    06) Faça um algoritmo que leia um intervalo inferior e superior, e mostre os números
    primos existentes no intervalo. Por exemplo, o algoritmo recebe 5 e 10, e mostra
    como saída 5 e 7. Além disso, o algoritmo deve mostrar a quantidade de números
    primos encontrados no intervalo.
*/

public class Ex06 {
    public static void main(String[] args) {
        int inicio, fim;
        
        inicio = leInteiro("Entre com o valor inicial: ");
        fim = leInteiro("Entre com o valor final: ");
        for (int i = inicio; i <= fim; i++) {
            if (ePrimo(i)) {
                System.out.print(i + " ");
            }
        }
    }
    
    public static boolean ePrimo(int num) {
        boolean primo = true;
        
        for (int i = 2; i < num-1; i++) {
            if ((num % i) == 0) {
                primo  = false;
            }
        }
        return primo;
    }
    
    public static int leInteiro(String msg) {
        Scanner entrada = new Scanner(System.in);
        int num;
        
        System.out.println(msg);
        num = entrada.nextInt();
        return num;
    }
}
