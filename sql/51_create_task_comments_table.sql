/*
============================================================
Project : TaskMaster
Program : 51
Table   : task_comments
============================================================
*/

USE taskmaster;

DROP TABLE IF EXISTS task_comments;

CREATE TABLE task_comments
(
    comment_id BIGINT AUTO_INCREMENT,

    task_id BIGINT NOT NULL,

    user_id BIGINT NOT NULL,

    comment_text TEXT NOT NULL,

    commented_at TIMESTAMP
    DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY(comment_id),

    CONSTRAINT fk_comments_task
    FOREIGN KEY(task_id)
    REFERENCES tasks(task_id),

    CONSTRAINT fk_comments_user
    FOREIGN KEY(user_id)
    REFERENCES users(user_id)
);