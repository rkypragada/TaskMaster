USE taskmaster;

SELECT

p.project_name,

t.task_code,

t.task_title,

u.full_name AS assigned_to,

d.department_name,

t.priority,

t.status,

t.estimated_hours,

t.actual_hours,

t.due_date

FROM tasks t

JOIN users u
ON t.assigned_to = u.user_id

JOIN departments d
ON u.department_id = d.department_id

JOIN projects p
ON t.project_id = p.project_id

ORDER BY

p.project_name,

t.priority DESC,

t.due_date;