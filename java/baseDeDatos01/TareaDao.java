
import com.mycompany.trabandoconbasededatos.conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TareaDao {
    
    public void insertarTarea(Tarea tarea)
    {
    String sql = "INSERT INTO tareas(descripcion) values(?)";
    
    try(Connection conn = ConexionMySQL.obtenerConexion();
    PreparedStatement stmt = conn.prepareStatement(sql))
    {
    stmt.setString(1, tarea.getDescripcion());
    stmt.executeUpdate();
    System.out.println("Tarea guardada con éxito");   
    
    }catch(SQLException e){e.printStackTrace();}
    
    
    }
    
   public ArrayList<Tarea> listarTareas(){ 
   
   ArrayList<Tarea> lista = new ArrayList<>();

    String sql = "Select * from tareas";
  
    try(Connection conn = ConexionMySQL.obtenerConexion();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)
            )
    {
        while (rs.next()) {            
            Tarea t = new Tarea(rs.getInt("id"),rs.getString("descripcion"));
            lista.add(t);
        }
           
    }catch(SQLException e){e.printStackTrace();}
    
     return lista;
    
            }
}
    
    
    

    
    
    
    
    

