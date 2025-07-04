
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {

    public void insertarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, correo) VALUES (?, ?)";
//prepara una consulta precompilada, es decir, 
   // crea un objeto PreparedStatement 
   //  a partir del texto SQL que definiste antes (sql)
   //  , pero aún no la ejecuta. 
        try (Connection conn = ConexionMySQL.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());

            int filas = stmt.executeUpdate(); // ✅ CORREGIDO AQUÍ

            if (filas > 0) {
                System.out.println("Usuario insertado correctamente.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Usuario> listarUsuarios() throws SQLException {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = ConexionMySQL.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo")
                );
                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}