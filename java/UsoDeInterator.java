package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
Tienes una lista de nombres de personas. Algunos 
* nombres empiezan por la letra "A". Queremos recorrer la 
* lista con un Iterator y eliminar todos los nombres que 
* empiecen por "A", y luego imprimir la lista resultante.
👉 Requisitos:
Usa ArrayList<String>.
Usa Iterator para eliminar los nombres que comienzan por "A".
Imprime la lista final después de eliminar.
 */
public class UsoDeInterator {
    
    public static void main(String[] args) {
        // Variable para almacenar el nombre;
        
        String nombre;
        
        // Variable para letra:
        
        String letra;
        
     // Creamos la lista de tipo String para almacenar los nombres.
     
        List <String> nombres = new ArrayList<>();
     
     // Añadimos la clase Scanner:
     
     Scanner sc = new Scanner(System.in);
     
     // Pedimos los nombres al usuario:
        System.out.println("Introduce los nombres que quieres añadir: ");
     // Asignamos cada nombre a la variable creada:
        nombre = sc.nextLine();
     // Mientras que el nombre sea distinto a salir se irá pdiendo un nuevo nombre.
        while (!nombre.equalsIgnoreCase("salir")) 
        {
        System.out.println("Introduce el siguiente nombre o escribe salir");
     // Se añade el nombre a la lista creada.
        nombres.add(nombre);
     // Se pide de nuevo el nombre.
        nombre = sc.nextLine();
        }
     // Se imprime cada valor de la lista mientras existan valores   
        for (int i = 0; i < nombres.size(); i++) 
        {
            System.out.println("Nombre: " + nombres.get(i)); 
        }
     // Usaremos Iterator para eliminar nombres mientras recorremos la lista:
     
     Iterator <String> it = nombres.iterator();
        System.out.println("Borraremos los nombres que comienzan por la letra ingresada: ");
        System.out.println("Ingrese una letra: ");
        letra = sc.nextLine();
        
        while (it.hasNext()) {
            
            String nombreLocal = it.next();
        // La variable nombrelocal verifica si está en minúscula y si empieza por la letra recibida en minúscula.
        // Si el nombre empieza la letra insertada, se eliminará.
            if (nombreLocal.toLowerCase().startsWith(letra.toLowerCase())) {
            // Elimina mientras recorre los datos.
            it.remove();
                    
            } 
        }
        // Imprimir la lista final después de eliminar
        System.out.println("Lista después de eliminar los nombres:");
        for (String nom : nombres) {
         System.out.println("Nombre: " + nom);
        }
             
        
         
     sc.close();
        
        
        
    }
    
}
