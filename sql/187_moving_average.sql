USE taskmaster;

SELECT

project_name,

budget,

ROUND
(
AVG(budget)

OVER
(
ORDER BY budget
ROWS BETWEEN 2 PRECEDING
AND CURRENT ROW
),
2
)

AS moving_average

FROM projects;