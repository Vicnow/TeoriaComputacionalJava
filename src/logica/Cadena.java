/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author sauldelaotorres
 */
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
    public int length() {
        return simbolos.length();
    }
    public Cadena concatenar(Cadena unaCadena) {
        return new Cadena(simbolos+unaCadena.simbolos);
    }
    public Cadena concatenar(Cadena unaCadena, Cadena otraCadena) {
        return new Cadena(unaCadena.simbolos+otraCadena.simbolos);
    }
    public Cadena potenciar(int potencia) {
        Cadena temporal = new Cadena("");
        Cadena miCadena = new Cadena(simbolos);
        if(length()!=0) {
            if(potencia==1) {
                temporal = miCadena;
                }
            else {
                for(int n=1; n<=potencia; n++) {
                    System.out.println(n + ") " +temporal);
                    temporal = concatenar(temporal,miCadena);
                    }
            }
        }
        return temporal;
    }
    public Cadena invertir() {
        String inversor = "";
        for(int n=length()-1; n>=0; n--) {
            inversor += simbolos.charAt(n);
        }
        return new Cadena(inversor);
    }
    /**
     * Simpre Saul De La O Torres --- Saul
     * z = xwy w es la subcadena
     * @param laCadena la subcadena o sea w
     * @return 
     */
    /*
    public Cadena [] obtenerSubcadena( Cadena laCadena ) {
        String temporal = laCadena.simbolos;
        int n = length();
        int m = laCadena.length();
        String x = "";
        String wTemporal = "";
        String y = "";
        boolean terminaX = false;
        boolean empiezaY = false;
        int cambio = 0;
        
        for(int s=0; s<n; s++) {
            for(int i=0; i<m; i++) {
                char ca = simbolos.charAt(s+i);
                char cb = temporal.charAt(i);
                if(cb == ca) {
                    wTemporal += ca;
                    System.out.println("Ocurrencia de Patrón con cambio: "+s);
                    terminaX = true;
                    cambio = s;
                    }
                else {
                    System.out.println(cambio+ "\t" +(cambio+m)+ "\t" + s + "\t" + empiezaY );
                    if(s>(cambio+m)) {
                        empiezaY = true;
                        }
                    if(terminaX!=true) {
                        if(ca==' ') {
                            x += '_';
                            }
                        else {
                            x += ca;
                            }
                        }
                    if(empiezaY==true) {
                        y += ca;
                        }
                    break;
                } //si no coincide la letra, rompemos el ciclo de i, y pasamos
            }               //a la siguiente iteración de s
        }
        Cadena [] lasCadenas = new Cadena[3];
        
        if(!wTemporal.isEmpty()) {
            lasCadenas[0] = new Cadena( "x: " + x );
            lasCadenas[1] = new Cadena( "w: " + wTemporal );
            lasCadenas[2] = new Cadena( "y: " + y);
            }
        else {
            lasCadenas = null;
            }
        return lasCadenas;
    }
    */
    /**
     * Simpre Saul De La O Torres --- Saul
     * z = xwy w es la subcadena
     * @param laCadena la subcadena o sea w
     * @return 
     */
    public Cadena [] obtenerSubcadena( Cadena laCadena ) {
        
        String temporal = laCadena.simbolos;
        String [] temporales = this.simbolos.split(temporal);
//        String [] temporales = this.simbolos.split(" ");
        String x = "";
        String w = "";
        String y = "";
        if(temporales.length!=1) {
            x = temporales[0];
            w = temporal;
            y = temporales[1];
        }
//        int contador = 0;
//        for( String buscada: temporales ) {
//            if(buscada.equals(temporal)) {
//                w = buscada;
//                break;
//                }
//            else {
//                x += buscada + "_";
//                contador++;
//                }
//            }
//        contador++;
//        for(int n=contador; n<temporales.length; n++) {
//            y += temporales[n] + "_";
//            }
        Cadena [] lasCadenas = new Cadena[3];
//        if(y.length()==0) {
//            y = "E";
//            }
        
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
    /**
     * Simpre Saul De La O Torres --- Saul
     * w = xy x es el prefijo, y es el sobrante de w
     * @param laCadena la subcadena o sea w
     * @return 
     */
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
