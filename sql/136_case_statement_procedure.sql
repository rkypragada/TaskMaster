USE taskmaster;

DELIMITER $$

CREATE PROCEDURE sp_priority_description
(
    IN p_priority VARCHAR(20)
)
BEGIN

    CASE p_priority

        WHEN 'LOW' THEN
            SELECT 'Normal Priority';

        WHEN 'MEDIUM' THEN
            SELECT 'Moderate Priority';

        WHEN 'HIGH' THEN
            SELECT 'Important Task';

        WHEN 'CRITICAL' THEN
            SELECT 'Immediate Attention Required';

        ELSE
            SELECT 'Unknown Priority';

    END CASE;

END$$

DELIMITER ;