USE taskmaster;

DELIMITER $$

CREATE FUNCTION fn_is_overdue
(
    p_due_date DATE,
    p_status VARCHAR(30)
)
RETURNS VARCHAR(20)
DETERMINISTIC

BEGIN

    IF p_status <> 'COMPLETED'
       AND p_due_date < CURDATE() THEN
        RETURN 'OVERDUE';
    END IF;

    RETURN 'ON_TRACK';

END$$

DELIMITER ;

SELECT

task_code,

task_title,

fn_is_overdue(due_date,status) AS task_status

FROM tasks;