package clasesprog.ExamenGesPro;

import java.util.Set;

public class Analisis extends Tarea {
    
    enum Metodologia { SCRUM, OOP, EXTREME_PROGRAMMING }
    
    private final Metodologia metodologia;

    @SuppressWarnings("NonPublicExported")
    public Analisis(int codigo, String descripcion,
        Set<Programador> miembros, int duracion, Metodologia metodologia) {
        
        super(codigo, descripcion, miembros, duracion);
        this.metodologia = metodologia;
    }

    @Override
    public String toString() {
        return "\n   - ANÁLISIS:       " + this.getDescripcion() + " " + this.metodologia;
    }

    @SuppressWarnings("NonPublicExported")
    public Metodologia getMetodologia() {
        return metodologia;
    }
}