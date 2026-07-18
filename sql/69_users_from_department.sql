USE taskmaster;

SELECT

u.employee_code,

u.full_name,

d.department_name

FROM users u

JOIN departments d

ON u.department_id=d.department_id

WHERE d.department_name='Software Development';