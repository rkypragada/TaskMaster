USE taskmaster;

DELIMITER $$

CREATE PROCEDURE sp_get_users_by_department
(
    IN p_department_id BIGINT
)
BEGIN

    SELECT
        employee_code,
        full_name,
        designation
    FROM users
    WHERE department_id = p_department_id
    ORDER BY full_name;

END$$

DELIMITER ;

CALL sp_get_users_by_department(2);