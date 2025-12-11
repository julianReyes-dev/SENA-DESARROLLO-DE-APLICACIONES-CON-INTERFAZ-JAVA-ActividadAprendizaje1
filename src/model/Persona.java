package model;

public abstract class Persona {

    protected static int totalPersonasCreadas = 0;
    protected String id;
    protected String nombre;
    private Cuenta cuenta;

    public Persona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        totalPersonasCreadas++;
    }

    public static int getTotalPersonasCreadas() {
        return totalPersonasCreadas;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", cuenta=" + cuenta + "]";
    }
}
