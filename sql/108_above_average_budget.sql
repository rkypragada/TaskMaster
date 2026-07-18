USE taskmaster;

SELECT
    project_code,
    project_name,
    budget
FROM projects
WHERE budget >
(
    SELECT AVG(budget)
    FROM projects
)
ORDER BY budget DESC;