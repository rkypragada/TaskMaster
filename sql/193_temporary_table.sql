USE taskmaster;

CREATE TEMPORARY TABLE temp_high_priority_tasks

AS

SELECT

task_id,

task_code,

task_title,

priority

FROM tasks

WHERE priority='HIGH';

SELECT *

FROM temp_high_priority_tasks;