USE taskmaster;

WITH project_summary AS
(
    SELECT

        p.project_id,

        p.project_name,

        p.budget,

        COUNT(t.task_id) AS total_tasks,

        SUM(CASE
                WHEN t.status='COMPLETED'
                THEN 1
                ELSE 0
            END) AS completed_tasks

    FROM projects p

    LEFT JOIN tasks t

    ON p.project_id=t.project_id

    GROUP BY

        p.project_id,

        p.project_name,

        p.budget
)

SELECT

    project_name,

    budget,

    total_tasks,

    completed_tasks,

    ROUND
    (
        completed_tasks*100.0/
        NULLIF(total_tasks,0),
        2
    ) AS completion_percentage,

    RANK()

    OVER
    (
        ORDER BY budget DESC
    ) AS budget_rank

FROM project_summary

ORDER BY budget DESC;