USE taskmaster;

START TRANSACTION;

UPDATE tasks
SET priority='HIGH'
WHERE task_id=4;

SAVEPOINT before_status_change;

UPDATE tasks
SET status='TESTING'
WHERE task_id=4;