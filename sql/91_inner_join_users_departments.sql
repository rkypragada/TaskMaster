USE taskmaster;

SELECT

u.employee_code,

u.full_name,

u.designation,

d.department_name

FROM users u

INNER JOIN departments d

ON u.department_id = d.department_id

ORDER BY u.full_name;