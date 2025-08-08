package baseDeDatosMetodosSueltos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Antes de comenzar: Crear una base de datos llamada ejemplodb y una tabla usuario.
 1º Asignar los datos a las variables y establecer conexion a la base de datos.
 */
public class ActualizarUsuario {
    
    private static final String HOST = "localhost";
    private static final String PUERTO = "3306";
    private static final String BASE_DATOS = "ejemplodb";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "1234";
    
    private static final String URL = String.format(
        "jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC",
        HOST, PUERTO, BASE_DATOS);
    
    // ¿Qué hace este método? Permite actualizar un usuario en función de un ID recibido, cambiamos 
    // el nombre recibido como parametro.
    
    // Añadimos la clausula Throws SQLException a la firma del método.
    
    
    // Obtenemos los datos o el resultado de la consulta.
    public static void updateUsuario(int id, String nombre) throws SQLException        
    {
     // Añadimos la consulta SQL que permite actulizar los datos.
     String consultaUpdate = "UPDATE usuarios SET nombre = ? WHERE id = ?";
    // Ejecutar UPDATE
    // Establecemos conexión a la base de datos con la clase Connection. Metemos todo dentro de try.
    // Mandamos la consulta a la base de datos con PreparedStatement.
    try(Connection conexionBaseDeDatos = DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
     PreparedStatement enviarConsulta = conexionBaseDeDatos.prepareStatement(consultaUpdate))
    {
    // Asignamos los valores a los parametros.
    enviarConsulta.setString(1, nombre);// El orden coincide con los parámetros
    enviarConsulta.setInt(2, id);
    enviarConsulta.executeUpdate(); // Ejecutar la actualización
    // Validar si la actualización ha tenido efecto
    // Puedes usar el valor devuelto por executeUpdate() para saber si algún registro fue actualizado:

    int filasAfectadas = enviarConsulta.executeUpdate();
    if (filasAfectadas > 0) {
    System.out.println("Datos actualizados con éxito------> ");
    System.out.println("El nombre recibido es: " + nombre + " El ID recibido es: " + id);
    } else {
    System.out.println("No se encontró ningún usuario con el ID: " + id);
    }
    }}
    
    public static void main(String[] args) {
        try {
            updateUsuario(2, "Juan");
            
        } catch (SQLException e) {
            System.err.println("Error al leer los datos: " + e.getMessage());
        }
    }
}
        
    
    

