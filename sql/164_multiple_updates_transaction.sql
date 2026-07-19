USE taskmaster;

START TRANSACTION;

UPDATE tasks
SET status='IN_PROGRESS'
WHERE task_id=3;

UPDATE projects
SET status='ACTIVE'
WHERE project_id=2;

UPDATE users
SET account_status='ACTIVE'
WHERE user_id=6;

COMMIT;