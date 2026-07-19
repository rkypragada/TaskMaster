USE taskmaster;

SELECT

table_name,

table_rows,

engine,

create_time

FROM information_schema.tables

WHERE table_schema='taskmaster'

ORDER BY table_name;