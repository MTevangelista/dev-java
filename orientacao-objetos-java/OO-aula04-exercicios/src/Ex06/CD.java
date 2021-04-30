package Ex06;

public class CD extends Produto {
    private String banda;

    public CD(int codigo, String descricao, float preco, float peso, String banda) {
        super(codigo, descricao, preco, peso);
        this.banda = banda;
    }
}

