package clasesprog.ExamenGesPro;

import java.util.*;

public class Disenno extends Tarea {
    
    enum Patron { SINGLETON, FACTORY, DAO, OBSERVER }
    
    private final Set<Patron> patrones;    

    @SuppressWarnings("NonPublicExported")
    public Disenno(int codigo, String descripcion,
        Set<Programador> miembros, int duracion, Set<Patron> patrones) {
        
        super(codigo, descripcion, miembros, duracion);
        this.patrones = patrones;
    }
    
    @Override
    public String toString() {
        String retorno = "\n   - DISEÑO:         " + this.getDescripcion();
        
        for(Patron p : this.patrones)
            retorno += "\n                       " + p;
        
        return retorno;
    }

    @SuppressWarnings("NonPublicExported")
    public Set<Patron> getPatrones() {
        return patrones;
    }
}