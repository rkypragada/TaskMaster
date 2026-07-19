USE taskmaster;

SELECT

project_name,

budget,

FIRST_VALUE(budget)

OVER
(
ORDER BY budget
)

AS minimum_budget,

LAST_VALUE(budget)

OVER
(
ORDER BY budget
ROWS BETWEEN UNBOUNDED PRECEDING
AND UNBOUNDED FOLLOWING
)

AS maximum_budget

FROM projects;