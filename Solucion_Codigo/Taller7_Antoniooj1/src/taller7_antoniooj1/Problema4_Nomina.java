package taller7_antoniooj1;
import java.util.ArrayList;

public class Problema4_Nomina {
    public static void main(String[] args) {
        ArrayList<Trabajador> listaEmpleados = new ArrayList<>();
        Nomina nomina = new Nomina(listaEmpleados);
        Jefe trab1 = new Jefe("Pepe", "Papas", 
                        "av Quito", "123");
        Jefe trab2 = new Jefe("Juan", "Nito", 
                        "av Loja", "456");
        Jefe trab3 = new Jefe("Pedro", "Yepez", 
                        "av Conca", "789");
        listaEmpleados.add(trab1);
        listaEmpleados.add(trab2);
        listaEmpleados.add(trab3);
        FijoMensual fm1 = new FijoMensual(trab1, "Jose", "Lopez", 
                                            "clle Zamora", "987");
        listaEmpleados.add(fm1);
        Comisionista com1 = new Comisionista(trab2, 5, "Espinosa", "Ramos", 
                                                    "barrio Ventilar", "321");
        listaEmpleados.add(com1);
        PorHoras ph1 = new PorHoras(trab3, 45, "Zota", "Zeto", 
                                                    "conjunto Rosales", "951");
        listaEmpleados.add(ph1);
        
        for(Trabajador trab : nomina.listaEmpleados){
            trab.calcularSueldo();
        }
        
        nomina.CalcularHoras();
        nomina.CalcularVentas();
        System.out.println(nomina.dibujarnomina());
        nomina.despedir("456");
        System.out.println("\n\n========================!!!!!!!! DNI: 456 - ESTAS DESPEDIDO!!!!!!!!========================\n\n");
        System.out.println(nomina.dibujarnomina());
    }
}
class Nomina{
    public ArrayList<Trabajador> listaEmpleados;
    public int horas;
    public int ventas;

    public Nomina(ArrayList<Trabajador> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    public void despedir(String DNI){
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if(listaEmpleados.get(i).dni.equalsIgnoreCase(DNI)){
                listaEmpleados.remove(i);
            }
        }
    }
    public void CalcularHoras(){
        for(Trabajador trabajador : listaEmpleados){
            if(trabajador instanceof PorHoras){
                this.horas += ((PorHoras) trabajador).horas;
            }
        }
    }
    
    public void CalcularVentas(){
        for(Trabajador trabajador : listaEmpleados){
            if(trabajador instanceof Comisionista){
                this.ventas += ((Comisionista) trabajador).ventas;
            }
        }
    }

    public String dibujarnomina(){
        String nomina="";
        for(Trabajador trabajador : listaEmpleados){
            nomina+=trabajador+"\n";
        }
        nomina+= "\n\nSe trabajaron: "+horas+"      -      Se hicieron "+ventas+" ventas";
        return nomina;
    }
}
class Trabajador{
    public String nombre;
    public String apellido;
    public String direccion;
    public String dni;
    public double sueldo;
    public Trabajador(String nombre, String apellido, String direccion, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
    } 
    public void calcularSueldo(){}
    
    @Override
    public String toString() {
        return "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", DNI=" + dni + ", sueldo=" + sueldo;
    }
}


class FijoMensual extends Trabajador{
    public Jefe jefe;
    public FijoMensual(Jefe jefe, String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.jefe = jefe;
    }
    @Override
    public void calcularSueldo(){
        this.sueldo = 350; 
    }
    @Override
    public String toString() {
        return super.toString() + " jefe=" + jefe.nombre;
    }
}
class Comisionista extends Trabajador{
    public Jefe jefe;
    public int ventas;
    public Comisionista(Jefe jefe, int ventasRealizadas, String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.jefe = jefe;
        this.ventas = ventasRealizadas;
    }

    @Override
    public void calcularSueldo(){
        this.sueldo = (this.ventas*100)*0.15;
    }

    @Override
    public String toString() {
        return super.toString() + " jefe=" + jefe.nombre + ", ventasRealiadas=" + ventas;
    }
}

class PorHoras extends Trabajador{
    public Jefe jefe;
    public int horas;
    public PorHoras(Jefe jefe, int horasTrabajadas, String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.jefe = jefe;
        this.horas = horasTrabajadas;
    }
    @Override
    public void calcularSueldo(){
        this.sueldo = this.horas*7;
        if(this.horas > 40){
            this.sueldo = (40*7)+(this.horas-40)*14;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " jefe=" + jefe.nombre + ", horasTrabajadas=" + horas;
    }
}

class Jefe extends Trabajador{
    public Jefe(String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
    }
    @Override
    public void calcularSueldo(){
        this.sueldo = 10000; 
    }
}