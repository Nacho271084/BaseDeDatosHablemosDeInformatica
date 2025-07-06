/*
 📝 Ejercicio: Registro de usuarios en archivo de texto
Objetivo:
Crear una aplicación en Java que permita al usuario registrar su nombre y edad, 
guardarlos en un archivo de texto y luego leer e imprimir el contenido del archivo.
🔧 Requisitos del ejercicio
Solicitar al usuario que introduzca su nombre y edad.
Guardar estos datos en un archivo llamado usuarios.txt.

Si el archivo no existe, debe crearse automáticamente.

Permitir agregar múltiples usuarios (uno tras otro).

Mostrar todo el contenido del archivo cada vez que se agregue un nuevo usuario.
 */
package com.mycompany.practicasjava04;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class TrabajoConArchivos {

    public static void main(String[] args) {
        
         String nombre;
        int edad;
        int semaforo = 0;
        File archivo = new File("usuarios.txt");

        Scanner sc = new Scanner(System.in);

        try {
            // Es una clase que permite escribir caracteres en un archivo. 
            // append hace que lo guarde de manera fija.
            FileWriter fw = new FileWriter(archivo, true);
            // agrega un búfer, que mejora el rendimiento al escribir grandes 
            // cantidades de texto (reduce los accesos al disco).
            BufferedWriter bw = new BufferedWriter(fw);
            // Permite escribir líneas completas de texto de forma sencilla.
            PrintWriter pw = new PrintWriter(bw);

            System.out.println("Introduce un número para continuar. "
                    + "Si quieres salir introduce el número 67");
            semaforo = sc.nextInt();

            while (semaforo != 67) {

                System.out.println("Introduce tu edad");
                edad = sc.nextInt();

                if (edad == 67) {
                    System.out.println("Saliendo del programa " + "Se ha pulsado el número 67");
                    break;
                }

                sc.nextLine(); // Consumir el salto de línea pendiente

                System.out.println("Introduce tu nombre");
                nombre = sc.nextLine();

                /* no imprime en pantalla, sino que guarda esa información en el 
                   archivo al que está conectado el PrintWriter */
                pw.println(nombre + " - " + edad + " años");

                // Mostrar el contenido actual del archivo después de cada ingreso
                System.out.println("Contenido actual del archivo: ");
                // sirve para leer texto desde un archivo de forma eficiente
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
                br.close();

                System.out.println("\nIntroduce otro número para continuar. "
                        + "Si quieres salir introduce el número 67");
                semaforo = sc.nextInt();
            }

            // Se cierra el flujo de escritura una vez fuera del bucle
            pw.close();

        } catch (Exception e) {
            System.out.println("Ocurrió un error al manejar el archivo: " + e.getMessage());
        }

        // Se cierra el Scanner al final del programa
        sc.close();
    }
}
