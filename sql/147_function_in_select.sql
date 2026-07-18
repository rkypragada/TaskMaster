USE taskmaster;

SELECT

project_name,

fn_project_duration(start_date,end_date) AS duration,

budget

FROM projects

ORDER BY duration DESC;