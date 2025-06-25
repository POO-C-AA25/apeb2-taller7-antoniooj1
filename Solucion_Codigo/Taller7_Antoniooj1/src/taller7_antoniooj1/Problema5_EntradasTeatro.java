package taller7_antoniooj1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
 Dadas las siguientes clases, que expresan una relación de herencia entre las entidades:

Se desea gestionar la venta de entradas para un espectáculo en un teatro. El patio de butacas del 
* teatro se divide en varias zonas, cada una identificada por su nombre. Los datos de las zonas son
* los mostrados en la siguiente tabla:

NOMBRE ZONA	NÚMERO DE LOCALIDADES	PRECIO NORMA	PRECIO ABONADO
Principal	200	25$	17.5$
PalcoB	40	70$	40$
Central	400	20$	14$
Lateral	100	15.5$	10$
Para realizar la compra de una entrada, un espectador debe indicar la zona que desea y presentar 
* al vendedor el documento que justifique que tiene algún tipo de descuento (estudiante, abonado
* o pensionista). El vendedor sacará la entrada del tipo apropiado y de la zona indicada, en el 
* momento de la compra se asignará a la entrada un identificador (un número entero) que permitirá
* la identificación de la entrada en todas las operaciones que posteriormente se desee realizar con ella.

Una entrada tiene como datos asociados su identificador, la zona a la que pertenece y el nombre del comprador.

Los precios de las entradas dependen de la zona y del tipo de entrada según lo explicado a continuación:

Entradas normales: su precio es el precio normal de la zona elegida sin ningún tipo de descuento.
Entradas reducidas (para estudiantes o pensionistas): su precio tiene una rebaja del 15% sobre el precio normal de la zona elegida.
Entradas abonado: su precio es el precio para abonados de la zona elegida.
La interacción entre el vendedor y la aplicación es la descrita en los siguientes casos de usos.

Note

Caso de uso “Vende entrada”:

El vendedor elige la opción “vende entrada” e introduce la zona deseada, el nombre del espectador y el
* tipo (normal, abonado o beneficiario de entrada reducida).
Si la zona elegida no está completa, la aplicación genera una nueva entrada con los datos facilitados.
Si no existe ninguna zona con ese nombre, se notifica y finaliza el caso de uso sin generar la entrada.
Si la zona elegida está completa lo notifica y finaliza el caso de uno sin generar la entrada.
La aplicación muestra el identificador y el precio de la entrada.
Caso de uso “Consulta entrada”:

El vendedor elige la opción “consulta entrada” e introduce el identificador de la entrada.
La aplicación muestra los datos de la entrada: nombre del espectador, precio y nombre de la zona.
* Si no existe ninguna entrada con ese identificador, lo notifica y finaliza el caso de uso

 * @author Antonio Ojeda
 */
public class Problema5_EntradasTeatro {

    public static void main(String[] args) {
        ArrayList<Zona> listaZonas = new ArrayList<>();
        Zona principal = new Zona( 25, 17.5,"Principal", 200);
        listaZonas.add(principal);
        Zona palco = new Zona( 70, 40,"Palco", 40);
        listaZonas.add(palco);
        Zona central = new Zona( 20, 14,"Central", 400);
        listaZonas.add(central);
        Zona lateral = new Zona( 15.5, 10,"Lateral", 100);
        listaZonas.add(lateral);

        int sigue = 0, precio = 0, id = 0;                                 
        Scanner put = new Scanner(System.in);
        ArrayList<Entrada> compradas = new ArrayList<>();
        while (sigue == 0) {
            System.out.println("\n\nELIJA SU ACCION");
            System.out.println("[1]Vender entrada");
            System.out.println("[2]Buscar info por id");
            System.out.println("[3]Terminar ejecucion");
            int accion = put.nextInt();
            switch (accion) {
                case 1:
                    System.out.println("ELIJA LA ZONA");
                    System.out.println("[1]Principal");
                    System.out.println("[2]Palco");
                    System.out.println("[3]Central");
                    System.out.println("[4]Lateral");
                    int zona = put.nextInt();
                    switch (zona) {
                        case 1:
                            if (principal.validarCapacidad()) {
                                System.out.println("Ingrese el nombre: ");
                                String nombreEspectador = put.next();

                                System.out.println("INGRESA EL PRECIO");
                                System.out.println("[1]Normal");
                                System.out.println("[2]Abonado");
                                System.out.println("[3]Reducido");
                                precio = put.nextInt();

                                switch (precio) {
                                    case 1:
                                        Normal entrada = new Normal(principal, nombreEspectador);
                                        principal.restarCapacidad();
                                        entrada.calcularPrecioEntrada();
                                        entrada.generarID();
                                        compradas.add(entrada);
                                        System.out.println(entrada);
                                        break;
                                    case 2:
                                        Abonada entrada1 = new Abonada(principal, nombreEspectador);
                                        principal.restarCapacidad();
                                        entrada1.calcularPrecioEntrada();
                                        entrada1.generarID();
                                        compradas.add(entrada1);
                                        System.out.println(entrada1);
                                        break;
                                    case 3:
                                        Reducid entrada2 = new Reducid(principal, nombreEspectador);
                                        principal.restarCapacidad();
                                        entrada2.calcularPrecioEntrada();
                                        entrada2.generarID();
                                        compradas.add(entrada2);
                                        System.out.println(entrada2);
                                        break;

                                }
                            } else {
                                System.out.println("Cupos Agotados");
                            }
                            break;
                        case 2:
                            if (palco.validarCapacidad()) {
                                System.out.println("Ingrese el nombre: ");
                                String nombreEspectador = put.next();

                                System.out.println("INGRESA EL PRECIO");
                                System.out.println("[1]Normal");
                                System.out.println("[2]Abonado");
                                System.out.println("[3]Reducido");
                                precio = put.nextInt();

                                switch (precio) {
                                    case 1:
                                        Normal entrada = new Normal(palco, nombreEspectador);
                                        principal.restarCapacidad();
                                        entrada.calcularPrecioEntrada();
                                        entrada.generarID();
                                        compradas.add(entrada);
                                        System.out.println(entrada);
                                        break;
                                    case 2:
                                        Abonada entrada1 = new Abonada(palco, nombreEspectador);
                                        principal.restarCapacidad();
                                        entrada1.calcularPrecioEntrada();
                                        entrada1.generarID();
                                        compradas.add(entrada1);
                                        System.out.println(entrada1);
                                        break;
                                    case 3:
                                        Reducid entrada2 = new Reducid(palco, nombreEspectador);
                                        principal.restarCapacidad();
                                        entrada2.calcularPrecioEntrada();
                                        entrada2.generarID();
                                        compradas.add(entrada2);
                                        System.out.println(entrada2);
                                        break;
                                }
                            } else {
                                System.out.println("Cupos agotados");
                            }
                            break;
                        case 3:
                            if (central.validarCapacidad()) {
                                System.out.println("Ingrese el nombre: ");
                                String nombreEspectador = put.next();

                                System.out.println("INGRESA EL PRECIO");
                                System.out.println("[1]Normal");
                                System.out.println("[2]Abonado");
                                System.out.println("[3]Reducido");
                                precio = put.nextInt();

                                switch (precio) {
                                    case 1:
                                        Normal entrada = new Normal(central, nombreEspectador);
                                        principal.restarCapacidad();
                                        entrada.calcularPrecioEntrada();
                                        entrada.generarID();
                                        compradas.add(entrada);
                                        System.out.println(entrada);
                                        break;
                                    case 2:
                                        Abonada entrada1 = new Abonada(central, nombreEspectador);
                                        principal.restarCapacidad();
                                        entrada1.calcularPrecioEntrada();
                                        entrada1.generarID();
                                        compradas.add(entrada1);
                                        System.out.println(entrada1);
                                        break;
                                    case 3:
                                        Reducid entrada2 = new Reducid(central, nombreEspectador);
                                        principal.restarCapacidad();
                                        entrada2.calcularPrecioEntrada();
                                        entrada2.generarID();
                                        compradas.add(entrada2);
                                        System.out.println(entrada2);
                                        break;
                                }
                            } else {
                                System.out.println("Cupos agotados");
                            }
                            break;
                        case 4:
                            if (lateral.validarCapacidad()) {
                                System.out.println("Ingrese el nombre: ");
                                String nombreEspectador = put.next();

                                System.out.println("INGRESA EL PRECIO");
                                System.out.println("[1]Normal");
                                System.out.println("[2]Abonado");
                                System.out.println("[3]Reducido");
                                precio = put.nextInt();

                                switch (precio) {
                                    case 1:
                                        Normal entrada = new Normal(lateral, nombreEspectador);
                                        principal.restarCapacidad();
                                        entrada.calcularPrecioEntrada();
                                        entrada.generarID();
                                        compradas.add(entrada);
                                        System.out.println(entrada);
                                        break;
                                    case 2:
                                        Abonada entrada1 = new Abonada(lateral, nombreEspectador);
                                        principal.restarCapacidad();
                                        entrada1.calcularPrecioEntrada();
                                        entrada1.generarID();
                                        compradas.add(entrada1);
                                        System.out.println(entrada1);
                                        break;
                                    case 3:
                                        Reducid entrada2 = new Reducid(lateral, nombreEspectador);
                                        principal.restarCapacidad();
                                        entrada2.calcularPrecioEntrada();
                                        entrada2.generarID();
                                        compradas.add(entrada2);
                                        System.out.println(entrada2);
                                        break;
                                }
                            } else {
                                System.out.println("Cupos Agotados");
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el id a consultar");
                    id = put.nextInt();
                    for (int i = 0; i < compradas.size(); i++) {
                        if (compradas.get(i).id == id) {
                            System.out.println("\n\nNombre: " + compradas.get(i).nombre);
                            System.out.println("Precio: " + compradas.get(i).precio);
                            System.out.println("Zona: " + compradas.get(i).zona.nombre+"\n\n");
                        }
                    }
                    break;
                case 3:
                    sigue = 1;
                    break;
            }
        }
    }
}
class Zona {
    public double precioNormal;
    public double precioAbonado;
    public String nombre;
    public int capacidad;

    public Zona(double precioNormal, double precioAbonado,String nombre, int capacidad) {
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }
    public boolean validarCapacidad() {
        if (this.capacidad > 0) {
            return true;
        }
        return false;
    }

    public void restarCapacidad() {
        this.capacidad -= 1;
    }

}

class Entrada {
    public Zona zona;
    public int id;
    public String nombre;
    public double precio;

    public Entrada(Zona zona, String nombre) {
        this.zona = zona;
        this.nombre = nombre;
    }
    public double calcularPrecioEntrada() {
        this.precio = this.zona.precioNormal;
        return precio;
    }
    public void generarID() {
        Random random = new Random();
        int numeroAleatorio = 10000 + random.nextInt(90000);
        this.id = numeroAleatorio;
    }
    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", precio=" + precio + '}';
    }

}
class Normal extends Entrada {
    public Normal(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
    }
}
class Reducid extends Entrada {
    public Reducid(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
    }
    @Override
    public double calcularPrecioEntrada() {
        this.precio = super.calcularPrecioEntrada() * 0.85;
        return precio;
    }
}
class Abonada extends Entrada {
    public Abonada(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
    }
    @Override
    public double calcularPrecioEntrada() {
        this.precio = this.zona.precioAbonado;
        return precio;
    }
}
