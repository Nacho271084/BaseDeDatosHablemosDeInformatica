/*
Crea un programa en Java que:
Pregunte cuántas personas se van a registrar.
Para cada persona:
Pida su nombre.
Pida su(s) color(es) favorito(s), permitiendo añadir más de uno si quiere.
Guarde esta información en un Map<String, List<String>>.
Muestre al final todos los nombres con su lista de colores favoritos.
 */
package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class map05 {
    
    public static void main(String[] args) {
        
    // Variables con las que trabajaremos:
    String cantidadPersonas;
    int numeroPersonasRegistradas;
    String nombre;
    String coloresFavoritos;
    // importamos la clase scanner y asignamos a la variable sc
    Scanner sc = new Scanner(System.in);
    // Creamos un map con una lista de valores, esto permite asociar una clave a varios valores.
    // Una persona puede tener varios colores favoritos.
    Map <String, List<String>> personasColores = new HashMap<>();
    
    System.out.println("Cuántas personas se van a registrar: ");
    cantidadPersonas = sc.nextLine();
    // Si por algún moivo se introduce una letra, lanzará una excepción. 
   try{
    numeroPersonasRegistradas = Integer.parseInt(cantidadPersonas);
    // Mientras el número de personas es distinto a cero, se irá recorriendo el bucle.
        while (numeroPersonasRegistradas !=0) 
        { 
         // Pre-incremento del número de personas registradas.
         --numeroPersonasRegistradas;   
            System.out.println("Tu nombre es: ");
            nombre = sc.nextLine();
            // Si nombre está vacio se le lanzará un mensaje de nombre no válido.
            if (nombre.isBlank()) 
            {
                System.out.println("Introduce un nombre valido");
                break;   
            }
            
            else
            {
                System.out.println("Nombre añadido con exito");
            }
            List <String> colores = new ArrayList<>();
            // Si el nombre ha sido añadio con éxito, solicitará el color.
            System.out.println("Ingrese uno o varios colores: " + 
                    "Si quieres abandonar el programa, escribe salir");
            // La variable color es booleana inicializada como verdadera, 
            // si se introduce salir, cambia a false y se sale del bucle.
            Boolean color = true;
            // Mientras el color sea verdadero, se pedirá el color favorito.
            // Al mismo tiempo se añade a nuestra lista llamada colores.
            // Una vez añadidos los colores favoritos, se podría escribir la opción de salir 
            // y comenzará a solicitar el nombre del siguiente usuario.
          while (color) {                
    coloresFavoritos = sc.nextLine();

    if (coloresFavoritos.equalsIgnoreCase("salir")) {
        color = false;
    } else {
        colores.add(coloresFavoritos);
        System.out.println("¿Tienes algún otro color favorito? Escribe 'salir' si no.");
    }
}
             
       
     // Finalmente, se añade el nombre y su color o colores. Un nombre podría tener varios colores.
    personasColores.put(nombre, colores);  
    
    // Mostrar todos los nombres con su lista de colores favoritos
            System.out.println("Estas son las personas registradas y sus colores favoritos: ");
            // La variable entry representa un par clave valor dentro de un map. 
            for(Map.Entry<String, List<String>> entry : personasColores.entrySet()) 
            {
                System.out.println("Nombre: " + entry.getKey());
                System.out.println("colores favoritos: " + entry.getValue());
            }
    
    
    
    }
    
    //Cerramos la clase scanner.
    sc.close();
    // El error sera capturado y enviará un mensaje de formato incorrecto.
    }catch(NumberFormatException e)
    {
        System.out.println("Formato incorrecto");
    }
    }
    
}
/*
Cuántas personas se van a registrar: 
2
Tu nombre es: 
Juan
Nombre añadido con exito
Ingrese uno o varios colores: Si quieres abandonar el programa, escribe salir
Rojo
¿Tienes algún otro color favorito? Escribe 'salir' si no.
Verde
¿Tienes algún otro color favorito? Escribe 'salir' si no.
salir
Estas son las personas registradas y sus colores favoritos: 
Nombre: Juan
colores favoritos: [Rojo, Verde]
Tu nombre es: 
Pepe
Nombre añadido con exito
Ingrese uno o varios colores: Si quieres abandonar el programa, escribe salir
Amarillo
¿Tienes algún otro color favorito? Escribe 'salir' si no.
Negro
¿Tienes algún otro color favorito? Escribe 'salir' si no.
salir
Estas son las personas registradas y sus colores favoritos: 
Nombre: Juan
colores favoritos: [Rojo, Verde]
Nombre: Pepe
colores favoritos: [Amarillo, Negro]


*/