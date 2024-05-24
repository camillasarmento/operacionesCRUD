USE ejerciciocrud;

-- Insert elements into Usuario table
INSERT INTO Usuario (nombre, apellidos, correo, contrasenya, rol) VALUES
('Juan', 'Pérez', 'juan.perez@example.com','contrasena123', 'admin'),
('María', 'García', 'maria.garcia@example.com', 'contrasena456', 'user'),
('Carlos', 'López', 'carlos.lopez@example.com', 'contrasena789', 'user'),
('Ana', 'Martínez', 'ana.martinez@example.com', 'contrasena101', 'user');


-- Insert elements into Reserva table
INSERT INTO Reserva (id_reserva, codigo_reserva, fecha_inicio_reserva, fecha_fin_reserva, precio, estado_reserva, pago, id_usuario) VALUES
(1, 'RES123', '2024-05-01 10:00:00', '2024-05-01 12:00:00', 100.50, 'confirmed', 1, 1),
(2, 'RES124', '2024-05-02 11:00:00', '2024-05-02 13:00:00', 150.75, 'pending', 0, 2),
(3, 'RES125', '2024-05-03 12:00:00', '2024-05-03 14:00:00', 200.00, 'cancelled', 0, 3),
(4, 'RES126', '2024-05-04 13:00:00', '2024-05-04 15:00:00', 250.25, 'confirmed', 1, 4);

-- Insert elements into Recordatorios table
INSERT INTO Recordatorios (id_recordatorio, fecha_recordatorio, tipo_recordatorio, id_usuario, id_reserva) VALUES
(1, '2024-04-30 10:00:00', 1, 1, 1),
(2, '2024-05-01 11:00:00', 2, 2, 2),
(3, '2024-05-02 12:00:00', 3, 3, 3),
(4, '2024-05-03 13:00:00', 4, 4, 4);

-- Insert elements into Reportes table
INSERT INTO Reportes (id_reporte, fecha_reporte, descripcion) VALUES
(1, '2024-05-01 10:00:00', 'Reporte de prueba 1'),
(2, '2024-05-02 11:00:00', 'Reporte de prueba 2'),
(3, '2024-05-03 12:00:00', 'Reporte de prueba 3'),
(4, '2024-05-04 13:00:00', 'Reporte de prueba 4');

-- Insert elements into Salas table
INSERT INTO Salas (id_sala, superficie, capacidad, disponibilidad, ubicacion, descripcion) VALUES
(1, 50, 20, 1, 'A101', 'Sala A101'),
(2, 60, 25, 1, 'B202', 'Sala B202'),
(3, 70, 30, 0, 'C303', 'Sala C303'),
(4, 80, 35, 1, 'D404', 'Sala D404');

-- Insert elements into Administrador table
INSERT INTO Administrador (id_administrador, id_usuario) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);

-- Insert elements into Equipamiento table
INSERT INTO Equipamiento (id_equipamiento, tipo_equipamiento, estado, fecha_recepcion, cantidad, id_administrador) VALUES
(1, 'Projector', 'new', '2024-01-01 10:00:00', 5, 1),
(2, 'Microphone', 'used', '2024-02-01 11:00:00', 10, 2),
(3, 'Speaker', 'new', '2024-03-01 12:00:00', 15, 3),
(4, 'Laptop', 'refurbished', '2024-04-01 13:00:00', 20, 4);
