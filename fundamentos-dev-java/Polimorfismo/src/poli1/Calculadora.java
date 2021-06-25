package poli1;

public class Calculadora {
    private double op1, op2;
    
    public Calculadora() {}
    
    public Calculadora(double op1, double op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    public double getOp1() {
        return op1;
    }

    public void setOp1(double op1) {
        this.op1 = op1;
    }

    public double getOp2() {
        return op2;
    }

    public void setOp2(double op2) {
        this.op2 = op2;
    }
    
    public double soma() {
        return op1 + op2;
    }
    
    public double soma(double op1, double op2) {
        return op1 + op2;
    }
    
    public int soma(int op1, int op2) {
        return op1 + op2;
    }
    
    @Override
    public String toString() {
        return "Calculadora{" + "op1=" + op1 + ", op2=" + op2 + '}';
    }
}
