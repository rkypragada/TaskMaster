USE taskmaster;

SELECT
    status,
    COUNT(*) AS total_tasks
FROM tasks
GROUP BY status
ORDER BY total_tasks DESC;