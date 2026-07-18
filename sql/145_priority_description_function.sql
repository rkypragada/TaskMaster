USE taskmaster;

DELIMITER $$

CREATE FUNCTION fn_priority_description
(
    p_priority VARCHAR(20)
)
RETURNS VARCHAR(100)
DETERMINISTIC

BEGIN

    RETURN CASE

        WHEN p_priority='LOW'
            THEN 'Low Priority'

        WHEN p_priority='MEDIUM'
            THEN 'Medium Priority'

        WHEN p_priority='HIGH'
            THEN 'High Priority'

        WHEN p_priority='CRITICAL'
            THEN 'Critical Priority'

        ELSE 'Unknown Priority'

    END;

END$$

DELIMITER ;