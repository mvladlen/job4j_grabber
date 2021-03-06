-- Table: grabber.post



-- DROP TABLE grabber.post;



CREATE TABLE grabber.post

(

    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),

    name text COLLATE pg_catalog."default",

    text text COLLATE pg_catalog."default",

    link text COLLATE pg_catalog."default" NOT NULL,

    created timestamp without time zone,

    CONSTRAINT post_pkey PRIMARY KEY (id, link),

    CONSTRAINT post_link_key UNIQUE (link)

)



TABLESPACE pg_default;



ALTER TABLE grabber.post

    OWNER to postgres;