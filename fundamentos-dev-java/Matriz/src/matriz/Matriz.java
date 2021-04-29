package matriz;

public class Matriz {
    public static void main(String[] args) {
        final int LINHAS = 3, COLUNAS = 5;
        int[][] mat = new int[LINHAS][COLUNAS];
        //int[][] mat = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.printf("%3d", mat[i][j]);
            }
            System.out.println("");
        }
    }
}
