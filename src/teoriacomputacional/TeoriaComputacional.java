/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoriacomputacional;

import logica.Alfabeto;
import logica.Cadena;
import logica.Lenguaje;

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
        // Alfabeto alfabeto = new Alfabeto("Prueba");
        // /*Imprimimos el alfabeto y su nombre*/ 
        // System.out.println("Alfabeto: " + alfabeto);
        // /*Creamos una nueva variable 'cadena' de tipo Cadena y le pasamos los simbolos que esta contiene*/
        // Cadena cadena = new Cadena("xyz");
    //     /*Imprimimos nuestra cadena*/ 
    //     System.out.println("Cadena: " + cadena);
    //     /**Potenciamos la cadena a la 5ta */
    //     System.out.println(cadena.potenciar(5));
    //     /*Invertimos la cadena*/
    //     System.out.println(cadena.invertir());
    //     /*Obtenemos las subcadenas (xwy)de la cadena apartir de una subcadena "w" y las metemos en un arreglo"*/
    //     Cadena [] subcadenas = cadena.obtenerSubcadena(new Cadena("Awesome"));
    //     if(subcadenas!=null) {
    //         for(Cadena subcadena: subcadenas) {
    //             System.out.println(subcadena);
    //         }
    //     }
    //     /*Obtenemos el prefijo de la cadena en base a una cadena que empice desde el primer simbolo de nuestra cadena*/
    //     Cadena [] lasCadenas = cadena.obtenerPrefijo(new Cadena("*Making Awesome"));
    //     if(lasCadenas==null) {
    //         System.out.println( "No hay prefijo" );
    //         }
    //     else {
    //         for(Cadena laCadena: lasCadenas) {
    //             System.out.println(laCadena);
    //         }
    //     }

    //     Cadena [] losPrefijos = cadena.obtenerTodosLosPrefijos(cadena);
    //     for (Cadena prefijo : losPrefijos) {
    //         System.out.println(prefijo);
    //     }
    //     Cadena [] losSubfijos = cadena.obtenerTodosLosSubfijos(cadena);
    //     for (Cadena subfijo : losSubfijos) {
    //         System.out.println(subfijo);
    //     }

    /**
     * Tarea1 - Operaciones de Lenguajes
     * @author Víctor Hugo Morales Martinez - 2020630281
    */
        Lenguaje lenguajeA = new Lenguaje();
        lenguajeA.insertarPalabra(new Cadena("123"));
        lenguajeA.insertarPalabra(new Cadena("abc"));
        System.out.print("Lenguaje A = "+ lenguajeA.mostrarCadenasDelLenguaje());
        System.out.println("\t\t|\tTamaño = "+ lenguajeA.size());
        Lenguaje lenguajeB = new Lenguaje();
        lenguajeB.insertarPalabra(new Cadena("a"));
        lenguajeB.insertarPalabra(new Cadena("ae"));
        lenguajeB.insertarPalabra(new Cadena("eia"));
        System.out.print("Lenguaje B = "+ lenguajeB.mostrarCadenasDelLenguaje());
        System.out.println("\t\t|\tTamaño = "+ lenguajeB.size());
        Lenguaje lenguajeC = new Lenguaje();
        lenguajeC.insertarPalabra(new Cadena("ee"));
        lenguajeC.insertarPalabra(new Cadena("ae"));
        lenguajeC.insertarPalabra(new Cadena("eia"));
        lenguajeC.insertarPalabra(new Cadena("o"));
        System.out.print("Lenguaje C = "+ lenguajeC.mostrarCadenasDelLenguaje());
        System.out.println("\t|\tTamaño = "+ lenguajeC.size());
        System.out.println();
        Lenguaje lenguajeConcatenado = lenguajeA.concatenarLenguaje(lenguajeB);
        System.out.println("Lenguaje A Concatenado B = "+ lenguajeConcatenado.mostrarCadenasDelLenguaje());
        int potencia = 3;
        Lenguaje lenguajePotenciado = lenguajeC.potenciaLenguaje(potencia);
        System.out.println("Lenguaje C Potenciado a la " +potencia+" = "+lenguajePotenciado.mostrarCadenasDelLenguaje());
        Lenguaje lenguajeInvertido = lenguajeC.invertirLenguaje();
        System.out.println("Lenguaje C Invertido = "+lenguajeInvertido.mostrarCadenasDelLenguaje());
        Lenguaje lenguajeUnion = lenguajeA.unirLenguajes(lenguajeB);
        System.out.println("Lenguaje A Union Lenguaje B | (A u B) = "+lenguajeUnion.mostrarCadenasDelLenguaje());
        Lenguaje lenguajeInter = lenguajeC.interseccionLenguajes(lenguajeB);
        System.out.println("Lenguaje C Interseccion B (C n B) = "+lenguajeInter.mostrarCadenasDelLenguaje());
        System.out.println();
        System.out.println("Demonstracion de Teorema 1.3.2 | A concat (B u C) = (A concat B) u (A concat C)");
        Lenguaje lenguajeTeoremaP1 = lenguajeA.concatenarLenguaje(lenguajeB.unirLenguajes(lenguajeC));
        Lenguaje lenguajeTeoremaAB = lenguajeA.concatenarLenguaje(lenguajeB);
        Lenguaje lenguajeTeoremaAC = lenguajeA.concatenarLenguaje(lenguajeC);
        Lenguaje lenguajeTeoremaP2 = lenguajeTeoremaAB.unirLenguajes(lenguajeTeoremaAC);
        // Lenguaje lenguajeComprobacion = lenguajeTeoremaP1.interseccionLenguajes(lenguajeTeoremaP2);
        System.out.println("Teorema 1.3.2 Parte 1 = A concat (B u C) = \t\t"+lenguajeTeoremaP1.mostrarCadenasDelLenguaje());
        System.out.println("Teorema 1.3.2 Parte 2 = (A concat B) u (A concat C) = \t"+lenguajeTeoremaP2.mostrarCadenasDelLenguaje());
        // System.out.println("Comprobacion (Parte 1 n Parte 2) = \t\t\t"+lenguajeComprobacion.mostrarCadenasDelLenguaje());
    }
}
