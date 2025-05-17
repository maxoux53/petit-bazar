-- ⚠️ Se connecter à 'PG_DB' ⚠️ --
/*SET search_path TO $PG_DB;*/

CREATE TABLE role (
    label VARCHAR(25) PRIMARY KEY
);

CREATE TABLE country (
    name VARCHAR(20) PRIMARY KEY
);

CREATE TABLE city (
    zip_code INT,
    name VARCHAR(20),
    country VARCHAR(20) NOT NULL REFERENCES country(name),
    CONSTRAINT pk_city PRIMARY KEY (zip_code, name),
    CONSTRAINT zip_code_length CHECK (zip_code BETWEEN 1 AND 99999)
);

CREATE TABLE employee (
    id SMALLSERIAL PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    password BYTEA NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    street VARCHAR(30) NOT NULL,
    street_number VARCHAR(4) NOT NULL,
    unit_number SMALLINT,
    role_label VARCHAR(25) NOT NULL,
    hire_date DATE NOT NULL,
    manager_id SMALLINT REFERENCES employee(id),
    city_zip_code INT NOT NULL,
    city_name VARCHAR(20) NOT NULL,
    CONSTRAINT fk_employee_city FOREIGN KEY (city_zip_code, city_name) REFERENCES city(zip_code, name),
    CONSTRAINT unit_number_length CHECK (unit_number >= 1)
);

CREATE TABLE vat (
    type CHAR(1) PRIMARY KEY,
    rate SMALLINT NOT NULL,
    CONSTRAINT rate_range CHECK (rate BETWEEN 0 AND 100)
);

CREATE TABLE category (
    id SMALLSERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE brand (
    id SMALLSERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE product (
    barcode BIGINT PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    description TEXT,
    amount SMALLINT NOT NULL,
    is_available BOOLEAN NOT NULL DEFAULT TRUE,
    vat_type CHAR(1) NOT NULL REFERENCES vat(type),
    category_id SMALLINT NOT NULL REFERENCES category(id),
    brand_id SMALLINT NOT NULL REFERENCES brand(id),
    excl_vat_price MONEY NOT NULL,
    start_date DATE NOT NULL,
    CONSTRAINT excl_vat_price_range CHECK ((excl_vat_price::NUMERIC) > 0)
);

CREATE TABLE customer (
    loyalty_card_number SERIAL PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    birth_date DATE NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone INT,
    vat_number BIGINT,
    loyalty_points SMALLINT NOT NULL DEFAULT 0,
    CONSTRAINT birth_date_past CHECK (birth_date < CURRENT_DATE),
    CONSTRAINT phone_positive CHECK (phone > 0),
    CONSTRAINT vat_number_positive CHECK (vat_number > 0),
    CONSTRAINT loyalty_points_not_negative CHECK (loyalty_points >= 0)
);

CREATE TABLE purchase (
    id BIGSERIAL PRIMARY KEY,
    date DATE NOT NULL,
    employee_id SMALLINT REFERENCES employee(id),
    customer_card_number INT REFERENCES customer(loyalty_card_number),
    CONSTRAINT date_check_not_future CHECK (date <= CURRENT_DATE)
);

CREATE TABLE order_line (
    quantity SMALLINT NOT NULL,
    product_barcode BIGINT REFERENCES product(barcode),
    purchase_id BIGINT NOT NULL REFERENCES purchase(id),
    CONSTRAINT pk_order_line PRIMARY KEY (product_barcode, purchase_id),
    CONSTRAINT quantity_positive CHECK (quantity > 0)
);
