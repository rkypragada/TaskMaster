USE taskmaster;

SELECT *

FROM tasks

WHERE priority IN ('HIGH','CRITICAL')

ORDER BY due_date;