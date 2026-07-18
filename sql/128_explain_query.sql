USE taskmaster;

EXPLAIN

SELECT *

FROM tasks

WHERE status='OPEN'

AND priority='HIGH';