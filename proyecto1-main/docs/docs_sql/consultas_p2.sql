/*
RF1: MOSTRAR EL DINEERO RECOLECTADO POR CADA HABITACIÓN 
*/
SELECT reservas_servicio.id_habitacion, servicios.nombre,'$' || TO_CHAR(SUM(reservas_servicio.costo), 'FM999,999,999.99') AS total_ganancias
FROM reservas_servicio
INNER JOIN servicios ON servicios.id = reservas_servicio.id_servicio
WHERE EXTRACT(YEAR FROM reservas_servicio.fecha) = 2023
GROUP BY reservas_servicio.id_habitacion, servicios.nombre
ORDER BY reservas_servicio.id_habitacion;



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
RF3: MOSTRAR EL ÍNDICE DE OCUPACIÓN DE CADA UNA DE LAS HABITACIONES DEL HOTEL
Se debe mostrar el % de ocupación de cada habitación en el último año de operación
*/

SELECT 
    r.id_habitacion AS ID_Habitacion,
    COUNT(DISTINCT r.fecha_entrada) AS Dias_Ocupados,
    (COUNT(DISTINCT r.fecha_entrada) / 365.0) * 100 AS Tasa_Ocupacion
FROM 
    reservas_habitacion r
WHERE 
    r.fecha_entrada BETWEEN SYSDATE - INTERVAL '1' YEAR AND SYSDATE
GROUP BY 
    r.id_habitacion
ORDER BY 
    Tasa_Ocupacion DESC;

/*
RF4: 
*/
SELECT servicios.nombre,
    COALESCE(gimnasios.capacidad, piscinas.capacidad, salones.capacidad, restaurantes_bares.capacidad) AS capacidad_total,
    CASE
        WHEN lavanderias.costo IS NOT NULL THEN lavanderias.costo
        WHEN prestamos_utensilios.costo_danio IS NOT NULL THEN prestamos_utensilios.costo_danio
        WHEN salones.costo_por_hora IS NOT NULL THEN salones.costo_por_hora
        WHEN spas.costo IS NOT NULL THEN spas.costo
        ELSE 0
    END AS costo_del_servicio
FROM servicios
LEFT JOIN gimnasios ON gimnasios.id = servicios.id
LEFT JOIN piscinas ON piscinas.id = servicios.id
LEFT JOIN salones ON salones.id = servicios.id
LEFT JOIN restaurantes_bares ON restaurantes_bares.id = servicios.id
LEFT JOIN lavanderias ON lavanderias.id = servicios.id
LEFT JOIN prestamos_utensilios ON prestamos_utensilios.id = servicios.id
LEFT JOIN spas ON spas.id = servicios.id

WHERE (CASE
        WHEN lavanderias.costo IS NOT NULL THEN lavanderias.costo
        WHEN prestamos_utensilios.costo_danio IS NOT NULL THEN prestamos_utensilios.costo_danio
        WHEN salones.costo_por_hora IS NOT NULL THEN salones.costo_por_hora
        WHEN spas.costo IS NOT NULL THEN spas.costo
        ELSE 0
    END >= :costo_minimo AND
    CASE
        WHEN lavanderias.costo IS NOT NULL THEN lavanderias.costo
        WHEN prestamos_utensilios.costo_danio IS NOT NULL THEN prestamos_utensilios.costo_danio
        WHEN salones.costo_por_hora IS NOT NULL THEN salones.costo_por_hora
        WHEN spas.costo IS NOT NULL THEN spas.costo
        ELSE 0
    END <= :costo_maximo)
    OR
    (COALESCE(gimnasios.capacidad, piscinas.capacidad, salones.capacidad, restaurantes_bares.capacidad) >= :capacidad_minima AND
    COALESCE(gimnasios.capacidad, piscinas.capacidad, salones.capacidad, restaurantes_bares.capacidad) <= :capacidad_maxima);
  

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
WHERE u.num_doc = 53365466 
    AND u.tipo_doc = 'PA'
    AND rs.fecha BETWEEN TO_DATE('01/01/2010', 'DD/MM/YYYY') AND TO_DATE('01/01/2024', 'DD/MM/YYYY')
ORDER BY rs.fecha, rs.hora_inicio;


/*
RF6: ANALIZAR LA OPERACIÓN DE HOTELANDES
Para todo el tiempo de operación de HotelAndes, indicar cuáles fueron las fechas de los días de mayor
ocupación (mayor cantidad habitaciones ocupadas), las fechas de mayores ingresos (mayor cantidad de
consumos realizados) y también las fechas de menor demanda (menor ocupación).
*/

SELECT fecha_entrada AS Fecha, COUNT(*) AS Ocupacion
FROM reservas_habitacion
GROUP BY fecha_entrada
ORDER BY Ocupacion DESC
FETCH FIRST 3 ROWS ONLY;

SELECT fecha as Fecha, SUM(costo) AS Ingresos
FROM reservas_servicio
GROUP BY fecha
ORDER BY Ingresos DESC
FETCH FIRST 3 ROWS ONLY;

SELECT fecha_entrada AS Fecha, COUNT(*) AS Ocupacion
FROM reservas_habitacion
GROUP BY fecha_entrada
ORDER BY Ocupacion ASC
FETCH FIRST 3 ROWS ONLY;

/*
RF7:
*/
WITH DatosCliente AS (
    SELECT
        usuarios.num_doc AS num_documento,
        usuarios.nombre AS clientes_buenos,
        SUM(rh.fecha_salida - rh.fecha_entrada) AS dias_hospedado,
        SUM(COALESCE(rh.costo, 0) + COALESCE(rs.costo, 0)) AS costo_total
    FROM usuarios 
    LEFT JOIN reservas_habitacion rh ON usuarios.num_doc = rh.num_doc
    LEFT JOIN reservas_servicio rs ON usuarios.num_doc = rs.id_consumidor
    WHERE EXTRACT(YEAR FROM rh.fecha_salida) = 2023 OR EXTRACT(YEAR FROM rs.fecha) = 2023
    GROUP BY usuarios.num_doc, usuarios.nombre
)
SELECT num_documento, clientes_buenos, dias_hospedado, costo_total
FROM DatosCliente
WHERE costo_total > 15000000 OR dias_hospedado > 14
ORDER BY costo_total DESC;


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
RF9: CONSULTAR CONSUMO EN HOTELANDES
Se quiere conocer la información de los clientes que consumieron al menos una vez un determinado servicio
del hotel, en un rango de fechas. Los resultados deben ser clasificados según un criterio deseado por quien
realiza la consulta. En la clasificación debe ofrecerse la posibilidad de agrupamiento y ordenamiento de las
respuestas según los intereses del usuario que consulta como, por ejemplo, por los datos del cliente, por fecha
y número de veces que se utilizó el servicio. Esta operación está disponible para el recepcionista y el gerente
del hotel.
*/

SELECT u.num_doc, u.tipo_doc, u.nombre, r.fecha, COUNT(*) as cantidad
FROM usuarios u
JOIN reservas_servicio r ON u.num_doc = r.id_consumidor AND u.tipo_doc = r.tipo_id_consumidor
WHERE r.id_servicio = :service_id AND r.fecha BETWEEN :start_date AND :end_date
GROUP BY u.num_doc, u.tipo_doc, u.nombre, r.fecha
ORDER BY :order_by;

/*
RF10 
*/
SELECT u.num_doc, u.tipo_doc, u.nombre
FROM usuarios u
WHERE (u.num_doc, u.tipo_doc) NOT IN (
    SELECT r.id_consumidor, r.tipo_id_consumidor
    FROM reservas_servicio r
    WHERE r.id_servicio = :service_id
    AND r.fecha BETWEEN :start_date AND :end_date
)
ORDER BY :order_by;


/*
RF11: CONSULTAR FUNCIONAMIENTO
Muestra, para cada semana del año (sábado a sábado), el servicio más consumido,
el servicio menos consumido, las habitaciones más solicitadas y las habitaciones
menos solicitadas. Las respuestas deben ser sustentadas por el detalle de las 
reservas y consumos correspondiente. Esta operación es realizada por el gerente 
general de HotelAndes.
*/
/*
Servicios más consumidos
*/
SELECT semana,
    nombre AS servicio_mas_consumido,
    consumos
FROM (
    SELECT TO_CHAR(rs.fecha, 'IW') AS semana,
           s.nombre,
           COUNT(*) AS consumos,
           ROW_NUMBER() OVER (PARTITION BY TO_CHAR(rs.fecha, 'IW') ORDER BY COUNT(*) DESC) AS rn
    FROM reservas_servicio rs
    JOIN servicios s ON rs.id_servicio = s.id
    WHERE rs.fecha BETWEEN TRUNC(SYSDATE, 'YEAR') - INTERVAL '1' YEAR AND TRUNC(SYSDATE)
    GROUP BY TO_CHAR(rs.fecha, 'IW'), s.nombre
)
WHERE rn = 1;

/*
Servicios menos consumidos
*/
SELECT semana,
    nombre AS servicio_menos_consumido,
    consumos
FROM (
    SELECT TO_CHAR(rs.fecha, 'IW') AS semana,
           s.nombre,
           COUNT(*) AS consumos,
           ROW_NUMBER() OVER (PARTITION BY TO_CHAR(rs.fecha, 'IW') ORDER BY COUNT(*)) AS rn
    FROM reservas_servicio rs
    JOIN servicios s ON rs.id_servicio = s.id
    WHERE rs.fecha BETWEEN TRUNC(SYSDATE, 'YEAR') - INTERVAL '1' YEAR AND TRUNC(SYSDATE)
    GROUP BY TO_CHAR(rs.fecha, 'IW'), s.nombre
)
WHERE rn = 1;

/*
Habitaciones más solicitadas
*/
SELECT semana,
    id AS habitacion_mas_solicitada,
    reservaciones
FROM (
    SELECT TO_CHAR(rh.fecha_entrada, 'IW') AS semana,
           h.id,
           COUNT(*) AS reservaciones,
           ROW_NUMBER() OVER (PARTITION BY TO_CHAR(rh.fecha_entrada, 'IW') ORDER BY COUNT(*) DESC) AS rn
    FROM reservas_habitacion rh
    JOIN habitaciones h ON rh.id_habitacion = h.id
    WHERE rh.fecha_entrada BETWEEN TRUNC(SYSDATE, 'YEAR') - INTERVAL '1' YEAR AND TRUNC(SYSDATE)
    GROUP BY TO_CHAR(rh.fecha_entrada, 'IW'), h.id
)
WHERE rn = 1;

/*
Habitaciones menos solicitadas
*/
SELECT semana,
    id AS habitacion_menos_solicitada,
    reservaciones
FROM (
    SELECT TO_CHAR(rh.fecha_entrada, 'IW') AS semana,
           h.id,
           COUNT(*) AS reservaciones,
           ROW_NUMBER() OVER (PARTITION BY TO_CHAR(rh.fecha_entrada, 'IW') ORDER BY COUNT(*)) AS rn
    FROM reservas_habitacion rh
    JOIN habitaciones h ON rh.id_habitacion = h.id
    WHERE rh.fecha_entrada BETWEEN TRUNC(SYSDATE, 'YEAR') - INTERVAL '1' YEAR AND TRUNC(SYSDATE)
    GROUP BY TO_CHAR(rh.fecha_entrada, 'IW'), h.id
)
WHERE rn = 1;

/*
RF12: CONSULTAR LOS CLIENTES EXCELENTES
Los clientes excelentes son de tres tipos: aquellos que realizan estancias (las estancias están delimitadas por
un check in y su respectivo check out) en HotelAndes al menos una vez por trimestre, aquellos que siempre
consumen por lo menos un servicio costoso (Entiéndase como costoso, por ejemplo, con un precio mayor a
$300.000.oo) y aquellos que en cada estancia consumen servicios de SPA o de salones de reuniones con
duración mayor a 4 horas. Esta consulta retorna toda la información de dichos clientes, incluyendo aquella que
justifica su calificación como clientes excelentes. Esta operación es realizada únicamente por el gerente general
de HotelAndes
*/

WITH
trimester_stays AS (
  SELECT num_doc, tipo_doc
  FROM check_ins
  GROUP BY num_doc, tipo_doc, EXTRACT(YEAR FROM fecha), TRUNC((EXTRACT(MONTH FROM fecha) - 1) / 3)
  HAVING COUNT(DISTINCT fecha) >= 1
),
expensive_services AS (
  SELECT id_consumidor, tipo_id_consumidor
  FROM reservas_servicio
  WHERE costo > 300000
  GROUP BY id_consumidor, tipo_id_consumidor
  HAVING COUNT(DISTINCT id_servicio) >= 1
),
long_services AS (
  SELECT id_consumidor, tipo_id_consumidor
  FROM reservas_servicio
  JOIN servicios ON reservas_servicio.id_servicio = servicios.id
  WHERE (LOWER(nombre) LIKE '%spa%' OR LOWER(nombre) LIKE '%salones%') AND (TO_DATE(hora_fin, 'HH24:MI:SS') - TO_DATE(hora_inicio, 'HH24:MI:SS')) * 24 > 4
  GROUP BY id_consumidor, tipo_id_consumidor
  HAVING COUNT(DISTINCT id_servicio) >= 1
)
SELECT num_doc, tipo_doc, 'Estancia Trimestral' AS categoria
FROM trimester_stays
UNION
SELECT id_consumidor, tipo_id_consumidor, 'Servicios Costosos'
FROM expensive_services
UNION
SELECT id_consumidor, tipo_id_consumidor, 'Servicios Largo'
FROM long_services;