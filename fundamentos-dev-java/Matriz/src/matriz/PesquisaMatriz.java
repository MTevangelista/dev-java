package matriz;

import java.util.Scanner;

public class PesquisaMatriz {
    public static void main(String[] args) {
        final int LINHAS = 3, COLUNAS = 5;
        //int[][] mat = new int[LINHAS][COLUNAS];
        int[][] mat = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        int num;
        
        num = leInteiro("Entre com um número: ");
        if (pesquisa(mat, num)) {
            System.out.println("Achou");
        } else {
            System.out.println("Não achou");
        }
    }
    
    public static boolean pesquisa(int[][] mat, int num) {
        boolean achou = false;
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == num){
                    achou = true;
                    break;
                }
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


