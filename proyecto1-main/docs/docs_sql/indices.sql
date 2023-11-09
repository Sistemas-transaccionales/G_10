--ÍNDICES

--Índice secundario simple sobre la tabla servicios en el atributo nombre
CREATE INDEX idx_servicios_nombre ON servicios(nombre);

--Índice secundario compuesto sobre la tabla reservas_habitacion en los atributos num_doc y tipo_doc
CREATE INDEX idx_reservas_habitacion_tipo_y_num_doc ON reservas_habitacion(num_doc, tipo_doc);

--Índice secundario simple sobre la tabla reservas_habitacion en el atributo fecha_entrada
CREATE INDEX idx_reservas_habitacion_fecha_entrada ON reservas_habitacion(fecha_entrada);

--Índice secundario simple sobre la tabla reservas_servicio en el atributo fecha
CREATE INDEX idx_reservas_servicio_fecha ON reservas_servicio(fecha);

--Índice secundario simple sobre la tabla reservas_servicio en el atributo id_servicio
CREATE INDEX idx_reservas_servicio_id_servicio ON reservas_servicio(id_servicio);

--Índice secundario simple sobre la tabla reservas_servicio en el atributo costo
CREATE INDEX idx_reservas_servicio_costo ON reservas_servicio(costo);

--Índice secundario simple sobre la tabla lavanderias en el atributo costo
CREATE INDEX idx_lavanderias_costo ON lavanderias(costo);

--Índice secundario simple sobre la tabla prestamos_utensilios en el atributo costo_danio
CREATE INDEX idx_prestamos_utensilios_costo_danio ON prestamos_utensilios(costo_danio);

--Índice secundario simple sobre la tabla salones en el atributo costo_por_hora
CREATE INDEX idx_salones_costo_por_hora ON salones(costo_por_hora);

--Índice secundario simple sobre la tabla spas en el atributo costo
CREATE INDEX idx_spas_costo ON spas(costo);

--Índice secundario simple sobre la tabla gimnasios en el atributo capacidad
CREATE INDEX idx_gimnasios_capacidad ON gimnasios(capacidad);

--Índice secundario simple sobre la tabla piscinas en el atributo costo
CREATE INDEX idx_piscinas_capacidad ON piscinas(capacidad);

--Índice secundario simple sobre la tabla salones en el atributo costo
CREATE INDEX idx_salones_capacidad ON salones(capacidad);

--Índice secundario simple sobre la tabla restaurantes_bares en el atributo costo
CREATE INDEX idx_restaurantes_bares_capacidad ON restaurantes_bares(capacidad);