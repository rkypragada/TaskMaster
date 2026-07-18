USE taskmaster;

SELECT

task_code,

task_title,

due_date

FROM tasks

WHERE fn_is_overdue(due_date,status)='OVERDUE';