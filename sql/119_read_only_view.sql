USE taskmaster;

CREATE OR REPLACE VIEW vw_project_report AS
SELECT
    p.project_name,
    COUNT(t.task_id) AS total_tasks
FROM projects p
LEFT JOIN tasks t
ON p.project_id = t.project_id
GROUP BY
    p.project_id,
    p.project_name;