USE taskmaster;

SELECT

project_name,

budget,

SUM(budget)

OVER
(
ORDER BY budget
ROWS BETWEEN UNBOUNDED PRECEDING
AND CURRENT ROW
)

AS running_budget

FROM projects;