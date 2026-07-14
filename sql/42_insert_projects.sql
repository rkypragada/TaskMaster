USE taskmaster;

INSERT INTO projects
(
project_code,
project_name,
description,
start_date,
end_date,
budget,
priority,
status,
manager_id
)

VALUES

('PRJ001',
'Hospital Management System',
'Complete Hospital Automation',
'2026-01-10',
'2026-08-30',
2500000,
'HIGH',
'ACTIVE',
2),

('PRJ002',
'Library Management System',
'Digital Library Solution',
'2026-02-01',
'2026-06-30',
800000,
'MEDIUM',
'ACTIVE',
2),

('PRJ003',
'Payroll System',
'Payroll Processing Software',
'2026-03-05',
'2026-09-30',
1200000,
'HIGH',
'PLANNING',
2),

('PRJ004',
'Online Examination System',
'University Examination Portal',
'2026-04-10',
'2026-10-20',
1800000,
'CRITICAL',
'ACTIVE',
2),

('PRJ005',
'E-Commerce Portal',
'Online Shopping Application',
'2026-05-01',
'2026-12-31',
4500000,
'CRITICAL',
'PLANNING',
2);