
package baseDeDatosMetodosSueltos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
Primero añadimos la dependecia en maven al fichero POM.
*/
public class InsertarUsuario {
   
    
 // Variable constante estatica de tipo String para Host, puerto, base de datos usada(debe existir)
 // Finalmente, tenemos el usuario y la contraseña de la cuenta de LOCALHOST.
    private static final String HOST = "localhost";         // IP o dominio del servidor MySQL
    private static final String PUERTO = "3306";            // Puerto (por defecto 3306)
    private static final String BASE_DATOS = "ejemplodb"; // Nombre de tu base de datos
    private static final String USUARIO = "root";           // Tu usuario de MySQL
    private static final String CONTRASEÑA = "1234";    
// Pasamos la URL completa con todos los valores anteriores. Usamos el método format para dar formato
// a la URL
    private static final String URL = String.format(
        "jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC",
        HOST, PUERTO, BASE_DATOS
    );
// Creamos un método que recibe el nombre y el correo, estos datos van directos a la base de datos.   
public static void insertarUsuarios(String nombre, String correo) throws SQLException
{
/* 1º hace que la consulta sea dinámica y parametrizada usando placeholders (?, ?). Luego, los 
    valores reales se asignan con.
 2º Usamos la clase de conexión para conectarnos a la base de datos, pasamos la URL, USUARIO y Contraseña.
 3º PreparedStatament permite enviar consultas parametrizados, usamos la conexión para accder y pasar la consulta.
 4º Tras añadir las llaves verás que salta un aviso, tendrás que añadir throw sqlException a la firma.
    */
String sql = "INSERT INTO usuarios (nombre, correo) VALUES (?, ?)";
try(Connection con = DriverManager.getConnection(URL, USUARIO,CONTRASEÑA);
    PreparedStatement stm = con.prepareStatement(sql))
        {
        // 1º Pasamos los datos para ello usamos la instancia creada con PreparedStatement.
        // 2º Asignamos los valores al insert anterior:
         stm.setString(1, nombre);
         stm.setString(2, correo);
         
         int filasInsertadas = stm.executeUpdate();
         
            if (filasInsertadas > 0) {
                System.out.println("El usuario ha sido insertado");
                
            }
            
        }catch (SQLException e)
                    {
                    System.out.println("Error de usuario" + e.getMessage());
                    
                    } 
        }
// Usamos el método y le pasamos los datos:
    public static void main(String[] args) throws SQLException {
        
        // Insertar un usuario con los mismo datos existente en la base de datos:
        // Recuerda, la base de datos debe existir y la tabla usuarios. No debes
        // pasar el ID de la columna, ya que es autoincremental.
        insertarUsuarios("Tere","Tere@gmail.com");
        
        
    }
}

    
    
    

