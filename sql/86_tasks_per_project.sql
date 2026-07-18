USE taskmaster;

SELECT

p.project_code,

p.project_name,

COUNT(t.task_id) AS total_tasks

FROM projects p

LEFT JOIN tasks t

ON p.project_id=t.project_id

GROUP BY

p.project_id,

p.project_code,

p.project_name

ORDER BY total_tasks DESC;