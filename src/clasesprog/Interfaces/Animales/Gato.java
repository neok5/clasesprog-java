package clasesprog.Interfaces.Animales;

public class Gato extends Animal {
    
    public Gato(String nombre) {
        super(nombre, "Maullido");
    }
    
    // presentación específica de un Gato
    @Override
    public String presentacionConcreta() {
        return "SOY UN GATO!";
    }

    // cada Animal concreto implementa su propio método caminar
    @Override
    public void caminar() {
        System.out.println(this.getNombre() + " camina ágilmente y salta.");
    }
}