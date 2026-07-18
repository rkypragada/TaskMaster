USE taskmaster;

DELIMITER $$

CREATE PROCEDURE sp_project_budget_status
(
    IN p_project_id BIGINT
)
BEGIN

    DECLARE v_budget DECIMAL(12,2);

    SELECT budget
    INTO v_budget
    FROM projects
    WHERE project_id = p_project_id;

    IF v_budget >= 3000000 THEN

        SELECT 'HIGH BUDGET PROJECT' AS status;

    ELSE

        SELECT 'STANDARD PROJECT' AS status;

    END IF;

END$$

DELIMITER ;

CALL sp_project_budget_status(5);