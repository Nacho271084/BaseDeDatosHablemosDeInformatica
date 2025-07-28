
package ficheros;

import com.sun.source.tree.BreakTree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NuevoFicheroMainMasMetodo {
    public static void main(String[] args) {
        
    // Establecemos la ruta del fichero, 
    String fichero = "C:\\Users\\Nacho\\Documents\\nachoDos.java";
    // Llamaos al método y le pasamos la ruta creada en la línea anterior.
    // Recuerda que al ser un método estático no es necesario crear una instancia.
    // Envolvemos con Try Catch y la excepción es IOException, errores de lectura.
        try {
            crearArchivo(fichero);
        } catch (IOException ex) {
            Logger.getLogger(NuevoFicheroMainMasMetodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            // Imprimos el contenido del fichero, le pasamos el fichero al método estático:
            // Se mostrará en rojo el fichero, ya que pide envolver con Truy y catch.
            leerFichero(fichero);
        } catch (IOException ex) {
            Logger.getLogger(NuevoFicheroMainMasMetodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public static void crearArchivo(String nombre) throws IOException
    {
        if (nombre == null) {
            System.out.println("Archivo no válido.....Saliendo");
        }
        else{
    // crear archivo, recibirá la ruta del archivo.
    File archivo = new File(nombre);
    // Escribir en el archivo y saltará un aviso que nos pide añadir throws, declaramos un método
    // que lanza una excepción.
    // Para hacer algo distinto, envolvemos FileWrite con printWrite, nos permite utilizar los métodos 
    // Printfn, Println...
    PrintWriter escritorConMetodosPrint = new PrintWriter(new FileWriter(archivo));
    // Añadimos texto al fichero:
    escritorConMetodosPrint.write("Primera línea del texto.\n");
    escritorConMetodosPrint.append("Segunda línea de texto añadida.\n");
    // Añadimos mucho más texto para leerlo con el siguiente método.
    escritorConMetodosPrint.append("Lorem Ipsum is simply dummy text of the printing.\n"
            + "and typesetting industry. Lorem Ipsum has been the industry's standard dummy.\n"
            + "text ever since the 1500s, when an unknown printer took a galley of.\n"
            + "type and scrambled it to make a type specimen book. It has survived.\n"
            + " not only five centuries, but also the leap into electronic typesetting.\n"
            + "remaining essentially unchanged. It was popularised in the 1960s with\n"
            + "the release of Letraset sheets containing Lorem Ipsum passages.\n"
            + "and more recently with desktop publishing software like Aldus.\n"
            + "PageMaker including versions of Lorem Ipsum.\n");
    // Cerramos la clase File, de lo contrario el contenido no se añade:
    escritorConMetodosPrint.close();
    // Imprimos una línea confirmando la creación si todo ha ido bien.
    System.out.println(" 🗂️ Fichero creado con éxito 🗂️");
            System.out.println("-----------------------------");
        }   
    }
    
    public static void leerFichero(String fichero) throws FileNotFoundException, IOException
    {
    // Para leer caracteres usamos FileReader, tendremos que añadir filefoundException, por si el 
    // fichero no existe.
    FileReader leer = new FileReader(fichero);
    // Para una lectura mucho más eficiente usaremos BufferedReader que envuelve al anterior.
    BufferedReader lector = new BufferedReader(leer);
    // Creamos una variable línea, para almacenar el resultado del bucle.
    String linea;
    // Recorremos línea a línea, mientra exista texto, o lo que es lo mismo que no sea null.
    // Añadimos IOException, para manejar errores de lectura, se añade a la firma del método.
    while((linea = lector.readLine()) != null)
      {
          System.out.println(linea);
      }
    // Cerramos la clase BufferedReader:
    lector.close();
    
    }
    
}
