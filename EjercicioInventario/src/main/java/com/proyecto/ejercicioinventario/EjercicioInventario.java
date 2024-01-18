/**
 * Inventario de Tienda: Escribe un programa para gestionar el inventario de una 
 * tienda utilizando ArrayList. Debe permitir agregar productos con detalles como 
 * nombre, precio y cantidad en stock, así como realizar operaciones como actualizar 
 * inventario, buscar productos y mostrar el inventario actualizado.
 */

package com.proyecto.ejercicioinventario;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Marcos
 * @version 1.2
 * 
 * Corrección de errores:
 * Corregido error al introducir el primer valor en la listaID
 * Corregido error al introducir el segundo valor (y consecutivos) en la listaID
 * Corregido error al modificar un producto que en lugar de modificar añadía
 * 
 * Añadidos:
 * Añadido mensaje a la hora de añadir un producto con nombre que ya existe
 * Añadidos comentarios de acompañamiento básicos
 * Añadida acaración de las opciones de busqueda en el texto
 * 
 */
public class EjercicioInventario {
    
    public static void main(String[] args) {
        //Listas a usar
        ArrayList<Integer> listaID = new ArrayList<>(); //Para los ID
        ArrayList<String> listaNombre = new ArrayList<>(); //Para los nombres
        ArrayList<Integer> listaPrecio = new ArrayList<>(); //Para los precios
        ArrayList<Integer> listaCantidad = new ArrayList<>(); //Para las cantidades almacenadas
        
        //scaners
        Scanner scNum = new Scanner(System.in);
        scNum.useLocale(Locale.ITALY);
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ITALY);
        
        
         while (true) {
            System.out.println("\nMenú:");

            System.out.println("1. Añadir producto");

            System.out.println("2. Actualizar producto");

            System.out.println("3. Buscar un producto");
            
            System.out.println("4. Mostrar el inventario");

            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            
            int opcion = scNum.nextInt();
            
            switch(opcion){
                case 1 ->{//Agregamos un producto
                    System.out.println("¿Cuál es el nombre del producto?");
                    String nombre = sc.nextLine();
                    
                    System.out.println("¿Cuál es el precio del producto?");
                    int precio = scNum.nextInt();
                    
                    System.out.println("¿Cuánto del producto se tiene en este momento?");
                    int cantidad = scNum.nextInt();
                    
                    nombre = nombre.toLowerCase();
                        if(!listaNombre.contains(nombre)){//Para saber si el producto esta dado de alta
                            if(listaID.isEmpty()){//Para saber si la lista de los ID's contiene algo o no
                                listaID.add(1); //la primera vez se inicia por 1
                                listaNombre.add(nombre);
                                listaPrecio.add(precio);
                                listaCantidad.add(cantidad);
                            }
                            else{
                                listaID.add(listaID.get(listaID.size()-1)+1); //Despues de la primera vez se autoincrementa el valor
                                listaNombre.add(nombre);
                                listaPrecio.add(precio);
                                listaCantidad.add(cantidad);
                            }
                        }//fin if si no esta el nombre
                        
                        else{
                            System.out.println("Ese producto ya esta dado de alta.");
                        }
                        break;
                }
                case 2 ->{//Actualizamos un producto
                    System.out.println("¿Cuál es el ID del producto a modificar?");
                    int ID = scNum.nextInt();
                    if(listaID.contains(ID)){
                        int indice = listaID.indexOf(ID);
                        
                        //Queremos cambiar el nombre
                        System.out.println("¿Quiere modificar el nombre? (s/n)");
                        String respuesta = sc.nextLine();
                        
                        if(respuesta.equalsIgnoreCase("s")){
                            System.out.println("¿Cuál es el nombre del producto?");
                            String nombre = sc.nextLine();
                            listaNombre.set(indice,nombre);
                        }
                        
                        
                        //Queremos cambiar el precio del producto
                        System.out.println("¿Quiere modificar el precio del producto? (s/n)");
                        respuesta = sc.nextLine();

                        if(respuesta.equalsIgnoreCase("s")){
                            System.out.println("¿Cuál es el precio del producto?");
                            int precio = scNum.nextInt();
                            listaPrecio.set( indice, precio);
                        }
                        
                        
                        //Queremos cambiar la cantidad del producto
                        System.out.println("¿Quiere modificar la cantidad del producto? (s/n)");
                        respuesta = sc.nextLine();

                        if(respuesta.equalsIgnoreCase("s")){
                            System.out.println("¿Cuánto del producto se tiene en este momento?");
                            int cantidad = scNum.nextInt();
                            listaCantidad.set(indice, cantidad);
                        }
                    }
                    break;
                }
                
                case 3 ->{//Buscamos un producto
                    System.out.println("Lo va a buscar por 1) ID o 2) nombre (1/2)" );//Queremos saber como se buscara si por ID o nombre
                    int respuesta = scNum.nextInt();
                    switch (respuesta) {
                        
                        case 1 -> {//Caso de busqueda por ID
                            System.out.println("¿Cuál es el ID del producto?");
                            int ID = scNum.nextInt();
                            
                            if(listaID.contains(ID)){//Solo se busca en caso de que exista el array
                                
                                int indice = listaID.indexOf(ID);
                                System.out.println(listaID.get(indice));
                                System.out.println(listaNombre.get(indice));
                                System.out.println(listaPrecio.get(indice));
                                System.out.println(listaCantidad.get(indice));
                                
                            }
                            else{
                                System.out.println("La ID no esta contenida"); 
                            }
                        }
                        case 2 -> {//Caso de busqueda por nombre
                            System.out.println("¿Cuál es el nombre del producto?");
                            String nombre = sc.nextLine();
                            nombre = nombre.toLowerCase();//El nombre lo pasamos a minusculas para buscar
                            
                            if(listaNombre.contains(nombre)){//Solo se busca en caso de que exista el array
                                
                                int indice = listaNombre.indexOf(nombre);
                                System.out.println(listaID.get(indice));
                                System.out.println(listaNombre.get(indice));
                                System.out.println(listaPrecio.get(indice));
                                System.out.println(listaCantidad.get(indice));
                                
                            }
                            else{
                                System.out.println("El nombre del producto no esta contenido"); 
                            }
                        }
                        default -> System.out.println("Esa respuesta no esta recogida"); //Solo si se reponde algo no recogido en los casos
                    }
                    break;
                }
                case 4 ->{//mostramos inventario
                    for(int i = 0; i < listaID.size(); i++){
                        System.out.println("ID: " + listaID.get(i) + " - Nombre: " + listaNombre.get(i) + " - Precio: " + listaPrecio.get(i) + " - Cantidad: " + listaCantidad.get(i));
                    }
                    break;
                }
                    
                case 5 -> {//Salimos del programa
                    System.out.println("Saliendo del programa.");

                    scNum.close();
                    sc.close();

                    System.exit(0);
                    break;
                }
            }    
         }
    }
}
