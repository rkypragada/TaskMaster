USE taskmaster;

SELECT

p.project_name,

COUNT(t.task_id) AS total_tasks

FROM projects p

JOIN tasks t

ON p.project_id=t.project_id

GROUP BY

p.project_id,

p.project_name

HAVING COUNT(t.task_id) > 5

ORDER BY total_tasks DESC;