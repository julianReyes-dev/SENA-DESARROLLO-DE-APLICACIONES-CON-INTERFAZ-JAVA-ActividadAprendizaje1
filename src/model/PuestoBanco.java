package model;

public enum PuestoBanco {
    CAJERO("Cajero", 1500000.00), 
    SUPERVISOR("Supervisor", 3500000.00),
    RECEPCIONISTA("Recepcionista", 1800000.00);

    private final String descripcion;
    private final double salarioBase;

    PuestoBanco(String descripcion, double salarioBase) {
        this.descripcion = descripcion;
        this.salarioBase = salarioBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}