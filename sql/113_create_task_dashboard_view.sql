USE taskmaster;

CREATE OR REPLACE VIEW vw_task_dashboard AS

SELECT

t.task_code,

t.task_title,

p.project_name,

u.full_name assigned_employee,

t.priority,

t.status,

t.due_date

FROM tasks t

JOIN projects p

ON t.project_id=p.project_id

JOIN users u

ON t.assigned_to=u.user_id;