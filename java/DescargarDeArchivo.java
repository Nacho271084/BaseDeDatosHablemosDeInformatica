
package hilos;

/**
Ejercicio: Simular descarga de archivos en distintos hilos

Tendremos dos hilos, cada uno simula la descarga de un archivo.
Cada hilo imprimirá mensajes como: "Descargando archivo X... (progreso)", 
* con pausas de 500 milisegundos para simular que tarda un poco.
El bucle for irá hacia atras del 5 hasta llegar al cero.
Así vemos cómo varios procesos pueden ejecutarse al mismo tiempo.
 */
public class DescargarDeArchivo {
    
    public static void main(String[] args) {
        // Primer hilo llamado fichero Uno.
        // Para cada hilo se ejecuta un bucle for.
        // Sleep simula una pausa de 500 milisegundos con cada iteracción.
        // Si existe un error será capturado y lanzará un error.
        // Finalmente, se imprime el archivo ha sido descargado con éxito.
        Thread fichero_Uno = new Thread (() -> 
        {for (int i = 5; i >= 0; i--) 
        {
            System.out.println("Descargando el fichero 1....." + i + "#");  
        
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println("El archivo 1 ha sido descargado con éxito.....");
            
        });
        
        Thread fichero_Dos = new Thread(() -> 
        {
            for (int i = 5; i >= 0; i--) {
                System.out.println("Descargando el fichero 2....." + i + "#");
                
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
            System.out.println("El archivo 2 ha sido descargado con éxito.....");
        });

    fichero_Uno.start();
    fichero_Dos.start();
    
    // Si añadimos join(), el main espera y no continúa hasta que ese hilo haya terminado.
    
        try {
            fichero_Uno.join();
            fichero_Dos.join();
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    
    }
}

// salida:
//Descargando el fichero 1.....5#
//Descargando el fichero 2.....5#
//Descargando el fichero 2.....4#
//Descargando el fichero 1.....4#
//Descargando el fichero 2.....3#
//Descargando el fichero 1.....3#
//Descargando el fichero 2.....2#
//Descargando el fichero 1.....2#
//Descargando el fichero 2.....1#
//Descargando el fichero 1.....1#
//Descargando el fichero 2.....0#
//Descargando el fichero 1.....0#
//El archivo 2 ha sido descargado con éxito.....
//El archivo 1 ha sido descargado con éxito.....
