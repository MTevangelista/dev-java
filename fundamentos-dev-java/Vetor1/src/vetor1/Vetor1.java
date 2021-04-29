package vetor1;

import java.util.Scanner;

public class Vetor1 {
    public static void main(String[] args) {
        final int TAM = 10;
        int[] vet = new int[TAM];
        //int[] vet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        for (int i = 0; i < vet.length; i++) {
            vet[i] = i + 1;
        }
        for (int i = 0; i < vet.length; i++) {
            System.out.println(vet[i] + " ");
        }
        System.out.println();
        
        int num = leInteiro("Entre com um número: ");
        if (pesquisa(vet, num)) {
            System.out.println("Achou");
        } else {
            System.out.println("Não achou");
        }
    }
    
    public static boolean pesquisa(int[] vet, int num) {
        boolean achou = false;
        
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] == num) {
                achou = true;
                break;
            }
        }
        return achou;
    }
    
    public static int leInteiro(String msg) {
        Scanner entrada = new Scanner(System.in);
        int num;
        
        System.out.println(msg);
        num = entrada.nextInt();
        return num;
    }
}
