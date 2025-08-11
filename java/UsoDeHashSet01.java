
package set;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 Crea un programa en Java que:
Pida al usuario una lista de números enteros (separados por espacios).
Los guarde en un HashSet para eliminar duplicados automáticamente.
Muestre:

Los números sin duplicados.
El número más grande.
El número más pequeño.
 */
public class UsoDeHashSet01 {
    
    public static void main(String[] args) {
        
      // Variable número de tipo String que almacenará una lista de números:
      
      String numero;
   
     // Añadimso la clase Scanner.
     
     Scanner sc = new Scanner(System.in);
     
     // Creamos el conjunto de tipo Integer llamado numeros.
     
     Set <Integer> numeros = new HashSet<>();
     
     // Pedimos el número y los almacenamos en una variable número:
        System.out.println("Por favor ingresa un número seguido de un espacio ej: 5 7 5 2 9");  
       numero = sc.nextLine();
     // Para cada número se añigna un separador con Split:
        for (String n : numero.split(" ")) {
          // Conversión de String a valor númerico de tipo Integer.
            try {
                numeros.add(Integer.parseInt(n));
            } catch (NumberFormatException e) {
                System.out.println("Error en la conversión....");
            }
            
        }
        System.out.println("Numeros sin duplicados: " + numeros); 
        System.out.println("----------------------------->");
        
        if (!numeros.isEmpty()) {
            
        
        // Devuelve el mínimo del conjunto:
        int minimo = Collections.min(numeros);
        System.out.println("El mínimo es: " + minimo);
        
        // Devuelve el máximo del conjunto:
        
        int maximo = Collections.max(numeros);
        System.out.println("El máximo es: " + maximo);
        }
    sc.close();
    
}}
