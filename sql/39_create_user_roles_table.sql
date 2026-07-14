USE taskmaster;

DROP TABLE IF EXISTS user_roles;

CREATE TABLE user_roles
(
    user_role_id BIGINT AUTO_INCREMENT,

    user_id BIGINT NOT NULL,

    role_id BIGINT NOT NULL,

    assigned_on DATE
    DEFAULT (CURRENT_DATE),

    PRIMARY KEY(user_role_id),

    CONSTRAINT fk_userroles_user

    FOREIGN KEY(user_id)

    REFERENCES users(user_id),

    CONSTRAINT fk_userroles_role

    FOREIGN KEY(role_id)

    REFERENCES roles(role_id)
);