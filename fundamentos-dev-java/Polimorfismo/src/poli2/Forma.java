package poli2;

public abstract class Forma {
    private int largura, altura;
    
    public Forma(int largura) {
        this.largura = largura;
    }
    
    public Forma(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public abstract int area();
}
