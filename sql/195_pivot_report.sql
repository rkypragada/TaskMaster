USE taskmaster;

SELECT

project_name,

SUM(CASE WHEN status='OPEN' THEN 1 ELSE 0 END) AS open_tasks,

SUM(CASE WHEN status='IN_PROGRESS' THEN 1 ELSE 0 END) AS in_progress,

SUM(CASE WHEN status='COMPLETED' THEN 1 ELSE 0 END) AS completed,

SUM(CASE WHEN status='TESTING' THEN 1 ELSE 0 END) AS testing

FROM tasks

JOIN projects

ON tasks.project_id=projects.project_id

GROUP BY project_name;