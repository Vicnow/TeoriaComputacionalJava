/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import java.util.ArrayList;
import java.util.Scanner;
import logica.Alfabeto;
import logica.Cadena;
import logica.Lenguaje;
import logica.AFD;

/**
 *
 * @author Saul de la O Torres
 */
public class TeoriaComputacional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Asignamos valores a todos nuestras variables
        Lenguaje lenguajeA = new Lenguaje();
        lenguajeA.insertarPalabra(new Cadena("123"));
        lenguajeA.insertarPalabra(new Cadena("abc"));
        Lenguaje lenguajeB = new Lenguaje();
        lenguajeB.insertarPalabra(new Cadena("a"));
        lenguajeB.insertarPalabra(new Cadena("ae"));
        lenguajeB.insertarPalabra(new Cadena("eia"));
        Lenguaje lenguajeC = new Lenguaje();
        lenguajeC.insertarPalabra(new Cadena("ee"));
        lenguajeC.insertarPalabra(new Cadena("ae"));
        lenguajeC.insertarPalabra(new Cadena("eia"));
        lenguajeC.insertarPalabra(new Cadena("o"));
        Scanner scanner = new Scanner(System.in);
        
        //Creando un Menu
        
        System.out.println();
        System.out.println("Teoria Computacional - Morales Martínez Víctor Hugo");
        System.out.println("Agregue un alfabeto. (separando cada simbolo por comas ',')");
        System.out.println("Ejemplo = a,b,c,d,f,e,1,3,4,ñ,A,B");
        String opc = scanner.nextLine();
        Alfabeto alfabeto = new Alfabeto(opc);
        System.out.println();
        System.out.println("Alfabeto agregado:"+alfabeto.mostrarSimbolosAlfabeto());
        System.out.println("Agregue una Palabra (cadena) cuyos simbolos pertenezcan al alfabeto que agrego.");
        System.out.println("Ejemplo = ABed1431ñ");
        opc = scanner.nextLine();
        Cadena cadena = new Cadena(opc);
        System.out.println("Su Cadena: " + cadena.getCadena());
        System.out.println();
        do {
            System.out.println("Elija una opción");
            System.out.println("1.-\tPractica 1 - Alfabeto");
            System.out.println("2.-\tPractica 1 - Cadenas");
            System.out.println("3.-\tLenguajes");
            System.out.println("4.-\tAFD");
            System.out.println("0.-\tSalir");
            opc = scanner.nextLine();
            System.out.println();
            switch (opc) {
                case "1":
                    System.out.println("Alfabeto a utilizar:"+alfabeto.mostrarSimbolosAlfabeto());
                    System.out.println("Longitud del alfabeto : "+alfabeto.size());
                    String pruebaSimbolo = "a";
                    System.out.println("Simbolo: "+pruebaSimbolo+"\tPertenece a Alfabeto? "+alfabeto.perteneceAlfabeto(pruebaSimbolo));
                    System.out.println();
                    System.out.println("Presione cualquier tecla para continuar");
                    opc = scanner.nextLine();
                    break;
                case "2":
                    System.out.println("Alfabeto a utilizar:"+alfabeto.mostrarSimbolosAlfabeto());
                    /*Imprimimos nuestra cadena*/ 
                    System.out.println("Cadena: " + cadena.getCadena());
                    /*Imprimimos si la cadena pertenece al alfabeto*/ 
                    System.out.println("La cadena pertenece al Alfabeto? "+cadena.estarEnAlfabeto(alfabeto));
                    /**Potenciamos la cadena a la 5ta */
                    System.out.print("Cadena a la potencia 5: ");
                    System.out.println(cadena.potenciar(5));
                    /*Invertimos la cadena*/
                    System.out.println("Cadena invetida: "+cadena.invertir());
                    /*Obtenemos las subcadenas (xwy)de la cadena apartir de una subcadena "w" y las metemos en un arreglo"*/
                    // System.out.println("Subcadena a buscar = compu");
                    // Cadena [] subcadenas = cadena.obtenerSubcadena(new Cadena("compu"));
                    // if(subcadenas!=null) {
                    //     for(Cadena subcadena: subcadenas) {
                    //         System.out.println(subcadena);
                    //     }
                    // }
                    // /*Obtenemos el prefijo de la cadena en base a una cadena que empice desde el primer simbolo de nuestra cadena*/
                    // System.out.println("prefijo = teoria");
                    // Cadena [] lasCadenas = cadena.obtenerPrefijo(new Cadena("teoria"));
                    // if(lasCadenas==null) {
                    //     System.out.println( "No hay prefijo" );
                    //     }
                    // else {
                    //     for(Cadena laCadena: lasCadenas) {
                    //         System.out.println(laCadena);
                    //     }
                    // }

                    Cadena [] losPrefijos = cadena.obtenerTodosLosPrefijos(cadena);
                    System.out.println("Todos los prefijos de la cadena:");
                    for (Cadena prefijo : losPrefijos) {
                        System.out.println(prefijo);
                    }
                    System.out.println();
                    System.out.println("Todos los subfijos de la cadena:");
                    Cadena [] losSubfijos = cadena.obtenerTodosLosSubfijos(cadena);
                    for (Cadena subfijo : losSubfijos) {
                        System.out.println(subfijo);
                    }
                    System.out.println();
                    System.out.println("Todos las subcadenas de la cadena:");
                    ArrayList lasSubcadenas = cadena.obtenerTodasLasSubcadenas(cadena);
                    for (int i = 0; i < lasSubcadenas.size(); i++) {
                        System.out.println(lasSubcadenas.get(i));
                    }
                    System.out.println();
                    System.out.println("Presione cualquier tecla para continuar");
                    opc = scanner.nextLine();
                    break;
                case "3":
                    System.out.println("Alfabeto a utilizar:"+alfabeto.mostrarSimbolosAlfabeto());
                    System.out.print("Lenguaje A = "+ lenguajeA.mostrarCadenasDelLenguaje());
                    System.out.println("\t\t|\tTamaño = "+ lenguajeA.size());
                    System.out.println("El lenguaje A pertenece al alfabeto?:" + lenguajeA.estarEnAlfabeto(alfabeto));
                    System.out.print("Lenguaje B = "+ lenguajeB.mostrarCadenasDelLenguaje());
                    System.out.println("\t\t|\tTamaño = "+ lenguajeB.size());
                    System.out.println("El lenguaje B pertenece al alfabeto?:" + lenguajeB.estarEnAlfabeto(alfabeto));
                    System.out.print("Lenguaje C = "+ lenguajeC.mostrarCadenasDelLenguaje());
                    System.out.println("\t|\tTamaño = "+ lenguajeC.size());
                    System.out.println("El lenguaje C pertenece al alfabeto?:" + lenguajeC.estarEnAlfabeto(alfabeto));
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
                    Lenguaje lenguajeComprobacion = lenguajeTeoremaP1.interseccionLenguajes(lenguajeTeoremaP2);
                    System.out.println("Teorema 1.3.2 Parte 1 = A concat (B u C) = \t\t"+lenguajeTeoremaP1.mostrarCadenasDelLenguaje());
                    System.out.println("Teorema 1.3.2 Parte 2 = (A concat B) u (A concat C) = \t"+lenguajeTeoremaP2.mostrarCadenasDelLenguaje());
                    System.out.println("Comprobacion (Parte 1 n Parte 2) = \t\t\t"+lenguajeComprobacion.mostrarCadenasDelLenguaje());
                    System.out.println();
                    System.out.println("Presione cualquier tecla para continuar");
                    opc = scanner.nextLine();
                    break;
                case "4":
                    System.out.println("Ingrese los estados del AFD con la siguiente sintaxis = Q0,Q1,Q2,....,Qn");
                    String estados = "";
                    opc = scanner.nextLine();
                    estados = opc;
                    System.out.println("Ingrese el estado Inicial con la siguiente sintaxis = Qn");
                    String estadoInicial= "";
                    opc = scanner.nextLine();
                    estadoInicial = opc;
                    System.out.println("Ingrese los estados de Aceptación con la siguiente sintaxis = Q2,Q3,etc");
                    String estadosAceptacion= "";
                    opc = scanner.nextLine();
                    estadosAceptacion = opc;
                    System.out.println("Ingrese los simbolos del alfabeto del AFD con la siguiente sintaxis = 0,1,2,etc");
                    String simbolosAlfabeto= "";
                    opc = scanner.nextLine();
                    simbolosAlfabeto = opc;
                    AFD automataFinito = new AFD(estados,estadoInicial, estadosAceptacion, simbolosAlfabeto);
                    for (int i = 0; i < automataFinito.totalTransiciones(); i++) {
                        System.out.println("Agrega la transicion "+(i+1)+" de "+automataFinito.totalTransiciones());
                        System.err.print("Estado: ");
                        String estado= "";
                        opc = scanner.nextLine();
                        estado = opc;
                        System.err.print("Simbolo: ");
                        String simbolo= "";
                        opc = scanner.nextLine();
                        simbolo= opc;
                        System.err.print("Estado resultado: ");
                        String estadoSiguiente= "";
                        opc = scanner.nextLine();
                        estadoSiguiente = opc;
                        automataFinito.agregarTrancicion(estado, simbolo, estadoSiguiente);
                    }
                    automataFinito.mostarDatos();
                    System.out.println("Ingrese una palabra para comprobar en el AFD");
                    String cadenaAFD= "";
                    opc = scanner.nextLine();
                    cadenaAFD = opc;
                    automataFinito.ingresarCadena(cadenaAFD);
                    automataFinito.comprobarCadenaEnAFD();
                    System.out.println("Autor: Morales Martinez Víctor Hugo 2020630281");
                    System.out.println("Presione cualquier tecla para continuar");
                    opc = scanner.nextLine();
                    break;
                case "0":
                    System.out.println("Autor: Morales Martinez Víctor Hugo 2020630281");
                    return;
                default:
                    System.out.println("Autor: Morales Martinez Víctor Hugo 2020630281");
                    return;
            }
        } while (true);
    }
}
