package model;

public abstract class Cuenta {

    protected static int contadorCuentas = 0;
    protected String accountNumber;
    protected String pass;
    protected double saldo;

    public Cuenta(String accountNumber, String pass) {
        this.accountNumber = accountNumber;
        this.pass = pass;
        this.saldo = 0;
        contadorCuentas++;
    }

    public static double getNumCuentas() { 
        return contadorCuentas; 
    }

    public abstract boolean depositar(double cantidad);
    public abstract boolean retirar(double cantidad);
    public abstract double calcularInteresesMensuales();

    public boolean verifyPass(String pass) {
        return this.pass.equals(pass);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Cuenta [numUser=" + ", accountNumber=" + accountNumber + ", money=" + saldo + "]";
    }
}
