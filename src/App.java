import model.*;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        
        System.out.println("DEMOSTRACIÓN DE POO EN EL BANCO");
        // 1. DEMOSTRACIÓN DE HERENCIA Y ENUMS (Jerarquía Persona/Empleado)
        System.out.println("\n1. HERENCIA Y ENUMS (EMPLEADOS)");
        // Crear un empleado utilizando el ENUM para definir su puesto y salario
        // Empleado hereda de Persona.
        Empleado supervisor = new Empleado("E101", "Ana Garcia", LocalDate.of(2020, 1, 1) ,PuestoBanco.SUPERVISOR);
        Empleado cajero = new Empleado("E102", "Beto Cruz", LocalDate.of(2025, 11, 25), PuestoBanco.CAJERO); // 0 años de antigüedad

        System.out.println("Empleado creado: " + supervisor.getNombre() + 
                           " (" + supervisor.getPosition() + ")");
        
        // Uso de lógica de la clase Empleado:
        System.out.println("Salario de " + supervisor.getNombre() + ": $" + supervisor.getSalary());
        System.out.println("Años trabajando: " + supervisor.calculateYearsWorking() + " años.");
        System.out.println("Días de vacaciones calculados: " + supervisor.calculateVacationDays() + " días.");
        
        System.out.println("Vacaciones de " + cajero.getNombre() + ": " + cajero.calculateVacationDays() + " días.");
        
        // Uso de miembro de clase (static)
        System.out.println("Máximo de días de vacaciones posible: " + Empleado.getMaxVacations());

        // 2. DEMOSTRACIÓN DE ABSTRACCIÓN Y POLIMORFISMO (Jerarquía Cuenta)
        
        System.out.println("\n2. ABSTRACCIÓN Y POLIMORFISMO (CUENTAS)");

        // Declaramos la referencia usando la clase abstracta (Polimorfismo / Abstracción)
        Cuenta cuentaAhorro;
        Cuenta cuentaInversion;

        // Inicializamos las referencias con las clases CONCRETAS (Polimorfismo)
        cuentaAhorro = new CuentaAhorro("A-456", "pass", 0.04);
        cuentaInversion = new CuentaInversion("I-789", "pass",0.1);

        // Uso de Abstracción: Almacenamos ambas cuentas en un arreglo de la clase abstracta
        Cuenta[] cuentasDelBanco = {cuentaAhorro, cuentaInversion};


        // --- Pruebas de Polimorfismo ---
        
        System.out.println("\n2.1. Pruebas de Cuentas");
        
        // Depósito en Cuenta Ahorro (Primer Depósito, debe ser $1000)
        System.out.println("Ahorro [A-456] Saldo inicial: $" + cuentaAhorro.getSaldo());
        System.out.println("-> Intento de depósito $500: " + cuentaAhorro.depositar(500.0));
        System.out.println("-> Intento de depósito $1000: " + cuentaAhorro.depositar(1000.0));
        System.out.println("Ahorro [A-456] Saldo actual: $" + cuentaAhorro.getSaldo()); // Debería ser $1000

        // Retiro en Cuenta Ahorro (Regla: no puede bajar de $500)
        System.out.println("-> Intento de retiro $600: " + cuentaAhorro.retirar(600.0));
        System.out.println("Ahorro [A-456] Saldo actual: $" + cuentaAhorro.getSaldo()); // Debería ser $400 (FALLO, SALDO MINIMO)
        // Corrección: El retiro de $600 deja $400. La lógica del retiro en CuentaAhorro debe ser revisada para evitar el error.
        System.out.println("-> Intento de retiro $200: " + cuentaAhorro.retirar(200.0));
        System.out.println("Ahorro [A-456] Saldo actual: $" + cuentaAhorro.getSaldo()); // Debería ser $800

        // Retiro en Cuenta Inversión (Regla: no puede bajar de $10,000)
        System.out.println("\nInversión [I-789] Saldo inicial: $" + cuentaInversion.getSaldo());
        System.out.println("-> Intento de depósito $20000: " + cuentaInversion.depositar(20000.0));
        System.out.println("-> Intento de depósito $25000: " + cuentaInversion.depositar(25000.0));
        System.out.println("-> Intento de retiro $16000: " + cuentaInversion.retirar(16000.0)); // Deja $9000 (debe fallar)
        System.out.println("-> Intento de retiro $10000: " + cuentaInversion.retirar(10000.0)); // Deja $15000
        System.out.println("Inversión [I-789] Saldo actual: $" + cuentaInversion.getSaldo()); // Debería ser $15,000


        // --- Cálculo Polimórfico de Intereses ---
        
        System.out.println("\n2.2. Cálculo Polimórfico");
        
        // Iteramos sobre el arreglo de cuentas (tipo abstracto) y llamamos al método.
        // El método correcto (de Ahorro o Inversión) se invoca automáticamente.
        for (Cuenta c : cuentasDelBanco) {
            double intereses = c.calcularInteresesMensuales(); // ¡Polimorfismo!
            System.out.println("Cuenta " + c.getAccountNumber() + " (" + 
                               c.getClass().getSimpleName() + 
                               "): Intereses calculados: $" + String.format("%.2f", intereses));
            System.out.println("Nuevo Saldo: $" + String.format("%.2f", c.getSaldo()));
        }
        
        // Uso de miembro de clase (static)
        System.out.println("\nTotal de objetos Cuenta creados: " + Cuenta.getNumCuentas());
    }
}