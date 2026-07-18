USE taskmaster;

DELIMITER $$

CREATE PROCEDURE sp_get_all_users()
BEGIN

    SELECT
        employee_code,
        full_name,
        designation,
        email
    FROM users
    ORDER BY full_name;

END$$

DELIMITER ;

CALL sp_get_all_users();