USE taskmaster;

INSERT INTO tasks
(
task_code,
project_id,
assigned_to,
created_by,
task_title,
task_description,
priority,
status,
estimated_hours,
actual_hours,
start_date,
due_date
)

VALUES

('TSK001',1,3,2,'Login Module',
'Develop secure login page',
'HIGH','IN_PROGRESS',
20,8,
'2026-01-12',
'2026-01-20'),

('TSK002',1,3,2,'Dashboard',
'Design project dashboard',
'HIGH','OPEN',
24,0,
'2026-01-15',
'2026-01-25'),

('TSK003',1,5,2,'Testing Login',
'Test authentication',
'MEDIUM','OPEN',
12,0,
'2026-01-20',
'2026-01-28'),

('TSK004',2,3,2,'Book Entry',
'Book management module',
'MEDIUM','IN_PROGRESS',
30,12,
'2026-02-01',
'2026-02-15'),

('TSK005',3,3,2,'Salary Calculation',
'Payroll calculations',
'CRITICAL','OPEN',
40,0,
'2026-03-10',
'2026-03-30');