USE taskmaster;

CREATE INDEX idx_tasks_status_priority

ON tasks(status,priority);

SELECT *

FROM tasks

WHERE status='OPEN'

AND priority='HIGH';