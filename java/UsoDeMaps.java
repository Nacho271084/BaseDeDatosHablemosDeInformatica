package com.mycompany.usodemaps;

import java.util.HashMap;
import java.util.Map;

/*
Ejercicio: Contar palabras en una frase usando Map
Enunciado:
Escribe un programa en Java que cuente cuántas veces aparece cada palabra en una frase. Usa un Map<String, Integer> para almacenar las palabras como clave y su número de apariciones como valor.
Ejemplo de entrada:

"hola mundo hola java mundo"
Salida esperada:

hola: 2
mundo: 2
java: 1
*/

public class UsoDeMaps {

    public static void main(String[] args) {

        /*
         * 1º Creamos una cadena de texto llamada 'frase' con el contenido "hola mundo hola java mundo".
         *    La usaremos para contar cuántas veces aparece cada palabra.
         * 2º Creamos un array llamado 'palabras' usando el método split() de la clase String,
         *    que separa la frase por los espacios.
         */
        String frase = "hola mundo hola java mundo";   
        String[] palabras = frase.split(" ");

        /*
         * 3º Creamos un Map llamado 'contador' con tipo String como clave (la palabra)
         *    e Integer como valor (número de veces que aparece).
         *    Usamos HashMap porque es una implementación común de la interfaz Map.
         */
        Map<String, Integer> contador = new HashMap<>();

        /*
         * Primer for: recorremos el array 'palabras'.
         *    Si la palabra ya existe en el mapa (containsKey), le sumamos 1.
         *    Si no existe, la añadimos con valor inicial 1.
         */
        for (String palabra : palabras) {
            if (contador.containsKey(palabra)) {
                contador.put(palabra, contador.get(palabra) + 1);
            } else {
                contador.put(palabra, 1);
            }
        }

        /*
         * Segundo for: recorremos el conjunto de claves del Map usando keySet().
         *    Cada clave representa una palabra distinta encontrada en la frase.
         *    Mostramos por pantalla cuántas veces aparece cada palabra.
         */
        for (String palabra : contador.keySet()) {
            System.out.println(palabra + ": " + contador.get(palabra));   
        }
    }
}

