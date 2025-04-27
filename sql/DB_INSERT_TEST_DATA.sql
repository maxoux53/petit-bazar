-- ⚠️ Se connecter à 'store_management' ⚠️ --

-- Insertion des rôles
INSERT INTO role (label) VALUES 
('ADMIN'), 
('MANAGER'), 
('CASHIER'), 
('STOCK_MANAGER');

-- Insertion des pays
INSERT INTO country (name) VALUES 
('Belgique'), 
('France'), 
('Allemagne'), 
('Pays-Bas'), 
('Luxembourg');

-- Insertion des villes
INSERT INTO city (zip_code, name, country) VALUES 
(1000, 'Bruxelles', 'Belgique'),
(1348, 'Louvain-la-Neuve', 'Belgique'),
(1050, 'Ixelles', 'Belgique'),
(4000, 'Liège', 'Belgique'),
(5000, 'Namur', 'Belgique'),
(75001, 'Paris', 'France'),
(69001, 'Lyon', 'France');

-- Insertion des employés (mot de passe en bytea "password123" pour tous par simplicité)
INSERT INTO employee (first_name, last_name, password, is_active, street, street_number, unit_number, role_label, hire_date, manager_id, city_zip_code, city_name) VALUES 
('Jean', 'Dupont', E'\\x70617373776F726431323300', TRUE, 'Rue de la Loi', 10, NULL, 'ADMIN', '2020-01-15', NULL, 1000, 'Bruxelles'),
('Marie', 'Martin', E'\\x70617373776F726431323300', TRUE, 'Avenue des Arts', 25, 3, 'MANAGER', '2020-02-01', 1, 1000, 'Bruxelles'),
('Pierre', 'Durand', E'\\x70617373776F726431323300', TRUE, 'Rue Neuve', 42, NULL, 'CASHIER', '2021-03-10', 2, 1050, 'Ixelles'),
('Sophie', 'Lefèvre', E'\\x70617373776F726431323300', TRUE, 'Boulevard Anspach', 15, 2, 'STOCK_MANAGER', '2021-04-05', 2, 1348, 'Louvain-la-Neuve'),
('Lucas', 'Bernard', E'\\x70617373776F726431323300', FALSE, 'Rue Haute', 78, NULL, 'CASHIER', '2022-01-20', 2, 4000, 'Liège');

-- Insertion des taux de TVA
INSERT INTO vat (type, rate) VALUES 
('A', 21),  -- Taux standard
('B', 12),  -- Taux réduit
('C', 6),   -- Taux très réduit
('D', 0);   -- Exonéré

-- Insertion des catégories de produits
INSERT INTO category (name) VALUES 
('Électronique'),
('Alimentation'),
('Vêtements'),
('Jardinage'),
('Librairie');

-- Insertion des marques
INSERT INTO brand (name) VALUES 
('Samsung'),
('Delhaize Selection'),
('H&M'),
('Gardena'),
('Dargaud'),
('Apple'),
('Sony'),
('Philips');

-- Insertion des produits (avec excl_vat_price et start_date directement intégrés)
INSERT INTO product (barcode, name, description, amount, is_available, vat_type, category_id, brand_id, excl_vat_price, start_date) VALUES 
(5901234123457, 'Smartphone Galaxy S22', 'Smartphone haut de gamme avec écran AMOLED 6.1"', 25, TRUE, 'A', 1, 1, '799.99', '2023-01-01'),
(4007817327098, 'Chocolat noir 70%', 'Tablette de chocolat noir pur beurre de cacao', 150, TRUE, 'B', 2, 2, '2.49', '2023-01-01'),
(2112345678900, 'T-shirt coton bio', 'T-shirt en coton bio, taille L, couleur noire', 75, TRUE, 'A', 3, 3, '19.99', '2023-01-01'),
(8711495392919, 'Sécateur Gardena', 'Sécateur de jardin ergonomique', 32, TRUE, 'A', 4, 4, '24.99', '2023-01-01'),
(9782205077940, 'BD Astérix', 'Astérix et la Transitalique', 45, TRUE, 'C', 5, 5, '12.99', '2023-01-01'),
(7350073733347, 'iPad Pro', 'Tablette tactile 11 pouces', 18, TRUE, 'A', 1, 6, '999.99', '2023-01-01'),
(4902505854453, 'Casque WH-1000XM5', 'Casque à réduction de bruit', 12, FALSE, 'A', 1, 7, '349.99', '2023-01-01'),
(8710103954798, 'Machine à café', 'Machine à café automatique', 8, TRUE, 'B', 1, 8, '199.99', '2023-01-01');

-- Insertion des clients
INSERT INTO customer (first_name, last_name, birth_date, email, phone, vat_number, loyalty_points) VALUES 
('Michel', 'Leroy', '1985-03-12', 'michel.leroy@email.com', 0471234567, NULL, 150),
('Camille', 'Dubois', '1992-07-25', 'camille.dubois@email.com', 0489654321, NULL, 75),
('François', 'Lambert', '1978-11-08', 'francois.lambert@email.com', 0475123456, NULL, 230),
('Isabelle', 'Petit', '1990-05-17', 'isabelle.petit@email.com', NULL, NULL, 45),
('Société ABC', 'SPRL', '2010-01-01', 'contact@abc.be', 025123456, 987654321, 320);

-- Insertion des achats
INSERT INTO purchase (date, employee_id, customer_card_number) VALUES 
('2023-09-01', 3, 1),
('2023-09-02', 3, 2),
('2023-09-03', 3, NULL),
('2023-09-04', 3, 3),
('2023-09-05', 3, 1);

-- Insertion des lignes de commande
INSERT INTO order_line (quantity, product_barcode, purchase_id) VALUES 
(1, 5901234123457, 1),  -- Smartphone dans achat 1
(2, 4007817327098, 1),  -- Chocolat dans achat 1
(1, 2112345678900, 2),  -- T-shirt dans achat 2
(3, 4007817327098, 2),  -- Chocolat dans achat 2
(2, 9782205077940, 3),  -- BD dans achat 3
(1, 8711495392919, 4),  -- Sécateur dans achat 4
(1, 7350073733347, 4),  -- iPad dans achat 4
(1, 8710103954798, 5);  -- Machine à café dans achat 5
