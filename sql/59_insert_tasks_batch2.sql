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

('TSK006',
6,
6,
2,
'Customer Registration',
'Develop customer registration module',
'HIGH',
'OPEN',
24,
0,
'2026-06-05',
'2026-06-20'),

('TSK007',
6,
7,
2,
'Loan Processing',
'Implement loan approval workflow',
'CRITICAL',
'IN_PROGRESS',
40,
12,
'2026-06-06',
'2026-06-30');

/* Continue up to TSK025 */