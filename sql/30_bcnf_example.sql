/*
BCNF Demonstration
*/

CREATE TABLE project_managers
(
    project_id INT,

    manager_id INT,

    PRIMARY KEY(project_id,manager_id)
);