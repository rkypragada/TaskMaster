USE taskmaster;

DELIMITER $$

CREATE PROCEDURE sp_demo_loop()
BEGIN

    DECLARE counter INT DEFAULT 1;

    WHILE counter <= 10 DO

        SELECT counter;

        SET counter = counter + 1;

    END WHILE;

END$$

DELIMITER ;