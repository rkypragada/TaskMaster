USE taskmaster;

SELECT
    task_code,
    task_title,
    due_date,
    completed_date
FROM tasks
WHERE completed_date IS NULL;