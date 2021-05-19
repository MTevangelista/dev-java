package banco;

public abstract class Conta {
    private int num;
    private double saldo;
    
    public Conta(int num, double saldo) {
        this.num = num;
        this.saldo = saldo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public abstract double calculaSaldo();

    @Override
    public String toString() {
        return num + " " + saldo;
    }
}