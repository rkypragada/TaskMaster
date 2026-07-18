USE taskmaster;

SELECT
    priority,
    COUNT(*) AS total_tasks
FROM tasks
GROUP BY priority
ORDER BY total_tasks DESC;