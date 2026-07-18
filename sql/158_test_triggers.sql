USE taskmaster;

/* Insert */

CALL sp_create_task
(
'TSK900',
1,
3,
2,
'Trigger Testing',
'HIGH',
'2026-12-31'
);

/* Update */

UPDATE tasks

SET status='IN_PROGRESS'

WHERE task_code='TSK900';

/* Delete */

DELETE

FROM tasks

WHERE task_code='TSK900';