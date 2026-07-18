USE taskmaster;

DROP TABLE IF EXISTS task_history;

CREATE TABLE task_history
(
    history_id BIGINT AUTO_INCREMENT,

    task_id BIGINT NOT NULL,

    action_type ENUM
    (
        'INSERT',
        'UPDATE',
        'DELETE'
    ),

    old_status VARCHAR(30),

    new_status VARCHAR(30),

    old_priority VARCHAR(20),

    new_priority VARCHAR(20),

    changed_by BIGINT,

    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    remarks VARCHAR(255),

    PRIMARY KEY(history_id),

    CONSTRAINT fk_history_task
    FOREIGN KEY(task_id)
    REFERENCES tasks(task_id),

    CONSTRAINT fk_history_user
    FOREIGN KEY(changed_by)
    REFERENCES users(user_id)
);