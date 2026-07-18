USE taskmaster;

CREATE INDEX idx_tasks_due_date

ON tasks(due_date);

SELECT *

FROM tasks

WHERE due_date<'2026-08-01';