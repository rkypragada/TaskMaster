/*
============================================================
Project      : TaskMaster
Module       : Module 1
Lesson       : Task Management
Program      : 46
Table        : tasks
============================================================
*/

USE taskmaster;

DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks
(
    task_id BIGINT AUTO_INCREMENT,

    task_code VARCHAR(20) NOT NULL,

    project_id BIGINT NOT NULL,

    assigned_to BIGINT NOT NULL,

    created_by BIGINT NOT NULL,

    task_title VARCHAR(200) NOT NULL,

    task_description TEXT,

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
        'OPEN',
        'IN_PROGRESS',
        'IN_REVIEW',
        'TESTING',
        'COMPLETED',
        'REOPENED',
        'CANCELLED'
    )
    DEFAULT 'OPEN',

    estimated_hours DECIMAL(5,2),

    actual_hours DECIMAL(5,2),

    start_date DATE,

    due_date DATE,

    completed_date DATE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY(task_id),

    UNIQUE(task_code),

    CONSTRAINT fk_tasks_project
    FOREIGN KEY(project_id)
    REFERENCES projects(project_id),

    CONSTRAINT fk_tasks_assigned_user
    FOREIGN KEY(assigned_to)
    REFERENCES users(user_id),

    CONSTRAINT fk_tasks_created_user
    FOREIGN KEY(created_by)
    REFERENCES users(user_id)
);