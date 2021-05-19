package fundamentos.dev.calculadoraoo;

public class Cientifica extends Calc implements ICientifica {
    
    public Cientifica() {
        super();
    }
    
    public Cientifica(double op1, double op2) {
        super(op1, op2);
    }
     
    @Override
    public double exp(double op1) {
        return Math.exp(op1);
    }
    
    @Override
    public String toString() {
        return "Cientifica";
    }
}
