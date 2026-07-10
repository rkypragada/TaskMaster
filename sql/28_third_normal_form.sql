CREATE TABLE departments
(
    department_id INT PRIMARY KEY,

    department_name VARCHAR(100)
);

CREATE TABLE employee_master
(
    employee_id INT PRIMARY KEY,

    employee_name VARCHAR(100),

    department_id INT
);