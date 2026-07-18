USE taskmaster;

SELECT
    task_code,
    task_title,
    assigned_to
FROM tasks
WHERE assigned_to IN
(
    SELECT user_id
    FROM users
    WHERE department_id =
    (
        SELECT department_id
        FROM departments
        WHERE department_name='Software Development'
    )
);