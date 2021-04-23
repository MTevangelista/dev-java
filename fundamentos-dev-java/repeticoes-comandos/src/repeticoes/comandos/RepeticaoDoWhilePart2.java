package repeticoes.comandos;

import java.util.Scanner;

public class RepeticaoDoWhilePart2 {
    public static void main(String[] args) {
        int dia;
        
        do {
            dia = leInteiro("Entre com um dia da semana: ");
            if ((dia < 1) || (dia > 7)) {
                System.err.println("Dia inválido");
            }
            
        } while ((dia < 1) || (dia > 7));
        
        exibeDiaSemana(dia);
    }
    
    public static int leInteiro(String msg) {
        Scanner entrada = new Scanner(System.in);
        int num;
        
        System.out.print(msg);
        num = entrada.nextInt();
        return num;
    }
    
    public static void exibeDiaSemana(int dia) {
        switch (dia) {
            case 1: System.out.println("Domingo"); break;
            case 2: System.out.println("Segunda"); break;
            case 3: System.out.println("Terça"); break;
            case 4: System.out.println("Quarta"); break;
            case 5: System.out.println("Quinta"); break;
            case 6: System.out.println("Sexta"); break;
            case 7: System.out.println("Sábado"); break;
        }
    }
}
