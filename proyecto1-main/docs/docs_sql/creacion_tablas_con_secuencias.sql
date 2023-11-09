CREATE TABLE tipos_habitacion (
    id INTEGER,
    nombre VARCHAR2(255) NOT NULL UNIQUE,
    costo_por_noche NUMERIC NOT NULL CHECK (costo_por_noche > 0),
    capacidad INTEGER NOT NULL CHECK(capacidad > 0),
    PRIMARY KEY (id)
);

CREATE SEQUENCE id_tipos_habitacion
START WITH 1
INCREMENT BY 1;

CREATE TABLE habitaciones (
    id VARCHAR2(255),
    tipo INTEGER NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT habitaciones_FK FOREIGN KEY (tipo) REFERENCES tipos_habitacion(id)
);

CREATE TABLE dotaciones (
    id INTEGER,
    nombre VARCHAR2(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE SEQUENCE id_dotaciones
START WITH 1
INCREMENT BY 1;

CREATE TABLE dotadas(
    id_tipo_habitacion INTEGER NOT NULL,
    id_dotacion INTEGER NOT NULL,
    CONSTRAINT dotadas_FK1 FOREIGN KEY (id_tipo_habitacion) REFERENCES tipos_habitacion(id),
    CONSTRAINT dotadas_FK2 FOREIGN KEY (id_dotacion) REFERENCES dotaciones(id),
    CONSTRAINT dotadas_PK PRIMARY KEY (id_tipo_habitacion, id_dotacion)
);

CREATE TABLE tipos_usuario (
    id INTEGER,
    nombre VARCHAR2(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE SEQUENCE id_tipos_usuario
START WITH 1
INCREMENT BY 1;

CREATE TABLE usuarios (
    num_doc NUMERIC NOT NULL,
    tipo_doc VARCHAR2(255) NOT NULL,
    tipo INTEGER NOT NULL,
    nombre VARCHAR2(255) NOT NULL,
    email VARCHAR2(255) NOT NULL,
    contrasenia VARCHAR(255) NOT NULL,
    CONSTRAINT usuarios_PK PRIMARY KEY (num_doc, tipo_doc),
    CONSTRAINT usuarios_FK FOREIGN KEY (tipo) REFERENCES tipos_usuario(id)
);

CREATE TABLE planes_consumo (
    id INTEGER,
    tipo_plan VARCHAR2(255) NOT NULL UNIQUE,
    tasa NUMERIC(3, 2) NOT NULL CHECK (tasa > 0),
    min_noches INTEGER NOT NULL CHECK (min_noches > 0),
    max_noches INTEGER NOT NULL CHECK (max_noches > 0),
    PRIMARY KEY (id)
);

CREATE SEQUENCE id_planes_consumo
START WITH 1
INCREMENT BY 1;

CREATE TABLE tipos_servicio (
    id INTEGER,
    nombre VARCHAR2(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE SEQUENCE id_tipos_servicio
START WITH 1
INCREMENT BY 1;

CREATE TABLE servicios (
    id INTEGER,
    tipo INTEGER NOT NULL,
    nombre VARCHAR2(255) NOT NULL,
    CONSTRAINT servicios_PK PRIMARY KEY (id),
    CONSTRAINT servicios_FK FOREIGN KEY (tipo) REFERENCES tipos_servicio(id)
);

CREATE SEQUENCE id_servicios
START WITH 1
INCREMENT BY 1;

CREATE TABLE gimnasios (
    id INTEGER,
    hora_apertura VARCHAR2(255) NOT NULL,
    hora_clausura VARCHAR2(255) NOT NULL,
    capacidad INTEGER NOT NULL CHECK (capacidad > 0),
    PRIMARY KEY (id),
    CONSTRAINT gimnasios_FK FOREIGN KEY (id) REFERENCES servicios(id)
);

CREATE TABLE internet (
    id INTEGER,
    capacidad INTEGER NOT NULL CHECK (capacidad > 0),
    PRIMARY KEY (id),
    CONSTRAINT internet_FK FOREIGN KEY (id) REFERENCES servicios(id)
);

CREATE TABLE piscinas (
    id INTEGER,
    capacidad INTEGER NOT NULL CHECK (capacidad > 0),
    area NUMERIC NOT NULL CHECK (area > 0),
    profundidad NUMERIC NOT NULL CHECK (profundidad > 0),
    PRIMARY KEY (id),
    CONSTRAINT piscinas_FK FOREIGN KEY (id) REFERENCES servicios(id)
);

CREATE TABLE lavanderias (
    id INTEGER,
    tipo_prenda VARCHAR2(255) NOT NULL,
    num_prendas INTEGER NOT NULL CHECK (num_prendas > 0),
    costo NUMERIC NOT NULL CHECK (costo >= 0),
    PRIMARY KEY (id),
    CONSTRAINT lavanderias_FK FOREIGN KEY (id) REFERENCES servicios(id)
);

CREATE TABLE prestamos_utensilios (
    id INTEGER,
    utensilio VARCHAR2(255) NOT NULL,
    costo_danio NUMERIC NOT NULL CHECK (costo_danio >= 0),
    PRIMARY KEY (id),
    CONSTRAINT prestamos_utensilios_FK FOREIGN KEY (id) REFERENCES servicios(id)
);

CREATE TABLE salones (
    id INTEGER,
    tipo_salon VARCHAR2(255) NOT NULL,
    capacidad INTEGER NOT NULL CHECK (capacidad > 0),
    costo_por_hora NUMERIC NOT NULL CHECK (costo_por_hora > 0),
    costo_adicional NUMERIC NOT NULL CHECK (costo_adicional >= 0),
    PRIMARY KEY (id),
    CONSTRAINT salones_FK FOREIGN KEY (id) REFERENCES servicios(id)
);

CREATE TABLE spas (
    id INTEGER,
    costo NUMERIC NOT NULL CHECK (costo > 0),
    duracion VARCHAR2(255) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT spas_FK FOREIGN KEY (id) REFERENCES servicios(id)
);

CREATE TABLE tiendas (
    id INTEGER,
    tipo_productos VARCHAR2(255) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT tiendas_FK FOREIGN KEY (id) REFERENCES servicios(id)
);

CREATE TABLE restaurantes_bares (
    id INTEGER,
    estilo VARCHAR2(255) NOT NULL,
    es_bar INTEGER NOT NULL CHECK (es_bar IN (0, 1)),
    horario VARCHAR2(255) NOT NULL,
    capacidad INTEGER NOT NULL CHECK (capacidad > 0),
    PRIMARY KEY (id),
    CONSTRAINT restaurantes_bares_FK FOREIGN KEY (id) REFERENCES servicios(id)
);

CREATE TABLE productos_menu (
    id INTEGER,
    nombre VARCHAR2(255) NOT NULL,
    costo NUMERIC NOT NULL CHECK (costo > 0),
    PRIMARY KEY (id),
    CONSTRAINT productos_menu_FK FOREIGN KEY (id) REFERENCES restaurantes_bares(id)
);

CREATE SEQUENCE id_productos_menu
START WITH 1
INCREMENT BY 1;

CREATE TABLE sirven (
    id_restaurante_bar INTEGER NOT NULL,
    id_producto INTEGER NOT NULL,
    CONSTRAINT sirven_PK PRIMARY KEY (id_restaurante_bar, id_producto),
    CONSTRAINT sirven_FK1 FOREIGN KEY (id_restaurante_bar) REFERENCES restaurantes_bares(id),
    CONSTRAINT sirven_FK2 FOREIGN KEY (id_producto) REFERENCES productos_menu(id)
);

CREATE TABLE reservas_servicio (
    id_habitacion VARCHAR2(255) NOT NULL,
    id_servicio INTEGER NOT NULL,
    fecha DATE NOT NULL,
    hora_inicio VARCHAR2(255) NOT NULL,
    hora_fin VARCHAR2(255) NOT NULL,
    costo NUMERIC NOT NULL CHECK (costo > 0),
    CONSTRAINT reservas_servicio_PK PRIMARY KEY (id_habitacion, id_servicio, fecha, hora_inicio, hora_fin, costo),
    CONSTRAINT reservas_servicio_FK1 FOREIGN KEY (id_habitacion) REFERENCES habitaciones(id),
    CONSTRAINT reservas_servicio_FK2 FOREIGN KEY (id_servicio) REFERENCES servicios(id)
);

CREATE TABLE cuentas_estadia (
    id INTEGER,
    id_habitacion VARCHAR2(255) NOT NULL,
    monto NUMERIC NOT NULL CHECK (monto >= 0),
    abierta INTEGER NOT NULL CHECK (abierta IN (0, 1)),
    PRIMARY KEY (id),
    CONSTRAINT cuentas_estadia_FK FOREIGN KEY (id_habitacion) REFERENCES habitaciones(id)
);

CREATE SEQUENCE id_cuentas_estadia
START WITH 1
INCREMENT BY 1;

CREATE TABLE reservas_habitacion (
    id_habitacion VARCHAR2(255) NOT NULL,
    num_doc NUMERIC NOT NULL,
    tipo_doc VARCHAR2(255) NOT NULL,
    fecha_entrada DATE NOT NULL,
    fecha_salida DATE NOT NULL,
    plan_consumo INTEGER NOT NULL,
    num_personas INTEGER NOT NULL CHECK (num_personas > 0),
    costo NUMERIC NOT NULL CHECK (costo >= 0),
    id_cuenta INTEGER NOT NULL,
    CONSTRAINT reservas_habitacion_PK PRIMARY KEY (id_habitacion, num_doc, tipo_doc, fecha_entrada, fecha_salida),
    CONSTRAINT reservas_habitacion_FK1 FOREIGN KEY (id_habitacion) REFERENCES habitaciones(id),
    CONSTRAINT reservas_habitacion_FK2 FOREIGN KEY (num_doc, tipo_doc) REFERENCES usuarios(num_doc, tipo_doc),
    CONSTRAINT reservas_habitacion_FK3 FOREIGN KEY (plan_consumo) REFERENCES planes_consumo(id),
    CONSTRAINT reservas_habitacion_FK4 FOREIGN KEY (id_cuenta) REFERENCES cuentas_estadia(id)
);

CREATE TABLE check_ins (
    id NUMERIC,
    id_habitacion VARCHAR2(255) NOT NULL,
    num_doc NUMERIC NOT NULL,
    tipo_doc VARCHAR2(255) NOT NULL,
    fecha DATE NOT NULL,
    hora VARCHAR2(255) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT check_ins_FK1 FOREIGN KEY (id_habitacion) REFERENCES habitaciones(id),
    CONSTRAINT check_ins_FK2 FOREIGN KEY (num_doc, tipo_doc) REFERENCES usuarios(num_doc, tipo_doc)
);

CREATE SEQUENCE id_check_ins
START WITH 1
INCREMENT BY 1;

CREATE TABLE check_outs (
    id_check_in NUMERIC,
    fecha DATE NOT NULL,
    hora VARCHAR2(255) NOT NULL,
    ingresos_totales NUMERIC NOT NULL CHECK (ingresos_totales >= 0),
    CONSTRAINT check_outs_PK PRIMARY KEY (id_check_in),
    CONSTRAINT check_outs_FK FOREIGN KEY (id_check_in) REFERENCES check_ins(id)
);

--select 'drop '||object_type||' '|| object_name || ';' from user_objects where object_type in ('VIEW','PACKAGE','SEQUENCE', 'PROCEDURE', 'FUNCTION', 'INDEX');

--select 'drop '||object_type||' '|| object_name || ';' from user_objects;

--drop table tipos_habitacion;

--POBLACION de la BD


