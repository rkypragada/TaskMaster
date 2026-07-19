USE taskmaster;

START TRANSACTION;

UPDATE tasks
SET
assigned_to=6,
status='IN_PROGRESS'
WHERE task_id=10;

INSERT INTO task_history
(
task_id,
action_type,
new_status,
changed_by,
remarks
)
VALUES
(
10,
'UPDATE',
'IN_PROGRESS',
6,
'Task assigned to employee'
);

COMMIT;


ROLLBACK;