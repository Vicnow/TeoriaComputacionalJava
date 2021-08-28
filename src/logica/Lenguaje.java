/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Un lenguaje es un conjunto de palabras=cadenas
 * @author Saul de la O Torres
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
}
