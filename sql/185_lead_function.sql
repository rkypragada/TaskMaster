USE taskmaster;

SELECT

project_name,

budget,

LEAD(budget,1) OVER
(
ORDER BY budget
) AS next_budget

FROM projects;