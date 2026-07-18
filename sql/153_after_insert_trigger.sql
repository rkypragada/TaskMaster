USE taskmaster;

DELIMITER $$

CREATE TRIGGER trg_tasks_after_insert

AFTER INSERT

ON tasks

FOR EACH ROW

BEGIN

    INSERT INTO task_history
    (
        task_id,
        action_type,
        new_status,
        new_priority,
        changed_by,
        remarks
    )

    VALUES
    (
        NEW.task_id,
        'INSERT',
        NEW.status,
        NEW.priority,
        NEW.created_by,
        'Task created'
    );

END$$

DELIMITER ;