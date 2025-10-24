create database hotel;
use hotel;

CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    genero ENUM('Masculino', 'Femenino', 'Otro') NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    departamento VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    rol ENUM('admin', 'usuario', 'empleado') NOT NULL DEFAULT 'usuario'
);

CREATE TABLE tipoHabitacion (
    id_tipoHabitacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    tarifa double NOT NULL
    );
    
CREATE TABLE habitacion (
    id_habitacion INT AUTO_INCREMENT PRIMARY KEY,
    id_tipoHabitacion int not null,
    foreign key (id_tipoHabitacion) references tipoHabitacion(id_tipoHabitacion),
    estado enum('Disponible','Ocupada','Reservada') not null
    );
    
CREATE TABLE huesped (
    id_huesped INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    documento int UNIQUE
);

CREATE TABLE checkin_checkout (
  id_checkin INT AUTO_INCREMENT PRIMARY KEY,
  documento int,
  id_habitacion int NOT NULL,
  fecha_Entrada varchar(50) DEFAULT NULL,
  fecha_Salida varchar(50) DEFAULT NULL,
  
  foreign key (id_habitacion) references habitacion(id_habitacion),
  foreign key (documento) references huesped(documento)
);
CREATE TABLE reserva (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    documento_huesped INT NOT NULL,
    id_habitacion INT NOT NULL,
    fecha_entrada DATE NOT NULL,
    fecha_salida DATE NOT NULL,
    estado ENUM('Pendiente', 'Confirmada', 'Expirada') DEFAULT 'Pendiente',
    fecha_registro varchar(50),
    id_usuario int,
    FOREIGN KEY (documento_huesped) REFERENCES huesped(documento),
    FOREIGN KEY (id_habitacion) REFERENCES habitacion(id_habitacion),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);
select count(*) from reserva;

UPDATE reserva SET fecha_entrada = '2025-10-23' WHERE id_reserva = 3;
UPDATE reserva SET Estado = 'Pendiente' WHERE id_reserva = 3;

select * from usuario;
select * from reserva;
select * from checkin_checkout;
select * from habitacion;
select * from tipoHabitacion;
select huesped.documento, huesped.nombre, huesped.apellido, habitacion.id_habitacion, tipoHabitacion.nombre, tipoHabitacion.tarifa, fecha_Entrada, fecha_Salida from checkin_checkout 
left join huesped on checkin_checkout.documento = huesped.documento
left join habitacion on checkin_checkout.id_habitacion = habitacion.id_habitacion
left join tipoHabitacion on habitacion.id_tipoHabitacion = tipoHabitacion.id_tipoHabitacion;

select * from checkin_checkout 
left join huesped on checkin_checkout.documento = huesped.documento
left join habitacion on checkin_checkout.id_habitacion = habitacion.id_habitacion
left join tipoHabitacion on habitacion.id_tipoHabitacion = tipoHabitacion.id_tipoHabitacion;

INSERT INTO usuario (nombre, apellido, genero, correo, contrasena, fecha_nacimiento, departamento, ciudad, rol)
VALUES ('Julian', 'Henry', 'Masculino', 'hiitslevi240211@gmail.com', '123456', '2001-12-24', 'Magdalena', 'Santa Marta', 'admin');

INSERT INTO usuario (nombre, apellido, genero, correo, contrasena, fecha_nacimiento, departamento, ciudad, rol)
VALUES ('Olmar', 'Lopez', 'Masculino', 'davidlopezarteaga22@gmail.com', '220066', '2006-12-22', 'Magdalena', 'Santa Marta', 'admin');

INSERT INTO usuario (nombre, apellido, genero, correo, contrasena, fecha_nacimiento, departamento, ciudad, rol)
VALUES ('Prueba', 'Empleado', 'Masculino', 'pruebaempleado@gmail.com', '123456', '2006-12-22', 'Magdalena', 'Santa Marta', 'empleado');

INSERT INTO usuario (nombre, apellido, genero, correo, contrasena, fecha_nacimiento, departamento, ciudad, rol)
VALUES ('Prueba', 'Cliente', 'Masculino', 'pruebacliente@gmail.com', '123456', '2006-12-22', 'Magdalena', 'Santa Marta', 'usuario');