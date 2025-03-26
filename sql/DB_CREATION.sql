CREATE DATABASE project;

CREATE TABLE role (
    label VARCHAR(25) PRIMARY KEY
);

CREATE TABLE employee (
    id NUMERIC(5) PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    password VARCHAR(250) NOT NULL, -- temporaire, à revoir en fonction du hash
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    street VARCHAR(30) NOT NULL,
    street_number NUMERIC(3) NOT NULL,
    unit_number NUMERIC(2),
    role_label VARCHAR(25) NOT NULL,
    hire_date DATE NOT NULL,
    manager_id NUMERIC(5) REFERENCES employee(id),
    city_zip_code NUMERIC(4) NOT NULL REFERENCES city(zip_code),
    city_name VARCHAR(20) NOT NULL REFERENCES city(name)
);

CREATE TABLE city (
    zip_code NUMERIC(4),
    name VARCHAR(20) NOT NULL,
    country VARCHAR(20) NOT NULL REFERENCES country(name),
    CONSTRAINT pk_city PRIMARY KEY (zip_code, name)
);

CREATE TABLE country (
    name VARCHAR(20) PRIMARY KEY
);

CREATE TABLE price_history (
    excl_vat_price NUMERIC(10,2) NOT NULL,
    discount NUMERIC(2) NOT NULL,
    start_date DATE NOT NULL,
    product_barcode NUMERIC(15) NOT NULL REFERENCES product(barcode),
    CONSTRAINT pk_price_history PRIMARY KEY (start_date, product_barcode)
);

CREATE TABLE product (
    barcode NUMERIC(15) PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    description VARCHAR(350),
    amount NUMERIC(4) NOT NULL,
    is_available BOOLEAN NOT NULL DEFAULT TRUE,
    vat_type CHAR(1) NOT NULL REFERENCES vat(type),
    category_id NUMERIC(3) NOT NULL REFERENCES category(id),
    brand_id NUMERIC(3) NOT NULL REFERENCES brand(id),
    supplier_vat_number NUMERIC(10) NOT NULL REFERENCES supplier(vat_number)
);

CREATE TABLE vat (
    type CHAR(1) PRIMARY KEY,
    rate NUMERIC(3,2) NOT NULL
);

CREATE TABLE category (
    id NUMERIC(3) PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE brand (
    id NUMERIC(3) PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE supplier (
    vat_number NUMERIC(10) PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone NUMERIC(15) NOT NULL,
    country_name VARCHAR(20) NOT NULL REFERENCES country(name)
);

CREATE TABLE order_line (
    quantity NUMERIC(3) NOT NULL,
    product_barcode NUMERIC(15) NOT NULL REFERENCES product(barcode),
    purchase_id NUMERIC(6) NOT NULL REFERENCES purchase(id),
    CONSTRAINT pk_order_line PRIMARY KEY (product_barcode, purchase_id)
);

CREATE TABLE purchase (
    id NUMERIC(6) PRIMARY KEY,
    date DATE NOT NULL,
    employee_id NUMERIC(5) NOT NULL REFERENCES employee(id),
    customer_card_number NUMERIC(15) REFERENCES customer(loyalty_card_number)
);

CREATE TABLE customer (
    loyalty_card_number NUMERIC(15) PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    birth_date DATE NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone NUMERIC(15),
    vat_number NUMERIC(10),
    loyalty_points NUMERIC(4) NOT NULL DEFAULT 0
);
