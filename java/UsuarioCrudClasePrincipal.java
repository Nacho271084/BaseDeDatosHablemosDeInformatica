
package com.mycompany.cruddeusuarios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UsuarioCrudClasePrincipal {
    // Creamos una Arraylist llamada usuarios de tipo Usuario 'hace referencia a la clase creada'.
    // estático, pertenece a la clase y no a la instancia.
    private static ArrayList <UsuarioCrud> usuarios = new ArrayList<>();
    // Un contador donde guardaremos los ids automáticos.
    private static int contadorId = 1;
    // La clase Scanner para recibir datos del usuario.
    private static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {
    int numero;
    // Mientras no se pulse en salir el menú se seguirá ejecutando, 
     // pero al menos se ejecuta una vez:
    do{
    // Simplemente un menú de opciones,     
        System.out.println("---------- Menú de opciones --------");
        System.out.println("1º Crear usuario.....");
        System.out.println("2º Leer usuario.....");
        System.out.println("3º Actualizar usuario.....");
        System.out.println("4º Eliminar usuario.....");
        System.out.println("0º Salir.....");
        // Pedimos el valor númerico al usuario.
        numero = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        switch (numero) {
            case 1:
                crearUsuario();
                break;
            case 2:
                leerusuario();
                break;
            case 3:
                actualizarUsuario();
                break;
            case 4:
                eliminarusuario();
                break;
            case 0:
                System.out.println("Saliendo...........");
                break;
            default:
                throw new AssertionError();
        }

}while(numero!=0);           
            
     // Creamos los métodos que nos van a permitir nuestra tarea:
     // Método para crear usuario:
     // Solicitamos los datos del usuario.
    }
   public static void crearUsuario()
   {
    System.out.println("Ingrese el nombre del usuario: ");
    String nombre = sc.nextLine();
    
    System.out.println("Ingrese el email del usuario: ");
    String email = sc.nextLine();
    
    System.out.println("Ingrese la edad del usuario: ");
    int edad = sc.nextInt();
    // Creamos una instancia de usuario llamada usuarioUno.
    // El constructor recibe los valores recibidos con la clase scanner.
    // El id se autoincrementa, post-incremento"Devuelve el valor y luego incrementa"
    UsuarioCrud usuario = new UsuarioCrud(contadorId++, nombre, email, edad);
    // Añadimos el usuario a la lista de usuarios.
    usuarios.add(usuario);
    System.out.println("El usuario se ha creado con éxito");

   }
   // Recorremos la lista imprimiendo los usuarios almacenados.
   public static void leerusuario()
   {
       // Si la lista está vacia deberíamos de informar de ello.
       if (usuarios.isEmpty()) 
       {
           System.out.println("No existen usuarios en la lista.....");
           
       } else{
       for (UsuarioCrud usuarioR : usuarios) {
           System.out.println(usuarioR);
       }   
       }

   }
   // Actualizamos los datos, pero mostramos el anterior dato con el get 
   // y modificamos con el set.
   public static void actualizarUsuario()
   {
       System.out.println("Debes proporcionar el id del usuario a actualizar");
       int id = sc.nextInt();
       sc.nextLine();
       
       for (UsuarioCrud usuarioA : usuarios) {
           
           if (usuarioA.getId() == id) {
               
               System.out.println("Nombre antiguo: " + usuarioA.getNombre());
               System.out.println("Ingrese su nuevo nombre");
               String nombre = sc.nextLine();
               System.out.println("Nombre nuevo: " + usuarioA.getNombre());
               usuarioA.setNombre(nombre);
               
               System.out.println("Email antiguo: " + usuarioA.getEmail());
               System.out.println("Ingrese su nuevo correo electrónico: ");
               String email = sc.nextLine();
               usuarioA.setEmail(email);
               System.out.println("Correo nuevo: " + usuarioA.getEmail());
               
               System.out.println("Edad antigua: " + usuarioA.getEdad());
               System.out.println("Ingrese su edad: ");
               int edad = sc.nextInt();
               usuarioA.setEdad(edad);
               System.out.println("Nueva edad: " + usuarioA.getEdad());
               System.out.println("Se ha modificado todos los datos con éxito");
           }
           
       } 
   }
   // Finalmente eliminamos el usuario seleccionado por el ID
   
  public static void eliminarusuario() {
    System.out.println("Introduce el ID a eliminar del usuario: ");
    int id = sc.nextInt();
    // Creamos un objeto de tipo iterator.
    Iterator<UsuarioCrud> it = usuarios.iterator();
    // Mientras que existan elementos.
    while (it.hasNext()) {
        // Pedimos el ID necesario.
        UsuarioCrud usuarioE = it.next();
        if (usuarioE.getId() == id) {
            // Eliminamos mientras recorremos sin provocar errores.
            it.remove();
            System.out.println("El usuario con ID " + id + " ha sido eliminado");
            return; // salir después de eliminar
        }
    }
    System.out.println("No se encontró ningún usuario con el ID " + id);
}
   }
   
    

