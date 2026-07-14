USE taskmaster;

DROP TABLE IF EXISTS project_members;

CREATE TABLE project_members
(
    member_id BIGINT AUTO_INCREMENT,

    project_id BIGINT NOT NULL,

    user_id BIGINT NOT NULL,

    allocation_percentage INT
    DEFAULT 100,

    joining_date DATE,

    PRIMARY KEY(member_id),

    CONSTRAINT fk_pm_project

    FOREIGN KEY(project_id)

    REFERENCES projects(project_id),

    CONSTRAINT fk_pm_user

    FOREIGN KEY(user_id)

    REFERENCES users(user_id)
);