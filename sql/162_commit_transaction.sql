USE taskmaster;

START TRANSACTION;

UPDATE tasks
SET status='COMPLETED'
WHERE task_id=1;

COMMIT;