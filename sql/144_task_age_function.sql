USE taskmaster;

DELIMITER $$

CREATE FUNCTION fn_task_age
(
    p_start DATE
)
RETURNS INT
DETERMINISTIC

BEGIN

    RETURN DATEDIFF(CURDATE(),p_start);

END$$

DELIMITER ;

SELECT

task_code,

task_title,

fn_task_age(start_date) AS task_age

FROM tasks;