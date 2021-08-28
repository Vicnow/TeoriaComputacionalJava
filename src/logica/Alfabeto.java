/**
 * Un conjunto no vacío y finito de símbolos se conoce como alfabeto
 * @author Saul de la O Torres
 */


package logica;

public class Alfabeto {
    private String simbolosDeAlfabeto;
    public Alfabeto(String simbolos) {simbolosDeAlfabeto = simbolos;}
    public int length() {return simbolosDeAlfabeto.length();}
    
    boolean pertenecerAlAlfabeto(Palabra palabra)  {
        String simbolosDePalabra = palabra.getPalabra();
        int n = 0;
        char ch = '0';
        do {
//            System.out.print( "Elija una: " );
            ch = simbolosDePalabra.charAt(n++);
        } while( estarEn( ch )  );
        return n!=simbolosDePalabra.length();
    }
    private boolean estarEn( char ch ) {
        for( int n=0; n<length(); n++ ) {
            if( ch==simbolosDeAlfabeto.charAt(n) ) {
                return true;
                }
            }
        return false;
    }
    public boolean estaVacio() {
        return length()==0;
    }
    public String toString() {
        return this.simbolosDeAlfabeto;
    }
}
