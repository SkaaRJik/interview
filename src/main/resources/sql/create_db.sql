CREATE DATABASE interview;

CREATE USER interviewer WITH ENCRYPTED PASSWORD 'interview';
GRANT ALL PRIVILEGES ON DATABASE interview TO interviewer;

CREATE TABLE sorts (
                       id bigserial primary key,
                       inputs text NOT NULL,
                       output text default NULL
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.sorts
    OWNER to interviewer;