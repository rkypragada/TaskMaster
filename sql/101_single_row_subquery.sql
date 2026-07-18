USE taskmaster;

SELECT
    task_code,
    task_title,
    assigned_to
FROM tasks
WHERE assigned_to =
(
    SELECT user_id
    FROM users
    WHERE designation = 'Project Manager'
);