USE taskmaster;

SELECT

table_name,

column_name,

data_type,

is_nullable,

column_key

FROM information_schema.columns

WHERE table_schema='taskmaster'

ORDER BY table_name,
ordinal_position;