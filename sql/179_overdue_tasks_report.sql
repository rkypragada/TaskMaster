USE taskmaster;

WITH overdue_tasks AS
(
SELECT

task_code,

task_title,

assigned_to,

due_date

FROM tasks

WHERE due_date<CURDATE()

AND status<>'COMPLETED'
)

SELECT

o.task_code,

o.task_title,

u.full_name,

o.due_date

FROM overdue_tasks o

JOIN users u

ON o.assigned_to=u.user_id

ORDER BY due_date;