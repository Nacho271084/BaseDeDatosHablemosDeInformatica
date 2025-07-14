package map;

import java.util.HashMap;
import java.util.Map;

/*
Ejercicio: Guardar y mostrar capitales de países
Objetivo: Crear un Map con algunos países y sus capitales, y luego mostrar el contenido.

Salida esperada:

La capital de España es Madrid  
La capital de Francia es París  
La capital de Italia es Roma  
La capital de Alemania es Berlín
*/

public class map02 {

    public static void main(String[] args) {

        // Creamos el Map llamado 'capital' con claves tipo String (países) y valores tipo String (capitales).
        // Usamos HashMap, que es una implementación de la interfaz Map.
        Map<String, String> capital = new HashMap<>();

        // Añadimos países como clave y sus capitales como valor.
        capital.put("España", "Madrid");
        capital.put("Francia", "París");
        capital.put("Italia", "Roma");
        capital.put("Alemania", "Berlín");

        /*
         * Recorremos el Map usando un for-each sobre capital.keySet(),
         * que devuelve todas las claves (es decir, los nombres de los países).
         * Para cada país, usamos capital.get(pais) para obtener su capital.
         */
        for (String pais : capital.keySet()) {
            System.out.println("La capital de " + pais + " es " + capital.get(pais));
        }
    }
}