USE taskmaster;

SELECT
    project_name,
    average_hours
FROM
(
    SELECT
        p.project_name,
        AVG(t.estimated_hours) AS average_hours
    FROM projects p
    JOIN tasks t
        ON p.project_id = t.project_id
    GROUP BY p.project_id, p.project_name
) AS project_summary
ORDER BY average_hours DESC;