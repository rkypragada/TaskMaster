USE taskmaster;

START TRANSACTION;

UPDATE tasks
SET status='COMPLETED'
WHERE task_id=5;

UPDATE projects
SET budget=-1000
WHERE project_id=1;

ROLLBACK;