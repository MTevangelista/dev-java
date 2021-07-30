package main;

public class AccountPJ extends Account {
    private String cnpj;
    
    public AccountPJ() {}
    
    public AccountPJ(String name, int accountNumber, double accountBalance, String cnpj) {
        super(name, accountNumber, accountBalance);
        this.cnpj = cnpj;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("cnpj: ").append(cnpj).append("\n");
        return super.toString() + sb.toString();
    }
}
