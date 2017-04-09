package clasesprog.Interfaces.Figuras;

// clase cuadrado que implementa la interfaz Figura
public class Cuadrado implements FiguraIF {
    private final double LADO;
    
    public Cuadrado(int LADO) {
        this.LADO = LADO;
    }

    // se sobreescriben los métodos de la interfaz, definiendo la implementación
    // LADO*4
    @Override
    public double calcularPerimetro() {
        return this.LADO*4;
    }

    // LADO²
    @Override
    public double calcularArea() {
        return Math.pow(this.LADO, 2);
    }

    public double getLado() {
        return LADO;
    }
}