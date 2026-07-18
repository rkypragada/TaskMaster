USE taskmaster;

DELIMITER $$

CREATE TRIGGER trg_tasks_before_update

BEFORE UPDATE

ON tasks

FOR EACH ROW

BEGIN

    IF NEW.actual_hours < 0 THEN

        SIGNAL SQLSTATE '45000'

        SET MESSAGE_TEXT =
        'Actual hours cannot be negative';

    END IF;

END$$

DELIMITER ;