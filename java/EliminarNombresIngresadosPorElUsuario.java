
package usoDelambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
Filtrar por letra introducida por el usuario
📌 Objetivo:
Pedir al usuario que escriba una letra.

Eliminar los nombres que comienzan con esa letra.

Mostrar los resultados por consola.
 */
public class EliminarNombresIngresadosPorElUsuario {
    
    public static void main(String[] args) {
        
     // Añadimos una lista para almacenar los nombres:
     
     List <String> nombres = new ArrayList<>();
        
     // Usamos el método "add" este nos permite añadir el nombre a la lista.
     // Escribimos el nombre de la lista + el método y entre comillas dobles el nombre.
     
     nombres.add("Juan");
     nombres.add("Pepe");
     nombres.add("Lucia");
     nombres.add("Julia");
     nombres.add("Nacho");
        
     // Añadimos la clase Scanner.
     
     Scanner sc = new Scanner(System.in);
    
    // Imprimimos por consola que queremos que haga el usuario:
    
    System.out.println("Por favor ingrese una letra para poder borrar el nombre: ");
    
    // Pedimos la letra al usuario y la convertimos a minuscula, de este modo será True.
    
    String letra = sc.nextLine().toLowerCase();
     
    // Eliminamos los nombres que comienzan por la letra introducida por el usuario.
    // startsWith evalúa la condición: si el nombre comienza con la letra, 
    // entonces se aplica removeIf para eliminarlo.
    nombres.removeIf(n -> n.toLowerCase().startsWith(letra));
    
    // Imprimimos la lista completa actualizada:
    
    System.out.println("Estos son los nombres disponibles: ");
    
    // Recorrer la lista e imprimir el resultado:
    
    nombres.forEach(System.out::println);
    
    // Salida esperada:

//Por favor ingrese una letra para poder borrar el nombre: 
//p
//Estos son los nombres disponibles: 
//Juan
//Lucia
//Julia
//Nacho    
//        
        
        
    }
    
}
