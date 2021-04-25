package lista01.exercicios;

import javax.swing.JOptionPane;

/*
    01) Faça um algoritmo que troque o valor de duas variáveis. Por exemplo, o algoritmo
    lê n1 igual a 3 e n2 a 17, e mostra n1 igual a 17 e n2 a 3.
*/

public class Ex01 {
    public static void main(String[] args) {
        int num1, num2;
        
        num1 = leInteiroGraf("Entre com um número: ");
        num2 = leInteiroGraf("Entre com um número: ");
        
        System.out.println(num1 * 2);
        System.out.println(num2 * 2);
    }
    
    public static int leInteiroGraf(String msg) {
        int num;
        
        num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        return num;
    }
}
