/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoriacomputacional;

import logica.Alfabeto;
import logica.Cadena;

/**
 *
 * @author sauldelaotorres
 */
public class TeoriaComputacional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alfabeto alfabeto = new Alfabeto("01");
        System.out.println("Alfabeto: " + alfabeto);
        Cadena cadena = new Cadena("MakingAwesomeShit");
        System.out.println("Cadena: " + cadena);
        System.out.println(cadena.potenciar(5));
        System.out.println(cadena.invertir());
        Cadena [] lasCadenas = cadena.obtenerSubcadena(new Cadena("fe"));
        if(lasCadenas==null) {
            System.out.println( "No hay subcadena" );
            }
        else {
            for(Cadena laCadena: lasCadenas) {
                System.out.println(laCadena);
                }
            }
        lasCadenas = cadena.obtenerPrefijo(new Cadena("Hola como estas luis saul"));
        if(lasCadenas==null) {
            System.out.println( "No hay prefijo" );
            }
        else {
            for(Cadena laCadena: lasCadenas) {
                System.out.println(laCadena);
                }
            }
    }
    
}
