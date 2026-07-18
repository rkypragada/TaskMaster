USE taskmaster;

SELECT

u.employee_code,

u.full_name,

r.role_name

FROM users u

JOIN user_roles ur
ON u.user_id=ur.user_id

JOIN roles r
ON ur.role_id=r.role_id

WHERE r.role_name='DEVELOPER';