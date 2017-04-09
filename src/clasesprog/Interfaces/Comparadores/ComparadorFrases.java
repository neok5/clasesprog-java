package clasesprog.Interfaces.Comparadores;

import java.text.Collator;
import java.util.Comparator;

public class ComparadorFrases implements Comparator<Frase>{

    @Override
    public int compare(Frase o1, Frase o2) {
        // Collator es una clase externa auxiliar que permite comparar Strings
        Collator comparadorExterno = Collator.getInstance();
        // Collator.PRIMARY indica que no distinga entre mayúsculas, minúsculas o acentos
        // Es decir, que "a" = "A" = "á" = "Á"
        // Se puede aplicar SECUNDARY, etc, para aplicar otras distinciones diferentes
        comparadorExterno.setStrength(Collator.PRIMARY);
        
        return comparadorExterno.compare(o1.getFrase(), o2.getFrase());
    }
}