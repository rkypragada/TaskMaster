/*
==========================================================
Project : TaskMaster
Lesson 3 : Un-Normalized Data
==========================================================
*/

USE taskmaster;

DROP TABLE IF EXISTS unnormalized_tasks;

CREATE TABLE unnormalized_tasks
(
    employee_name VARCHAR(100),

    employee_email VARCHAR(100),

    department VARCHAR(50),

    role VARCHAR(50),

    project_name VARCHAR(100),

    project_manager VARCHAR(100),

    task1 VARCHAR(100),

    task2 VARCHAR(100),

    task3 VARCHAR(100)
);

INSERT INTO unnormalized_tasks
VALUES

('Rahul Singh',
'rahul@taskmaster.com',
'Development',
'Developer',
'Hospital Management',
'Priya Sharma',
'Login Module',
'Dashboard',
'Patient Module'),

('Anil Kumar',
'anil@taskmaster.com',
'Development',
'Developer',
'Library Management',
'Ravi Kumar',
'Book Entry',
'Issue Books',
'Return Books');

SELECT *
FROM unnormalized_tasks;