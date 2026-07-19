USE taskmaster;

SELECT

project_name,

total_tasks

FROM

(
SELECT

project_id,

COUNT(*) total_tasks

FROM tasks

GROUP BY project_id

) task_summary

JOIN projects

ON task_summary.project_id=projects.project_id;