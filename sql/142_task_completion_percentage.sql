USE taskmaster;

DELIMITER $$

CREATE FUNCTION fn_completion_percentage
(
    p_completed INT,
    p_total INT
)
RETURNS DECIMAL(5,2)
DETERMINISTIC

BEGIN

    IF p_total = 0 THEN
        RETURN 0;
    END IF;

    RETURN ROUND((p_completed * 100.0)/p_total,2);

END$$

DELIMITER ;

SELECT fn_completion_percentage(45,60);