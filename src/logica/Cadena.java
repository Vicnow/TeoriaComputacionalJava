/*Clase Cadena*/
/**
 *
 * @author sauldelaotorres
 */
package logica;

public class Cadena extends Object {

    /**
     * Si simbolos.length()==0 tenemos una cadena vacia (epsilon)
     */
    private String simbolos;
    public Cadena(String simbolos) {
        this.simbolos = simbolos;
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto==null) {
            return false;
        }
        if(!(objeto instanceof Cadena)) {
            return false;
        }
        Cadena laCadena = (Cadena)objeto;
        return simbolos.equals(laCadena.simbolos);
    }
    @Override
    public String toString() {
        if(length()==0) {
            return "E";
            }
        return this.simbolos;
    }
    /*Longitud de una cadena */
    public int length() {
        return simbolos.length();
    }
    /*Concatenar para una sola cadena*/
    public Cadena concatenar(Cadena unaCadena) {
        return new Cadena(simbolos+unaCadena.simbolos);
    }
    /*Concatenar para 2 cadenas (Sobrecarga de metodos)*/
    public Cadena concatenar(Cadena unaCadena, Cadena otraCadena) {
        return new Cadena(unaCadena.simbolos+otraCadena.simbolos);
    }
    /*Potenciar una cadena */
    public Cadena potenciar(int potencia) {
        Cadena temporal = new Cadena("");
        Cadena miCadena = new Cadena(simbolos);
        if(length()!=0) {
            if(potencia==1) {
                temporal = miCadena;
                }
            else {
                for(int n=1; n<=potencia; n++) {
                    temporal = concatenar(temporal,miCadena);
                }
            }
        }
        return temporal;
    }
    /*Invertir la cadena*/
    public Cadena invertir() {
        String inversor = "";
        for(int n=length()-1; n>=0; n--) {
            inversor += simbolos.charAt(n);
        }
        return new Cadena(inversor);
    }
    /**
     * Obtener 3 subcadenas (xwy) apartir de una cadena "w"
     * @author Víctor Hugo Morales Martínez (Vicnow)
     * @param laCadena - Subcadena "w"
     * @return 3 subcadenas en caso de ser posible, null si no lo es.
     */
    public Cadena [] obtenerSubcadena( Cadena laCadena ) {
        
        String temporal = laCadena.simbolos;
        String [] temporales = this.simbolos.split(temporal);
        String x = "";
        String w = "";
        String y = "";
        if(temporales.length!=1) {
            x = temporales[0];
            w = temporal;
            y = temporales[1];
        }
        Cadena [] lasCadenas = new Cadena[3];
        if(!w.isEmpty()) {
            lasCadenas[0] = new Cadena( "x: " + x );
            lasCadenas[1] = new Cadena( "w: " + w );
            lasCadenas[2] = new Cadena( "y: " + y);
            }
        else {
            lasCadenas = null;
            }
        return lasCadenas;
    }

    public Cadena [] obtenerPrefijo( Cadena laCadena ) {
        int longitud = laCadena.length();
        String x = "";
        String y = "";
        Cadena [] lasCadenas = new Cadena[2];
        if(longitud<=length()) {
        String subCadena = simbolos.substring(0, longitud);
        
        if(laCadena.length()==0) {
            x = "E";
            y = simbolos;
            }
        else  {
            if(subCadena.equals(laCadena.simbolos)) {
                x = laCadena.simbolos;
                y = simbolos.substring(longitud, length());
                }
            }
        }
        if(!x.isEmpty()) {
            lasCadenas[0] = new Cadena( "x: " + x );
            lasCadenas[1] = new Cadena( "y: " + y );
            }
        else {
            lasCadenas = null;
            }
        return lasCadenas;
    }
}
