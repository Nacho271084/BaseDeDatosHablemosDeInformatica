package com.mycompany.menuinteractivo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
1º La opción uno agrega los elementos a una lista. 
2º Listará los elementos añadidos en la lista uno.
3º Marcará como completada o no la tarea.
4º Si has añadido tareas, puedes eliminarla.

Menú Interactivo de Gestión de Tareas
Funcionalidades del menú:
Agregar tarea
Listar tareas
Marcar tarea como completada
Eliminar tarea
Salir
 */
public class menuinteractivoSegundaOpcion {
    
 private Scanner sc = new Scanner(System.in);  
 private static List <String> tareas = new ArrayList<>();
 private final static String FICHERO_NOTAS = "archivoNotas.txt";
 private static boolean completada;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numero;
        int opcion = 0;
      
        do {            
            System.out.println("Menú Interactivo de Gestión de Tareas");
            System.out.println("----------------------------------------");
            System.out.println("1.Agregar tarea");
            System.out.println("2.Listar tareas");
            System.out.println("3.Marcar tarea como completada");
            System.out.println("4.Eliminar la tarea existente");
            System.out.println("5.Salir");
            
            if (sc.hasNextInt()) {
                
            
            
            // Recibimos un valor numérico en String
            numero = sc.nextLine();
            try {
                // Convertimos una cadena de texto y la transoformamos en un entero.
                opcion = Integer.parseInt(numero);
            } catch (NumberFormatException e) 
            {
                System.out.println("Debe proporcionar un valor numérico");
            }
           
            }
            // Menu de opciones con Switch
            
            switch (opcion) {
                case 1:
                    System.out.println("Agrega un nueva tarea");
                    String nuevaTarea = sc.nextLine();
                    tareas.add(nuevaTarea);
                    break;
                case 2:
                    System.out.println("Estas son tus tareas");
                    System.out.println("----------------------------");
                    mostrarTareas();
                    break;
                
                case 3:
                    System.out.println("Marcar tarea como completada");
                    marcarTareaCompletada();
                    break;
                
               case 4:
                    System.out.println("Eliminar tareas");
                    eliminarTarea ();
                    mostrarTareas();
                    break; 
                    
               case 5:
                    System.out.println("Saliendo del sistema.........");
                    break;
                
                default:
                    
            }      
        } while (opcion != 5);
     
  
    }
        private static void agregarTareaEnArchivo()
        {   //  Entre parentesis se declara los recursos que se van a cerrar automáticamente.
            try (
                PrintWriter file = new PrintWriter(new FileWriter (FICHERO_NOTAS));
                    ){
// Entre llaves Defines el bloque de instrucciones que se ejecutan con ese recurso (file) abierto.
                for (String tarea : tareas) {
                    file.println(tarea);
                }
            } catch (Exception e) 
            {
                System.out.println("Error al guardar las notas");
            }
        }

        private static void mostrarTareas ()
        {
            if (tareas.isEmpty()) 
            {
                System.out.println("La lista de tareas está vacia");  
            }
            else
            {
                for (String tarea : tareas) {
                    System.out.println("Estas son tus tareas: " + tarea);
                }
                
            }}
        
        private static void marcarTareaCompletada()
        {
            if (tareas.isEmpty()) 
            {
                completada = false;
            }
            else 
            {
            completada = true;
                System.out.println("Se han marcado las siguientes tareas");
                for (String tarea : tareas) 
                {
                  
                        System.out.println("Tarea: " + tarea + " " + completada);
 
                }
            }
        
        
        }
        
        private static void eliminarTarea ()
        {
            if (tareas.isEmpty()) 
            {
                System.out.println("No hay tareas para eliminar");
            }
            else 
            {
                for (int i = 0; i < tareas.size(); i++) 
                {
                    System.out.println("Eliminando tareas");
                    tareas.remove(i);
                }
                    
                }
            }
        
        
        }





        
      
