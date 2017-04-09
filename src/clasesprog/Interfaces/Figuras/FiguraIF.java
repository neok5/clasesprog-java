package clasesprog.Interfaces.Figuras;

public interface FiguraIF {
    // por defecto, los campos son public final static
    double NUM_PI = 3.1416;
    
    // por defecto, las clases son abstract public
    double calcularPerimetro();
    
    double calcularArea();
}