USE taskmaster;

SELECT /*+ INDEX(t idx_tasks_status_priority) */

t.task_code,

t.task_title,

t.priority

FROM tasks t

WHERE

t.status='OPEN'

AND t.priority='HIGH';