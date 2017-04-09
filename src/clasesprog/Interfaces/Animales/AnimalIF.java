package clasesprog.Interfaces.Animales;

public interface AnimalIF {
    String ESTOY_VIVO = "Estoy vivo.";
    
    // método static
    static String isAlive() {
        return ESTOY_VIVO;
    }
    
    // dos métodos default
    default String presentacionGenerica() {
        return "SOY UN ANIMAL!";
    }
    
    default String presentacionConcreta() {
        return "SOY UN ANIMAL! (presentación no definida)";
    }
    
    // métodos abstractos tradicionales de una interfaz
    void emitirSonido();
    
    void caminar();

    // no está permitido redefinir métodos de la clase Object como default
    // ni como static, daría un error de compilación
    // default public String toString();
}