package poli2;

public class Quadrado extends Forma {
    
    public Quadrado(int lado) {
        super(lado);
    }
    
    @Override
    public int area() {
        return getLargura() * getLargura();
    }
}
