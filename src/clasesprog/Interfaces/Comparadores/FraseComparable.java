package clasesprog.Interfaces.Comparadores;

import java.text.Collator;

public class FraseComparable implements Comparable<FraseComparable> {
    private String frase;
    
    public FraseComparable(String frase) {
        this.frase = frase;
    }

    // es igual que Frase, solo que implementa compareTo, isLess,
    //isEqual e isGreater, propios de un elemento Comparable
    @Override
    public int compareTo(FraseComparable fraseComparable) {
        // Collator es una clase externa auxiliar que permite comparar Strings
        // para obtener un objeto hay que llamar a un método estático, getInstance
        Collator comparadorExterno = Collator.getInstance();
        // Collator.PRIMARY indica que no distinga entre mayúsculas, minúsculas o acentos
        // Es decir, que "a" = "A" = "á" = "Á" a la hora de comparar
        // Se puede aplicar SECUNDARY, etc, para aplicar otras distinciones diferentes
        comparadorExterno.setStrength(Collator.PRIMARY);
        
        return comparadorExterno.compare(
                this.getFrase(), fraseComparable.getFrase());
    }
    
    // devuelve true si this es menor que fr
    public boolean isLess(FraseComparable fr) {
        return this.compareTo(fr) < 0;
    }
    
    // devuelve true si this es igual que fr
    public boolean isEqual(FraseComparable fr) {
        return this.compareTo(fr) == 0;
    }
    
    // devuelve true si this es mayor que fr
    public boolean isGreater(FraseComparable fr) {
        return this.compareTo(fr) > 0;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
}