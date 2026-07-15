USE taskmaster;

DROP TABLE IF EXISTS attachments;

CREATE TABLE attachments
(
    attachment_id BIGINT AUTO_INCREMENT,

    task_id BIGINT NOT NULL,

    file_name VARCHAR(255) NOT NULL,

    file_type VARCHAR(50),

    file_size BIGINT,

    uploaded_by BIGINT NOT NULL,

    uploaded_at TIMESTAMP
    DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY(attachment_id),

    CONSTRAINT fk_attachment_task
    FOREIGN KEY(task_id)
    REFERENCES tasks(task_id),

    CONSTRAINT fk_attachment_user
    FOREIGN KEY(uploaded_by)
    REFERENCES users(user_id)
);