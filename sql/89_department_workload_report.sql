USE taskmaster;

SELECT

d.department_name,

COUNT(t.task_id) AS assigned_tasks

FROM departments d

JOIN users u

ON d.department_id=u.department_id

LEFT JOIN tasks t

ON u.user_id=t.assigned_to

GROUP BY

d.department_id,

d.department_name

ORDER BY assigned_tasks DESC;