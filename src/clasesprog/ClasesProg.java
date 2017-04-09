package clasesprog;

import clasesprog.Colecciones.EjemplosCole;
import clasesprog.Enumerados.EjemplosEnum;
import clasesprog.Excepciones.EjemplosExcep;
import clasesprog.Interfaces.EjemplosInter;
import clasesprog.ExamenCalando.ExamenCalando;
import clasesprog.ExamenGesPro.ExamenGesPro;
import clasesprog.ExamenGuasa.ExamenGuasa;
import clasesprog.ExamenLinkedIn.ExamenLinkedIn;

// clase principal, desde donde se ejecutan todos los ejemplos
public class ClasesProg {
    // método main, que inicia todo el programa
    public static void main(String[] args) {
        EjemplosEnum.runEnumerados();
        EjemplosInter.runInterfaces();
        EjemplosCole.runColecciones();
        EjemplosExcep.runExcepciones();
        ExamenCalando.runCalando();
        ExamenLinkedIn.runLinkedIn();
        ExamenGuasa.runGuasa();
        ExamenGesPro.runGesPro();
    }
}