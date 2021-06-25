package poli1;

public class Teste {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora(2, 5);
        
        System.out.println(calc.soma());
        System.out.println(calc.soma(2.5, 2.5));
        System.out.println(calc.soma(2, 2));
    }
}
