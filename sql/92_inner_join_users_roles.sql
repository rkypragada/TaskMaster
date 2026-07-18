USE taskmaster;

SELECT

u.employee_code,

u.full_name,

r.role_name

FROM users u

INNER JOIN user_roles ur

ON u.user_id = ur.user_id

INNER JOIN roles r

ON ur.role_id = r.role_id

ORDER BY r.role_name;