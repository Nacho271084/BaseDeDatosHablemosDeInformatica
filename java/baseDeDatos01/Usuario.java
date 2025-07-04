// 1º Hemos creado una base de datos en MySQL Workbench con una tabla.
// 2º importamos la clase que contiene la conexión, excepto si se encuentra en el mismo sitio.
// 3º Escribimos el nombre de la base de datos y la contraseña de acceso en MySQL.
// 4º Añadimos las variables que son las misma que las columnas de la tabla.
// 5º Crear la Clase para operaciones con la base de datos: UsuarioDAO.java


public class Usuario {
    
 // Los atributos coinciden con las columnas   
    int id; // id INT AUTO_INCREMENT PRIMARY KEY
    String nombre; // nombre VARCHAR(100)
    String correo; // correo VARCHAR(100)
 
// Definimos dos constructores:
    
    public Usuario(String nombre, String correo)
    {
    this.nombre = nombre;
    this.correo = correo;
    }
    
    public Usuario(int id, String nombre, String correo)
    {
    this.id = id;
    this.nombre = nombre;
    this.correo = correo;
    }
    
// Getter 
    
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    
    
    
}
