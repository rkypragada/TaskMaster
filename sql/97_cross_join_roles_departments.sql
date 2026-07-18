USE taskmaster;

SELECT

r.role_name,

d.department_name

FROM roles r

CROSS JOIN departments d

ORDER BY

r.role_name,

d.department_name;