/*
==========================================================
Convert to First Normal Form
==========================================================
*/

DROP TABLE IF EXISTS task_details;

CREATE TABLE task_details
(
    task_id INT AUTO_INCREMENT PRIMARY KEY,

    employee_name VARCHAR(100),

    employee_email VARCHAR(100),

    department VARCHAR(50),

    role VARCHAR(50),

    project_name VARCHAR(100),

    project_manager VARCHAR(100),

    task_name VARCHAR(100)
);

INSERT INTO task_details
(employee_name,employee_email,department,role,
project_name,project_manager,task_name)

VALUES

('Rahul Singh',
'rahul@taskmaster.com',
'Development',
'Developer',
'Hospital Management',
'Priya Sharma',
'Login Module'),

('Rahul Singh',
'rahul@taskmaster.com',
'Development',
'Developer',
'Hospital Management',
'Priya Sharma',
'Dashboard'),

('Rahul Singh',
'rahul@taskmaster.com',
'Development',
'Developer',
'Hospital Management',
'Priya Sharma',
'Patient Module');