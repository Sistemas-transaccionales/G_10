--Datos tabla TIPO HABITACION
Insert into tipos_habitacion (id,nombre,costo_por_noche,capacidad) values (id_tipos_habitacion.NEXTVAL,'suite presidencial',350000,2);
Insert into tipos_habitacion (id,nombre,costo_por_noche,capacidad) values (id_tipos_habitacion.NEXTVAL,'suite',250000,3);
Insert into tipos_habitacion (id,nombre,costo_por_noche,capacidad) values (id_tipos_habitacion.NEXTVAL,'familiar',450000,6);
Insert into tipos_habitacion (id,nombre,costo_por_noche,capacidad) values (id_tipos_habitacion.NEXTVAL,'doble',200000,3);
Insert into tipos_habitacion (id,nombre,costo_por_noche,capacidad) values (id_tipos_habitacion.NEXTVAL,'sencilla',100000,1);

SELECT * FROM tipos_habitacion;

--Datos tabla HABITACION
Insert into habitaciones (id,tipo) values ('H101',1);
Insert into habitaciones (id,tipo) values ('H102',1);
Insert into habitaciones (id,tipo) values ('H103',1);
Insert into habitaciones (id,tipo) values ('H104',2);
Insert into habitaciones (id,tipo) values ('H105',2);
Insert into habitaciones (id,tipo) values ('H106',2);
Insert into habitaciones (id,tipo) values ('H107',3);
Insert into habitaciones (id,tipo) values ('H108',3);
Insert into habitaciones (id,tipo) values ('H109',3);
Insert into habitaciones (id,tipo) values ('H110',4);
Insert into habitaciones (id,tipo) values ('H111',4);
Insert into habitaciones (id,tipo) values ('H112',4);
Insert into habitaciones (id,tipo) values ('H113',5);
Insert into habitaciones (id,tipo) values ('H114',5);
Insert into habitaciones (id,tipo) values ('H115',5);
Insert into habitaciones (id,tipo) values ('H201',1);
Insert into habitaciones (id,tipo) values ('H202',1);
Insert into habitaciones (id,tipo) values ('H203',1);
Insert into habitaciones (id,tipo) values ('H204',2);
Insert into habitaciones (id,tipo) values ('H205',2);
Insert into habitaciones (id,tipo) values ('H206',2);
Insert into habitaciones (id,tipo) values ('H207',3);
Insert into habitaciones (id,tipo) values ('H208',3);
Insert into habitaciones (id,tipo) values ('H209',3);
Insert into habitaciones (id,tipo) values ('H210',4);
Insert into habitaciones (id,tipo) values ('H211',4);
Insert into habitaciones (id,tipo) values ('H212',4);
Insert into habitaciones (id,tipo) values ('H213',5);
Insert into habitaciones (id,tipo) values ('H214',5);
Insert into habitaciones (id,tipo) values ('H215',5);


--Datos Tabla DOTACION
Insert into dotaciones (id,nombre) values (id_dotaciones.NEXTVAL,' Televisor');
Insert into dotaciones (id,nombre) values (id_dotaciones.NEXTVAL,'Cafetera');
Insert into dotaciones (id,nombre) values (id_dotaciones.NEXTVAL,'Jacuzzi');
Insert into dotaciones (id,nombre) values (id_dotaciones.NEXTVAL,'Cocina');
Insert into dotaciones (id,nombre) values (id_dotaciones.NEXTVAL,'Comedor');



--Datos Tabla DOTADAS
Insert into dotadas (id_tipo_habitacion,id_dotacion) values (1,1);
Insert into dotadas (id_tipo_habitacion,id_dotacion) values (2,1);
Insert into dotadas (id_tipo_habitacion,id_dotacion) values (1,3);
Insert into dotadas (id_tipo_habitacion,id_dotacion) values (3,4);
Insert into dotadas (id_tipo_habitacion,id_dotacion) values (5,5);

--Datos tabla TIPOS USUARIO
Insert into tipos_usuario (id,nombre) values (111,'ADMIN');
Insert into tipos_usuario (id,nombre) values (222,'GERENTE');
Insert into tipos_usuario (id,nombre) values (333,'RECEPCIONISTA');
Insert into tipos_usuario (id,nombre) values (444,'EMPLEADO');
Insert into tipos_usuario (id,nombre) values (555,'CLIENTE');

--Datos tabla USUARIOS
Insert into usuarios (num_doc,tipo_doc,tipo,nombre,email,contrasenia) values (56447902,'CC',111,'Camilo Olaya','c.olaya@gmail.com','cam1234');
Insert into usuarios (num_doc,tipo_doc,tipo,nombre,email,contrasenia) values (10080902,'CC',222,'Daniela Luque','danielalu.2@gmail.com','006dal');
Insert into usuarios (num_doc,tipo_doc,tipo,nombre,email,contrasenia) values (32218990,'CC',333,'Iván Perez','i.perezm@gmail.com','para124');
Insert into usuarios (num_doc,tipo_doc,tipo,nombre,email,contrasenia) values (47791629,'CC',333,'Fernando Huertas','Hhernandom1@hotmail.com','fers34');
Insert into usuarios (num_doc,tipo_doc,tipo,nombre,email,contrasenia) values (19012833,'CC',444,'Claudia Ruiz','cl.ruizr2@gmail.com','1829227al');
Insert into usuarios (num_doc,tipo_doc,tipo,nombre,email,contrasenia) values (82728912,'CC',444,'Diego Salgar','salgardiegom@hotmail.com','DS920124');
Insert into usuarios (num_doc,tipo_doc,tipo,nombre,email,contrasenia) values (418927902,'CC',444,'Jorge Sarmiento','j.sarmiento@gmail.com','sarm234');
Insert into usuarios (num_doc,tipo_doc,tipo,nombre,email,contrasenia) values (910182212,'CC',444,'Mariana Cifuentes','mariana2cifuent@hotmail.com','0marial');
Insert into usuarios (num_doc,tipo_doc,tipo,nombre,email,contrasenia) values (037528493,'CC',555,'Juan Camilo Fino','jf.finom123@gmail.com','juan92014');
Insert into usuarios (num_doc,tipo_doc,tipo,nombre,email,contrasenia) values (928715830,'CC',555,'Valentina Pineda','valentina.pineda@hotmail.com','vp123984');
Insert into usuarios (num_doc,tipo_doc,tipo,nombre,email,contrasenia) values (592829105,'CC',555,'Ricardo Acero','ricadroacerom5@gmail.com','18391R');
Insert into usuarios (num_doc,tipo_doc,tipo,nombre,email,contrasenia) values (239201810,'CC',555,'Felipe Muñoz','f.muñoz444@hotmail.com','fmm185');


--Datos tabla planes de consumo
Insert into planes_consumo (id,tipo_plan,tasa,min_noches,max_noches) values (id_planes_consumo.nextval,'Larga Estadía',0.02,7,30);
Insert into planes_consumo (id,tipo_plan,tasa,min_noches,max_noches) values (id_planes_consumo.nextval,'Tiempo Compartido',0.03,7,7);
Insert into planes_consumo (id,tipo_plan,tasa,min_noches,max_noches) values (id_planes_consumo.nextval,'Todo Incluido',0.02,1,10);
Insert into planes_consumo (id,tipo_plan,tasa,min_noches,max_noches) values (id_planes_consumo.nextval,'Promociones Particulares',0.03,1,10);

--Datos tabla tipo servicio
Insert into tipos_servicio (id,nombre) values (id_tipos_servicio.nextval,'Piscina');
Insert into tipos_servicio (id,nombre) values (id_tipos_servicio.nextval,'Gimnasio');
Insert into tipos_servicio (id,nombre) values (id_tipos_servicio.nextval,'Internet');
Insert into tipos_servicio (id,nombre) values (id_tipos_servicio.nextval,'Bare(es)');
Insert into tipos_servicio (id,nombre) values (id_tipos_servicio.nextval,'Restaurant(es)');
Insert into tipos_servicio (id,nombre) values (id_tipos_servicio.nextval,'Supermercado');
Insert into tipos_servicio (id,nombre) values (id_tipos_servicio.nextval,'Tiendas');
Insert into tipos_servicio (id,nombre) values (id_tipos_servicio.nextval,'Spa');
Insert into tipos_servicio (id,nombre) values (id_tipos_servicio.nextval,'Lavandería');
Insert into tipos_servicio (id,nombre) values (id_tipoos_servicio.nextval,'Prestamo de utensilios');
Insert into tipos_servicio (id,nombre) values (id_tipos_servicio.nextval,'Salones de reuniones');
Insert into tipos_servicio (id,nombre) values (id_tipos_servicio.nextval,'Salones de conferencia');

--Datos tabla servicios
Insert into servicios (id,tipo,nombre) values (id_servicios.nextval,id_tipos_servicio.nextval,'Piscina');
Insert into servicios (id,tipo,nombre) values (id_servicios.nextval,id_tipos_servicio.nextval,'Gimnasio');
Insert into servicios (id,tipo,nombre) values (id_servicios.nextval,id_tipos_servicio.nextval,'Internet');
Insert into servicios (id,tipo,nombre) values (id_servicios.nextval,id_tipos_servicio.nextval,'Bare(es)');
Insert into servicios (id,tipo,nombre) values (id_servicios.nextval,id_tipos_servicio.nextval,'Restaurant(es)');
Insert into servicios (id,tipo,nombre) values (id_servicios.nextval,id_tipos_servicio.nextval,'Supermercado');
Insert into servicios (id,tipo,nombre) values (id_servicios.nextval,id_tipos_servicio.nextval,'Tiendas');
Insert into servicios (id,tipo,nombre) values (id_servicios.nextval,id_tipos_servicio.nextval,'Spa');
Insert into servicios (id,tipo,nombre) values (id_servicios.nextval,id_tipos_servicio.nextval,'Lavandería');
Insert into servicios (id,tipo,nombre) values (id_servicios.nextval,id_tipos_servicio.nextval,'Prestamo de utensilios');
Insert into servicios (id,tipo,nombre) values (id_servicios.nextval,id_tipos_servicio.nextval,'Salones de reuniones');
Insert into servicios (id,tipo,nombre) values (id_servicios.nextval,id_tipos_servicio.nextval,'Salones de conferencia');

--Datos tabla Gimnasios
Insert into gimnasios (id,hora_apertura,hora_clausura,capacidad) values (id_servicios.nextval,'07:30:00','18:50:00',15);
Insert into gimnasios (id,hora_apertura,hora_clausura,capacidad) values (id_servicios.nextval,'05:30:00','17:30:00',20);
Insert into gimnasios (id,hora_apertura,hora_clausura,capacidad) values (id_servicios.nextval,'08:30:00','20:00:00',25);

--Datos tabla Internet
Insert into internet (id,capacidad) values (id_servicios.nextval,100);
Insert into internet (id,capacidad) values (id_servicios.nextval,70);
Insert into internet (id,capacidad) values (id_servicios.nextval,90);

--Datos tabla Piscina
Insert into piscina (id,capacidad,area,profundidad) values (id_servicios.nextval,50,20.5,2.3);
Insert into piscina (id,capacidad,area,profundidad) values (id_servicios.nextval,20,10.5,1);
Insert into piscina (id,capacidad,area,profundidad) values (id_servicios.nextval,30,16.5,1.8);

--Datos tabla Prestamo Utensilios
Insert into prestamo_utensilios (id,utensilio,costo_danio) values (id_servicios.nextval,'toalla',40.000);
Insert into prestamo_utensilios (id,utensilio,costo_danio) values (id_servicios.nextval,'balon',30.000);
Insert into prestamo_utensilios (id,utensilio,costo_danio) values (id_servicios.nextval,'cartas',20.000);
Insert into prestamo_utensilios (id,utensilio,costo_danio) values (id_servicios.nextval,'monopoly',50.000);

--Datos tabla Salones
Insert into salones (id,tipo_salon,capacidad,costo_por_hora,costo_adicional) values (id_servicios.nextval,'Salón de reuniones',12,70.000,30.000);
Insert into salones (id,tipo_salon,capacidad,costo_por_hora,costo_adicional) values (id_servicios.nextval,'Salón de conferencias',100,600.000,0);

--Datos tabla Spa
Insert into spa (id,costo,duracion) values (id_servicios.nextval,70.000,'45 min');
Insert into spa (id,costo,duracion) values (id_servicios.nextval,50.000,'45 min');
Insert into spa (id,costo,duracion) values (id_servicios.nextval,80.000,'50 min');
Insert into spa (id,costo,duracion) values (id_servicios.nextval,100.000,'65 min');

--Datos tabla Restaurante Bar
Insert into restaurantes_bares (id,estilo,es_bar,horario,capacidad) values (id_servicios.nextval,'italiano','FALSE','horario',50);
Insert into restaurantes_bares (id,estilo,es_bar,horario,capacidad) values (id_servicios.nextval,'oriental','FALSE','horario',40);
Insert into restaurantes_bares (id,estilo,es_bar,horario,capacidad) values (id_servicios.nextval,'internacional','FALSE','horario',60);
Insert into restaurantes_bares (id,estilo,es_bar,horario,capacidad) values (id_servicios.nextval,'rock','TRUE','horario',60);
Insert into restaurantes_bares (id,estilo,es_bar,horario,capacidad) values (id_servicios.nextval,'jazz','TRUE','horario',60);
Insert into restaurantes_bares (id,estilo,es_bar,horario,capacidad) values (id_servicios.nextval,'moderna','TRUE','horario',60);

--Datos tabla Lavandería
Insert into lavanderias (id,tipo_prenda,num_prendas,costo) values (id_servicios.nextval,'camisetas basicas',5,50.000);
Insert into lavanderias (id,tipo_prenda,num_prendas,costo) values (id_servicios.nextval,'camisetas cuidado especial',5,80.000);
Insert into lavanderias (id,tipo_prenda,num_prendas,costo) values (id_servicios.nextval,'pantalones basicos',5,70.000);
Insert into lavanderias (id,tipo_prenda,num_prendas,costo) values (id_servicios.nextval,'pantalones cuidado especial',5,100.000);

--Datos tabla Tienda
Insert into tiendas (id,tipo_productos) values (id_servicios.nextval,'joyería');
Insert into tiendas (id,tipo_productos) values (id_servicios.nextval,'deporte');
Insert into tiendas (id,tipo_productos) values (id_servicios.nextval,'moda');
Insert into tiendas (id,tipo_productos) values (id_servicios.nextval,'belleza');

--Datos tabla ProductosMenu
Insert into productos_menu (id,tipo_nombre,costo) values (id_productos_menu.nextval,'carne',35.000);
Insert into productos_menu (id,tipo_nombre,costo) values (id_productos_menu.nextval,'smoothie',10.000);
Insert into productos_menu (id,tipo_nombre,costo) values (id_productos_menu.nextval,'pescado',25.000);
Insert into productos_menu (id,tipo_nombre,costo) values (id_productos_menu.nextval,'postre',8.000);
Insert into productos_menu (id,tipo_nombre,costo) values (id_productos_menu.nextval,'porción de arroz',10.000);
Insert into productos_menu (id,tipo_nombre,costo) values (id_productos_menu.nextval,'hamburguesa',22.000);
Insert into productos_menu (id,tipo_nombre,costo) values (id_productos_menu.nextval,'pizza',22.000);
Insert into productos_menu (id,tipo_nombre,costo) values (id_productos_menu.nextval,'tacos',20.000);

--Datos tabla Sirven
Insert into sirven (id_rest_bar,id_producto) values (id_servicios.nextval,id_producto_menu.nextval);
Insert into sirven (id_rest_bar,id_producto) values (id_servicios.nextval,id_producto_menu.nextval);
Insert into sirven (id_rest_bar,id_producto) values (id_servicios.nextval,id_producto_menu.nextval);

--Datos tabla Reserva Servicio
Insert into reserva_servicios (id_habitacion,id_servicio,fecha,hora_inicio,hora_fin,costo) values ('H101',id_servicios.nextval,'05/06/2023','07:30:00','09:30:00',50.000);
Insert into reserva_servicios (id_habitacion,id_servicio,fecha,hora_inicio,hora_fin,costo) values ('H102',id_servicios.nextval,'11/07/2023','11:00:00','12:30:00',80.000);
Insert into reserva_servicios (id_habitacion,id_servicio,fecha,hora_inicio,hora_fin,costo) values ('H103',id_servicios.nextval,'02/04/2023','09:30:00','11:30:00',40.000);
Insert into reserva_servicios (id_habitacion,id_servicio,fecha,hora_inicio,hora_fin,costo) values ('H104',id_servicios.nextval,'14/08/2023','07:30:00','09:30:00',90.000);
Insert into reserva_servicios (id_habitacion,id_servicio,fecha,hora_inicio,hora_fin,costo) values ('H105',id_servicios.nextval,'05/09/2023','14:30:00','15:50:00',50.000);

SELECT* FROM cuentas_estadia;

--Datos tabla Cuenta Estadia
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H101',400.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H102',500.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H103',600.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H104',450.000,'FALSE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H105',780.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H106',740.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H107',490.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H108',500.000,'FALSE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H109',390.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H110',390.000,'FALSE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H111',390.000,'FALSE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H112',700.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H113',590.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H114',495.000,'FALSE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H115',543.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H201',765.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H202',223.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H203',785.000,'FALSE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H204',896.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H205',463.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H206',342.000,'FALSE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H207',234.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H208',500.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H209',690.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H210',500.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H211',790.000,'FALSE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H212',390.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H213',800.000,'FALSE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H214',320.000,'TRUE');
Insert into cuentas_estadia (id,id_habitacion,monto,abierta) values (id_cuentas_estadia.nextval,'H215',490.000,'TRUE');

--Datos tabla Reserva Habitacion
Insert into reserva_habitacion (id_habitacion,id_usuario,fecha_entrada,fecha_salida,plan_consumo,num_personas,costo,id_cuenta) values ('H101',id_tipos_usuario.nextval,'3/06/2023','11/06/2023',id_planes_consumo.nextval,'2',100.000,id_cuenta_estadia.nextval);
Insert into reserva_habitacion (id_habitacion,id_usuario,fecha_entrada,fecha_salida,plan_consumo,num_personas,costo,id_cuenta) values ('H102',id_tipos_usuario.nextval,'10/07/2023','17/07/2023',id_planes_consumo.nextval,'2',100.000,id_cuenta_estadia.nextval);
Insert into reserva_habitacion (id_habitacion,id_usuario,fecha_entrada,fecha_salida,plan_consumo,num_personas,costo,id_cuenta) values ('H103',id_tipos_usuario.nextval,'2/04/2023','5/04/2023',id_planes_consumo.nextval,'2',100.000,id_cuenta_estadia.nextval);

--Datos tabla CheckIn
Insert into check_ins (id,id_habitacion,id_usuario,fecha,hora) values (id_check_ins.nextval,'H101',32218990,'CC','3/06/2023','15:30:00');
Insert into check_ins (id,id_habitacion,id_usuario,fecha,hora) values (id_check_ins.nextval,'H102',32218990,'CC','10/07/2023','16:00:00');
Insert into check_ins (id,id_habitacion,id_usuario,fecha,hora) values (id_check_ins.nextval,'H103',32218990,'CC','2/04/2023','15:15:00');

--Datos tabla CheckOut
Insert into check_out (id_checkin,fecha,hora,ingresos_totales) values (id_check_in.nextval,'11/06/2023','10:30:00',900.000);
Insert into check_out (id_checkin,fecha,hora,ingresos_totales) values (id_check_in.nextval,'17/07/2023','9:30:00',780.000);

--Datos tabla Reserva Habitacion
Insert into reservas_habitacion (id_habitacion,id_usuario,fecha_entrada,fecha_salida,plan_consumo,num_personas,costo,id_cuenta) values ('H101',id_tipos_usuario.nextval,'3/06/2023','11/06/2023',id_planes_consumo.nextval,'2',100.000,id_cuenta_estadia.nextval);
Insert into reservas_habitacion (id_habitacion,id_usuario,fecha_entrada,fecha_salida,plan_consumo,num_personas,costo,id_cuenta) values ('H102',id_tipos_usuario.nextval,'10/07/2023','17/07/2023',id_planes_consumo.nextval,'2',100.000,id_cuentas_estadia.nextval);
Insert into reservas_habitacion (id_habitacion,id_usuario,fecha_entrada,fecha_salida,plan_consumo,num_personas,costo,id_cuenta) values ('H103',id_tipos_usuario.nextval,'2/04/2023','5/04/2023',id_planes_consumo.nextval,'2',100.000,id_cuentas_estadia.nextval);

--Datos tabla CheckIn
Insert into check_ins (id,id_habitacion,num_doc,tipo_doc,fecha,hora) values (id_check_ins.nextval,'H101',32218990,'CC','3/06/2023','15:30:00');
Insert into check_ins (id,id_habitacion,num_doc,tipo_doc,fecha,hora) values (id_check_ins.nextval,'H102',32218990,'CC','10/07/2023','16:00:00');
Insert into check_ins (id,id_habitacion,num_doc,tipo_doc,fecha,hora) values (id_check_ins.nextval,'H103',32218990,'CC','2/04/2023','15:15:00');

--Datos tabla CheckOut
Insert into check_outs (id_check_in,fecha,hora,ingresos_totales) values (id_check_ins.nextval,'11/06/2023','10:30:00',900.000);
Insert into check_outs (id_check_in,fecha,hora,ingresos_totales) values (id_check_ins.nextval,'17/07/2023','9:30:00',780.000);