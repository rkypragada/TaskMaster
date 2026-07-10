CREATE TABLE employees
(
    employee_id INT PRIMARY KEY,

    employee_name VARCHAR(100),

    department VARCHAR(100)
);

CREATE TABLE projects
(
    project_id INT PRIMARY KEY,

    project_name VARCHAR(100)
);

CREATE TABLE employee_projects
(
    employee_id INT,

    project_id INT,

    PRIMARY KEY(employee_id,project_id)
);