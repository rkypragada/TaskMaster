USE taskmaster;

SELECT

d.department_name,

COUNT(u.user_id) AS employees

FROM departments d

LEFT JOIN users u

ON d.department_id=u.department_id

GROUP BY

d.department_id,

d.department_name

ORDER BY employees DESC;