USE backendflorista;

DESCRIBE categoria;
DESCRIBE producto;
DESCRIBE proveedor;


INSERT INTO categoria
(nombre)
VALUES
('Rosas'),
('Lirios'),
('Tulipanes'),
('Girasoles');

INSERT INTO proveedor
(nombre, direccion, telefono, email) 
VALUES
('Proveedor A', 'Calle 123, Ciudad A', '123-456-7890', 'proveedora@example.com'),
('Proveedor B', 'Avenida 456, Ciudad B', '456-789-0123', 'proveedorb@example.com'),
('Proveedor C', 'Plaza Principal, Ciudad C', '789-012-3456', 'proveedorc@example.com'),
('Proveedor D', 'Calle Principal 789, Ciudad D', '012-345-6789', 'proveedord@example.com');

SELECT * FROM categoria;
Select * FROM proveedor;

INSERT INTO producto
(nombre,descripcion,precio,cantidad_stock,id_proveedor,id_categoria)
VALUES
('Rosa roja','Rosa de alta calidad',10.99,200,3,1);

SELECT * FROM producto;
