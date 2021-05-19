package banco;

public class ContaPF extends Conta {
    private String titular;
    private String cpf;
    private double chequeEspecial;
    
    public ContaPF(int num, double saldo, String titular,  String cpf, double chequeEspecial) {
        super(num, saldo);
        this.titular = titular;
        this.cpf = cpf;
        this.chequeEspecial = chequeEspecial;
    }
    
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    
    @Override
    public double calculaSaldo() {
        return getSaldo() + chequeEspecial;
    }

    @Override
    public String toString() {
        return super.toString() + " " + titular + " " + cpf + " " + chequeEspecial;
    }
}
