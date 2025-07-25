package com.mycompany.practicasjava04;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Ejercicio: Leer y mostrar usuarios desde un archivoyaCreado
Objetivo:
Leer el contenido de un archivo llamado usuarios.txt (creado en el ejercicio anterior) 
y mostrar cada línea por pantalla
✅ Requisitos:
Usar BufferedReader para leer línea por línea.
Mostrar cada línea con numeración.
Si el archivo no existe, mostrar un mensaje de error.
 */
public class LeerYmotrarUsuariosDesdeunArchivo {
    public static void main(String[] args) {
        
    String archivo = "usuarios.txt";
    int contador = 0;
   try(BufferedReader lectura = new BufferedReader(new FileReader(archivo)))
            {
            String linea;
            /* Guarda en la variable linea el resultado de 
            leer una línea del archivo, y continúa haciéndolo 
            mientras esa línea no sea null (es decir, mientras 
            no se haya llegado al final del archivo).*/
            while((linea = lectura.readLine()) != null)
            {
                
                System.out.println(contador + "." + linea);
                contador++;
            
            }
            
                if (contador == 1) 
                {
                    System.out.println("El archivo está vacio");
                }
            
            }
      catch(IOException e)
      {
          System.out.println("Problema de lectura del archivo" + e.getMessage());
      }
    
            }
}
// Ejemplo de salida:
// Nombre: Ana, Edad: 30
// Nombre: Luis, Edad: 22