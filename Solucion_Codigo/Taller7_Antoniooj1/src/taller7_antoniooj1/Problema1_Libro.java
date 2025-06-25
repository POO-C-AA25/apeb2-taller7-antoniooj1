
package taller7_antoniooj1;
/**
 * Dibujad un diagrama de clases que muestre la estructura de un capítulo de libro;
 * un capítulo está compuesto por varias secciones, cada una de las cuales comprende
 * varios párrafos y figuras. Un párrafo incluye varias sentencias, cada una de las 
 * cuales contiene varias palabras.

 * @author Antonio Ojeda
 */
public class Problema1_Libro {
    public static void main(String[] args) {
        Palabra palabra = new Palabra(3, "Wow");
        Sentencia sent = new Sentencia(1, palabra);
        Figura fig1 = new Figura();
        Parrafo parr1 = new Parrafo(1,sent,palabra);
        ComponenteSeccion compSec1 = new ComponenteSeccion();
        Seccion sec1 = new Seccion(compSec1);

        CapituloLibro cap1 = new CapituloLibro("1944", 10, sec1);
        System.out.println(cap1);
    }
}


class CapituloLibro {
    public String nombreCap;
    public int numPags;
    public Seccion seccion;
    public CapituloLibro(String nombreCap, int numPags, Seccion seccion) {
        this.nombreCap = nombreCap;
        this.numPags = numPags;
        this.seccion = seccion;
    }
    @Override
    public String toString() {
        return "CapituloLibro{" + "nombreCap=" + nombreCap + ", numPags=" + numPags + ", seccion=" + seccion + '}'; 
    }
}


class Seccion {
    public ComponenteSeccion compSecc;
    public Seccion(ComponenteSeccion compSecc) {
        this.compSecc = compSecc;
    }
    @Override
    public String toString() {
        return "Seccion{" + "compSecc=" + compSecc + '}';
    }
}


class ComponenteSeccion {}


class Figura extends ComponenteSeccion {}


class Parrafo extends ComponenteSeccion {
    public int numParrafos;
    public Sentencia sentencia;
    public Palabra palabra;
    public Parrafo(int numParrafos, Sentencia sentencia, Palabra palabra) {
        this.numParrafos = numParrafos;
        this.sentencia = sentencia;
        this.palabra = palabra;
    }  
    @Override
    public String toString() {
        return "Parrafo{" + "numParrafos=" + numParrafos + ", sentencia=" + sentencia + ", palabra=" + palabra + '}';
    }
}
class Sentencia {
    public int numPalabras;
    public Palabra palabra;
    public Sentencia(int numPalabras, Palabra palabra) {
        this.numPalabras = numPalabras;
        this.palabra = palabra;
    }
    @Override
    public String toString() {
        return "Sentencia{" + "numPalabras=" + numPalabras + '}';
    }
}
class Palabra {
    public int numLetras;
    public String palabra;
    public Palabra(int numLetras, String palabra) {
        this.numLetras = numLetras;
        this.palabra = palabra;
    }
    @Override
    public String toString() {
        return "Palabra{" + "numLetras=" + numLetras + ", palabra=" + palabra + '}';
    }
}