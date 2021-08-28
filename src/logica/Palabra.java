/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 * Una secuencia finita de símbolos de un determinado alfabeto se conoce
 * como palabra
 * @author Saul de la O Torres
 */
public class Palabra {
    private String simbolosDePalabra;
    public Palabra(String simbolos) {
        this.simbolosDePalabra = simbolos;
    }
    public String getPalabra() {
        return this.simbolosDePalabra;
    }
    public boolean pertenecerAAlfabeto(Alfabeto alfabeto) {
        return alfabeto.pertenecerAlAlfabeto(this);
    }
    public boolean equals(Object objeto) {
        if(objeto==null) {
            return false;
            }
        if(!(objeto instanceof Palabra)) {
            return false;
            }
        Palabra unaPalabra = (Palabra)objeto;
        return simbolosDePalabra.equals(unaPalabra.simbolosDePalabra);
    }
    public String toString() {
        if(simbolosDePalabra.length()==0) {
            return "E";
            }
        return simbolosDePalabra;
    }
}
