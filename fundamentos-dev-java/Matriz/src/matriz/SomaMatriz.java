package matriz;

public class SomaMatriz {
    final static int LINHAS = 3, COLUNAS = 5;
    
    public static void main(String[] args) {
        //int[][] mat = new int[LINHAS][COLUNAS];
        int[][] mat1 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        int[][] mat2 = {{10, 20, 30, 40, 50}, {60, 70, 80, 90, 100}, {110, 120, 130, 140, 150}};
        int[][] mat3 = new int [LINHAS][COLUNAS];
        
        exibeMatriz(mat1);
        exibeMatriz(mat2);
        mat3 = soma(mat1, mat2);
        System.out.println("Soma igual a:");
        exibeMatriz(mat3);
    }
    
    public static int[][] soma(int[][] mat1, int[][]mat2) {
        int[][] mat3 = new int[LINHAS][COLUNAS];
        
        
         for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                mat3[i][j] = mat1[i][j] + mat2[i][j];
            }
         }
        return mat3;
    }
    
    public static void exibeMatriz(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.printf("%3d ", mat[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
