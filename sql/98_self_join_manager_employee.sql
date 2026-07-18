ALTER TABLE users

ADD COLUMN manager_id BIGINT NULL;

ALTER TABLE users

ADD CONSTRAINT fk_users_manager

FOREIGN KEY (manager_id)

REFERENCES users(user_id);