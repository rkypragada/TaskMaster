USE taskmaster;

DELIMITER $$

CREATE PROCEDURE sp_increase_hours
(
    INOUT p_hours DECIMAL(6,2)
)
BEGIN

    SET p_hours = p_hours * 1.10;

END$$

DELIMITER ;

SET @hours = 20;

CALL sp_increase_hours(@hours);

SELECT @hours;