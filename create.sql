Create database ejerciciocrud;
use ejerciciocrud;

CREATE TABLE Usuario (
id_usuario int auto_increment,
nombre varchar(250) not null,
apellidos varchar(250) not null,
correo varchar(250) not null unique,
contrasenya varchar(250) not null,
rol varchar(10),
primary key (id_usuario)
)engine = InnoDB;

CREATE TABLE Reserva (
id_reserva int,
codigo_reserva varchar(10),
fecha_inicio_reserva datetime,
fecha_fin_reserva datetime,
precio float,
estado_reserva varchar(45),
pago boolean not null default 0,
id_usuario int,
primary key (id_reserva, id_usuario),
foreign key (id_usuario) references Usuario(id_usuario)
)engine = InnoDB;

CREATE TABLE Recordatorios (
id_recordatorio int,
fecha_recordatorio datetime,
tipo_recordatorio int,
id_usuario int not null,
id_reserva int not null,
primary key (id_recordatorio),
foreign key ( id_reserva, id_usuario) references  Reserva(id_reserva, id_usuario)
)engine = InnoDB;

CREATE TABLE Reportes (
id_reporte int,
fecha_reporte datetime,
descripcion longtext,
primary key (id_reporte)
);

CREATE TABLE Salas (
id_sala int,
superficie int,
capacidad int,
disponibilidad boolean,
ubicacion varchar(45),
descripcion longtext,
primary key (id_sala)
);

CREATE TABLE Administrador (
id_administrador int,
id_usuario int,
primary key (id_administrador),
foreign key (id_usuario) references Usuario(id_usuario)
);

CREATE TABLE Equipamiento (
id_equipamiento int,
tipo_equipamiento varchar(45),
estado varchar(45),
fecha_recepcion datetime,
cantidad int,
id_administrador int,
primary key (id_equipamiento, id_administrador),
foreign key (id_administrador) references administrador(id_administrador)
);