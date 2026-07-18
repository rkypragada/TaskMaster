USE taskmaster;

DELIMITER $$

CREATE TRIGGER trg_tasks_after_update

AFTER UPDATE

ON tasks

FOR EACH ROW

BEGIN

    INSERT INTO task_history
    (
        task_id,
        action_type,

        old_status,
        new_status,

        old_priority,
        new_priority,

        changed_by,

        remarks
    )

    VALUES
    (
        NEW.task_id,

        'UPDATE',

        OLD.status,
        NEW.status,

        OLD.priority,
        NEW.priority,

        NEW.created_by,

        'Task updated'
    );

END$$

DELIMITER ;