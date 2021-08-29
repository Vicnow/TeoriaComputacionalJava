package logica;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Un lenguaje es un conjunto de palabras=cadenas
 * @author Saul de la O Torres
 * @author Victot Hugo Morales Martinez (2020630218)
 */
public class Lenguaje {
    private LinkedList<Cadena> cadenas;
    public Lenguaje() {
        cadenas = new LinkedList<>();
    }
    public void insertarPalabra(Cadena cadena) {
        boolean insertada = false;
        Iterator<Cadena> iterador = cadenas.iterator();
        while(iterador.hasNext()) {
            Cadena laCadena = iterador.next();
            if(laCadena.equals(cadena)) {
                insertada = true;
                break;
                }
            }
        if(insertada==false) {
            cadenas.add(cadena);
            }
    }
    public boolean estarVacio() {
        return cadenas.size()==0;
    }

    /**
     * Muestra el tamaño del lenguaje
     * @author Víctor Hugo Morales Martínez 2020630281 (Vicnow)
     * @return Tamaño de del lenguaje
     */
    public int size(){
        int size= this.cadenas.size();
        return size;
    }
    /**
     * Devuelbe un booleano dependiendo si el lenguaje esta vacio o no.
     * @author Víctor Hugo Morales Martínez 2020630281 (Vicnow)
     * @return true si el lenguaje esta vacio - false si el lenguaje no esta vacio
     */
    public boolean isEmpty(){
        if(cadenas.size()==0){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Obtener todas las cadenas de un lenguaje
     * @author Víctor Hugo Morales Martínez 2020630281 (Vicnow)
     * @return Todas las cadenas del lenguaje, null si esta vacio
     */
    public Cadena [] cadenasDeLenguaje(){
        int lenguajeSize = this.size();
        if (this.isEmpty()) {       
            // Cadena [] cadenas = new Cadena[0];
            // cadenas[0] = new Cadena("E");
            Cadena [] cadenas = null;
            return cadenas;
        }
        Cadena [] cadenas = new Cadena[lenguajeSize];
        for (int i = 0; i < lenguajeSize; i++) {
            cadenas[i] = this.cadenas.get(i);
        }
        return cadenas;
    }
    /**
     * Obtener todas las cadenas de un lenguaje en un string
     * @author Víctor Hugo Morales Martínez 2020630281 (Vicnow)
     * @return String con todas las cadenas del lenguaje con el formato = [cadena,cadena,cadena]
     */
    public String mostrarCadenasDelLenguaje (){
        String cadenasString = "";
        if (this.isEmpty()){
            cadenasString += "No hay cadenas en el lenguaje";
            return null;
        }
        Cadena [] cadenasLenguaje = this.cadenasDeLenguaje();
        cadenasString += "[";
        for (int i = 0; i < cadenasLenguaje.length; i++) {
            cadenasString += cadenasLenguaje[i];
            if (i!=cadenasLenguaje.length-1) {
                cadenasString += ",";
            }
        }
        cadenasString += "]";
        return cadenasString;
    }
    /**
     * Concatena el Lenguaje A (este lenguaje) con un Lenguaje B 
     * @author Víctor Hugo Morales Martínez 2020630281 (Vicnow)
     * @param Lenguaje lenguaje a concatenar
     * @return Un nuevo lenguaje A concatenacion B
     */
    public Lenguaje concatenarLenguaje(Lenguaje lenguaje){
        Lenguaje lenguajeConcatenado = new Lenguaje();
        String cadenaTemporal = "";
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < lenguaje.size(); j++) {
                cadenaTemporal += this.cadenas.get(i);
                cadenaTemporal += lenguaje.cadenas.get(j);
                lenguajeConcatenado.insertarPalabra(new Cadena(cadenaTemporal));
                cadenaTemporal="";
            }
        }
        return lenguajeConcatenado;
    }
    /**
     * Concatena el lenguaje a una potencia n
     * @author Víctor Hugo Morales Martínez 2020630281 (Vicnow)
     * @param int potencia 
     * @return Un nuevo lenguaje A potenciado a la n
     */
    public Lenguaje potenciaLenguaje(int potencia){
        Lenguaje lenguajePotenciado = new Lenguaje();
        String temporal = "";
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                temporal += this.cadenas.get(i);
                temporal += this.cadenas.get(j);
                lenguajePotenciado.insertarPalabra(new Cadena(temporal));
                temporal = "";
            }
        }
        return lenguajePotenciado;
    }
    /**
     * Invierte el Lenguaje 
     * @author Víctor Hugo Morales Martínez 2020630281 (Vicnow)
     * @return Un nuevo lenguaje invertido
     */
    public Lenguaje invertirLenguaje(){
        Lenguaje lenguajeInvertido = new Lenguaje();
        int longitud = this.size();
        Cadena [] cadenasInvertidas = new Cadena[longitud];
        Cadena temporal;
        for (int i = 0; i < this.size(); i++) {
            cadenasInvertidas[i] = this.cadenas.get(i);
            temporal = cadenasInvertidas[i].invertir();
            lenguajeInvertido.insertarPalabra(temporal);
        }
        return lenguajeInvertido;
    }
    /**
     * Une el Lenguaje A (este lenguaje) con un Lenguaje B 
     * @author Víctor Hugo Morales Martínez 2020630281 (Vicnow)
     * @param Lenguaje lenguaje a unir
     * @return Un nuevo lenguaje A union B | A u B
     */
    public Lenguaje unirLenguajes(Lenguaje lenguaje){
        Lenguaje lenguajeUnion = new Lenguaje();
        for (int i = 0; i < this.size(); i++) {
            lenguajeUnion.insertarPalabra(this.cadenas.get(i));
        }
        for (int i = 0; i < lenguaje.size(); i++) {
            lenguajeUnion.insertarPalabra(lenguaje.cadenas.get(i));
        }
        return lenguajeUnion;
    }
    /**
     * Intersecta el Lenguaje A (este lenguaje) con un Lenguaje B 
     * @author Víctor Hugo Morales Martínez 2020630281 (Vicnow)
     * @param Lenguaje lenguaje a intersectar
     * @return Un nuevo lenguaje A interseccion B | A n B
     */
    public Lenguaje interseccionLenguajes(Lenguaje lenguaje){
        Lenguaje lenguajeIntersectado = new Lenguaje();
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < lenguaje.size(); j++) {
                if (this.cadenas.get(i).equals(lenguaje.cadenas.get(j))) {
                    lenguajeIntersectado.insertarPalabra(this.cadenas.get(i));
                }
            }
        }
        return lenguajeIntersectado;
    }
}
