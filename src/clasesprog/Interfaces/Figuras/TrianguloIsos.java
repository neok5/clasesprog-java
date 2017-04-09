package clasesprog.Interfaces.Figuras;

public class TrianguloIsos extends Triangulo {
    // tiene 2 lados iguales, y 1 diferente
    private final double LADO_DIF, LADO_IGUAL;
    
    public TrianguloIsos(double LADO_DIF, double LADO_IGUAL) {
        // se calcula la altura del triángulo a partir de su lado
        // al inicializar el objeto, directamente en el constructor
        super(LADO_DIF/2, Math.sqrt(Math.pow(LADO_IGUAL,2) - Math.pow(LADO_DIF/2, 2)));
        this.LADO_DIF = LADO_DIF;
        this.LADO_IGUAL = LADO_IGUAL;
    }

    // el triángulo isósceles calcula su perímetro
    // de una forma distinta al resto
    @Override
    public double calcularPerimetro() {
        return this.LADO_DIF+this.LADO_IGUAL*2;
    }

    public double getLadoDif() {
        return LADO_DIF;
    }

    public double getLadoIgual() {
        return LADO_IGUAL;
    }
}