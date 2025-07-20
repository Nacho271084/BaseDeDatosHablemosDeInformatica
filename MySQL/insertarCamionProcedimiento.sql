/*
En este ejercicio crearemos un procedimiento que permitirá insertar los datos de un camión: 
IdCamion, numero entero.
Matricula, cadena de texto de 5 dígitos.
tipo, cadena de texto, puede ser largo, corto o doble.
El procedimiento recibe los datos como parametro de entrada in.
*/
-- La base de datos es transportes.
USE transportes;
-- Vemos la tabla camión:
select * from camion;
-- Hacemos el insert fuera para ver si todo funciona:
insert into camion (idCamion, Matricula, tipo) values (1,"3358F","Largo");
-- Si ya existe el procedimiento:
DROP PROCEDURE if exists insertarCamion;
-- Comenzamos el procedimiento:
-- Establecemos el delimitador:
DELIMITER //
CREATE PROCEDURE insertarCamion(in pIdCamion int, in pMatricula varchar(30), in pTipo varchar(30))
BEGIN
insert into camion (idCamion, Matricula, tipo) values (pIdCamion, pMatricula, pTipo);
END //

DELIMITER ;

-- Comenzamos a ejecutar el procedimiento:
-- Creamos las variables y asignamos los datos:
SET @v_IdCamion = 2;
SET @v_Matricula = "2340F";
SET @v_Tipo = "Doble";

-- Llamamos al procedimiento y pasamos los parametros:

CALL insertarCamion(@v_IdCamion, @v_Matricula, @v_Tipo);

-- Vemos los datos ingresados:

SELECT * FROM camion;




