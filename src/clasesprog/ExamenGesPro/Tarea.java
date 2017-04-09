package clasesprog.ExamenGesPro;

import java.util.*;

// es abstracto para que no se puedan crear directamente objetos Tarea
// siempre serán objetos Analisis, Disenno o Implementacion
public abstract class Tarea {
    
    private final int codigo; // IDENTIFICADOR ÚNICO
    private final String descripcion;
    private final Set<Programador> miembros;
    private final int duracion; // en dias
    
    public Tarea(int codigo, String descripcion, Set<Programador> miembros, int duracion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.miembros = miembros;
        this.duracion = duracion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Set<Programador> getMiembros() {
        return miembros;
    }

    public int getDuracion() {
        return duracion;
    }
}