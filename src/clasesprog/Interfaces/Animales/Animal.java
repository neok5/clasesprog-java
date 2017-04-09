package clasesprog.Interfaces.Animales;

import java.io.*;

public abstract class Animal implements AnimalIF {
    private String nombre;
    // constante, se inicializa al crear el Animal, y  no se modifica nunca
    private final String sonido;
    
    public Animal(String nombre, String sonido) {
        this.nombre = nombre;
        this.sonido = sonido;
    }

    // redefinimos el método emitirSonido de la interfaz AnimalIF para todos los Animales
    @Override
    public void emitirSonido() {
        System.out.println(this.getNombre() + " hace el siguiente ruido: " + this.sonido);
    }

    public String getSonido() {
        return sonido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}