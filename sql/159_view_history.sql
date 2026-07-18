USE taskmaster;

SELECT

history_id,

task_id,

action_type,

old_status,

new_status,

changed_at,

remarks

FROM task_history

ORDER BY changed_at DESC;