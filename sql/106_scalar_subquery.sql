USE taskmaster;

SELECT
    task_code,
    task_title,
    (
        SELECT COUNT(*)
        FROM tasks
    ) AS total_tasks
FROM tasks;