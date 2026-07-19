USE taskmaster;

SELECT

assigned_to,

SUM(estimated_hours) AS total_hours,

RANK() OVER
(
ORDER BY SUM(estimated_hours) DESC
) AS workload_rank

FROM tasks

GROUP BY assigned_to;