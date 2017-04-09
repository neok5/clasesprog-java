package clasesprog.ExamenLinkedIn;

public class Oferta {
    private String perfil;
    private int aniosExpNecesaria;
    
    public Oferta(String perfil, int aniosExpNecesaria) {
        this.perfil = perfil;
        this.aniosExpNecesaria = aniosExpNecesaria;
    }
    
    @Override
    public String toString() {
        return "Perfil buscado: " + this.perfil +
            "\nExperiencia mínima (años): " + this.aniosExpNecesaria;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getAniosExpNecesaria() {
        return aniosExpNecesaria;
    }

    public void setAniosExpNecesaria(int aniosExpNecesaria) {
        this.aniosExpNecesaria = aniosExpNecesaria;
    }
}