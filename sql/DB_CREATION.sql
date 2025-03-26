CREATE DATABASE project;

CREATE TABLE role (
    label VARCHAR(25) PRIMARY KEY
);

CREATE TABLE employees (
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
    manager_id NUMERIC(5) REFERENCES employees(id),
    city_zip_code NUMERIC(4) NOT NULL REFERENCES city(zip_code),
    city_name VARCHAR(20) NOT NULL REFERENCES city(name)
);

CREATE TABLE city (
    zip_code NUMERIC(4) PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    country VARCHAR(20) NOT NULL REFERENCES country(name)
);

CREATE TABLE country (
    name VARCHAR(20) PRIMARY KEY
);
