package clasesprog.Interfaces.Comparadores;

public class Fecha {
    private int day, month, year;
    private String nombre;
    
    public Fecha(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.nombre = "";
    }
    
    public Fecha(int day, int month, int year, String nombre) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.nombre = nombre;
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