USE taskmaster;

SELECT
    project_code,
    project_name,
    priority,
    status
FROM projects
WHERE status = 'ACTIVE';