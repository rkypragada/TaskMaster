USE taskmaster;

CREATE OR REPLACE VIEW vw_manager_dashboard AS

SELECT

p.project_name,

COUNT(t.task_id) total_tasks,

SUM(CASE WHEN t.status='OPEN' THEN 1 ELSE 0 END) open_tasks,

SUM(CASE WHEN t.status='IN_PROGRESS' THEN 1 ELSE 0 END)

in_progress_tasks,

SUM(CASE WHEN t.status='COMPLETED' THEN 1 ELSE 0 END)

completed_tasks

FROM projects p

LEFT JOIN tasks t

ON p.project_id=t.project_id

GROUP BY

p.project_name;