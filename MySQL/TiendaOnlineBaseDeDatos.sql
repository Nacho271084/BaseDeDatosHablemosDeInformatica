-- Crear la base de datos
CREATE DATABASE TiendaOnline;
USE TiendaOnline;

-- Tabla: clientes
CREATE TABLE clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    email VARCHAR(100),
    ciudad VARCHAR(50),
    fecha_registro DATE
);

-- Tabla: productos
CREATE TABLE productos (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre_producto VARCHAR(100),
    categoria VARCHAR(50),
    precio DECIMAL(10,2),
    stock INT
);

-- Tabla: pedidos
CREATE TABLE pedidos (
    id_pedido INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    fecha_pedido DATE,
    total DECIMAL(10,2),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

-- Tabla: detalle_pedido
CREATE TABLE detalle_pedido (
    id_detalle INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT,
    id_producto INT,
    cantidad INT,
    precio_unitario DECIMAL(10,2),
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla: opiniones
CREATE TABLE opiniones (
    id_opinion INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    id_producto INT,
    puntuacion INT CHECK(puntuacion BETWEEN 1 AND 5),
    comentario TEXT,
    fecha_opinion DATE,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Insertar clientes
INSERT INTO clientes (nombre, email, ciudad, fecha_registro) VALUES
('Ana Torres', 'ana@mail.com', 'Madrid', '2023-01-10'),
('Luis Pérez', 'luis@mail.com', 'Barcelona', '2023-02-20'),
('Marta Ruiz', 'marta@mail.com', 'Sevilla', '2023-03-15'),
('Pablo López', 'pablo@mail.com', 'Valencia', '2023-05-03');

-- Insertar productos
INSERT INTO productos (nombre_producto, categoria, precio, stock) VALUES
('Portátil Lenovo', 'Electrónica', 750.00, 10),
('Smartphone Samsung', 'Electrónica', 450.00, 15),
('Zapatillas Nike', 'Calzado', 90.00, 20),
('Mochila Eastpak', 'Accesorios', 60.00, 8),
('Cafetera Philips', 'Electrodomésticos', 120.00, 5);

-- Insertar pedidos
INSERT INTO pedidos (id_cliente, fecha_pedido, total) VALUES
(1, '2023-02-01', 750.00),
(2, '2023-03-10', 540.00),
(1, '2023-04-22', 150.00),
(3, '2023-05-10', 120.00);

-- Insertar detalle_pedido
INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio_unitario) VALUES
(1, 1, 1, 750.00),
(2, 2, 1, 450.00),
(2, 3, 1, 90.00),
(3, 4, 1, 60.00),
(3, 3, 1, 90.00),
(4, 5, 1, 120.00);

-- Insertar opiniones
INSERT INTO opiniones (id_cliente, id_producto, puntuacion, comentario, fecha_opinion) VALUES
(1, 1, 5, 'Muy buen portátil, lo recomiendo.', '2023-02-10'),
(2, 2, 4, 'Buen móvil, aunque un poco caro.', '2023-03-15'),
(3, 5, 3, 'La cafetera es normalita.', '2023-05-12'),
(1, 4, 5, 'Perfecta para la universidad.', '2023-04-25');
