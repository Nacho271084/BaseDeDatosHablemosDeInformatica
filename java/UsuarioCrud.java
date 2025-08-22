
package com.mycompany.cruddeusuarios;

public class UsuarioCrud {

    // El usuario tiene los siguientes atributos:
    
    private int id;
    private String nombre;
    private String email;
    private int edad;
    
    // Añadimos un constructor para inicializar los atributos creados en el paso anterior:
    
    public UsuarioCrud(int id, String nombre, String email, int edad)
    {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.edad = edad;
    }
    
    // Si en algún momento necesitamos obtener o modificar los datos será necesario Getter y Setter.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    // Para terminar esta clase, usaremos el método ToSTring, este permite mostrar los datos.

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", edad=" + edad + '}';
    }
    
    
    
    
    
    
}
