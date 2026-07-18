USE taskmaster;

CREATE OR REPLACE VIEW vw_employee_directory AS

SELECT

u.user_id,

u.employee_code,

u.full_name,

u.email,

u.designation,

d.department_name,

r.role_name,

u.account_status

FROM users u

JOIN departments d
ON u.department_id=d.department_id

JOIN user_roles ur
ON u.user_id=ur.user_id

JOIN roles r
ON ur.role_id=r.role_id;

SELECT *

FROM vw_employee_directory;