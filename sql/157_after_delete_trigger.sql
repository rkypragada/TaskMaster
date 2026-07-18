USE taskmaster;

DELIMITER $$

CREATE TRIGGER trg_tasks_after_delete

AFTER DELETE

ON tasks

FOR EACH ROW

BEGIN

    INSERT INTO task_history
    (
        task_id,

        action_type,

        old_status,

        old_priority,

        changed_by,

        remarks
    )

    VALUES
    (
        OLD.task_id,

        'DELETE',

        OLD.status,

        OLD.priority,

        OLD.created_by,

        'Task deleted'
    );

END$$

DELIMITER ;