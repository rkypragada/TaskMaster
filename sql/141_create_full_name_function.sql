USE taskmaster;

DELIMITER $$

CREATE FUNCTION fn_full_name
(
    p_first_name VARCHAR(100),
    p_last_name VARCHAR(100)
)
RETURNS VARCHAR(201)
DETERMINISTIC

BEGIN

    RETURN CONCAT(p_first_name,' ',p_last_name);

END$$

DELIMITER ;

SELECT fn_full_name('Akhil','Rao') AS Full_Name;