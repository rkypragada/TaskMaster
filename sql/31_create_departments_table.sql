/*
============================================================
Project      : TaskMaster
Module       : Module 1
Lesson       : Master Tables
Program      : 31
Table        : departments
Author       : Rama Krishna
============================================================
*/

USE taskmaster;

DROP TABLE IF EXISTS departments;

CREATE TABLE departments
(
    department_id BIGINT AUTO_INCREMENT,

    department_name VARCHAR(100) NOT NULL,

    description VARCHAR(255),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY(department_id),

    UNIQUE(department_name)
);