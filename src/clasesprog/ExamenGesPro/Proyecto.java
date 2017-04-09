package clasesprog.ExamenGesPro;

import java.text.Collator;
import java.util.*;

public class Proyecto implements Comparable<Proyecto> {
    
    private final String referencia; // IDENTIFICADOR ÚNICO
    private final String nombre;
    private final String cliente;
    private final Programador lider;
    private final Map<Integer,Tarea> tareas;
    
    public Proyecto(String referencia, String nombre, String cliente, Programador lider) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.cliente = cliente;
        this.lider = lider;
        this.tareas = new HashMap();
    }

    @Override
    public int compareTo(Proyecto p) {
        return Collator.getInstance().compare(this.referencia, p.getReferencia());
    }
    
    @Override
    public String toString() {
        String retorno = " • Referencia: " + this.referencia
                       + "\n • Nombre:     " + this.nombre
                       + "\n • Cliente:    " + this.cliente
                       + "\n • Lider:      " + this.lider.getNombre()
                       + "\n • Tareas:";
        
        if(this.tareas.values().isEmpty())
            retorno += "     (no hay tareas asignadas)";
        else {
            for (Tarea t : this.tareas.values())
                retorno += t;
        }
        
        return retorno;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCliente() {
        return cliente;
    }

    public Programador getLider() {
        return lider;
    }

    public Map<Integer, Tarea> getTareas() {
        return tareas;
    }
}