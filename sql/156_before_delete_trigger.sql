USE taskmaster;

DELIMITER $$

CREATE TRIGGER trg_tasks_before_delete

BEFORE DELETE

ON tasks

FOR EACH ROW

BEGIN

    IF OLD.status='COMPLETED' THEN

        SIGNAL SQLSTATE '45000'

        SET MESSAGE_TEXT =
        'Completed tasks cannot be deleted';

    END IF;

END$$

DELIMITER ;