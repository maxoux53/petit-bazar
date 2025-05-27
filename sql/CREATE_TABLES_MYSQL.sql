-- ⚠️ Utiliser la base de données en version MySQL ⚠️ --

CREATE TABLE role (
    label VARCHAR(25) PRIMARY KEY
);

CREATE TABLE country (
    name VARCHAR(50) PRIMARY KEY
);

CREATE TABLE city (
    zip_code INT,
    name VARCHAR(20),
    country VARCHAR(50) NOT NULL,
    CONSTRAINT pk_city PRIMARY KEY (zip_code, name),
    CONSTRAINT zip_code_length CHECK (zip_code BETWEEN 1 AND 99999),
    FOREIGN KEY (country) REFERENCES country(name)
);

CREATE TABLE employee (
    id SMALLINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    password BINARY(64) NOT NULL,
    is_active BOOLEAN NOT NULL,
    street VARCHAR(30) NOT NULL,
    street_number VARCHAR(4) NOT NULL,
    unit_number SMALLINT,
    role_label VARCHAR(25) NOT NULL,
    hire_date DATE NOT NULL,
    manager_id SMALLINT,
    city_zip_code INT NOT NULL,
    city_name VARCHAR(20) NOT NULL,
    CONSTRAINT fk_employee_city FOREIGN KEY (city_zip_code, city_name) REFERENCES city(zip_code, name),
    CONSTRAINT fk_employee_manager FOREIGN KEY (manager_id) REFERENCES employee(id),
    CONSTRAINT fk_employee_role FOREIGN KEY (role_label) REFERENCES role(label),
    CONSTRAINT unit_number_length CHECK (unit_number >= 1)
);

CREATE TABLE vat (
    type CHAR(1) PRIMARY KEY,
    rate SMALLINT NOT NULL,
    CONSTRAINT rate_range CHECK (rate BETWEEN 0 AND 100)
);

CREATE TABLE category (
    id SMALLINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE brand (
    id SMALLINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE product (
    barcode BIGINT PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    description TEXT,
    amount SMALLINT NOT NULL,
    is_available BOOLEAN NOT NULL,
    vat_type CHAR(1) NOT NULL,
    category_id SMALLINT NOT NULL,
    brand_id SMALLINT NOT NULL,
    excl_vat_price DECIMAL(10,2) NOT NULL,
    start_date DATE NOT NULL,
    CONSTRAINT fk_product_vat FOREIGN KEY (vat_type) REFERENCES vat(type),
    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category(id),
    CONSTRAINT fk_product_brand FOREIGN KEY (brand_id) REFERENCES brand(id),
    CONSTRAINT excl_vat_price_range CHECK (excl_vat_price > 0)
);

CREATE TABLE customer (
    loyalty_card_number INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    birth_date DATE NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone INT,
    vat_number BIGINT,
    loyalty_points SMALLINT NOT NULL DEFAULT 0,
    CONSTRAINT phone_positive CHECK (phone > 0),
    CONSTRAINT vat_number_positive CHECK (vat_number > 0),
    CONSTRAINT loyalty_points_not_negative CHECK (loyalty_points >= 0)
);

CREATE TABLE purchase (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    employee_id SMALLINT,
    customer_card_number INT,
    CONSTRAINT fk_purchase_employee FOREIGN KEY (employee_id) REFERENCES employee(id),
    CONSTRAINT fk_purchase_customer FOREIGN KEY (customer_card_number) REFERENCES customer(loyalty_card_number)
);

CREATE TABLE order_line (
    quantity SMALLINT NOT NULL,
    product_barcode BIGINT,
    purchase_id BIGINT NOT NULL,
    CONSTRAINT pk_order_line PRIMARY KEY (product_barcode, purchase_id),
    CONSTRAINT fk_orderline_product FOREIGN KEY (product_barcode) REFERENCES product(barcode),
    CONSTRAINT fk_orderline_purchase FOREIGN KEY (purchase_id) REFERENCES purchase(id),
    CONSTRAINT quantity_positive CHECK (quantity > 0)
);
