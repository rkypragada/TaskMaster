/*
============================================================
Project      : TaskMaster
Module       : Module 1
Lesson       : Master Tables
Program      : 36
Table        : users
Author       : Rama Krishna
============================================================
*/

USE taskmaster;

DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    user_id BIGINT AUTO_INCREMENT,

    employee_code VARCHAR(20) NOT NULL,

    first_name VARCHAR(50) NOT NULL,

    last_name VARCHAR(50) NOT NULL,

    full_name VARCHAR(120) NOT NULL,

    email VARCHAR(120) NOT NULL,

    phone VARCHAR(15) NOT NULL,

    gender ENUM('Male','Female','Other') NOT NULL,

    date_of_birth DATE,

    designation VARCHAR(100),

    department_id BIGINT NOT NULL,

    password_hash VARCHAR(255) NOT NULL,

    account_status ENUM
    (
        'ACTIVE',
        'INACTIVE',
        'BLOCKED'
    )
    DEFAULT 'ACTIVE',

    created_at TIMESTAMP
    DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP
    DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY(user_id),

    UNIQUE(employee_code),

    UNIQUE(email),

    CONSTRAINT fk_users_department
    FOREIGN KEY(department_id)

    REFERENCES departments(department_id)
);