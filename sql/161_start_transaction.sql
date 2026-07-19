USE taskmaster;

START TRANSACTION;

UPDATE tasks
SET status = 'IN_PROGRESS'
WHERE task_id = 1;

SELECT *
FROM tasks
WHERE task_id = 1;