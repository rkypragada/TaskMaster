/*
============================================================
TaskMaster
Roles Table
============================================================
*/

USE taskmaster;

DROP TABLE IF EXISTS roles;

CREATE TABLE roles
(
    role_id BIGINT AUTO_INCREMENT,

    role_name VARCHAR(50) NOT NULL,

    description VARCHAR(255),

    PRIMARY KEY(role_id),

    UNIQUE(role_name)
);