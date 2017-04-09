package clasesprog.Interfaces.Figuras;

public class TrianguloEq extends Triangulo {
    // los 3 lados son iguales, basta almacenar 1
    private final double LADO;
    
    public TrianguloEq(double LADO) {
        // se calcula la altura del triángulo a partir de su LADO
        // al inicializar el objeto, directamente en el constructor
        super(LADO, LADO*(Math.sqrt(3)/2));
        this.LADO = LADO;
    }

    // el triángulo equilátero calcula su perímetro
    // de una forma distinta al resto
    @Override
    public double calcularPerimetro() {
        return this.LADO*3;
    }

    public double getLado() {
        return LADO;
    }
}