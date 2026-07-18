USE taskmaster;

SELECT
    project_code,
    project_name,
    priority,
    status
FROM projects
WHERE priority = 'CRITICAL'
AND status = 'ACTIVE';