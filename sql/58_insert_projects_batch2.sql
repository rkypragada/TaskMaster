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

('PRJ006',
'Bank Management System',
'Core Banking Software',
'2026-06-01',
'2027-01-30',
5000000,
'CRITICAL',
'ACTIVE',
2),

('PRJ007',
'Inventory Management',
'Warehouse Automation',
'2026-06-15',
'2026-12-31',
1800000,
'HIGH',
'ACTIVE',
2),

('PRJ008',
'CRM Application',
'Customer Relationship Management',
'2026-07-01',
'2027-02-15',
3500000,
'HIGH',
'PLANNING',
2),

('PRJ009',
'Hotel Booking Portal',
'Online Hotel Reservation',
'2026-07-10',
'2027-03-30',
2800000,
'MEDIUM',
'ACTIVE',
2),

('PRJ010',
'Vehicle Tracking System',
'GPS Fleet Management',
'2026-08-01',
'2027-04-30',
4000000,
'HIGH',
'PLANNING',
2);