package model;

public class CuentaAhorro extends Cuenta {

    private double porcentajeAhorroAnual;
    public static final double MINIMUM_BALANCE = 500;
    private boolean primerDepositoRealizado;

    public CuentaAhorro(String accountNumber, String pass, double porcentajeAhorroAnual) {
        super(accountNumber, pass);
        this.porcentajeAhorroAnual = porcentajeAhorroAnual;
        primerDepositoRealizado = false;    
    }

    @Override
    public boolean depositar(double cantidad) {
        if (cantidad <= 0) return false;
        if (!primerDepositoRealizado) {
            if (cantidad == 1000) { 
                saldo += cantidad;
                primerDepositoRealizado = true;
                return true;
            } else {
                System.out.println("Error: El primer depósito debe ser exactamente $1,000.");
                return false;
            }
        } else {
            saldo += cantidad;
            return true;
        }
    }

    @Override
    public boolean retirar(double cantidad) {
        if (cantidad <= 0) {return false;}
        if (cantidad + MINIMUM_BALANCE <= saldo) {
            saldo -= cantidad;
            return true;
        } else {
            System.out.println("Error: El retiro excede el saldo permitido. Saldo mínimo requerido: $" + MINIMUM_BALANCE);
            return false;
        }
    }

    @Override
    public double calcularInteresesMensuales() {
        // Interés Mensual = Saldo * (Porcentaje Anual / 12)
        double interes = saldo * (porcentajeAhorroAnual / 12.0);
        saldo += interes; // Incrementa el saldo
        return interes;
    }

    public boolean cancelarCuenta(String confirmacion) {
        if (confirmacion.equalsIgnoreCase("CANCELAR")) {
            // Retira todo el saldo
            double saldoTotal = this.saldo;
            this.saldo = 0.0;
            System.out.println("Cuenta " + accountNumber + " cancelada. Se retiraron $" + saldoTotal);
            return true;
        }
        return false;
    }

}
