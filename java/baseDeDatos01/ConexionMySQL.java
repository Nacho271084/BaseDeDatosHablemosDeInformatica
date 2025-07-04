
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    
        // PERSONALIZA ESTOS VALORES SEGÚN TU CONFIGURACIÓN:
    private static final String HOST = "localhost";         // IP o dominio del servidor MySQL
    private static final String PUERTO = "3306";            // Puerto (por defecto 3306)
    private static final String BASE_DATOS = "ejemploDB"; // Nombre de tu base de datos
    private static final String USUARIO = "root";           // Tu usuario de MySQL
    private static final String CONTRASEÑA = "1234";            // Tu contraseña de MySQL

    // 🔗 Construcción dinámica de la URL de conexión
    private static final String URL = String.format(
        "jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC",
        HOST, PUERTO, BASE_DATOS
    );

    // ✅ Método para obtener la conexión
    public static Connection obtenerConexion() {
        try {
            // Cargar el driver (opcional en versiones modernas)
       
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Crear la conexión y le pasamos los datos 'Variables'
            Connection conexion = DriverManager.getConnection
        (URL, USUARIO, CONTRASEÑA);
            // Si todo ha ido bien se lanza un mensaje de conexión establecida
            System.out.println("✅ Conexión establecida correctamente.");
            return conexion;
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver JDBC no encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos:");
            e.printStackTrace();
        }
        return null;
    }

    // 🛑 Método para cerrar la conexión
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("🔒 Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("⚠️ Error al cerrar la conexión:");
                e.printStackTrace();
            }
        }
    }
    }

