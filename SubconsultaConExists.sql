/* 
En este ejercicio vamos a realizar una subconsulta y verificar el resultado con EXISTS.
Si la subconsulta devuelve al menos una fila, EXISTS devolverá TRUE y, por lo tanto, se mostrarán los datos.
Dicho de otro modo, si la subconsulta devuelve resultados, su valor booleano será TRUE.
*/
-- Comenzamos a trabajar sobre la base de datos llamada tiendaonline:

USE tiendaonline;

-- Vemos la tabla clientes:
SELECT * FROM clientes as c;
-- Vemos la tabla de pedidos:
SELECT * FROM pedidos as p;

-- Vemos el nombre de aquellos clientes que tienen al menos un pedido.

SELECT c.nombre FROM clientes as c WHERE exists 
(SELECT 1 FROM pedidos as p WHERE p.id_cliente = c.id_cliente);

/*Si la subconsulta devuelve al menos una fila 
(es decir, si el cliente tiene algún pedido en la tabla pedidos), entonces EXISTS devuelve TRUE.
*/
