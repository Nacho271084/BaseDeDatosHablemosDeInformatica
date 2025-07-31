
package usoDelambda;

import java.util.ArrayList;
import java.util.List;

/**
Dada una lista de edades (List<Integer>), convierte cada número a una cadena de texto que diga:
"Edad: X años"
y muestra el resultado por pantalla usando map y forEach.
 */
public class ConvierteNumeroATexto {
    
    public static void main(String[] args) {
    // Creamos una lista de Integer llamada edades.
      List <Integer> edades = new ArrayList<>();
    // Añadimos los datos dentro de la lista.  
      edades.add(20);
      edades.add(25);
      edades.add(30);
      edades.add(35);
   // Convertir una lista a flujo de Stream de tipo Integer.
   
   edades.stream().
   // Convertir de integer a String
   map(edad -> "Edad " + edad + " años").
   // Iterar e imprimir los datos anteriores
   forEach(System.out::println);
        
    }
    
}
