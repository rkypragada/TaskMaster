USE taskmaster;

DELIMITER $$

CREATE PROCEDURE sp_safe_project_lookup
(
    IN p_project_id BIGINT
)
BEGIN

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'Database error occurred.' AS message;
    END;

    SELECT
        project_code,
        project_name,
        budget
    FROM projects
    WHERE project_id = p_project_id;

END$$

DELIMITER ;