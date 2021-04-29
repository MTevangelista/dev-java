package vetor2;

public class Vetor2 {
    public static void main(String[] args) {
        final int TAM = 10;
        int[] vet1 = new int[TAM];
        int[] vet2 = new int[TAM];
        int[] vet3 = new int[TAM];
        
        initVetor(vet1);
        initVetor(vet2);
        soma(vet1, vet2, vet3);
        exibeSoma(vet3);
    }
    
    public static void initVetor(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            vet[i] = 1;
        }
    }
    
    public static void soma(int [] vet1, int[] vet2, int[] vet3) {
        for (int i = 0; i < vet1.length; i++) {
            vet3[i] = vet1[i] + vet2[i];
        }
    }
    
    public static void exibeSoma(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + "");
        }
    }
}
