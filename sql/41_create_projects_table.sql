/*
============================================================
Project      : TaskMaster
Module       : Module 1
Lesson       : Project Management
Program      : 41
Table        : projects
============================================================
*/

USE taskmaster;

DROP TABLE IF EXISTS projects;

CREATE TABLE projects
(
    project_id BIGINT AUTO_INCREMENT,

    project_code VARCHAR(20) NOT NULL,

    project_name VARCHAR(150) NOT NULL,

    description TEXT,

    start_date DATE NOT NULL,

    end_date DATE,

    budget DECIMAL(12,2),

    priority ENUM
    (
        'LOW',
        'MEDIUM',
        'HIGH',
        'CRITICAL'
    )
    DEFAULT 'MEDIUM',

    status ENUM
    (
        'PLANNING',
        'ACTIVE',
        'ON_HOLD',
        'COMPLETED',
        'CANCELLED'
    )
    DEFAULT 'PLANNING',

    manager_id BIGINT NOT NULL,

    created_at TIMESTAMP
    DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY(project_id),

    UNIQUE(project_code),

    CONSTRAINT fk_projects_manager

    FOREIGN KEY(manager_id)

    REFERENCES users(user_id)
);