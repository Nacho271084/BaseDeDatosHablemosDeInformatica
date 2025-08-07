
package baseDeDatosMetodosSueltos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultarUsuario {
    
    // Creamos las variables con los datos de la base de datos. 
    // Debemos crear la base de datos antes con el usuario y la contraseña.
    
    private static final String HOST = "localhost";
    private static final String PUERTO = "3306";
    private static final String BASE_DATOS = "ejemplodb";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "1234";
    
    // Montamos la URL con todo los datos anteriores:
    private static final String URL = String.format(
        "jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC",
        HOST, PUERTO, BASE_DATOS);
    
    
    // Este método recibe un entero, el id con el que confirmamos dentro de la consulta.
    // 1º Conexión a la base de datos y le pasamos la URL Preformateada de la conexión.
    // 2º Mandamos la consulta a la base de datos con PreparedStatement, usamos cuando es con parametros.
    // 3º Añadimos a la firma Throws SQLException.
    // 4º Asignamos el valor a la consulta.
    // 5º Vemos el resultado, para ello ejecutamos la consulta:
    // 6º Tras ejecutar la consulta, obtenemos el resultado. 
    public static void leerUsuario(int id) throws SQLException
    {
    
    String sql = "SELECT nombre FROM usuarios WHERE id = ?"; 
    try(Connection conexion = DriverManager.getConnection(URL, USUARIO,CONTRASEÑA);
        PreparedStatement envioConsulta = conexion.prepareStatement(sql))
    {
    
    envioConsulta.setInt(1, id); 
    
    
    // 7º ExecuteQuery ejecuta la consulta y devuelve el resulset.
    try(ResultSet resultadoConsulta = envioConsulta.executeQuery())
            {
                if (resultadoConsulta.next()) 
                {
                    // 8º Obtenemos el nombre.
                    String nombre = resultadoConsulta.getString("nombre");
                    System.out.println("El nombre asociado al ID es: " + nombre);
                }
                // 9º En caso de no existir el ID que le hemos pasado, lanzará un error.
                else{System.out.println("No hay usuarios con el ID reflejado. " + id);}
            }
        }
    
    }
    public static void main(String[] args) {
        // 10º Llamamos al método, ya que es estático no es necesario crear una instancia.
        // 11º Envolvemos con un bloque try catch.
        try {
            leerUsuario(5);
        } catch (Exception e) 
        {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
        } }}

