-- Esta función devuelve el nombre y email de la tabla cliente en función del ID recibido:
-- 1 Nos conectamos a una base de datos.
-- 2 Vemos la tabla sobre la que vamos a trabajar.
-- 3 Si la función existe será eliminada.
-- 4 Establecemos el delimitador para crear funciones sin errores.
-- 5 Creamos la función que recibe un parametro y devolverá el nombre y el email.
-- 6 Establecemos el tipo de dato devuelto con returns, con varchar de 100 será suficiente para el nombre y el correo.
-- 7 Deterministic quiere decir que la función devuelve los mismos valores si recibe los mismos valores.
-- 8 Dentro de Begin y end metemos el código a ejecutar, en este caso la consulta que devuelve los datos.
-- 9 Declaramos una variable que almacenará la concatenación del nombre y el email.
-- 10 Devolvemos los datos con return, en este caso el resultado de la concatenación.
-- 11 Cerramos el END y devolvemos el delimitador a su estado original, avisando de la finalización de la función.
-- 12 Con el select llamamos a la función, entre el paréntesis metemos el id del cliente.
USE tiendaonline;
SELECT * FROM clientes as c;
DROP FUNCTION if exists consutarNombreYEmail;
DELIMITER //
CREATE function consultarNombreYEmail(f_id int)
returns varchar(100)
DETERMINISTIC
BEGIN
DECLARE v_resultado varchar (100);
Select concat(c.nombre,'     ', c.email) into v_resultado from clientes as c where id_cliente = f_id;
return v_resultado;
END //
DELIMITER ;
select consultarNombreYEmail(2) AS "Nombre y correo del cliente";