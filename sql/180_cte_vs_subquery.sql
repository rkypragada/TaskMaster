SELECT

project_name,

budget

FROM projects

WHERE budget >
(
SELECT AVG(budget)

FROM projects
);

WITH avg_budget AS
(
SELECT AVG(budget) average_budget

FROM projects
)

SELECT

project_name,

budget

FROM projects

CROSS JOIN avg_budget

WHERE budget>average_budget;