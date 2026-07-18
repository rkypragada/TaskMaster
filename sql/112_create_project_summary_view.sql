USE taskmaster;

CREATE OR REPLACE VIEW vw_project_summary AS

SELECT

p.project_id,

p.project_code,

p.project_name,

COUNT(t.task_id) total_tasks,

SUM(CASE WHEN t.status='COMPLETED' THEN 1 ELSE 0 END)

completed_tasks

FROM projects p

LEFT JOIN tasks t

ON p.project_id=t.project_id

GROUP BY

p.project_id,

p.project_code,

p.project_name;

SELECT *

FROM vw_project_summary;