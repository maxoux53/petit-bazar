-- Script d'insertion des données de base --

INSERT INTO country (name) VALUES
    ('Afghanistan'),
    ('Afrique du Sud'),
    ('Albanie'),
    ('Algérie'),
    ('Allemagne'),
    ('Andorre'),
    ('Angola'),
    ('Antigua-et-Barbuda'),
    ('Arabie saoudite'),
    ('Argentine'),
    ('Arménie'),
    ('Australie'),
    ('Autriche'),
    ('Azerbaïdjan'),
    ('Bahamas'),
    ('Bahreïn'),
    ('Bangladesh'),
    ('Barbade'),
    ('Belgique'),
    ('Belize'),
    ('Bénin'),
    ('Bhoutan'),
    ('Biélorussie'),
    ('Birmanie'),
    ('Bolivie'),
    ('Bosnie-Herzégovine'),
    ('Botswana'),
    ('Brésil'),
    ('Brunei'),
    ('Bulgarie'),
    ('Burkina Faso'),
    ('Burundi'),
    ('Cambodge'),
    ('Cameroun'),
    ('Canada'),
    ('Cap-Vert'),
    ('Centrafrique'),
    ('Chili'),
    ('Chine'),
    ('Chypre'),
    ('Colombie'),
    ('Comores'),
    ('Congo'),
    ('Congo (RDC)'),
    ('Corée du Nord'),
    ('Corée du Sud'),
    ('Costa Rica'),
    ('Côte d''Ivoire'),
    ('Croatie'),
    ('Cuba'),
    ('Danemark'),
    ('Djibouti'),
    ('Dominique'),
    ('Égypte'),
    ('Émirats arabes unis'),
    ('Équateur'),
    ('Érythrée'),
    ('Espagne'),
    ('Estonie'),
    ('Eswatini'),
    ('États-Unis'),
    ('Éthiopie'),
    ('Fidji'),
    ('Finlande'),
    ('France'),
    ('Gabon'),
    ('Gambie'),
    ('Géorgie'),
    ('Ghana'),
    ('Grèce'),
    ('Grenade'),
    ('Guatemala'),
    ('Guinée'),
    ('Guinée équatoriale'),
    ('Guinée-Bissau'),
    ('Guyana'),
    ('Haïti'),
    ('Honduras'),
    ('Hongrie'),
    ('Îles Marshall'),
    ('Îles Salomon'),
    ('Inde'),
    ('Indonésie'),
    ('Irak'),
    ('Iran'),
    ('Irlande'),
    ('Islande'),
    ('Israël'),
    ('Italie'),
    ('Jamaïque'),
    ('Japon'),
    ('Jordanie'),
    ('Kazakhstan'),
    ('Kenya'),
    ('Kirghizistan'),
    ('Kiribati'),
    ('Kosovo'),
    ('Koweït'),
    ('Laos'),
    ('Lesotho'),
    ('Lettonie'),
    ('Liban'),
    ('Liberia'),
    ('Libye'),
    ('Liechtenstein'),
    ('Lituanie'),
    ('Luxembourg'),
    ('Macédoine du Nord'),
    ('Madagascar'),
    ('Malaisie'),
    ('Malawi'),
    ('Maldives'),
    ('Mali'),
    ('Malte'),
    ('Maroc'),
    ('Maurice'),
    ('Mauritanie'),
    ('Mexique'),
    ('Micronésie'),
    ('Moldavie'),
    ('Monaco'),
    ('Mongolie'),
    ('Monténégro'),
    ('Mozambique'),
    ('Namibie'),
    ('Nauru'),
    ('Népal'),
    ('Nicaragua'),
    ('Niger'),
    ('Nigeria'),
    ('Norvège'),
    ('Nouvelle-Zélande'),
    ('Oman'),
    ('Ouganda'),
    ('Ouzbékistan'),
    ('Pakistan'),
    ('Palaos'),
    ('Palestine'),
    ('Panama'),
    ('Papouasie-Nlle-Guinée'),
    ('Paraguay'),
    ('Pays-Bas'),
    ('Pérou'),
    ('Philippines'),
    ('Pologne'),
    ('Portugal'),
    ('Qatar'),
    ('Roumanie'),
    ('Royaume-Uni'),
    ('Russie'),
    ('Rwanda'),
    ('Saint-Kitts-et-Nevis'),
    ('Saint-Marin'),
    ('Saint-Vincent'),
    ('Sainte-Lucie'),
    ('Salvador'),
    ('Samoa'),
    ('São Tomé-et-Principe'),
    ('Sénégal'),
    ('Serbie'),
    ('Seychelles'),
    ('Sierra Leone'),
    ('Singapour'),
    ('Slovaquie'),
    ('Slovénie'),
    ('Somalie'),
    ('Soudan'),
    ('Soudan du Sud'),
    ('Sri Lanka'),
    ('Suède'),
    ('Suisse'),
    ('Suriname'),
    ('Syrie'),
    ('Tadjikistan'),
    ('Taïwan'),
    ('Tanzanie'),
    ('Tchad'),
    ('Tchéquie'),
    ('Thaïlande'),
    ('Timor oriental'),
    ('Togo'),
    ('Tonga'),
    ('Trinité-et-Tobago'),
    ('Tunisie'),
    ('Turkménistan'),
    ('Turquie'),
    ('Tuvalu'),
    ('Ukraine'),
    ('Uruguay'),
    ('Vanuatu'),
    ('Vatican'),
    ('Venezuela'),
    ('Viêt Nam'),
    ('Yémen'),
    ('Zambie'),
    ('Zimbabwe')
;

INSERT INTO vat (type, rate) VALUES
('A', 21),  -- Taux standard
('B', 12),  -- Taux intermédiaire
('C', 6),   -- Taux réduit
('D', 0);   -- Exonéré

INSERT INTO category (name) VALUES
('Alimentation'),
('Électronique'),
('Vêtements'),
('Livres'),
('Meubles'),
('Santé'),
('Beauté'),
('Sports'),
('Jardinage'),
('Jouets'),
('Bricolage'),
('Animalerie'),
('Automobile');

INSERT INTO brand (name) VALUES
('Samsung'),
('Delhaize Selection'),
('Gardena'),
('Apple'),
('Sony'),
('Nike'),
('Adidas'),
('Philips'),
('L''Oréal'),
('Nestlé'),
('IKEA'),
('Bosch'),
('Canon'),
('Lego'),
('HP'),
('Acer'),
('Puma'),
('Asus'),
('Carrefour'),
('Boni');

INSERT INTO product (barcode, name, description, amount, is_available, vat_type, category_id, brand_id, excl_vat_price, start_date) VALUES
(5901234123457, 'Smartphone Galaxy S22', 'Smartphone haut de gamme avec écran AMOLED 6.1"', 25, TRUE, 'A', 2, 1, '799.99', '2023-01-01'),
(4007817327098, 'Chocolat noir 70%', 'Tablette de chocolat noir pur beurre de cacao', 150, TRUE, 'B', 1, 2, '2.49', '2023-01-01'),
(8711495392919, 'Sécateur Gardena', 'Sécateur de jardin ergonomique', 32, TRUE, 'A', 9, 3, '24.99', '2023-01-01'),
(7350073733347, 'iPad Pro', 'Tablette tactile 11 pouces', 18, TRUE, 'A', 2, 4, '999.99', '2023-01-01'),
(4902505854453, 'Casque WH-1000XM5', 'Casque à réduction de bruit', 12, FALSE, 'A', 2, 5, '349.99', '2023-01-01'),
(8714574638291, 'T-shirt Nike Air', 'T-shirt de sport respirant', 50, TRUE, 'A', 3, 6, '29.99', '2023-01-01'),
(8714574638292, 'Short Adidas Training', 'Short léger pour entraînement', 40, TRUE, 'A', 3, 7, '24.99', '2023-01-01'),
(8714574638293, 'Ampoule LED Philips', 'Ampoule LED E27 10W', 100, TRUE, 'B', 11, 8, '4.99', '2023-01-01'),
(8714574638294, 'Shampooing L''Oréal', 'Shampooing nourrissant 250ml', 60, TRUE, 'B', 7, 9, '5.49', '2023-01-01'),
(8714574638295, 'Café soluble Nestlé', 'Café instantané 200g', 80, TRUE, 'B', 1, 10, '6.99', '2023-01-01'),
(8714574638296, 'Table basse LACK', 'Table basse blanche 90x55cm', 15, TRUE, 'A', 5, 11, '39.99', '2023-01-01'),
(8714574638297, 'Perceuse Bosch', 'Perceuse sans fil 18V', 10, TRUE, 'A', 11, 12, '89.99', '2023-01-01'),
(8714574638298, 'Imprimante Canon Pixma', 'Imprimante jet d''encre couleur', 8, TRUE, 'A', 2, 13, '59.99', '2023-01-01'),
(8714574638299, 'Jeu Lego City', 'Coffret de construction Lego City', 20, TRUE, 'B', 10, 14, '29.99', '2023-01-01'),
(8714574638300, 'Cartouche HP 304', 'Cartouche d''encre noire', 30, TRUE, 'A', 2, 15, '14.99', '2023-01-01'),
(8714574638301, 'Ordinateur portable Acer Aspire', 'PC portable 15.6" 8Go RAM', 7, TRUE, 'A', 2, 16, '499.99', '2023-01-01'),
(8714574638302, 'Ballon Puma', 'Ballon de football taille 5', 25, TRUE, 'A', 8, 17, '19.99', '2023-01-01'),
(8714574638303, 'PC portable Asus VivoBook', 'PC portable 14" 512Go SSD', 6, TRUE, 'A', 2, 18, '599.99', '2023-01-01'),
(8714574638304, 'Yaourt nature Carrefour', 'Yaourt nature 4x125g', 70, TRUE, 'C', 1, 19, '1.99', '2023-01-01'),
(8714574638305, 'Biscuits Boni', 'Biscuits au beurre 250g', 90, TRUE, 'C', 1, 20, '2.29', '2023-01-01'),
(8714574638306, 'Livre "Le Petit Prince"', 'Roman classique de Saint-Exupéry', 35, TRUE, 'C', 4, 2, '7.99', '2023-01-01'),
(8714574638307, 'Lampe de bureau IKEA', 'Lampe LED orientable', 22, TRUE, 'B', 5, 11, '14.99', '2023-01-01'),
(8714574638308, 'Brosse à dents Philips Sonicare', 'Brosse à dents électrique', 18, TRUE, 'A', 6, 8, '39.99', '2023-01-01'),
(8714574638309, 'Lait demi-écrémé Delhaize', 'Brique de lait 1L', 120, TRUE, 'C', 1, 2, '0.99', '2023-01-01'),
(8714574638310, 'Jus d''orange Boni', 'Jus d''orange 1L', 80, TRUE, 'C', 1, 20, '1.49', '2023-01-01'),
(8714574638311, 'Chaussures de running Nike', 'Chaussures de course légères', 15, TRUE, 'A', 3, 6, '69.99', '2023-01-01'),
(8714574638312, 'Sweat Adidas Originals', 'Sweat à capuche', 20, TRUE, 'A', 3, 7, '49.99', '2023-01-01'),
(8714574638313, 'Tondeuse Gardena', 'Tondeuse à gazon électrique', 5, TRUE, 'A', 9, 3, '129.99', '2023-01-01'),
(8714574638314, 'Batterie externe Samsung', 'Batterie 10000mAh', 30, TRUE, 'A', 2, 1, '24.99', '2023-01-01'),
(8714574638315, 'Chargeur Apple MagSafe', 'Chargeur sans fil', 25, TRUE, 'A', 2, 4, '39.99', '2023-01-01'),
(8714574638316, 'Câble HDMI Sony', 'Câble HDMI 2m', 40, TRUE, 'A', 2, 5, '12.99', '2023-01-01'),
(8714574638317, 'Lait infantile Nestlé', 'Lait en poudre 800g', 35, TRUE, 'B', 1, 10, '14.99', '2023-01-01'),
(8714574638318, 'Crème visage L''Oréal', 'Crème hydratante 50ml', 28, TRUE, 'B', 7, 9, '9.99', '2023-01-01'),
(8714574638319, 'Table de jardin IKEA', 'Table extérieure 120x70cm', 8, TRUE, 'A', 5, 11, '79.99', '2023-01-01'),
(8714574638320, 'Scie sauteuse Bosch', 'Scie sauteuse électrique', 12, TRUE, 'A', 11, 12, '59.99', '2023-01-01'),
(8714574638321, 'Livre "1984"', 'Roman de George Orwell', 30, TRUE, 'C', 4, 2, '8.99', '2023-01-01'),
(8714574638322, 'Puzzle Lego Friends', 'Puzzle 500 pièces', 18, TRUE, 'B', 10, 14, '14.99', '2023-01-01'),
(8714574638323, 'Cartouche couleur HP', 'Cartouche d''encre couleur', 20, TRUE, 'A', 2, 15, '19.99', '2023-01-01'),
(8714574638324, 'Écran PC Asus 24"', 'Écran LED Full HD', 10, TRUE, 'A', 2, 18, '129.99', '2023-01-01'),
(8714574638325, 'Baskets Puma Smash', 'Baskets basses', 22, TRUE, 'A', 3, 17, '39.99', '2023-01-01'),
(8714574638326, 'Sac à dos Adidas', 'Sac à dos sport', 18, TRUE, 'A', 3, 7, '34.99', '2023-01-01'),
(8714574638327, 'Brosse à cheveux L''Oréal', 'Brosse démêlante', 25, TRUE, 'B', 7, 9, '6.99', '2023-01-01'),
(8714574638328, 'Croquettes chien Boni', 'Croquettes 3kg', 40, TRUE, 'B', 12, 20, '8.99', '2023-01-01'),
(8714574638329, 'Croquettes chat Carrefour', 'Croquettes 2kg', 35, TRUE, 'B', 12, 19, '6.99', '2023-01-01'),
(8714574638330, 'Huile moteur Bosch', 'Huile synthétique 5L', 12, TRUE, 'A', 13, 12, '29.99', '2023-01-01'),
(8714574638331, 'Essuie-glaces Bosch', 'Paire d''essuie-glaces', 20, TRUE, 'A', 13, 12, '14.99', '2023-01-01'),
(8714574638332, 'Batterie voiture Philips', 'Batterie 60Ah', 6, TRUE, 'A', 13, 8, '89.99', '2023-01-01'),
(8714574638333, 'Gants de jardinage Gardena', 'Gants taille M', 30, TRUE, 'B', 9, 3, '7.99', '2023-01-01'),
(8714574638334, 'Bâton de colle UHU', 'Bâton de colle 21g', 60, TRUE, 'C', 11, 2, '1.49', '2023-01-01');

INSERT INTO role (label) VALUES
('ADMINISTRATEUR'),
('CAISSIER'),
('SAISONNIER/ÉTUDIANT'),
('BOUCHER');

INSERT INTO city (zip_code, name, country) VALUES
(1000, 'Bruxelles', 'Belgique'),
(1050, 'Ixelles', 'Belgique'),
(4000, 'Liège', 'Belgique'),
(2000, 'Anvers', 'Belgique'),
(7000, 'Mons', 'Belgique');

INSERT INTO employee (first_name, last_name, password, is_active, street, street_number, unit_number, role_label, hire_date, manager_id, city_zip_code, city_name) VALUES
('Jean', 'Dupont', E'\\x70617373776F726431323300', TRUE, 'Rue de la Loi', '10', NULL, 'ADMINISTRATEUR', '2020-01-15', NULL, 1000, 'Bruxelles'),
('Pierre', 'Durand', E'\\x70617373776F726431323300', TRUE, 'Rue Neuve', '42B', NULL, 'CAISSIER', '2021-03-10', 1, 1050, 'Ixelles'),
('Sophie', 'Lemaire', E'\\x70617373776F726431323300', TRUE, 'Boulevard d''Avroy', '15', NULL, 'CAISSIER', '2022-05-20', 1, 4000, 'Liège'),
('Lucas', 'Vermeulen', E'\\x70617373776F726431323300', TRUE, 'Meir', '101', NULL, 'SAISONNIER/ÉTUDIANT', '2023-02-01', 1, 2000, 'Anvers'),
('Emma', 'Dubois', E'\\x70617373776F726431323300', TRUE, 'Rue de Nimy', '8', NULL, 'BOUCHER', '2021-09-10', 1, 7000, 'Mons');

INSERT INTO customer (first_name, last_name, birth_date, email, phone, vat_number, loyalty_points) VALUES
('Michel', 'Leroy', '1985-03-12', 'michel.leroy@email.com', 0471234567, NULL, 150),
('Camille', 'Dubois', '1992-07-25', 'camille.dubois@email.com', 0489654321, 0823456780, 75),
('Sophie', 'Martin', '1990-01-15', 'sophie.martin@email.com', 0471122334, NULL, 120),
('Lucas', 'Bernard', '1988-06-22', 'lucas.bernard@email.com', 0471987654, NULL, 60),
('Emma', 'Petit', '1995-09-10', 'emma.petit@email.com', 0471765432, NULL, 90),
('Louis', 'Robert', '1982-11-30', 'louis.robert@email.com', 0471345678, NULL, 30),
('Chloé', 'Richard', '1993-04-18', 'chloe.richard@email.com', 0471456789, 0412123456, 110),
('Nathan', 'Durand', '1987-08-27', 'nathan.durand@email.com', 0471567890, NULL, 80),
('Léa', 'Moreau', '1991-12-05', 'lea.moreau@email.com', 0471678901, NULL, 55),
('Hugo', 'Simon', '1989-03-14', 'hugo.simon@email.com', 0471789012, NULL, 40),
('Manon', 'Laurent', '1994-07-21', 'manon.laurent@email.com', 0471890123, NULL, 95),
('Arthur', 'Lefebvre', '1986-10-02', 'arthur.lefebvre@email.com', 0471901234, NULL, 70),
('Julie', 'Michel', '1996-02-28', 'julie.michel@email.com', 0471012345, NULL, 85),
('Gabriel', 'Garcia', '1984-05-19', 'gabriel.garcia@email.com', 0471123456, 0123456789, 65),
('Alice', 'David', '1993-11-11', 'alice.david@email.com', 0471234568, NULL, 100),
('Tom', 'Roux', '1990-08-08', 'tom.roux@email.com', 0471345679, NULL, 50),
('Sarah', 'Vincent', '1987-01-23', 'sarah.vincent@email.com', 0471456780, NULL, 115),
('Maxime', 'Fontaine', '1992-03-30', 'maxime.fontaine@email.com', 0471567891, NULL, 77),
('Laura', 'Chevalier', '1995-06-17', 'laura.chevalier@email.com', 0471678902, NULL, 82),
('Antoine', 'Lambert', '1983-09-25', 'antoine.lambert@email.com', 0471789013, 0999999991, 68);

INSERT INTO purchase (date, employee_id, customer_card_number) VALUES
('2023-10-15', 1, 1),
('2023-10-16', 2, 2),
('2023-10-17', 1, 3),
('2023-10-18', 2, 4),
('2023-10-19', 1, 5),
('2023-10-20', 2, 6),
('2023-10-21', 1, 7),
('2023-10-22', 2, 8),
('2023-10-25', 1, 1),     -- Client 1 avec employé 1 (deuxième achat)
('2023-11-02', 1, 1),     -- Client 1 avec employé 1 (troisième achat)
('2023-10-28', 2, 3),     -- Client 3 avec employé 2 (deuxième achat)
('2023-11-05', 2, 3),     -- Client 3 avec employé 2 (troisième achat)
('2023-10-30', 2, 5),     -- Client 5 avec employé 2 (deuxième achat)
('2023-11-10', 1, 5),     -- Client 5 avec employé 1 (troisième achat)
('2023-11-01', 2, 7),     -- Client 7 avec employé 2 (deuxième achat)
('2023-11-12', 3, 7),     -- Client 7 avec employé 3 (troisième achat)
('2023-11-15', 3, 10),    -- Client 10 avec employé 3 (premier achat)
('2023-11-20', 3, 10);    -- Client 10 avec employé 3 (deuxième achat)

INSERT INTO order_line (quantity, product_barcode, purchase_id) VALUES
(1, 5901234123457, 1),  -- Smartphone dans achat 1
(2, 4007817327098, 1),  -- Chocolat dans achat 1
(1, 8711495392919, 1),  -- Sécateur dans achat 1
(1, 7350073733347, 2),  -- iPad dans achat 2
(1, 4902505854453, 2),  -- Casque dans achat 2
(3, 8714574638295, 3),  -- Café soluble Nestlé dans achat 3
(2, 8714574638291, 3),  -- T-shirt Nike Air dans achat 3
(1, 8714574638304, 4),  -- Yaourt nature Carrefour dans achat 4
(2, 8714574638311, 4),  -- Chaussures de running Nike dans achat 4
(1, 8714574638325, 5),  -- Baskets Puma Smash dans achat 5
(1, 8714574638326, 5),  -- Sac à dos Adidas dans achat 5
(2, 8714574638292, 6),  -- Short Adidas Training dans achat 6
(1, 8714574638293, 6),  -- Ampoule LED Philips dans achat 6
(1, 8714574638294, 7),  -- Shampooing L'Oréal dans achat 7
(2, 8714574638299, 7),  -- Jeu Lego City dans achat 7
(1, 8714574638300, 8),  -- Cartouche HP 304 dans achat 8
(1, 8714574638301, 8),  -- Ordinateur portable Acer Aspire dans achat 8
(1, 8714574638303, 9),    -- PC portable Asus
(2, 8714574638310, 9),    -- Jus d'orange Boni
(1, 8714574638297, 10),   -- Perceuse Bosch
(1, 8714574638334, 10),   -- Bâton de colle UHU
(3, 8714574638309, 11),   -- Lait demi-écrémé Delhaize
(1, 8714574638320, 11),   -- Scie sauteuse Bosch
(2, 8714574638305, 12),   -- Biscuits Boni
(1, 8714574638324, 12),   -- Écran PC Asus
(1, 8714574638319, 13),   -- Table de jardin IKEA
(2, 8714574638327, 13),   -- Brosse à cheveux L'Oréal
(1, 8714574638316, 14),   -- Câble HDMI Sony
(4, 8714574638306, 14),   -- Livre "Le Petit Prince"
(1, 8714574638330, 15),   -- Huile moteur Bosch
(2, 8714574638331, 15),   -- Essuie-glaces Bosch
(1, 8714574638332, 16),   -- Batterie voiture Philips
(3, 8714574638333, 16),   -- Gants de jardinage Gardena
(1, 8714574638313, 17),   -- Tondeuse Gardena
(2, 8714574638314, 17),   -- Batterie externe Samsung
(1, 8714574638315, 18),   -- Chargeur Apple MagSafe
(1, 8714574638318, 18);   -- Crème visage L'Oréal
