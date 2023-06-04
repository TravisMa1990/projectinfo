CREATE TABLE project_info(
    id VARCHAR(255)	NOT NULL,
    name VARCHAR(255) NOT NULL,
    status TINYINT NOT NULL DEFAULT 1,
    id_p INTEGER NOT NULL AUTO_INCREMENT,
    expt_designed_time datetime,
    expt_testing_time datetime,
    dead_line datetime,
    scheduled_time datetime,
    design_start_time datetime,
    develop_start_time datetime,
    testing_start_time datetime,
    CONSTRAINT pk_project_info PRIMARY KEY(id_p)
)

CREATE TABLE project_member(
    id VARCHAR(255)	NOT NULL,
    project_id VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    id_p INTEGER NOT NULL AUTO_INCREMENT,
    member_name VARCHAR(255) NOT NULL,
    role_type TINYINT NOT NULL DEFAULT 1,
    CONSTRAINT pk_project_member PRIMARY KEY(id_p)
)