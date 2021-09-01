/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import java.util.Scanner;
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
        // Asignamos valores a todos nuestras variables
        Alfabeto alfabeto = new Alfabeto("a,b,c,d,e,f,g,h,i,j,k,l,m,n,ñ,o,p,q,r,s,t,u,v,w,x,y,z");
        Cadena cadena = new Cadena("teoriacomputacional");
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
        
        do {
            System.out.println();
            System.out.println("Elija una opción");
            System.out.println("1.-\tAlfabeto");
            System.out.println("2.-\tCadenas");
            System.out.println("3.-\tLenguajes");
            System.out.println("4.-\tExpresiones Regulares");
            System.out.println("0.-\tSalir");
            String opc = scanner.nextLine();
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
                    System.out.println("Subcadena a buscar = compu");
                    Cadena [] subcadenas = cadena.obtenerSubcadena(new Cadena("compu"));
                    if(subcadenas!=null) {
                        for(Cadena subcadena: subcadenas) {
                            System.out.println(subcadena);
                        }
                    }
                    /*Obtenemos el prefijo de la cadena en base a una cadena que empice desde el primer simbolo de nuestra cadena*/
                    System.out.println("prefijo = teoria");
                    Cadena [] lasCadenas = cadena.obtenerPrefijo(new Cadena("teoria"));
                    if(lasCadenas==null) {
                        System.out.println( "No hay prefijo" );
                        }
                    else {
                        for(Cadena laCadena: lasCadenas) {
                            System.out.println(laCadena);
                        }
                    }

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
