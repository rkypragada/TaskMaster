USE taskmaster;

SELECT

d.department_name,

u.full_name,

SUM(t.estimated_hours) AS total_hours,

RANK()

OVER
(
PARTITION BY d.department_id
ORDER BY SUM(t.estimated_hours) DESC
)

AS department_rank

FROM departments d

JOIN users u

ON d.department_id=u.department_id

JOIN tasks t

ON u.user_id=t.assigned_to

GROUP BY

d.department_id,

d.department_name,

u.user_id,

u.full_name;