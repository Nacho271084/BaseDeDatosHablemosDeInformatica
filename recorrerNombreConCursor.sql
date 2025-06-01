/*
En este procedimiento llamado recorrerNombre, se recorre la columna nombre de la 
tabla clientes de la base de datos tiendaonline, utilizando un cursor y el comando FETCH.
Durante cada iteración del bucle:
FETCH recupera un nombre desde el cursor y lo guarda en la variable v_nombre.
Si ya no hay más filas, se activa el manejador CONTINUE HANDLER FOR NOT FOUND, que
el valor de la variable v_semaforo a TRUE, lo que provoca la salida del bucle (LEAVE).
Si se recuperó un nombre correctamente, se imprime usando SELECT v_nombre AS nombre;.
*/
-- Comenzamos a usar el procedimiento:
use tiendaonline;

-- Vemos la tabla sobre la que trabajaremos:

select * from tiendaonline.clientes;
-- Solo si el procedimiento existe lo borrará.
DROP PROCEDURE if exists recorrerNombre;
-- Cambiamos el delimitador:
DELIMITER //
-- Creamos el procedimiento con el nombre recorrerNombre:
CREATE PROCEDURE recorrerNombre()
BEGIN
-- Variable que permite salir del bucle cuando no quedan más filas:
DECLARE v_semaforo boolean default 0;
DECLARE v_nombre varchar (50);
-- Declaramos el cursor:
DECLARE cNombreCursor CURSOR FOR select c.nombre from tiendaonline.clientes as c;
DECLARE continue handler for not found SET v_semaforo = 1;
OPEN cNombreCursor;
recorrer:loop
BEGIN
fetch cNombreCursor into v_nombre;
IF v_semaforo then leave recorrer; end if;
end;
-- El nombre se encuentra dentro del bucle para imprimir un nombre por resultado:
SELECT v_nombre AS nombre;

end loop;

CLOSE cNombreCursor;
END //
-- Devolvemos el delimitador al punto y coma:
DELIMITER ;
-- Llamamos al procedimiento:
CALL recorrerNombre();