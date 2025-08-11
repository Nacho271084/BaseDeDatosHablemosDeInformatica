
package collections;

// En este ejercicio veremos como extraer el máximo y el mínimo de una lista de números con Collections.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximoYMinimoDeUnaLista {
    public static void main(String[] args) {
        
     //  Creamos una lista de números llamadas misNumeros:
     
     List <Integer> misNumeros = new ArrayList<>();
     
     // Almacenamos los números en la lista anterior:
     
     misNumeros.add(78);
     misNumeros.add(129);
     misNumeros.add(45);
     misNumeros.add(6);
     misNumeros.add(179);
     misNumeros.add(53);
     misNumeros.add(900);
     
     // Extraemos el máximo de la lista:
     
     int maximo = Collections.max(misNumeros);
     
        System.out.println("El máximo de la lista es el siguiente número: " + maximo);
     
     // Extraemos el mínimo de la lista:
        
     int minimo = Collections.min(misNumeros);
     
        System.out.println("El mínimo de la lista es el siguiente número: " + minimo);
        
    }
    
}
