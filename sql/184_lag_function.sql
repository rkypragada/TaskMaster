USE taskmaster;

SELECT

project_name,

budget,

LAG(budget,1) OVER
(
ORDER BY budget
) AS previous_budget

FROM projects;