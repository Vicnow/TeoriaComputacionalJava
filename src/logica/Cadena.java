/*Clase Cadena*/
/**
 *
 * @author Saul de la O Torres
 */
package logica;
import java.util.ArrayList;

/**Tipo de dato que guarda un string y puede hacer todas las operaciones relacionadas a una cadena*/
public class Cadena extends Object {

    /**
     * Si simbolos.length()==0 tenemos una cadena vacia (epsilon)
     */
    private String simbolos;

    /**
     * Cadena que obtiene un string (simbolos) para utlizar las propiedades de esta
     * @param simbolos (String)
     * @author Saul de la O Torres 
     * @author Víctor Hugo Morales Martínez (vicnow)
     */
    public Cadena(String simbolos) {
        this.simbolos = simbolos;
    }
    public String getCadena(){
        return this.simbolos;
    }
    //@Override
    // public boolean pertenecerAlfabeto(Alfabeto alfabeto) {
    //     return alfabeto.pertenecerAlfabeto(this);
    // }
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
     * @param subcadena - Subcadena "w"
     * @return arreglo con 3 subcadenas en caso de ser posible, null si no lo es.
     */
    public Cadena [] obtenerSubcadena( Cadena subcadena ) {
        
        String temporal = subcadena.simbolos;
        /*Separamos la Cadena en las partes que esten antes y despues de la subcadena y las guardamos en un array*/
        String [] temporales = this.simbolos.split(temporal);
        String x = "";
        String w = "";
        String y = "";
        if(temporales.length!=1 & temporales.length>0) {
            x = temporales[0];
            w = temporal;
            y = temporales[1];
        }else{
            /*Si la subcadena es toda la cadena, regresamos epsilon*/
            System.out.println("E");
            return null;
        }
        Cadena [] lasCadenas = new Cadena[3];
        if(!w.isEmpty()) {
            lasCadenas[0] = new Cadena( "subcadena x: " + x );
            lasCadenas[1] = new Cadena( "subcadena w: " + w );
            lasCadenas[2] = new Cadena( "subcadena y: " + y);
            }
        else {
            lasCadenas = null;
            System.out.println("No hay subcadena");
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

     /**
     * Recibe una cadena y Devuelve todos los prefijos de una cadena (Si la cadena es vacia devuelva epsilon)
     * @author Víctor Hugo Morales Martínez (Vicnow)
     * @param cadena - Cadena a saber todos los prefijos
     * @return Array con todos los prefijos (Simpre regresaalmenos epsilon)
     */
    public Cadena [] obtenerTodosLosPrefijos (Cadena cadena){
        int longitud = cadena.length();
        Cadena [] prefijos = new Cadena[longitud+1];
        String prefijo;
        prefijos[0] = new Cadena("E");
        for (int i = 1; i <= longitud; i++) {
            prefijo = simbolos.substring(0, i);
            prefijos[i] =new Cadena(prefijo);
        }
        return prefijos;
    }

    /**
     * Recibe una cadena y Devuelve todos los subfijos de una cadena (Si la cadena es vacia devuelva epsilon)
     * @author Víctor Hugo Morales Martínez (Vicnow)
     * @param cadena - Cadena a saber todos los subfijos
     * @return Array con todos los subfijos (Simpre regresaalmenos epsilon)
     */
    public Cadena [] obtenerTodosLosSubfijos (Cadena cadena){
        int longitud = cadena.length();
        // Cadena [] subfijos = new Cadena[longitud+1];
        Cadena [] subfijos = new Cadena[longitud];
        String subfijo;
        // subfijos[longitud] = new Cadena("E");
        for (int i = 0; i < longitud; i++) {
            subfijo = simbolos.substring(i, longitud);
            subfijos[i] =new Cadena(subfijo);
        }
        return subfijos;
    }

    /**
     * Recibe una cadena y Devuelve todos los subcadenas de una cadena
     * @author Víctor Hugo Morales Martínez (Vicnow)
     * @param cadena - Cadena a saber todos las subcadenas
     * @return ArrayList con todas los subcadenas
     */
    public ArrayList<Cadena> obtenerTodasLasSubcadenas (Cadena cadena){
        ArrayList<Cadena> subcadenas = new ArrayList<Cadena>();
        // Primera Parte
        int x = 1;
        int longitudCadena = cadena.length();
        int y = longitudCadena-1;
        String subcadenaTemp;
        do {
            subcadenaTemp = cadena.getCadena().substring(x, y);
            subcadenas.add(new Cadena(subcadenaTemp));
            y--;
            if(x==y){
                x++;
                y = longitudCadena-1;
            }
        } while (x!=longitudCadena-1);
        return subcadenas;
    }

    /**
    * Recibe una alfabeto y muestra si la cadena pertenece a dicho alfabeto
    * @author Víctor Hugo Morales Martínez (Vicnow)
    * @param Alfabeto - Alfabeto a comparar simbolass
    * @return True si los simbolos de la palabra estan en el alfabeto, False en caso conrario.
    */
    public boolean estarEnAlfabeto(Alfabeto alfabeto) {
        if(alfabeto.isEmpty()){
            return false;
        }
        String simbolosDePalabra = this.getCadena();
        String [] simbolosDeAlfabeto = alfabeto.getAlfabeto();
        int contador = 0;
        for (int i = 0; i < alfabeto.size(); i++) {
            for (int j = 0; j < this.length(); j++) {
                if (simbolosDeAlfabeto[i].charAt(0)==simbolosDePalabra.charAt(j)) {
                    contador++;
                }
            }
        }
        if (contador == simbolosDePalabra.length()) {
            return true;
        }
        return false;
    }
}
