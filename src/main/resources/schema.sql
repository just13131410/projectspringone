CREATE DATABASE employee_management_system;
USE employee_management_system;

CREATE TABLE IF NOT EXISTS employees (
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email_id VARCHAR(100) NOT NULL UNIQUE
);