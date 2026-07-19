USE taskmaster;

SELECT

project_name,

budget,

DENSE_RANK() OVER
(
ORDER BY budget DESC
) AS budget_rank

FROM projects;