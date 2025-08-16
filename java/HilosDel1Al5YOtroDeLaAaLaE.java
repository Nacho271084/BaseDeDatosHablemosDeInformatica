
package hilos;

/**
Vamos a hacer un programa que cree dos hilos:
Uno imprime números del 1 al 5. Bucle For que recorre del 1 al 5.
Otro imprime las letras de la A a la H.
Así verás cómo se ejecutan de forma intercalada 
* (dependiendo del planificador de hilos del sistema).
 */
public class HilosDel1Al5YOtroDeLaAaLaE {
       // Creamos una instancia de la clase Thread. 
       // El primer bucle imprime números del 1 al 5.
       // El segundo bucle imprime letras de la A a la E.
       // utilizamos Lambdas para decir para este hilo haz un bucle de números o letras.
       // Cada hilo ejecuta su propio bucle.
       // Con Thread se establece una parada de 500 milisegundos con cada iteracción.
       // Si ocurre un error, se captura con la clase InterruptedException.
    // Finalmente, se van mezclando los hilos según las interrupciones de la CPU.
    // El objetivo es entender la concurrencia o la ejecución de varios casos a la vez.
       
  public static void main(String[] args) {

        // Primer hilo: imprime números del 1 al 5 con pausas de 500 ms
        // “Para este nuevo hilo, ejecuta este bloque de código”.
        // En tu caso, el bloque de código es un bucle que imprime resultados.
        Thread hiloDeNumeros = new Thread(() -> { 
            for (int i = 1; i <= 5; i++) {
                System.out.println("El número es: " + i);
                try { 
                    Thread.sleep(500); // Pausa de 500 ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Segundo hilo: imprime letras de la A a la E con pausas de 500 ms
        Thread hiloDeLetras = new Thread(() -> { 
            for (char i = 'A'; i <= 'E'; i++) {
                System.out.println("Letra: " + i);
                try {
                    Thread.sleep(500); // Pausa de 500 ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Iniciamos ambos hilos
        hiloDeNumeros.start();
        hiloDeLetras.start();
    }
}
    
// SOLUCIÓN:
//Letra: A
//El número es: 1
//Letra: B
//El número es: 2
//El número es: 3
//Letra: C
//Letra: D
//El número es: 4
//Letra: E
//El número es: 5

    
    
    

