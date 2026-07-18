USE taskmaster;

SELECT

u.full_name,

t.task_code,

t.task_title

FROM users u

RIGHT JOIN tasks t

ON u.user_id = t.assigned_to

ORDER BY

t.task_code;