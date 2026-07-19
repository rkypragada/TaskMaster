USE taskmaster;

WITH project_stats AS
(
SELECT

project_id,

COUNT(*) total_tasks,

SUM(status='COMPLETED') completed_tasks

FROM tasks

GROUP BY project_id
)

SELECT

p.project_name,

total_tasks,

completed_tasks,

ROUND
(
completed_tasks*100/total_tasks,
2
) completion_percentage

FROM projects p

JOIN project_stats ps

ON p.project_id=ps.project_id;