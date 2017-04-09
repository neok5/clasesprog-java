package clasesprog.Interfaces.Comparadores;

public class FechaComparable implements Comparable<FechaComparable> {
    private int day, month, year;
    private String nombre;
    
    public FechaComparable(int day, int month, int year, String nombre) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.nombre = nombre;
    }

    @Override
    public int compareTo(FechaComparable fechaComparable) {
        // variable resultado, para tener 1 sola sentencia return, al final
        // se inicializa al resultado por defecto (0)
        int resultado = 0;
        // si el año es menor, el elemento this es menor
        if(this.year < fechaComparable.getYear())
            resultado = -1;
        // si el año es mayor, el this es mayor que el parámetro
        else if(this.year > fechaComparable.getYear())
            resultado = 1;
        // si los años son iguales, se pasa a comparar los meses y años
        else {
            if (this.month < fechaComparable.getMonth()) {
                resultado = -1;
            } else if (this.month > fechaComparable.getMonth()) {
                resultado = 1;
            } else { // los años y meses son iguales, se pasa a comparar días
                if (this.day < fechaComparable.getDay()) {
                    resultado = -1;
                } else if (this.day > fechaComparable.getDay()) {
                    resultado = 1;
                }
            }
        }
        // si son iguales en año, mes y día, son iguales en todo, devuelve 0
        return resultado;
    }
    
    // devuelve true si this es menor que fe
    public boolean isLess(FechaComparable fe) {
        return this.compareTo(fe) < 0;
    }
    
    // devuelve true si this es igual que fe
    public boolean isEqual(FechaComparable fe) {
        return this.compareTo(fe) == 0;
    }
    
    // devuelve true si this es mayor que fe
    public boolean isGreater(FechaComparable fe) {
        return this.compareTo(fe) > 0;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}