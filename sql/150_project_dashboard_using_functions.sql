USE taskmaster;

SELECT

project_name,

fn_project_duration(start_date,end_date) AS duration_days,

budget

FROM projects

ORDER BY budget DESC;