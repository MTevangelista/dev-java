package banco;

public class ContaPJ extends Conta {
    private String razao;
    private String cnpj;
    
    public ContaPJ(int num, double saldo, String razao, String cnpj) {
        super(num, saldo);
        this.razao = razao;
        this.cnpj = cnpj;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public double calculaSaldo() {
        return getSaldo();
    }

    @Override
    public String toString() {
        return super.toString() + " " + razao + " " + cnpj;
    }
}
