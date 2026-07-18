USE taskmaster;

SELECT

u.employee_code,

u.full_name,

p.project_name,

t.task_code,

t.task_title,

t.status,

t.priority

FROM users u

JOIN tasks t

ON u.user_id = t.assigned_to

JOIN projects p

ON t.project_id = p.project_id

ORDER BY

u.full_name,

p.project_name;