package lista01.exercicios;

import java.util.Scanner;

/*
    05) Faça um algoritmo que calcule o novo valor de um salário a partir de um valor
    percentual de reajuste. O valor atual do salário e o valor percentual do reajuste
    devem ser informados pelo usuário como, por exemplo, 7,3%.
*/

public class Ex05 {
    public static void main(String[] args) {
        double valorAtualDoSalario, valorPercentualReajuste, valorDoNovoSalario;
        
        valorAtualDoSalario = Double.parseDouble(entraValor("Entre com o valor atual do salário: "));
        valorPercentualReajuste = (Double.parseDouble(entraValor("Entre com o percentual do reajuste: ")) / 100);
        
        valorDoNovoSalario =  valorAtualDoSalario + (valorAtualDoSalario * valorPercentualReajuste);
        
        System.out.println("Valor atual do salário: " + valorAtualDoSalario);
        System.out.println("Valor do percentual de reajuste: " + valorPercentualReajuste);
        System.out.printf("Valor do novo salário: %.2f ", valorDoNovoSalario);
    }
    
    public static String entraValor(String msg) {
        Scanner entrada = new Scanner(System.in);
        String data;
        
        System.out.print(msg);
        data = entrada.nextLine();
        return data;
    }
}
