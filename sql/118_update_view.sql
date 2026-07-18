USE taskmaster;

CREATE OR REPLACE VIEW vw_active_users AS

SELECT

user_id,

full_name,

email,

account_status

FROM users

WHERE account_status='ACTIVE';

UPDATE vw_active_users

SET email='akhil.rao@taskmaster.com'

WHERE user_id=6;