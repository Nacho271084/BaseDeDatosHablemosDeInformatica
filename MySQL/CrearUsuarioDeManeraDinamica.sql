/* En este ejercicio crearemos un usuario mediante un procedimiento, pasaremos el nombre y la contraseña
como parametro de entrada. 
Si el nombre o la contraseña contiene carecteres especiales se lanzará una advertencia con SIGNAL SQLSTATE, 
este comando nos permite personalizar nuestras propias excepciones.
-- Si el usurio p_nombre existe lanzará un error avisando que el usuario ya existe.
*/

USE tiendaonline;

DROP procedure if exists crearUsuario;
DELIMITER //
CREATE procedure crearUsuario(
in p_nombre varchar(30), 
in p_contrasena varchar(30))
DETERMINISTIC
BEGIN
-- Validar que no haya caracteres peligrosos en el nombre o la contraseña.
-- Si p_nombre o la contraseña contiene caracteres espciales, lanzará un mensaje de error de caracteres no permitidos.
    IF p_nombre REGEXP '[^a-zA-Z0-9_]' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'El nombre de usuario contiene caracteres no permitidos';
    END IF;

    IF p_contrasena REGEXP '[[:space:]]' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'La contraseña no debe contener espacios';
    END IF;
    
        -- Comprobar si el usuario de MySQL ya existe
        IF NOT EXISTS (
            SELECT 1 
            FROM mysql.user
            WHERE user = p_nombre AND host = '%'
        ) THEN
            -- Crear el usuario dinámicamente
            SET @sentenciasql = CONCAT(
            'CREATE USER \'', REPLACE(p_nombre, '''', ''''''), 
            '\'@\'%\' IDENTIFIED BY \'', REPLACE(p_contrasena, '''', ''''''), '\'');
            -- Preparamos el comando con la sentencia anterior.
            -- Ejecutamos el comando anterior.
            -- Liberamos recuersos anteriores.
            PREPARE comandoDinamico FROM @sentenciasql;
            EXECUTE comandoDinamico;
            DEALLOCATE PREPARE comandoDinamico;
        
    ELSE
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'El USUARIO YA existe en la base de datos';
   END IF;
END //
DELIMITER ;
-- Ejecutamos el procedimiento, le pasamos el nombre y la contraseña.
call crearUsuario('Juan','12345');
-- Vemos si el usuario ha sido creado con exito.
select user from mysql.user where user = "Juan";