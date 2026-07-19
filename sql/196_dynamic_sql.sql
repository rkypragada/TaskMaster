USE taskmaster;

SET @table_name='projects';

SET @sql_query=
CONCAT
(
'SELECT * FROM ',
@table_name
);

PREPARE stmt

FROM @sql_query;

EXECUTE stmt;

DEALLOCATE PREPARE stmt;