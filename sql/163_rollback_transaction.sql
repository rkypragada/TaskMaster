USE taskmaster;

START TRANSACTION;

UPDATE tasks
SET priority='CRITICAL'
WHERE task_id=2;

ROLLBACK;


SELECT
task_id,
priority
FROM tasks
WHERE task_id=2;