USE taskmaster;

WITH active_projects AS
(
    SELECT
        project_id,
        project_name,
        budget
    FROM projects
    WHERE status='ACTIVE'
)

SELECT *
FROM active_projects;