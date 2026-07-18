USE taskmaster;

SELECT

SUM(budget) AS total_budget,

AVG(budget) AS average_budget,

MIN(budget) AS minimum_budget,

MAX(budget) AS maximum_budget

FROM projects;