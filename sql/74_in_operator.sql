USE taskmaster;

SELECT
    task_code,
    task_title,
    priority
FROM tasks
WHERE priority IN ('HIGH', 'CRITICAL');