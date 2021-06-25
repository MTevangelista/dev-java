package main;

public class AccountPF extends Account {
    private String cpf;
    private double specialCheck;
    
    public AccountPF() {}
    
    public AccountPF(String name, int accountNumber, double accountBalance, String cpf, double specialCheck) {
        super(name, accountNumber, accountBalance);
        this.cpf = cpf;
        this.specialCheck = specialCheck;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public double getSpecialCheck() {
        return specialCheck;
    }

    public void setSpecialCheck(double specialCheck) {
        this.specialCheck = specialCheck;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CPF: ").append(cpf).append("\n");
        sb.append("Cheque especial: ").append(specialCheck).append("\n");
        return super.toString() + sb.toString();
    }
}
