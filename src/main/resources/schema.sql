CREATE TABLE tasks
(
    task_id      BIGSERIAL PRIMARY KEY,
    title        VARCHAR(256) NOT NULL,
    is_completed BOOLEAN      NOT NULL DEFAULT FALSE
);