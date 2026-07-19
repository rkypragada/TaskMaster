USE taskmaster;

WITH RECURSIVE calendar_dates AS
(
SELECT DATE('2026-01-01') AS work_date

UNION ALL

SELECT DATE_ADD(work_date,INTERVAL 1 DAY)

FROM calendar_dates

WHERE work_date<'2026-01-15'
)

SELECT *

FROM calendar_dates;