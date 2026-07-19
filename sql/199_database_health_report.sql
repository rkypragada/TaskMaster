USE taskmaster;

SELECT

(SELECT COUNT(*) FROM departments) AS total_departments,

(SELECT COUNT(*) FROM users) AS total_users,

(SELECT COUNT(*) FROM projects) AS total_projects,

(SELECT COUNT(*) FROM tasks) AS total_tasks,

(SELECT COUNT(*) FROM task_comments) AS total_comments,

(SELECT COUNT(*) FROM attachments) AS total_attachments;