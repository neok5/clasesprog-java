package clasesprog.Interfaces.Animales;

public class Perro extends Animal {
    
    public Perro(String nombre) {
        super(nombre, "Ladrido");
    }
    
    // presentación específica de un Perro
    @Override
    public String presentacionConcreta() {
        return "SOY UN PERRO!";
    }

    // cada Animal concreto implementa su propio método caminar
    @Override
    public void caminar() {
        System.out.println(this.getNombre() + " camina rápidamente, y puede correr.");
    }
}