USE taskmaster;

SELECT
    project_code,
    project_name,
    budget
FROM projects
WHERE budget BETWEEN 1000000 AND 3000000;