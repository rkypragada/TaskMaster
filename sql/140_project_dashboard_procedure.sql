USE taskmaster;

DELIMITER $$

CREATE PROCEDURE sp_project_dashboard
(
    IN p_project_id BIGINT
)
BEGIN

    SELECT
        p.project_name,
        t.task_code,
        t.task_title,
        u.full_name AS assigned_employee,
        t.priority,
        t.status,
        t.due_date
    FROM projects p
    JOIN tasks t
        ON p.project_id = t.project_id
    JOIN users u
        ON t.assigned_to = u.user_id
    WHERE p.project_id = p_project_id
    ORDER BY t.due_date;

END$$

DELIMITER ;