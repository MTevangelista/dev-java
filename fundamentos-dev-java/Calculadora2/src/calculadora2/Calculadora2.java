package calculadora2;

import java.util.Scanner;

public class Calculadora2 {
    public static void main(String[] args) {
        final int FIM = 0;
        double op1, op2;
        int opcao;
        
        opcao = menu();
        while (opcao != FIM) {
            op1 = leReal("Entre com o operando: ");
            op2 = leReal("Entre com o operando: ");
            calcula(opcao, op1, op2);
            opcao = menu();
        }
        System.out.println("Fim da calculadora");
    }
    
    public static int menu() {
        int opcao;
        
        do {
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("0 - Sair");
            opcao = leInteiro("Entre com uma opção: ");
            if ((opcao < 0) || (opcao > 4)) {
                System.err.println("Erro: opção inválida");
            }
        } while ((opcao < 0) || (opcao > 4));
        return opcao;
    }
    
    public static int leInteiro(String msg) {
        Scanner entrada = new Scanner(System.in);
        int num;
        
        System.out.print(msg);
        num = entrada.nextInt();
        return num;
    }
    
    public static double leReal(String msg) {
        Scanner entrada = new Scanner(System.in);
        double num;
        
        System.out.print(msg);
        num = entrada.nextDouble();
        return num;
    }    
    
    public static void calcula(int oper, double op1, double op2) {
        double result = 0;
        
        switch (oper) {
            case 1:
                result = op1 + op2; 
                System.out.println("Resultado = " + result);
                break;
            case 2:
                result = op1 - op2; 
                System.out.println("Resultado = " + result);
                break;
            case 3:
                result = op1 * op2;
                System.out.println("Resultado = " + result);
                break;
            case 4:
                result = op1 / op2;
                if (op2 == 0) {
                    System.err.println("Erro: div / 0");
                } 
                else {
                    System.out.println("Resultado = " + result);
                }
                break;
        }    
    }    
}
