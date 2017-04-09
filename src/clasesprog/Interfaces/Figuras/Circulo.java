package clasesprog.Interfaces.Figuras;

public class Circulo implements FiguraIF {
    private final double RADIO;
    
    public Circulo(double RADIO) {
        this.RADIO = RADIO;
    }

    // 2*PI*R
    @Override
    public double calcularPerimetro() {
        return 2*FiguraIF.NUM_PI*this.RADIO;
    }

    // PI*R²
    @Override
    public double calcularArea() {
        return FiguraIF.NUM_PI*(Math.pow(this.RADIO, 2));
    }

    public double getRadio() {
        return RADIO;
    }
}