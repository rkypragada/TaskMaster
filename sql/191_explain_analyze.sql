USE taskmaster;

EXPLAIN ANALYZE

SELECT

t.task_code,

t.task_title,

u.full_name,

p.project_name

FROM tasks t

JOIN users u
ON t.assigned_to=u.user_id

JOIN projects p
ON t.project_id=p.project_id

WHERE

t.status='OPEN'

AND t.priority='HIGH';