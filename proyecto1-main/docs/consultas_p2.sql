/*
RF2: MOSTRAR LOS 20 SERVICIOS MÁS POPULARES.
Los que fueron más consumidos en un período de tiempo dado.
*/

SELECT rs.id_servicio, s.nombre AS nombre_servicio, COUNT(rs.id_servicio) AS consumos
FROM reservas_servicio rs
JOIN servicios s ON rs.id_servicio = s.id
WHERE rs.fecha BETWEEN TO_DATE('01/01/2010', 'DD/MM/YYYY') AND TO_DATE('01/01/2024', 'DD/MM/YYYY')
GROUP BY rs.id_servicio, s.nombre
ORDER BY consumos DESC
FETCH FIRST 20 ROWS ONLY;


/*
RF5: MOSTRAR EL CONSUMO EN HOTELANDES POR UN USUARIO DADO, EN UN RANGO DE FECHAS INDICADO.
Recuerde que un cliente puede alojarse en el hotel cuantas veces quiera.
*/

SELECT u.num_doc, u.tipo_doc, u.nombre AS nombre_cliente, s.id AS servicio_id, s.nombre AS nombre_servicio, rs.fecha, rs.costo
FROM reservas_servicio rs
JOIN habitaciones h ON rs.id_habitacion = h.id
JOIN reservas_habitacion rh ON h.id = rh.id_habitacion
JOIN usuarios u ON rh.num_doc = u.num_doc AND rh.tipo_doc = u.tipo_doc
JOIN servicios s ON rs.id_servicio = s.id
WHERE u.num_doc = 225943974 
    AND u.tipo_doc = 'CC'
    AND rs.fecha BETWEEN TO_DATE('01/01/2010', 'DD/MM/YYYY') AND TO_DATE('01/01/2024', 'DD/MM/YYYY')
ORDER BY rs.fecha, rs.hora_inicio;


/*
RF8: ENCONTRAR LOS SERVICIOS QUE NO TIENEN MUCHA DEMANDA
Encontrar los servicios que hayan sido solicitados menos de 3 veces semanales,
durante el último año de operación de HotelAndes.
*/

SELECT s.nombre, COUNT(rs.id_servicio) AS consumos,
    COUNT(rs.id_servicio) / 52 AS tasa_semanal
FROM reservas_servicio rs
JOIN servicios s ON rs.id_servicio = s.id
WHERE rs.fecha >= SYSDATE - INTERVAL '1' YEAR
GROUP BY s.nombre
HAVING COUNT(rs.id_servicio) / 52 < 3
ORDER BY tasa_semanal;


/*
RF11: CONSULTAR FUNCIONAMIENTO
Muestra, para cada semana del año (sábado a sábado), el servicio más consumido,
el servicio menos consumido, las habitaciones más solicitadas y las habitaciones
menos solicitadas. Las respuestas deben ser sustentadas por el detalle de las 
reservas y consumos correspondiente. Esta operación es realizada por el gerente 
general de HotelAndes.
*/
