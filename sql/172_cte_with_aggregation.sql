USE taskmaster;

WITH task_summary AS
(
    SELECT
        project_id,
        COUNT(*) AS total_tasks
    FROM tasks
    GROUP BY project_id
)

SELECT
    p.project_name,
    t.total_tasks
FROM projects p
JOIN task_summary t
ON p.project_id=t.project_id;