package clasesprog.ExamenLinkedIn;

import java.text.Collator;
import java.util.Comparator;

public class ComparadorUsuarios implements Comparator<Usuario> {

    @Override
    public int compare(Usuario a, Usuario b) {
        return Collator.getInstance().compare(a.getNombre(), b.getNombre());
    }
}