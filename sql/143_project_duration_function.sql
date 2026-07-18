USE taskmaster;

DELIMITER $$

CREATE FUNCTION fn_project_duration
(
    p_start DATE,
    p_end DATE
)
RETURNS INT
DETERMINISTIC

BEGIN

    RETURN DATEDIFF(p_end,p_start);

END$$

DELIMITER ;

SELECT
project_name,
fn_project_duration(start_date,end_date) AS duration_days
FROM projects;