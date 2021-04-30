package Ex06;

public class Livro extends Produto {
    private String autor;
    
    public Livro(int codigo, String descricao, float preco, float peso, String autor){
        super(codigo, descricao, preco, peso);
        this.autor = autor;
    }
}
