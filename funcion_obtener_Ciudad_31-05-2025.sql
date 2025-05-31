/*
En esta función veremos como obtener el nombre de la ciudad del cliente. Pasaremos un
id desde fuera para comparar con el id_cliente de la tabla.
Si el parametro id_cliente coincide con el id_cliente de la tabla entonces se mostrará la 
ciudad
*/
-- Comenzamos a usar la tabla clientes de la base de datos tiendaonline:
use tiendaonline;
-- Vemos la tabla sobre la que vamos a trabajar:

select * from clientes;

-- Esta es la consulta que haremos dentro de la función. 

select c.ciudad FROM clientes as c where id_cliente = 2;

-- Si la función existe la borramos.

DROP function if exists obtenerCiudad;

-- Creamos la función:

DELIMITER //
CREATE function obtenerCiudad(pid_cliente int)
-- El tipo de dato es varchar 50 -> cadena de texto
RETURNS varchar (50)
deterministic
-- La función lee datos, pero no modifica las tablas.
READS SQL DATA
BEGIN
DECLARE v_ciudad varchar (50);
select c.ciudad INTO v_ciudad FROM clientes as c where c.id_cliente = pid_cliente and c.id_cliente is not null;
return v_ciudad;
END //
DELIMITER ;

select obtenerCiudad(2) as Ciudad;


