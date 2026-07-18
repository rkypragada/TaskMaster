USE taskmaster;

SELECT

p.project_code,

p.project_name,

t.task_code,

t.task_title,

t.status

FROM projects p

INNER JOIN tasks t

ON p.project_id = t.project_id

ORDER BY

p.project_name,

t.task_code;