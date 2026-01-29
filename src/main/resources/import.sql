-- CATEORIAS
INSERT INTO categorias (id, nombre) VALUES (1, 'Harinas y Básicos');
INSERT INTO categorias (id, nombre) VALUES (2, 'Rellenos y Proteínas');
INSERT INTO categorias (id, nombre) VALUES (3, 'Varios (Aceite, Sal, Especias)');
INSERT INTO categorias (id, nombre) VALUES (4, 'Panadería y Bollería');
INSERT INTO categorias (id, nombre) VALUES (5, 'Empanadillas');

-- PRODUCTOS MATERIA PRIMA
INSERT INTO productos (id,nombre, descripcion, precio_venta, categoria_id, existencias, activo, punto_reorden, tipo_producto, sku, unidad_medida) VALUES (1, 'Harina de Trigo', 'Harina de fuerza tipo 00, saco de 25kg.', 0.60, 1, 500.00, true, 100.00, 'MP', 'MP-HAR-001', 'KG');
INSERT INTO productos (id,nombre, descripcion, precio_venta, categoria_id, existencias, activo, punto_reorden, tipo_producto, sku, unidad_medida) VALUES (2, 'Atún en Conserva', 'Atún en aceite de girasol para rellenos.', 8.00, 2, 45.00, true, 10.00, 'MP', 'MP-ATU-001', 'KG');
INSERT INTO productos (id,nombre, descripcion, precio_venta, categoria_id, existencias, activo, punto_reorden, tipo_producto, sku, unidad_medida) VALUES (3, 'Aceite de Girasol', 'Aceite para freír empanadillas.', 2.50, 3, 100.00, true, 20.00, 'MP', 'MP-ACE-001', 'LT');

-- PRODUCTOS PRODUCTO FINAL
INSERT INTO productos (id, nombre, descripcion, precio_venta, categoria_id, existencias, activo, punto_reorden, tipo_producto, sku, unidad_medida) VALUES (4,'Barra de Pan Tradicional', 'Pan de corteza crujiente y miga aireada.', 1.10, 4, 120.00, true, 30.00, 'PT', 'PT-PAN-001', 'UN');
INSERT INTO productos (id,nombre, descripcion, precio_venta, categoria_id, existencias, activo, punto_reorden, tipo_producto, sku, unidad_medida) VALUES (5, 'Empanadilla de Atún', 'Empanadilla artesana frita rellena de atún.', 1.50, 5, 80.00, true, 20.00, 'PT', 'PT-EMP-001', 'UN');

INSERT INTO bom_estructura (producto_final_id, componente_id, cantidad_necesaria, unidad_medida) VALUES (5, 1, 0.05,'KG');
INSERT INTO bom_estructura (producto_final_id, componente_id, cantidad_necesaria, unidad_medida) VALUES (5, 2, 0.03,'KG');
