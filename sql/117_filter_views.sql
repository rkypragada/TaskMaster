USE taskmaster;

SELECT *

FROM vw_task_dashboard

WHERE priority='CRITICAL'

ORDER BY due_date;