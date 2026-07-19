USE taskmaster;

SELECT

project_id,

task_code,

task_title,

ROW_NUMBER() OVER
(
PARTITION BY project_id
ORDER BY due_date
) AS row_no

FROM tasks;