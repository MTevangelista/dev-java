package Ex06;

public class Produto {
    private int codigo;
    private String descricao;
    private float preco;
    private float peso;
    
    public Produto(int codigo, String descricao, float preco, float peso){
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.peso = peso;
    }
    
    public float calculaFrete() {
        return (float) 6.5 * peso;
    }
}
