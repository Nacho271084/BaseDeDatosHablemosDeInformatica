/*
 ✍️ Ejercicio propuesto: Guardar usuarios en un fichero de texto
Objetivo:
Pedir al usuario que introduzca su nombre y edad varias veces, y 
guardar esa información en un archivo llamado usuarios.txt.
✅ Requisitos:
Pedir nombre y edad en bucle.
Si el usuario escribe "salir" como nombre, se termina el programa.
Cada línea en el archivo tendrá este formato:
Nombre: Juan, Edad: 25
Usaremos FileWriter y BufferedWriter.
 */
package com.mycompany.practicasjava04;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
public class TrabajoConArchivos02 { 
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
    
    int edad;
    String nombre;
    try
    (
     BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.txt",true)))
    {
        while (true) 
        {  
            System.out.println("Introduce tu nombre para ser almacenado o si lo prefieres salir");
            nombre = sc.nextLine();
           
            
            if (nombre.equalsIgnoreCase("salir")) 
            {
                System.out.println("Programa terminado. Saliendo.............");
                break;
            }
            
            System.out.println("Introduce tu edad para ser almacenado");
            
            
            if (sc.hasNextInt()) 
            {
                edad = sc.nextInt();
                sc.nextLine();
            }
            else
            {
                System.out.println("Edad no válida");
                continue;
            }
            
            // Guardar en el archivo
            bw.write("Nombre: " + nombre + ", Edad: " + edad);
            // Espacio.
            bw.newLine();
            System.out.println("usuario guardado con éxito");
            
        }
    
    
    
    }
    catch(IOException e)
    {
        System.out.println("Error al guardar el nombre de usuario" + e.getMessage());
    
    }
     
    
           sc.close();
    
    }
  
    }
  
    
    
    
    
    
    
