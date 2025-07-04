package com.mycompany.menuinteractivo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
1º La opción uno agrega los elementos a una lista. 
2º Listará los elementos añadidos en la lista uno.
3º Tras añadir tareas, marcará como completada o no la tarea.
4º Si has añadido tareas, puedes eliminarla.

Menú Interactivo de Gestión de Tareas
Funcionalidades del menú:
Agregar tarea
Listar tareas
Marcar tarea como completada
Eliminar tarea
Salir
*/
public class MenuInteractivo {

public static void main(String[] args) {
    
List<String> tareas = new ArrayList<>();
List<Boolean> completadas = new ArrayList<>();
Scanner sc = new Scanner(System.in);
int opcionSwich;
   
do {        

 // MENÚ DE IMPRESIÓN:       
        System.out.println("Menú interactivo");
        System.out.println("--------------------");
        System.out.println("1.Agregar tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Marcar tareas como completadas");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
        System.out.println("Introduce un numero entero");

 while (!sc.hasNextInt()) {
                System.out.print("Por favor, introduce un número válido: ");
                sc.next();
            }
    
// PEDIR DATOS AL USUARIO:

  
    opcionSwich = sc.nextInt();
    sc.nextLine(); // Limpiar el buffer
    
 // MENÚ DE OPCIONES CON SWICTH:     
        
    switch (opcionSwich) {
        case 1:
            System.out.println("Introduce la nueva tarea");
            String nuevaTarea = sc.nextLine();
            tareas.add(nuevaTarea);
            System.out.println("Tarea agregada: " + nuevaTarea);
            break;

            case 2: // Recuerda que para usar la opción de 2 es necesario agregar tareas en la 1
                System.out.println("Listar tareas");
                if (tareas.isEmpty()) 
                {
                    System.out.println("No hay tareas en este momento");
                }
                else{
                for (int i = 0; i < tareas.size(); i++) 
                {
                    // Imprimimos las tareas agregadas:
                    
                    System.out.println((i+1) + "." + "" + tareas.get(i));
                }
                }

                break;
            case 3: 
                System.out.println("Introduce el numero de la tarea a marcar como completada");
                // Variable a completar, el valor insertado menos uno.
                int indiceCompletar = sc.nextInt() -1;
                
                if (indiceCompletar >= 0 && indiceCompletar < tareas.size() ) 
                {   // Marca la tarea como no completada
                    completadas.add(false);
                    //  Marca la tarea como completada
                    completadas.set(indiceCompletar, Boolean.TRUE);
                    System.out.println("Tarea marcada como completada");
                }
                else 
                {
                    System.out.println("Tarea invalida");
                }
                break;
            case 4:
                System.out.println("Introduce el numero de la tarea a eliminar");
                int indiceEliminar = sc.nextInt()-1;
                if (indiceEliminar >= 0 && indiceEliminar < tareas.size()) 
                {
                    System.out.println("Tarea eliminada" + tareas.get(indiceEliminar));
                    // Elimina la tarea con el indice especificado.
                    tareas.remove(indiceEliminar);
                    // Elimina la tarea completada con el indice especificado.
                    completadas.remove(indiceEliminar);
                }
                
                break;
            case 5:
                System.out.println("Saliendo del programa");
                
            default:
                System.out.println("Se ha salido correctamente del sistema");
        }
        
    } while(opcionSwich != 5);
    
    
    }}



