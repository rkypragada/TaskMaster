USE taskmaster;

SELECT
    project_id,
    project_name,
    budget,

    ROW_NUMBER() OVER (
        ORDER BY budget DESC
    ) AS row_num,

    RANK() OVER (
        ORDER BY budget DESC
    ) AS rank_num,

    DENSE_RANK() OVER (
        ORDER BY budget DESC
    ) AS dense_rank_num,

    SUM(budget) OVER (
        ORDER BY budget DESC
        ROWS BETWEEN UNBOUNDED PRECEDING
        AND CURRENT ROW
    ) AS cumulative_budget,

    AVG(budget) OVER () AS average_budget,

    budget - AVG(budget) OVER () AS budget_difference

FROM projects

ORDER BY budget DESC;