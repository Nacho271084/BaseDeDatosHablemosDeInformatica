package usoDelambda;

import java.util.ArrayList;
import java.util.List;

// En este ejercicio creamos una lista y añadimos elementos a ella.
// Luego la transformamos en un Stream para usar funciones y referencias a métodos.
public class ConvertirAMayuscula {
    
    public static void main(String[] args) {
        // Creamos la lista nombres, que usaremos para almacenar nombres.
        List<String> nombres = new ArrayList<>();
        
        // Añadimos los datos:
        nombres.add("julia");
        nombres.add("nacho");
        nombres.add("julio");
        
        // Convertimos la lista a un Stream de tipo String.
        // Stream permite operar sobre los datos de forma funcional.
        nombres.stream() // crea un Stream de Strings
            // El método map aplica una función a cada elemento del Stream.
            // En este caso, convierte cada nombre a mayúsculas usando una referencia a método.
            .map(String::toUpperCase) // convierte cada nombre a mayúsculas
            // El método forEach permite realizar una acción para cada elemento.
            // Aquí imprimimos cada elemento en mayúsculas.
            .forEach(System.out::println);
        
        // Resultado esperado:
        // JULIA
        // NACHO
        // JULIO
    }
}
