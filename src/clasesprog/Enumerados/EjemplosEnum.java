package clasesprog.Enumerados;

public class EjemplosEnum {
    // enumerados internos en la propia clase principal
    // enumerado simple
    enum Dias { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO }
    
    // enumerado complejo
    enum Vaso {    
        // tipos de vaso disponibles.
        // pasan al constructor su capacidad en cc
        JARRA(500), TUBO(250), TERCIO(333), CAÑA(200);
        
        // variable interna donde se almacena la capacidad
        private final int cc;
        
        // el constructor fuerza a pasar parámetros al definir un nuevo tipo
        Vaso(int cc) {
            this.cc = cc;
        }
        
        // devuelve la capacidad del vaso
        public int getCentimetrosCubicos() {
            return cc;
        }
    }
    
    public static void runEnumerados() {
        // enumerado en la propia clase ("interno")
        // uso simple
        System.out.println("Mi nacionalidad es: " + Nacionalidades.SPANISH + "\n");
        
        // listar valores enumerado
        System.out.println("Las diferentes nacionalidades son:\n");
        // el método values() devuelve un array estático
        for(Nacionalidades aux : Nacionalidades.values()) {
            System.out.println(aux + "\n");
        }
        
        System.out.println("\n ******************************* \n");
        
        // ejemplo uso de ordinales para mostrar la posición de un elemento
        Dias dia = Dias.JUEVES;
        System.out.println("El " + dia + " es el día " + (dia.ordinal()+1)
                + " de la semana.\n");
        
        // uso de compareTo() según el orden de enumeración
        Dias d1 = Dias.DOMINGO, d2 = Dias.SABADO;
        System.out.println("¿El " + d1 + " va antes que el " + d2 + "?");
        System.out.println((d1.compareTo(d2) < 0) + "\n");
        
        d1 = Dias.MARTES; d2 = Dias.JUEVES;
        System.out.println("¿El " + d1 + " va antes que el " + d2 + "?");
        System.out.println((d1.compareTo(d2) < 0) + "\n");
        
        // ejemplo de switch-case con enumerados
        Dias d = Dias.DOMINGO;
        System.out.println("Hoy es " + d + ". ");
        
        switch (d) {
            case LUNES:
            case MARTES:
            case MIERCOLES:
            case JUEVES:
            case VIERNES:
                System.out.println("Es un día laborable.");
                break;
            default:
                System.out.println("Es fin de semana.");
        }
        
        System.out.println("\n ******************************* \n");
        
        // ejemplo uso valueOf(). Obtener un elemento del enumerado a partir de su nombre
        Lenguajes lenguajeJava = Lenguajes.valueOf("JAVA");
        System.out.println("El año de publicación de " +
                // lenguajeJava.toString(). Es equivalente, es el método llamado por defecto
                lenguajeJava +  " fue: " + lenguajeJava.getYear());
        
        // uso simple
        // enumerado en clase externa
        Lenguajes miLenguaje = Lenguajes.HASKELL;
        System.out.println("\nMi lenguaje es: " + miLenguaje + "\n");
        
        // listar valores enumerado
        System.out.println("Los diferentes lenguajes son:\n");
        for(Lenguajes e : Lenguajes.values()) {
            System.out.println(e + " [" + e.getParadigm() + "]["
                    + e.getYear() + "]\n");
        }
        
        // ordenar datos enumerado y listar
        System.out.println("\nLos diferentes lenguajes ordenados" +
                                        " por año de aparición son:\n");
        Lenguajes[] aux = Lenguajes.values();
        
        // se ordena la lista original
        Lenguajes leng;
        
        // ordenación por intercambio de posiciones
        // *elementoBucleExterno _elementoBucleInterno
        // *2 _3 8 5 -> *2 3 _8 5 -> *2 3 8 _5
        // 2 *3 _8 5 -> 2 *3 8 _5
        // 2 3 *8 _5 -> 2 3 _5 *8 (se produce un intercambio)
        // fin del algoritmo, no hay más elementos por recorrer en ninguno de los bucles
        for(int i = 0; i < aux.length-1; i++) {
            for(int j = i+1; j < aux.length; j++) {
                if(aux[i].getYear() > aux[j].getYear()) {
                    leng = aux[i];
                    aux[i] = aux[j];
                    aux[j] = leng;
                }
            }
        }
        
        // se listan todos los valores ordenados
        for(Lenguajes e : aux) {
            System.out.println(e + " (" + e.getYear() + ") \n");
        }
        
        System.out.println("\n ******************************* \n");
        
        // ejemplo de bebidas
        BebidaCerveza birra = new BebidaCerveza(BebidaCerveza.MarcaCerveza.AMBAR, Vaso.JARRA);
        birra.servir();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
}

// enumerado anexo y externo a la propia clase principal
// enumerado simple
enum Nacionalidades { SPANISH, ENGLISH, IRISH, TURKISH, JAPANESE }

// clase auxiliar para desarrollar otro ejemplo con cervezas
// esta clase solo es accesible desde las clases del propio fichero .java
class BebidaCerveza {
    // tipos enumerados sencillos. Solo tenemos estas marcas
    enum MarcaCerveza { AMBAR, GUINNESS, HEINEKEN }

    // campos de clase constantes, cada uno de un tipo Enum diferente
    private final EjemplosEnum.Vaso vaso;
    private final MarcaCerveza marca;

    // constructor de la clase, al que se le pasa una marca y un vaso (capacidad)
    BebidaCerveza(MarcaCerveza marca, EjemplosEnum.Vaso vaso) {
        this.marca = marca;
        this.vaso = vaso;
    }

    // método que simula servir una bebida de determinada marca y capacidad
    public void servir() {
        System.out.println("Sirviendo " + vaso.getCentimetrosCubicos()
                + "cc. de cerveza " + marca);
    }
}