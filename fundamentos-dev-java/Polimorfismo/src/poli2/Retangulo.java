package poli2;

public class Retangulo extends Forma {
    public Retangulo(int larg, int alt) {
        super(larg, alt);
    }
    
    @Override
    public int area() {
        return getAltura() * getLargura();
    }
}
