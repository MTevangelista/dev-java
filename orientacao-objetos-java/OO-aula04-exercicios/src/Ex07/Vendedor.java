package Ex07;

public class Vendedor extends Funcionario{
    private float bonus;
    
    public Vendedor(String nome, float salarioBruto, float bonus) {
        super(nome, salarioBruto);
        this.bonus = bonus;
    }
    
    @Override
    public float salarioLiquido() {
        float salarioLiquido = 0;
        
        salarioBruto += salarioBruto * (bonus / 100);
        if (salarioBruto <= 900) {
            salarioLiquido = calculaSalario(0, salarioBruto);
        } else if (salarioBruto <= 1500) {
            salarioLiquido = calculaSalario((float) 0.15, salarioBruto);
        } else if (salarioBruto > 1500) {
            salarioLiquido = calculaSalario((float) 0.20, salarioBruto);
        }
       
        return salarioLiquido;
    }
    
    private float calculaSalario(float impostoRenda, float salarioBruto) {
        return salarioBruto - (salarioBruto * impostoRenda);   
    }
}
