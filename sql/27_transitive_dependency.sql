DROP TABLE IF EXISTS employee_department;

CREATE TABLE employee_department
(
    employee_id INT PRIMARY KEY,

    employee_name VARCHAR(100),

    department_id INT,

    department_name VARCHAR(100)
);