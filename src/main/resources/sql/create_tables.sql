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