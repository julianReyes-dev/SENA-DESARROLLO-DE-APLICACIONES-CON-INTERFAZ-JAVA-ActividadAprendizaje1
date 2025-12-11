package model;

import java.time.LocalDate;
import java.time.Period;

public class Empleado extends Persona {

    private static final int MAX_VACATIONS = 20;
    private boolean salaryReceived;
    private LocalDate hiringDate;
    private PuestoBanco position;

    public Empleado(String id, String nombre, LocalDate hiringDate, PuestoBanco position) {
        super(id, nombre);
        this.hiringDate = hiringDate;
        this.position = position;
    }

    public static int getMaxVacations() { 
        return MAX_VACATIONS; 
    }

    public boolean consignarSalary() {
        if (salaryReceived) {
            salaryReceived = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean retirarSalary() {
        if (!salaryReceived) {
            return salaryReceived = true;
        } else {
            return false;
        }
    }

    public int calculateYearsWorking() {
        Period period = Period.between(hiringDate, LocalDate.now());
        return period.getYears();
    }

    public int calculateVacationDays() {
        int yearsWorking = calculateYearsWorking();
        if (yearsWorking < 1) {
            return 5;
        } else {
            return yearsWorking > 7? getMaxVacations() : 5 + (yearsWorking * 2);
        }
    }

    public double getSalary() {
        return position.getSalarioBase();
    }

    public boolean isSalaryReceived() {
        return salaryReceived;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public String getPosition() {
        return position.getDescripcion();
    }

    @Override
    public String toString() {
        return "Empleado [id=" + id + ", nombre=" + nombre + ", salaryReceived=" + salaryReceived + ", hiringDate="
                + hiringDate + ", position=" + position + "]";
    }
}
