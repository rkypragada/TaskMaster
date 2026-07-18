USE taskmaster;

DELIMITER $$

CREATE PROCEDURE sp_project_task_count
(
    IN p_project_id BIGINT,
    OUT p_total_tasks INT
)
BEGIN

    SELECT COUNT(*)
    INTO p_total_tasks
    FROM tasks
    WHERE project_id = p_project_id;

END$$

DELIMITER ;

CALL sp_project_task_count(1,@task_count);

SELECT @task_count;