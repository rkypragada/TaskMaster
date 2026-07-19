USE taskmaster;

WITH

project_tasks AS
(
    SELECT
        project_id,
        COUNT(*) AS total_tasks
    FROM tasks
    GROUP BY project_id
),

completed_tasks AS
(
    SELECT
        project_id,
        COUNT(*) AS completed
    FROM tasks
    WHERE status='COMPLETED'
    GROUP BY project_id
)

SELECT

p.project_name,

pt.total_tasks,

COALESCE(ct.completed,0) AS completed_tasks

FROM projects p

LEFT JOIN project_tasks pt
ON p.project_id=pt.project_id

LEFT JOIN completed_tasks ct
ON p.project_id=ct.project_id;