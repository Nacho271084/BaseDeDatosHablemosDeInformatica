USE tiendaonline;
DROP PROCEDURE IF EXISTS recorrerUsuario;
DELIMITER //
CREATE PROCEDURE recorrerUsuario(IN pId INT)
BEGIN
    DECLARE vNombre VARCHAR(30);
    DECLARE done INT DEFAULT 0;

    -- Declarar cursor
    DECLARE curNombre CURSOR FOR
        SELECT c.nombre FROM clientes AS c WHERE id_cliente = pId;

    -- Handler para cuando no haya más filas, cuando no haya más filas la variable se asigna a 1.
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    OPEN curNombre;
    centros_loop: LOOP
        FETCH curNombre INTO vNombre;
        IF done = 1 THEN
            LEAVE centros_loop;
        END IF;

        
        IF vNombre = 'Marta Ruiz' THEN
            SELECT CONCAT('Encontrado: ', vNombre) AS resultado;
            LEAVE centros_loop;
        ELSE
            SELECT CONCAT('No coincide: ', vNombre) AS resultado;
        END IF;
    END LOOP;

    CLOSE curNombre;
END //
DELIMITER ;

-- Llamar al procedimiento
CALL recorrerUsuario(3);