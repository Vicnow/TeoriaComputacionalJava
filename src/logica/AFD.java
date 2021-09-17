/*Clase Cadena*/
/**
 *
 * @author Víctor Hugo Morales Martínez
 */
package logica;
import logica.Alfabeto;

public class AFD {
    private String estadoInicial;
    private String [] estadosAceptacion;
    private String [] estadosAFD;
    private Alfabeto alfabetoAFD;
    private String [][] tranciciones;
    private int numeroTranciciones;
    private String cadenaAFD = "";
    // private int banderaTrancicion = 0;
    public AFD(String estados,String inicial,String aceptacion,String alfabeto) {
        estadosAFD = estados.split(",");
        if(estadosAFD[0]==""){
            estadosAFD = null;
        }
        estadoInicial = inicial; 
        estadosAceptacion = aceptacion.split(",");
        if(estadosAceptacion[0]==""){
            estadosAFD = null;
        }
        alfabetoAFD = new Alfabeto(alfabeto);
        System.out.println(estadosAFD.length);
        System.out.println(alfabetoAFD.size());
        numeroTranciciones = estadosAFD.length * alfabetoAFD.size();
        tranciciones = new String[estadosAFD.length][alfabetoAFD.size()];
    }
    public Boolean comprobarEstados(){
        if(this.estadoInicial == null || this.estadosAceptacion == null || this.estadosAFD == null){
            return false;
        }
        return true;
    }
    public int posicionEstado(String estado){
        if(this.comprobarEstados()==false){
            return 0;
        }
        for (int i = 0; i < estadosAFD.length; i++) {
            if (estadosAFD[i].equals(estado)) {
                return i;
            }
        }
        return 0;
    }
    public void agregarTrancicion(String estado,String simbolo,String estadoSiguiente){
        tranciciones[this.posicionEstado(estado)][this.alfabetoAFD.posicionSimbolo(simbolo)] = estadoSiguiente;
    }
    public int totalTransiciones(){
        return this.numeroTranciciones;
    }
    public String mostrarEstados(){
        String estados = "";
        if (this.comprobarEstados()== null){
            estados += "No hay estados en el alfabeto";
            return estados;
        }
        estados += "[";
        for (int i = 0; i < estadosAFD.length; i++) {
            estados += estadosAFD[i];
            if (i!=estadosAFD.length-1) {
                estados += ",";
            }
        }
        estados += "]";
        return estados;
    }
    public String mostrarEstadosAceptacion(){
        String estados = "";
        if (this.comprobarEstados()== null){
            estados += "No hay estados en el alfabeto";
            return estados;
        }
        estados += "[";
        for (int i = 0; i < estadosAceptacion.length; i++) {
            estados += estadosAceptacion[i];
            if (i!=estadosAceptacion.length-1) {
                estados += ",";
            }
        }
        estados += "]";
        return estados;
    }
    public String mostrarEstadoInicial(){
        return estadoInicial;
    }
    public void mostrarTrancicones(){
        System.out.print("Estado/Entrada\t\t");
        String [] simbolos = alfabetoAFD.getAlfabeto();
        String simbolo = "";
        for (int i = 0; i < simbolos.length ;i++) {
            simbolo += simbolos[i];
            System.out.print(simbolo+"\t\t");
            simbolo = "";
        }
        System.out.println();
        for (int i = 0; i < this.estadosAFD.length; i++) {
            System.out.print(estadosAFD[i]+"\t\t\t");
            for (int j = 0; j < simbolos.length; j++) {
                System.out.print(tranciciones[i][j]+"\t\t");
            }
            System.out.println();
        }
    }
    public void mostarDatos(){
        System.out.println("----------------------------------------------------------");
        System.out.println("Estados del AFD = " + this.mostrarEstados());
        System.out.println("Estados inicial del AFD = " + this.mostrarEstadoInicial());
        System.out.println("Estados de aceptación del AFD = " + this.mostrarEstadosAceptacion());
        System.out.println("Simbolos del alfabeto en el AFD" + this.alfabetoAFD.mostrarSimbolosAlfabeto());
        this.mostrarTrancicones();
        System.out.println("----------------------------------------------------------");
    }
    public void ingresarCadena(String cadena){
        cadenaAFD = cadena;
    }
    public void comprobarCadenaEnAFD(){
        String simbolo = "";
        String siguiente = "";
        String actual = estadoInicial;
        simbolo += cadenaAFD.charAt(0);
        siguiente += tranciciones[this.posicionEstado(actual)][this.alfabetoAFD.posicionSimbolo(simbolo)];
        System.out.println(actual+" -> "+simbolo+" -> "+siguiente);
        actual = siguiente;
        siguiente = "";
        simbolo = "";
        for (int i = 1; i < cadenaAFD.length(); i++) {
            simbolo += cadenaAFD.charAt(i);
            siguiente += tranciciones[this.posicionEstado(actual)][this.alfabetoAFD.posicionSimbolo(simbolo)];
            System.out.println(actual+" -> "+simbolo+" -> "+siguiente);
            simbolo = "";
            actual = siguiente;
            siguiente = "";
        }
        for (int i = 0; i < estadosAceptacion.length; i++) {
            if(estadosAceptacion[i].equals(actual)){
                System.out.println("La cadena: '" + cadenaAFD +"' es valida para el AFD");
            }else{
                System.out.println("La cadena: '" + cadenaAFD +"' NO es valida para el AFD");
            }
        }
    }
}