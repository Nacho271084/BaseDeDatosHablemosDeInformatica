
package usoDelambda;

import java.util.ArrayList;
import java.util.List;

/**
Filtrar una lista de nombres usando Lambdas

Filtrar una lista de nombres para obtener solo aquellos que comienzan con una 
* letra específica por ejemplo S, 
* usando una expresión lambda y Stream.
 */
public class FiltrarNombresQueEmpiezan {
    
    public static void main(String[] args) {
    // Creamos la lista de tipo String donde añadir todos los nombres:    
    List <String> nombres = new ArrayList<>();
    
    // Comenzamos añadiendo los nombres a la lista creada en el paso anterior.

    nombres.add("Natalia");
    nombres.add("Nacho");
    nombres.add("Santi");
    nombres.add("Faustina");
    
 // Convertimos la lista de tipo String a un Stream de tipo String para trabajar con funciones.
// Lo leemos de la siguiente forma: Para cada nombre, filtrar los que comienzan por la letra "S".
// Finalmente, imprimimos el resultado utilizando una referencia a método.
        System.out.println("Nombres que comienzan por s"); 
    nombres.stream().filter(nombre -> nombre.startsWith("S")).forEach(System.out::println);
           
    }
    
   // Salida esperada:Santi 
}
