USE taskmaster;

SELECT
    employee_code,
    full_name,
    designation
FROM users
WHERE full_name LIKE 'A%';