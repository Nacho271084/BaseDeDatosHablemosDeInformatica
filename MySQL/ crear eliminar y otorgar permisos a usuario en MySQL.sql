-- En esta ocasión, vamos a crear un usuario y una contraseña en un HOST cualquiera.
-- El usuario es 'Manolo' y la contraseña es '1234'. El Host puede ser %
-- Comenzar a usar la base de datos:
USE tiendaonline;

-- Vemos si el usuario existe:

SELECT user FROM mysql.user where user = 'Manolo';

-- Crear el usuario 'Manolo' con contraseña '1234' y host '%' (cualquier host)

CREATE USER 'Manolo'@'%' IDENTIFIED BY '1234';

-- Ver los usuarios creados:

SELECT user FROM mysql.user;

-- Muestra todos los permisos otorgados al usuario desde el host especificado.

SHOW GRANTS FOR 'Manolo'@'%';

-- El resultado anterior es que no tiene privilegios.

-- Dar permisos totales sobre la base de datos:

GRANT ALL PRIVILEGES ON tiendaonline.* TO 'Manolo'@'%';

-- Esto permite que Manolo pueda crear, leer, modificar y eliminar datos, 
-- así como crear tablas, vistas, etc., en la base de datos tiendaonline.

-- Eliminar el usuario creado. Elimina ese usuario sólo si existe con ese host específico.

DROP USER if exists 'Manolo';
