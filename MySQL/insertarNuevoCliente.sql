use tiendaonline;

-- Vemos la tabla clientes donde insertaremos los datos:

select * from clientes;

-- Creamos un procedimiento que nos permita insertar los datos:

DROP PROCEDURE if exists insertarNuevoCliente;
DELIMITER //

CREATE PROCEDURE insertarNuevoCliente
(
IN p_nombre VARCHAR(100),
IN p_email VARCHAR(100),
IN p_ciudad VARCHAR(100),
IN p_fecha_registro DATE
)
BEGIN
-- Declaramos la condición para clave duplicada
DECLARE claveDuplicada CONDITION FOR SQLSTATE '23000';

-- Declaramos el handler para esa condición
DECLARE CONTINUE HANDLER FOR claveDuplicada
BEGIN
    SELECT 'Error: ID duplicado. El cliente ya existe.' AS mensaje;
END;

-- Insertamos el cliente (id_cliente es autoincremental)

INSERT INTO clientes (nombre, email, ciudad, fecha_registro)
VALUES (p_nombre, p_email, p_ciudad, p_fecha_registro);

END //

DELIMITER ;
set @nombre = "Juan";
set @email = "juan@mail.com";
set @ciudad = "Sevilla";
set @fecha_registro = "2023-01-10";

call insertarNuevoCliente (@nombre,@email, @ciudad,@fecha_registro);
