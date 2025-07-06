import java.sql.*;
import java.util.ArrayList;

public class Tarea {

int id;
String descripcion;

public Tarea(String descripcion)
{
    this.descripcion = descripcion;
}



public Tarea (int id,String descripcion)
{
    this.id = id;
    this.descripcion = descripcion;
}

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }


    
    
    
}
