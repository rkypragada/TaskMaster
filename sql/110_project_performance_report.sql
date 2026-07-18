USE taskmaster;

SELECT
    p.project_code,
    p.project_name,

    (
        SELECT COUNT(*)
        FROM tasks t
        WHERE t.project_id = p.project_id
    ) AS total_tasks,

    (
        SELECT COUNT(*)
        FROM tasks t
        WHERE t.project_id = p.project_id
          AND t.status = 'COMPLETED'
    ) AS completed_tasks,

    (
        SELECT ROUND(AVG(estimated_hours),2)
        FROM tasks t
        WHERE t.project_id = p.project_id
    ) AS average_estimated_hours

FROM projects p
ORDER BY project_name;