package poli2;

public class Main {
    public static void main(String[] args) {
        Forma forma;
        
        forma = new Quadrado(3);
        System.out.println(forma);
        
        forma = new Retangulo(4, 7);
        System.out.println("Área: "+forma.area());
        
        forma = new Triangulo(2, 3);
        System.out.println("Área: "+forma.area()); 
    }
}
