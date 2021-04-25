package calculadora;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Calculadora {
    public static void main(String[] args) {
        int op1, op2, oper;
        double result;
        
        oper = menu();
        if ((oper < 1) || (oper > 4)) {
            System.out.println("Operação inválida");
            return;
        }
        op1 = leInteiroGraf("Entre com um número: ");
        op2 = leInteiroGraf("Entre com um número: ");
        result = calcula(oper, op1, op2);
    }

    public static double calcula(int oper, int op1, int op2) {
        double result = 0;

        switch (oper) {
            case 1: 
                result = op1 + op2;
                JOptionPane.showMessageDialog(null, "Soma = " + result);
                break;
            case 2:
                result = op1 - op2;
                JOptionPane.showMessageDialog(null, "Subtração = " + result);
                break;
            case 3:
                result = op1 * op2;
                JOptionPane.showMessageDialog(null, "Multiplicação = " + result);
                break;    
            case 4: 
                result = (double) op1 / op2;
                JOptionPane.showMessageDialog(null, "Divisão = " + result);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Operação inválida");
                break;
        }
        return result;
    }

    public static int menu() {
        int oper;
        String opcoes = "Escolha a operação:\n"
                + "1 - Soma\n"
                + "2 - Subtração\n" 
                + "3 - Multiplicação\n"
                + "4 - Divisão\n";
        oper = leInteiroGraf(opcoes);
        return oper;
    }
    
    public static int leInteiroGraf(String msg) {
        int num;
        
        num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        return num;
    }
    
    public static int leInteiro(String msg) {
        Scanner entrada = new Scanner(System.in);
        int num;
        
        System.out.print(msg);
        num = entrada.nextInt();
        return num;
    }
}