USE taskmaster;

CREATE INDEX idx_users_department

ON users(department_id);

SELECT *

FROM users

WHERE department_id=2;