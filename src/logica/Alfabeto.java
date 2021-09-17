/**
 * Un conjunto no vacío y finito de símbolos se conoce como alfabeto
 * @author Saul de la O Torres
 */


package logica;

public class Alfabeto {
    private String [] simbolosDeAlfabeto;
    public Alfabeto(String simbolos) {
        simbolosDeAlfabeto = simbolos.split(",");
        if(simbolosDeAlfabeto[0]==""){
            simbolosDeAlfabeto = null;
        }
        
    }

    public String [] getAlfabeto(){
        return this.simbolosDeAlfabeto;
    }

    public boolean isEmpty() {
        if (simbolosDeAlfabeto == null) {
            return true;
        }
        return false;
    }

    public int size() {
        if(!this.isEmpty()){
            int longitud = simbolosDeAlfabeto.length;
            return longitud;
        }
        return 0;
    }
    public int posicionSimbolo(String simbolo){
        for (int i = 0; i < simbolosDeAlfabeto.length; i++) {
            if(simbolosDeAlfabeto[i].equals(simbolo)){
                return i;
            }
        }
        return 0;
    }

    public String mostrarSimbolosAlfabeto(){
        String simbolos = "";
        if (this.isEmpty()){
            simbolos += "No hay simbolos en el alfabeto";
            return simbolos;
        }
        simbolos += "[";
        for (int i = 0; i < simbolosDeAlfabeto.length; i++) {
            simbolos += simbolosDeAlfabeto[i];
            if (i!=simbolosDeAlfabeto.length-1) {
                simbolos += ",";
            }
        }
        simbolos += "]";
        return simbolos;
    }

    public boolean perteneceAlfabeto(String simbolo){
        if(this.isEmpty()){
            return false;
        }
        for (int i = 0; i < simbolosDeAlfabeto.length; i++) {
            if (simbolosDeAlfabeto[i].equals(simbolo)) {
                return true;
            }
        }
        return false;
    }
}
