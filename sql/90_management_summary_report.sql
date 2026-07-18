USE taskmaster;

SELECT

p.project_name,

COUNT(t.task_id) AS total_tasks,

SUM(CASE WHEN t.status='COMPLETED' THEN 1 ELSE 0 END) AS completed_tasks,

SUM(CASE WHEN t.status='OPEN' THEN 1 ELSE 0 END) AS open_tasks,

ROUND(

100 *
SUM(CASE WHEN t.status='COMPLETED' THEN 1 ELSE 0 END)
/ COUNT(t.task_id),

2

) AS completion_percentage

FROM projects p

LEFT JOIN tasks t

ON p.project_id=t.project_id

GROUP BY

p.project_id,

p.project_name

ORDER BY completion_percentage DESC;