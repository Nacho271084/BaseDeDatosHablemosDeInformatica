
package producto;

/**
Crea una clase Producto con los atributos nombre y precio.
Incluye un método que devuelva el nombre del producto en 
* mayúsculas y otro que aplique un descuento del 10% al precio.
Luego, en el main, crea un objeto Producto, llama a ambos 
* métodos y muestra los resultados por pantalla.
 */
public class Producto {
    
    // Atributo privado cadena de texto llamado nombre.
    // Atributo privado double - Decimal - llamado precio.
    private String nombre;
    private double precio;
    
    // Añadimos el constructor:

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public String getNombre ()
    {
        return this.nombre;
    }
        
    public double getPrecio()
    {
    
    return this.precio;
    
    }
    
    public double getPrecioConDescuento() {
        return precio * 0.90;
    }
    
    
    
}
