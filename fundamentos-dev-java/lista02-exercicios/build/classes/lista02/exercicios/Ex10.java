package lista02.exercicios;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        String data;
        
        data = entraData();
        String[] campos = data.split("/");
        int dia = Integer.parseInt(campos[0]);
        int mes = Integer.parseInt(campos[1]);
        int ano = Integer.parseInt(campos[2]);
        
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if ((dia < 0) || (dia > 31)) {
                    System.out.println("Data inválida");
                }
                break;
            case 4: case 6: case 9: case 11:
                if ((dia < 0) || (dia > 30)) {
                    System.out.println("Data inválida");
                }
                break;
            case 2:
                if ((ano % 4) == 0) {
                    if ((dia < 0) || (dia > 29)) {
                        System.out.println("Data inválida");
                    }
                } else {
                    if ((dia < 0) || (dia > 28)) {
                        System.out.println("Data inválida");
                    }
                }
                break;
            default:
                System.out.println("Data inválida");
        }
    }
    
    public static String entraData() {
        Scanner entrada = new Scanner(System.in);
        String data;
        
        System.out.print("Entre com a data: ");
        data = entrada.nextLine();
        return data;
    }
}
