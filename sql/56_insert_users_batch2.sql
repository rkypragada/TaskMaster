USE taskmaster;

INSERT INTO users
(
employee_code,
first_name,
last_name,
full_name,
email,
phone,
gender,
date_of_birth,
designation,
department_id,
password_hash
)

VALUES

('EMP006','Akhil','Rao','Akhil Rao',
'akhil@taskmaster.com',
'9876543215',
'Male',
'1996-01-15',
'Software Engineer',
2,
'dev@123'),

('EMP007','Meena','Sharma','Meena Sharma',
'meena@taskmaster.com',
'9876543216',
'Female',
'1994-03-10',
'Software Engineer',
2,
'dev@123'),

('EMP008','Arjun','Patel','Arjun Patel',
'arjun@taskmaster.com',
'9876543217',
'Male',
'1995-08-18',
'QA Engineer',
3,
'test@123'),

('EMP009','Divya','Nair','Divya Nair',
'divya@taskmaster.com',
'9876543218',
'Female',
'1993-11-11',
'Business Analyst',
2,
'ba@123'),

('EMP010','Vikram','Reddy','Vikram Reddy',
'vikram@taskmaster.com',
'9876543219',
'Male',
'1992-06-20',
'UI Developer',
2,
'ui@123');

/* Continue similarly until EMP025 */