USE taskmaster;

SELECT
    project_code,
    project_name,
    budget
FROM projects
WHERE budget > ALL
(
    SELECT budget
    FROM projects
    WHERE status = 'COMPLETED'
);