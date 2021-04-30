package Ex07;

public class Teste {
    public static void main(String[] args) {
        Funcionario vendedor = new Vendedor("Matheus", 900, 10);
        System.out.println("Nome do vendedor: "+vendedor.nome);
        System.out.println("Salário líquido: "+vendedor.salarioLiquido());
        
        Funcionario estagiario = new Estagiario("Souza", 1600);
        System.out.println("Nome do estagiário: "+estagiario.nome);
        System.out.println("Salário líquido: "+estagiario.salarioBruto);
    }
}
