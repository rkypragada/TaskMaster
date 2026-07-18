USE taskmaster;

SELECT
    project_code,
    project_name
FROM projects p
WHERE NOT EXISTS
(
    SELECT 1
    FROM tasks t
    WHERE t.project_id = p.project_id
);