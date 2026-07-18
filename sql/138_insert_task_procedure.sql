USE taskmaster;

DELIMITER $$

CREATE PROCEDURE sp_create_task
(
    IN p_task_code VARCHAR(20),
    IN p_project_id BIGINT,
    IN p_assigned_to BIGINT,
    IN p_created_by BIGINT,
    IN p_task_title VARCHAR(200),
    IN p_priority VARCHAR(20),
    IN p_due_date DATE
)
BEGIN

    INSERT INTO tasks
    (
        task_code,
        project_id,
        assigned_to,
        created_by,
        task_title,
        priority,
        status,
        due_date
    )
    VALUES
    (
        p_task_code,
        p_project_id,
        p_assigned_to,
        p_created_by,
        p_task_title,
        p_priority,
        'OPEN',
        p_due_date
    );

END$$

DELIMITER ;