USE taskmaster;

SELECT
    project_code,
    project_name,
    budget
FROM projects
WHERE budget =
(
    SELECT MAX(budget)
    FROM projects
);