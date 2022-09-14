CREATE TABLE IF NOT EXISTS users
(
    id                SERIAL PRIMARY KEY,
    name              CHARACTER VARYING(20)  not null,
    surname           CHARACTER VARYING(20)  not null,
    lastname          CHARACTER VARYING(20)  not null,
    email             CHARACTER VARYING(255) not null,
    registration_date timestamp default CURRENT_TIMESTAMP
)