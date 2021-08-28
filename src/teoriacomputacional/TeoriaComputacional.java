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
 * @author Saul de la O Torres
 */
public class TeoriaComputacional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Creando un alfabeto y lo nombramos 01*/
        Alfabeto alfabeto = new Alfabeto("Prueba");
        /*Imprimimos el alfabeto y su nombre*/ 
        System.out.println("Alfabeto: " + alfabeto);
        /*Creamos una nueva variable 'cadena' de tipo Cadena y le pasamos los simbolos que esta contiene*/
        Cadena cadena = new Cadena("*Making Awesome Shit*");
        /*Imprimimos nuestra cadena*/ 
        System.out.println("Cadena: " + cadena);
        /**Potenciamos la cadena a la 5ta */
        System.out.println(cadena.potenciar(5));
        /*Invertimos la cadena*/
        System.out.println(cadena.invertir());
        /*Obtenemos las subcadenas (xwy)de la cadena apartir de una subcadena "w" y las metemos en un arreglo"*/
        Cadena [] subcadenas = cadena.obtenerSubcadena(new Cadena("Awesome"));
        if(subcadenas!=null) {
            for(Cadena subcadena: subcadenas) {
                System.out.println(subcadena);
            }
        }
        /*Obtenemos el prefijo de la cadena en base a una cadena que empice desde el primer simbolo de nuestra cadena*/
        Cadena [] lasCadenas = cadena.obtenerPrefijo(new Cadena("*Making Awesome"));
        if(lasCadenas==null) {
            System.out.println( "No hay prefijo" );
            }
        else {
            for(Cadena laCadena: lasCadenas) {
                System.out.println(laCadena);
            }
        }

        Cadena [] losprefijos = cadena.obtenerTodosLosPrefijos(cadena);
        for (Cadena prefijo : losprefijos) {
            System.out.println(prefijo);
        }
    }
}
