
package ficheros;
import java.io.IOException;

public class ProgramNuevoFichero {
    
    public static void main(String[] args) {
        // ruta completa del archivo, en caso de no existir lo creará. Mi ruta seleccionada es 
        // documentos y el nombre por ejemplo nacho.java
        String nombre = "C:\\Users\\Nacho\\Documents\\nacho.java";
        // Creamos una instancia de la de archivo para comenzar a usar.
        NuevoFichero archivo = new NuevoFichero();
       // Usamos el método para crear el archivo, le pasamos la ruta donde debe crearlo.
       // Encapsulamos con un try catch por si hay errores de lectura y queremos capturarlos.
        try {
            archivo.crearArchivo(nombre);
        } catch (IOException e) 
        {
            System.out.println("Error al crear el fichero " + e.getMessage());
        }
       
       
       // Tras ejecutar esta clase main, debemos tener un fichero creado en documentos, si 
       // salta un error es que la ruta está mal escrita.
       
       
       
       
       // Salida deseada:
       // Fichero creado con exito en la carpeta documentos del disco C:
       
    }
    
}
