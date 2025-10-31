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

DELIMITER //

CREATE PROCEDURE registrarUsuarios(
IN usuario_nombre VARCHAR(50),
IN usuario_apellido VARCHAR(50),
IN usuario_genero ENUM('Masculino','Femenino','Otro'),
IN usuario_correo VARCHAR(100),
IN usuario_contrasena VARCHAR(255),
IN usuario_fecha_nacimiento DATE,
IN usuario_departamento VARCHAR(100),
IN usuario_ciudad VARCHAR(100),
IN usuario_rol ENUM('admin','usuario','empleado')
)
BEGIN
INSERT INTO usuario
(nombre, apellido, genero, correo, contrasena, fecha_nacimiento, departamento, ciudad, rol)
VALUES
(usuario_nombre, usuario_apellido, usuario_genero, usuario_correo, usuario_contrasena, usuario_fecha_nacimiento, usuario_departamento, usuario_ciudad, usuario_rol);
END //
DELIMITER;

DELIMITER //
CREATE PROCEDURE iniciarSesion(
in usuario_correo varchar(100), 
in usuario_contrasena varchar(255)) 
begin SELECT * FROM usuario 
WHERE correo = usuario_correo 
AND contrasena = usuario_contrasena;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE datosUsuario(
in usuario_id varchar(50))
begin SELECT * FROM usuario 
WHERE id_usuario = usuario_id;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE insertarHabitacion(
in habitacion_nombre varchar(50),
in habitacion_descripcion varchar(100),
in habitacion_tarifa double
)
begin insert into tipohabitacion(nombre, descripcion, tarifa) values (habitacion_nombre, habitacion_descripcion, habitacion_tarifa);
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE buscarReserva(
in reserva_documento int,
in reserva_estado varchar(50))
begin SELECT * FROM reserva 
WHERE documento_huesped = reserva_documento AND estado = reserva_estado;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE hacerReserva(
in reserva_documento int,
in reserva_id_habitacion int,
in reserva_fechaentrada Date,
in reserva_fechasalida Date,
in reserva_estado varchar(50),
in reserva_fecharegistro varchar(50),
in reserva_id_usuario int)
begin INSERT INTO reserva (documento_huesped, id_habitacion, fecha_entrada, fecha_salida, estado, fecha_registro, id_usuario) 
VALUES (reserva_documento, reserva_id_habitacion, reserva_fechaentrada, reserva_fechasalida , reserva_estado, reserva_fecharegistro, reserva_id_usuario);
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE actualizarEstadoReserva(
in reserva_estado varchar(50),
in reserva_documento int)
begin UPDATE reserva SET estado = reserva_estado WHERE documento_huesped = reserva_documento;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE verReservaPorUsuario(
in reserva_id_usuario int)
begin SELECT id_reserva, documento_huesped, nombre, apellido, id_habitacion, fecha_entrada, fecha_salida, estado, fecha_registro, id_usuario FROM reserva left join huesped on reserva.documento_huesped = huesped.documento WHERE id_usuario = reserva_id_usuario;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE verReservas()
begin SELECT id_reserva, documento_huesped, nombre, apellido, id_habitacion, fecha_entrada, fecha_salida, estado, fecha_registro, id_usuario FROM reserva left join huesped on reserva.documento_huesped = huesped.documento;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE verReserva()
begin SELECT * FROM reserva;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE agregarHuesped(
in huesped_nombre varchar(50),
in huesped_apellido varchar(50),
in huesped_documento int)
begin INSERT INTO huesped (nombre, apellido, documento) VALUES (huesped_nombre, huesped_apellido, huesped_documento);
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE verHuesped(
in huesped_documento int)
begin SELECT * FROM huesped WHERE documento = huesped_documento;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE agregarHabitacion(
in habitacion_id_tipoHabitacion int,
in habitacion_estado enum('Disponible','Ocupada','Reservada'))
begin INSERT INTO habitacion (id_tipoHabitacion, estado) VALUES (habitacion_id_tipoHabitacion, habitacion_estado);
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE mostrarHabitacion()
begin select id_habitacion, nombre, descripcion, tarifa, estado from habitacion left join tipohabitacion on tipohabitacion.id_tipoHabitacion = habitacion.id_tipoHabitacion;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE modificarEstadoHabitacion(
in habitacion_estado enum('Disponible','Ocupada','Reservada'),
in habitacion_id int)
begin UPDATE habitacion SET estado = habitacion_estado WHERE id_habitacion = habitacion_id;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE buscarHuesped(
in checkin_checkout_documento int)
begin SELECT * FROM checkin_checkout WHERE documento = checkin_checkout_documento AND fecha_Salida is null;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE hacerCheckin(
in checkin_checkout_documento int,
in checkin_checkout_id_habitacion int,
in checkin_checkout_fechaEntrada varchar(50),
in checkin_checkout_fechaSalida varchar(50))
begin INSERT INTO checkin_checkout (documento, id_habitacion, fecha_Entrada, fecha_Salida) VALUES (checkin_checkout_documento, checkin_checkout_id_habitacion, checkin_checkout_fechaEntrada, checkin_checkout_fechaSalida);
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE hacerCheckout(
in checkin_checkout_fechaSalida varchar(50),
in checkin_checkout_documento int)
begin UPDATE checkin_checkout SET fecha_Salida = checkin_checkout_fechaSalida WHERE documento = checkin_checkout_documento AND fecha_Salida is null;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE datosCheck(
in checkin_checkout_documento int)
begin SELECT * FROM checkin_checkout WHERE documento = checkin_checkout_documento;
end //
DELIMITER ;


INSERT INTO usuario (nombre, apellido, genero, correo, contrasena, fecha_nacimiento, departamento, ciudad, rol)
VALUES ('Julian', 'Henry', 'Masculino', 'hiitslevi240211@gmail.com', '123456', '2001-12-24', 'Magdalena', 'Santa Marta', 'admin');

INSERT INTO usuario (nombre, apellido, genero, correo, contrasena, fecha_nacimiento, departamento, ciudad, rol)
VALUES ('Olmar', 'Lopez', 'Masculino', 'davidlopezarteaga22@gmail.com', '220066', '2006-12-22', 'Magdalena', 'Santa Marta', 'admin');

INSERT INTO usuario (nombre, apellido, genero, correo, contrasena, fecha_nacimiento, departamento, ciudad, rol)
VALUES ('Prueba', 'Empleado', 'Masculino', 'pruebaempleado@gmail.com', '123456', '2006-12-22', 'Magdalena', 'Santa Marta', 'empleado');

INSERT INTO usuario (nombre, apellido, genero, correo, contrasena, fecha_nacimiento, departamento, ciudad, rol)
VALUES ('Prueba', 'Cliente', 'Masculino', 'pruebacliente@gmail.com', '123456', '2006-12-22', 'Magdalena', 'Santa Marta', 'usuario');