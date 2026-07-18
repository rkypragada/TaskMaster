USE taskmaster;

CREATE OR REPLACE VIEW vw_department_summary AS

SELECT

d.department_name,

COUNT(u.user_id) employees

FROM departments d

LEFT JOIN users u

ON d.department_id=u.department_id

GROUP BY

d.department_name;