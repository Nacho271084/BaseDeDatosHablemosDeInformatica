
package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
Crear un programa que pida al usuario el nombre de varias personas y su color favorito. Guardar esta información en un Map<String, String> y luego mostrar los resultados.

📝 Enunciado:
Crea un programa en Java que haga lo siguiente:
Pregunte cuántas personas se van a registrar.
Para cada persona, pide el nombre y su color favorito.
Guarda esa información en un Map<String, String>.
Muestra al final todos los nombres con su color favorito.
 */
public class map04 {
    
    public static void main(String[] args) {
        
   Scanner sc = new Scanner(System.in);
   // Variables usadas:
   String nombre;
   String personasAregistrar;
   int personasRegistradas;
   String colorFavorito;
   Map <String, String> personaColor = new HashMap<>();
        
   System.out.println("¿Cuantas personas se van a registrar?"); 
   personasAregistrar = sc.nextLine();
        try {
   personasRegistradas = Integer.parseInt(personasAregistrar);
        // Mientras el número de personas registrada es distinto a cero, irá iterando. 
        
        while (personasRegistradas != 0) 
        {
        // Pre-decremento, cada vuelta restará una.
        --personasRegistradas;
        System.out.println("Introduce el nombre de la persona: ");
        // Pedimos el nombre a la persona con la clase scanner.
        nombre = sc.nextLine();
        
        System.out.println("Introduce su color favorito: ");
        // Pedimos el color favorito, el cual se almacenará en el map.
        colorFavorito = sc.nextLine();
        personaColor.put(nombre, colorFavorito);
       
        }
        // Devuelve las claves del map llamado personaColor, en concreto el nombre
        System.out.println("Colores favoritos registrados en este momento");
        for (String vnombre : personaColor.keySet()) 
        {
        // Imprime la clave nombre y el valor colorFavorito, estos se han guardado en un map.
            System.out.println(vnombre + "->"+ personaColor.get(vnombre));  
        }
        
    } catch (NumberFormatException e) 
        {
            System.out.println("Error debes introducir un número válido");
        }
   // Cerramos la clase scanner:
   sc.close();
    }
    
}
