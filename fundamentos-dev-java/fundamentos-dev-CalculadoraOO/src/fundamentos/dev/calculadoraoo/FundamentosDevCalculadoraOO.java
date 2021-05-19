package fundamentos.dev.calculadoraoo;

public class FundamentosDevCalculadoraOO {
    public static void main(String[] args) {
        Calc calc = new Engenharia(2, 3);
        
        System.out.println(calc.soma());
        System.out.println(calc.subtracao());
        System.out.println(calc.multiplicacao());
        System.out.println(calc.divisao());
        
        for (int i = 0; i < calc.getLog().size(); i++) {
            System.out.println(calc.getLog().get(i));
        }
    }
}
