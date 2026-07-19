SELECT
project_name
FROM projects
WHERE budget >
(
SELECT AVG(budget)
FROM projects
);