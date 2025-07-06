/*
Guardar y mostrar tareas en una lista.

✏️ Ejemplo de lo que hará el programa:
El usuario escribe una tarea (por ejemplo: "Estudiar para el examen").

Esa tarea se guarda en la base de datos.

Luego se muestran todas las tareas guardadas.

🗃️ Base de datos MySQL (estructura mínima)
Primero, crea esta tabla en MySQL:

CREATE DATABASE tareasdb;

USE tareasdb;

CREATE TABLE tareas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255)
);
📁 Archivos Java necesarios
Tendrás solo 3 clases:

ConexionMySQL.java → Para conectarse a la base de datos.

TareaDAO.java → Para insertar y mostrar tareas.

Tarea.java con los atributos, getter y setter. 

Main.java → Con Scanner para leer la tarea desde consola.

recuerda en cada proyecto nuevo añadir la dependencia del conector de Pomp  
 <dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>8.0.33</version>
</dependency>



 */

