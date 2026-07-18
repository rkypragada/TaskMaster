USE taskmaster;

SELECT

u.employee_code,

u.full_name,

u.email,

d.department_name,

r.role_name,

u.designation,

u.account_status

FROM users u

JOIN departments d

ON u.department_id=d.department_id

JOIN user_roles ur

ON u.user_id=ur.user_id

JOIN roles r

ON ur.role_id=r.role_id

ORDER BY

d.department_name,

u.full_name;