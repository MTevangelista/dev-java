package fundamentos.dev.calculadoraoo;

import java.util.ArrayList;

public class Calc implements ICalc {
    private double op1;
    private double op2;
    private ArrayList<String> log;
    
    public Calc() {
        log = new ArrayList<>();
    }
    
    public Calc(double op1, double op2) {
        this.op1 = op1;
        this.op2 = op2;
        log = new ArrayList<>();
    } 
    
    public ArrayList<String> getLog() { return log; }
    
    public void setLog(ArrayList<String> log) { this.log = log; }
    
    public double getOp1() { return op1; }

    public void setOp1(double op1) { this.op1 = op1; }

    public double getOp2() { return op2; }

    public void setOp2(double op2) { this.op2 = op2; }
    
    @Override
    public double soma() { 
        double result;
        
        result = op1 + op2;
        log.add(op1 + " + " + op2 + " = " + result);
        return op1 + op2; 
    }
    
    @Override
    public double soma(double op1, double op2) { 
        double result;
        
        result = op1 + op2;
        log.add(op1 + " + " + op2 + " = " + result);
        return op1 + op2; 
    }
    
    @Override
    public double subtracao() { 
        double result;
        
        result = op1 - op2;
        log.add(op1 + " - " + op2 + " = " + result);
        return op1 - op2; 
    }
    
    @Override
    public double subtracao(double op1, double op2) { 
        double result;
        
        result = op1 - op2;
        log.add(op1 + " - " + op2 + " = " + result);
        return op1 - op2; 
    }
    
    @Override
    public double multiplicacao() {
        double result;
        
        result = op1 * op2;
        log.add(op1 + " * " + op2 + " = " + result);
        return op1 * op2;
    }
    
    @Override
    public double multiplicacao(double op1, double op2) {
        double result;
        
        result = op1 * op2;
        log.add(op1 + " * " + op2 + " = " + result);
        return op1 * op2;
    }

    @Override
    public double divisao() {
        double result;
    
        result = op1 / op2;
        log.add(op1 + " / " + op2 + " = " + result);
        return op1 / op2;
    }    
    
    @Override
    public double divisao(double op1, double op2) {
        double result;
    
        result = op1 / op2;
        log.add(op1 + " / " + op2 + " = " + result);
        return op1 / op2;
    }
    
    @Override
    public String toString() {
        return op1 + " " + op2; 
    }
}
