package Ex07;

public class Funcionario {
    protected String nome;
    protected float salarioBruto;
    
    public Funcionario(String nome, float salarioBruto) {
        this.nome = nome;
        this.salarioBruto = salarioBruto;
    }
    
    public float salarioLiquido() {
        return 0;
    }
}
