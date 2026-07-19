ALTER TABLE users

ADD COLUMN manager_id BIGINT NULL,

ADD CONSTRAINT fk_users_manager

FOREIGN KEY(manager_id)

REFERENCES users(user_id);

USE taskmaster;

WITH RECURSIVE employee_tree AS
(
SELECT

user_id,

full_name,

manager_id,

1 AS level

FROM users

WHERE manager_id IS NULL

UNION ALL

SELECT

u.user_id,

u.full_name,

u.manager_id,

e.level+1

FROM users u

JOIN employee_tree e

ON u.manager_id=e.user_id
)

SELECT *

FROM employee_tree

ORDER BY level,full_name;