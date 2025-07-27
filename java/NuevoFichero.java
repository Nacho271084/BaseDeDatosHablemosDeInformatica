package ficheros;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
En este ejercicio tenemos dos clases, una que contiene el método para crear el archivo, y otra
donde crearemos una instancia con la ruta del archivo. Le pasamos la ruta del archivo donde lo creará.

 */
public class NuevoFichero {
  public static void crearArchivo(String nombre) throws IOException
    {
    // Creamos un archivo con la clase File, y le pasaremos el nombre por parametro, la ruta completa.
    File archivo = new File(nombre);
    // Para añadir texto en el fiechro usaremos FileWriter,permite escribir caracteres en el fichero.
    // Marca un error la siguiente línea, nos obliga a importar y capturar el error.
    // Tenemos que tener en cuenta que se podría productir un error de lectura y escritura en el fichero.
    FileWriter escritor = new FileWriter(archivo,true); // True evita que se borre el contenido anterior.
    // Añadir texto al archivo, si colocamos un punto podemos añadir más texto.
    escritor.write("Estoy aprendiendo Java\n");
    escritor.append("Y otros lenguajes.\n");
            
    // Mensaje de confirmación de que se ha creado, no garantiza la creación, pero por lo menos
    // vemos que todo ha ido bien.
    // Cerramos la clase Filewriter, de lo contrario no se añade el texto.
    escritor.close();

    System.out.println("Fichero creado con exito en la carpeta documentos del disco C:");
    }
}
