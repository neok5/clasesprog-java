package clasesprog.Interfaces.Figuras;

public abstract class Triangulo implements FiguraIF {
    // se declaran constantes, puesto que se definen al crear
    // el Triangulo, pero no cambian a lo largo de su uso
    private final double BASE;
    private final double ALTURA;
    
    public Triangulo(double BASE, double ALTURA) {
        // elementos comunes a cualquier triángulo
        // se pueden calcular ya al crear el objeto (en el constructor)
        this.BASE = BASE;
        this.ALTURA = ALTURA;
    }
    
    // método común a todos los triángulos, de cualquier tipo
    @Override
    public double calcularArea() {
        return (this.ALTURA*this.BASE)/2;
    }

    public double getBase() {
        return BASE;
    }

    public double getAltura() {
        return ALTURA;
    }
}