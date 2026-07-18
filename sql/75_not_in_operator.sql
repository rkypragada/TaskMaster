USE taskmaster;

SELECT
    project_code,
    project_name,
    status
FROM projects
WHERE status NOT IN ('CANCELLED');