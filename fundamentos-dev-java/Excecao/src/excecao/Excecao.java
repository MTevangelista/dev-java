package excecao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excecao {
    public static void main(String[] args) {
        int op1, op2, result;
        boolean operandoOK = false;
        
        do {
            op1 = entraInt("Entre com op1: ");
            op2 = entraInt("Entre com op2: ");
            try {
                result = op1/ op2;
                System.out.println("Divisão = "+result);
            } catch (ArithmeticException e ) {
                System.out.println("Erro: divisão por zero");
            }
        } while(!operandoOK);
    }
    
    public static int entraInt(String msg) {
        Scanner entrada = new Scanner(System.in);
        boolean entradaOK = false;
        int op = 0;
        
        do {
            try {
                System.out.println(msg);
                op = entrada.nextInt();
                entradaOK = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: dado inválido");
                entrada.next();
            }
        } while (!entradaOK);
        return op;
    }
}
