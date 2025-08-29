-- 1 La base de datos donde trabajaremos:
USE tiendaonline;
-- 1.5 vemos los datos, queremos a 'Luis Pérez'
SELECT c.nombre FROM clientes AS c WHERE id_cliente = 2;
-- 2 Si el procedimiento existe se borrará
-- 3 Establecemos un delimitador temporal para definir procedimientos sin errores.
-- 4 Creamos el procedimiento llamado recorrerUsuario, este recibe un parámetro de entrada un id.
-- 5 Abrimos el procedimiento con Begin y lo cerramos con END //
-- 6 Declaramos dos variables una para almacenar el nombre de la consulta del cursor y otra para finalizar cuando no queden más fila.
-- 7 Declaramos el cursor llamado cursorNombre
-- 8 Cuando ya no hay más filas el semaforo vale 1 y continua.
-- 9 almacenamos el cursorNombre en variableNombre con INTO.
-- 10 si existe el nombre buscado, lanzará un mensaje de usuario existe en la base de datos.
-- 11 Cerramos el cursor y cerramos el bucle.
-- 12 Llamamos al id con CALL y el nombre del procedimiento, entre el parentesis pasamos el id.
DROP PROCEDURE IF EXISTS recorrerElUsuario;
DELIMITER //
CREATE PROCEDURE recorrerElUsuario(IN p_Id INT)
BEGIN
    DECLARE variableNombre VARCHAR(30);
    DECLARE semaforo INT DEFAULT 0;    
    DECLARE cursorNombre CURSOR FOR
        SELECT c.nombre FROM clientes AS c WHERE id_cliente = p_Id;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET semaforo = 1;
    OPEN cursorNombre;
    miBucle: LOOP
        FETCH cursorNombre INTO variableNombre;
        IF semaforo = 1 THEN
            LEAVE miBucle;
        END IF;
        IF variableNombre = 'Luis Pérez' THEN
            SELECT CONCAT('El usuario existe en la base de datos: ', variableNombre) AS resultado;
            LEAVE miBucle;
        ELSE
            SELECT CONCAT('El usuario no coincide en la base de datos: ', variableNombre) AS resultado;
        END IF;
    END LOOP;

    CLOSE cursorNombre;
END //
DELIMITER ;
-- Llamar al procedimiento
CALL recorrerElUsuario(2);