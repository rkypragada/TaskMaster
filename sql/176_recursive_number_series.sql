USE taskmaster;

WITH RECURSIVE numbers AS
(
SELECT 1 AS n

UNION ALL

SELECT n+1

FROM numbers

WHERE n<20
)

SELECT *

FROM numbers;