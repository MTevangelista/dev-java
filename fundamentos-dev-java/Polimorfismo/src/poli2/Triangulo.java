package poli2;

public class Triangulo extends Forma {
    public Triangulo(int larg, int alt) {
        super(larg, alt);
    }
    
    @Override
    public int area() {
        return (getAltura() + getLargura() / 2);
    }
}
