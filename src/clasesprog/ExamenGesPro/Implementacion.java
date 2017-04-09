package clasesprog.ExamenGesPro;

import java.util.Set;

public class Implementacion extends Tarea {
    
    enum Lenguaje { JAVA, C, DOT_NET }
    
    private final Lenguaje lenguaje;

    @SuppressWarnings("NonPublicExported")
    public Implementacion(int codigo, String descripcion,
        Set<Programador> miembros, int duracion, Lenguaje lenguaje) {
        
        super(codigo, descripcion, miembros, duracion);
        this.lenguaje = lenguaje;
    }
    
    @Override
    public String toString() {
        return "\n   - IMPLEMENTACIÓN: " + this.getDescripcion() + " " + this.lenguaje;
    }

    @SuppressWarnings("NonPublicExported")
    public Lenguaje getLenguaje() {
        return lenguaje;
    }
}