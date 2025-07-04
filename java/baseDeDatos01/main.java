
import java.sql.SQLException;
import java.util.Scanner;


public class main {
    
    public static void main(String[] args) throws SQLException {
        
    UsuarioDAO dao = new  UsuarioDAO();
    Scanner sc = new Scanner(System.in);
    
        System.out.println("Introduce un nombre: ");
        String nombre = sc.nextLine();
        
        System.out.println("Introduce el correo");
        String correo = sc.nextLine();
        
        Usuario nuevoUsuario = new Usuario(nombre, correo);
        dao.insertarUsuario(nuevoUsuario);
        
        System.out.println("Lista de usuarios: ");
        for (Usuario u: dao.listarUsuarios()) {
            System.out.println(u.getId() + "-" + u.getNombre() + "-" + u.getCorreo());
        }
        sc.close();
    
        
        
        
    }
    
}
