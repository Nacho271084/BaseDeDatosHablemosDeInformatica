
package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
Ejercicio con Map: Notas de estudiantes con Scanner
Objetivo:
Crear un programa en Java que utilice un Map para almacenar los nombres de estudiantes y 
* sus calificaciones. El programa deberá:
Pedir al usuario cuántos estudiantes desea registrar.
Solicitar el nombre y la nota de cada estudiante.
Guardar esa información en un Map<String, Integer>.
Mostrar el listado de estudiantes con sus notas.
Calcular y mostrar la media de las notas.
Mostrar el nombre del estudiante con la nota más alta.
Mostrar el nombre del estudiante con la nota más baja.
 */
public class map03 {
    public static void main(String[] args) {
    // variable contadorEstudiantes
    int contadorEstudiantes;
    // Valores usados para el map
    String nombre;
    int nota;
    // Valores usados para el for
    int not = 0; 
    int suma = 0;
    // Valores usados para el if
    // Inicializamos con el valor más bajo posible.
    // Si encontramos una nota mayor, se asignará como nueva nota máxima. -2_147_483_648
    int notaMaximaDelAlumno = Integer.MIN_VALUE;
     // Inicializamos con el valor más alto posible.
    // Si encontramos una nota menor, se asignará como nueva nota minima. 2_147_483_647
    int notaMinimoDelAlumno = Integer.MAX_VALUE;
    // Ver dentro del if el estudiante más listo y el menos listo
    String masListo = "";
    String menosListo = "";
    
    // Creamos la variable Scanner e importamos sus clase. De este modo accedemos a sus métodos.   
    Scanner sc = new Scanner(System.in);
    // Creamos el map para almacenar el nombre del estudiante y la nota.
    // Recuerda map es una interfaz, no se puede implementar directamente, usaremos su implementación
    // HashMap.
    Map <String, Integer> datosEstudiante = new HashMap<>();
    // Preguntamos cuanto estudiantes desean registrar:   
    System.out.println("Cuantos estudiantes deseas registrar");
    // Guardamos el número de estudiantes en la variable contadorEstudiantes.
    contadorEstudiantes = sc.nextInt();
    // Limpiamos el buffer de entrada.
    sc.nextLine(); 
    
    /* usamos While para establecer el número de estudiantes que se insertarán mientras
    El contador sea distinto a cero. Si ingresas 2 por ejemplo, debería de pedir dos veces 
    el nombre y la nota y finalizará. */
        while (contadorEstudiantes != 0) {            
    // Predecremento, cada vuelta resta un estudiante del contador.
        --contadorEstudiantes;
    // Pedimos la nota y luego el nombre del estudiante.
        System.out.println("Ingese su nota: ");
        nota = sc.nextInt();
        
        
        sc.nextLine();
        
        System.out.println("Ingrese su nombre: ");
        nombre = sc.nextLine();
     // Guardamos los datos del estudiante en el map
     
        datosEstudiante.put(nombre, nota);
     
        }
        System.out.println("Listado de estudiantes y sus notas: ");
        // keySet() que devuelve todas las claves (es decir, los nombres de los estudiantes.
            for (String estudiante: datosEstudiante.keySet()) 
            {
            // Guardamos en la variable local la nota del estudiante, obtenida del map.
                not = datosEstudiante.get(estudiante);
            // Mostrar el listado de estudiantes con sus notas.
                System.out.println("Nombre del estudiante: " + estudiante + " tiene una nota de: " + not);
            // Suma todas las notas ingresas:
                suma += not;
        
            
        // Verificamos si la nota del estudiante es la mayor, si es así, se almacena.
          if (not > notaMaximaDelAlumno) 
          {
            // asigna la nota del estudiante a la nota máxima siempre y cuando sea la mayor.
            notaMaximaDelAlumno = not;
            // Asigna la clave nombre almacenada en estudiante "For" a la variable String masListo
            masListo = estudiante;
        }
          // Comprueba si el valor es el menor al anterior.
          
          if (not < notaMinimoDelAlumno) 
          {
            notaMinimoDelAlumno = not;
            // Asigna la clave nombre almacena en estudiante "For" a la variable String menosListo
            menosListo = estudiante;
        }
            }
     
        
        // Calcular y mostrar la media de las notas, casteamos el resultado.
        double media = (double)suma / datosEstudiante.size();
        System.out.println( "la media es: " + media);
        
        // Mostrar el nombre del estudiante con la nota más alta.
        
        System.out.println("El estudiante con la nota más alta es: " + masListo);
        
        
        // Mostrar el nombre del estudiante con la nota más baja.
    
        System.out.println("El estudiante con la nota más baja es: " + menosListo);
            
            
    // Cerramos la clase scanner.
        sc.close();
    
    
    }
}
