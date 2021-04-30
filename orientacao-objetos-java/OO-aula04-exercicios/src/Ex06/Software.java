package Ex06;

public class Software extends Produto {
    private String categoria;

    public Software(int codigo, String descricao, float preco, float peso, String categoria) {
        super(codigo, descricao, preco, peso);
        this.categoria = categoria;
    }
}
