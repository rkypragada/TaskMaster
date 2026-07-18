USE taskmaster;

DELIMITER $$

CREATE TRIGGER trg_tasks_before_insert

BEFORE INSERT

ON tasks

FOR EACH ROW

BEGIN

    IF NEW.due_date < NEW.start_date THEN

        SIGNAL SQLSTATE '45000'

        SET MESSAGE_TEXT =
        'Due date cannot be earlier than start date';

    END IF;

END$$

DELIMITER ;