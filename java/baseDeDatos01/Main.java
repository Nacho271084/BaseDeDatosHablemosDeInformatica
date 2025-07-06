
import java.util.Scanner;




public class Main {
    
    public static void main(String[] args) {
        
     TareaDao dao = new TareaDao();  
     
     Scanner sc = new Scanner (System.in);
     
     System.out.println("Hola ingrese una tarea: ");
     String descripcion = sc.nextLine();
     
     Tarea nuevaTarea = new Tarea(descripcion);
     
     dao.insertarTarea(nuevaTarea);
     
        System.out.println("Listar las tareas: ");
        
        for (Tarea t : dao.listarTareas()) 
        {
            System.out.println(t.getId() +"-"+ t.getDescripcion());
        }
        
        
    sc.close();
        
    }
    
}
