USE taskmaster;

SELECT
    task_code,
    task_title,
    status
FROM tasks
WHERE status = 'OPEN'
OR status = 'IN_PROGRESS';