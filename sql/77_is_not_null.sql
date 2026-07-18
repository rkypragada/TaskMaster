USE taskmaster;

SELECT
    task_code,
    task_title,
    completed_date
FROM tasks
WHERE completed_date IS NOT NULL;