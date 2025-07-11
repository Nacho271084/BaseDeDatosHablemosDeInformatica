/* En esta gran ocasión haremos juntos una consulta que permite comprobar una ciudad
mediante un id, este se lo pasaremos mediante parametro, de este modo será todo más dinámico.
*/ 
use tiendaonline;
select * from clientes;
select c.ciudad from clientes as c where id_cliente = 3;

DROP function if exists consultarCiudad;
DELIMITER //
CREATE function consultarCiudad(p_id_Cliente INT)
returns varchar(50)
reads sql data
deterministic
BEGIN
DECLARE v_ciudad varchar(50);


select c.ciudad into v_ciudad from clientes as c where id_cliente = p_id_Cliente;
return v_ciudad;
END //
DELIMITER ;
-- Llamamos a la consulta:
select consultarCiudad(3) as ciudad;