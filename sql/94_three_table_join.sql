USE taskmaster;

SELECT

t.task_code,

t.task_title,

u.full_name AS assigned_employee,

p.project_name,

t.status,

t.priority

FROM tasks t

INNER JOIN users u

ON t.assigned_to = u.user_id

INNER JOIN projects p

ON t.project_id = p.project_id

ORDER BY p.project_name;