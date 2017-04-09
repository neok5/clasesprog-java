package clasesprog.Enumerados;

// enumerado que contiene diferentes lenguajes de programación
// cada uno con su (paradigma, año)
public enum Lenguajes {
    JAVA("OO", 1995),
    CPP("OO", 1983),
    PROLOG("DECLARATIVO", 1971),
    HASKELL("FUNCIONAL", 1990),
    C("IMPERATIVO", 1972),
    PASCAL("IMPERATIVO", 1970);
    
    // campos propios del enumerado
    private final String paradigma;
    private final int year;
    
    // no se declara como público porque no se debe crear
    // nuevos objetos directamente utilizando new(), de forma dinámica
    // la asignación correcta de variables de tipo Enum es de forma estática:
    // Lenguajes leng = Lenguajes.JAVA; por ejemplo
    Lenguajes(String paradigma, int year) {
        this.paradigma = paradigma;
        this.year = year;
    }

    // métodos de acceso a los campos
    // no tiene métodos set (setters) puesto que
    // los campos son constantes (palabra clave "final")
    // de hecho, un Enumerado no es más que una variable que representa
    // un conjunto de constantes (con campos y métodos internos opcionales)
    public String getParadigm() {
        return paradigma;
    }

    public int getYear() {
        return year;
    }
}