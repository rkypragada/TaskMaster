/*
Second Normal Form Example
*/

DROP TABLE IF EXISTS employee_project;

CREATE TABLE employee_project
(
    employee_id INT,

    project_id INT,

    employee_name VARCHAR(100),

    department VARCHAR(100),

    project_name VARCHAR(100),

    PRIMARY KEY(employee_id,project_id)
);

INSERT INTO employee_project
VALUES

(1,101,'Rahul Singh','Development','Hospital'),

(1,102,'Rahul Singh','Development','Library'),

(2,101,'Anil Kumar','Development','Hospital');