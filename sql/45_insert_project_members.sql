USE taskmaster;

INSERT INTO project_members
(
project_id,
user_id,
allocation_percentage,
joining_date
)

VALUES

(1,2,100,'2026-01-10'),

(1,3,100,'2026-01-10'),

(1,4,100,'2026-01-10'),

(1,5,100,'2026-01-10'),

(2,2,100,'2026-02-01'),

(2,3,50,'2026-02-01'),

(3,2,100,'2026-03-05'),

(4,2,100,'2026-04-10'),

(5,2,100,'2026-05-01');


SELECT * FROM projects;

SELECT * FROM project_members;