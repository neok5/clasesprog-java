package clasesprog.Interfaces.Animales;

public class Oveja extends Animal {
    
    public Oveja(String nombre) {
        super(nombre, "Balido");
    }
    
    // presentación específica de una Oveja
    @Override
    public String presentacionConcreta() {
        return "SOY UNA OVEJA!";
    }

    // cada Animal concreto implementa su propio método caminar
    @Override
    public void caminar() {
        System.out.println(this.getNombre() + " camina torpemente y despacio.");
    }
}