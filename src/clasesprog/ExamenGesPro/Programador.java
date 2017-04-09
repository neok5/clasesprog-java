package clasesprog.ExamenGesPro;

import java.text.Collator;

public class Programador implements Comparable<Programador> {
    
    private final String dni; // IDENTIFICADOR ÚNICO
    private final String nombre;
    private final int antiguedad;
    
    public Programador(String dni, String nombre, int antiguedad) {
        this.dni = dni;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
    }

    @Override
    public int compareTo(Programador p) {
        return Collator.getInstance().compare(this.nombre, p.getNombre());
    }
    
    @Override
    public String toString() {
        return "\n • Nombre:     " + this.nombre
             + "\n • DNI:        " + this.dni
             + "\n • Antigúedad: " + this.antiguedad + " años";
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }
}