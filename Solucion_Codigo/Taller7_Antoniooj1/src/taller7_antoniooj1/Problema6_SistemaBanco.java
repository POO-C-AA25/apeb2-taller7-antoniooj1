package taller7_antoniooj1;

public class Problema6_SistemaBanco {

    public static void main(String[] args) { 
        CuentaCheques cuentaCheques = new CuentaCheques("999", "Pepe");
        CuentaAhorros cuentaAhorros = new CuentaAhorros("888", "Pedro", 5);
        CuentaPlatino cuentaPlatino = new CuentaPlatino("777", "Jose");

        cuentaCheques.depositar(1000);
        cuentaCheques.retirar(500);
        System.out.println("Cuenta Cheques: "+cuentaCheques.toString());
        
        cuentaAhorros.depositar(2000);
        cuentaAhorros.calcularInteres();
        cuentaAhorros.retirar(500);
        System.out.println("Cuenta Ahorros: "+cuentaAhorros.toString());
        

        cuentaPlatino.depositar(3000);
        cuentaPlatino.calcularInteres();
        cuentaPlatino.retirar(500);
        System.out.println("Cuenta Platino: "+cuentaPlatino.toString());
        
    }
}

class CuentaBancaria { 

    public String numeroCuenta;
    public String nombreCliente;
    public double balance;

    public CuentaBancaria(String numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = 0.0;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            balance += cantidad;
        }
    }
    public void retirar(double cantidad) {
        if (cantidad > 0) {
            balance -= cantidad;
        }
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + "numeroCuenta=" + numeroCuenta + ", nombreCliente=" + nombreCliente + ", balance=" + balance + '}';
    }

}

class CuentaCheques extends CuentaBancaria {

    public CuentaCheques(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

 

}

class CuentaAhorros extends CuentaBancaria {

    public double interes;

    public CuentaAhorros(String numeroCuenta, String nombreCliente, double tasaInteres) {
        super(numeroCuenta, nombreCliente);
        this.interes = tasaInteres;
    }

    public void calcularInteres() {
        balance += balance * interes / 100;
    }

   @Override       
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= balance) {
            balance -= cantidad;
        }
    }
}

class CuentaPlatino extends CuentaBancaria {

    public double interes = 10.0;

    public CuentaPlatino(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    public void calcularInteres() {
        balance += balance * interes / 100;
    }

  

}
