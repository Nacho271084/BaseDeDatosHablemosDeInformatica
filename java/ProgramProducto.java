
package producto;

import java.util.ArrayList;
import java.util.List;

/*
Tienes una lista de productos con nombre y precio.
Queremos:

Filtrar solo los productos que cuestan más de 10 euros.

Convertir sus nombres a mayúsculas.

Mostrar el nombre y precio con descuento del 10%.


*/

public class ProgramProducto {
    
    public static void main(String[] args) {
    
    // Creamos una lista de productos usando como tipo de dato nuestra clase producto.

    List <Producto> listaDeProductos = new ArrayList<>();
    
    // Añadimos 4 productos, pero recuerda crear una instancia de producto.
    
    listaDeProductos.add(new Producto("Monitor", 120));
    listaDeProductos.add(new Producto("TV", 180));
    listaDeProductos.add(new Producto("USB_8GB", 3));
    listaDeProductos.add(new Producto("Ratón_USB", 9));
    
    // Convertimos nuestra lista a un Streams de tipo Producto.
    
    listaDeProductos.stream().
    // Filtrar solo los productos que cuestan más de 10 euros.
    // Esto quiere decir para producto haz precio del producto mayor a 10 euros. Solo mayores.
            filter(p -> p.getPrecio() > 10).
    // Para p obtener el nombre y transformarlo a mayúscula.
    // Para p obtener el precio en decuento.
            map(p -> "Nombre del producto  : " + "  "+
                    p.getNombre().toUpperCase() +
                    " |   Precio con porcentaje : " +
                    p.getPrecioConDescuento()).
   // Metodo referencia: Imprimir cada línea usando referencia a método
            forEach(System.out::println);
    
    }
    
}
