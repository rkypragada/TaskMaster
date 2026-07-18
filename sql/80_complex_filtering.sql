USE taskmaster;

SELECT
    t.task_code,
    t.task_title,
    p.project_name,
    u.full_name AS assigned_employee,
    t.priority,
    t.status,
    t.due_date
FROM tasks t
JOIN projects p
    ON t.project_id = p.project_id
JOIN users u
    ON t.assigned_to = u.user_id
WHERE t.priority IN ('HIGH', 'CRITICAL')
AND t.status IN ('OPEN', 'IN_PROGRESS')
AND t.due_date IS NOT NULL
ORDER BY
    t.priority DESC,
    t.due_date ASC;