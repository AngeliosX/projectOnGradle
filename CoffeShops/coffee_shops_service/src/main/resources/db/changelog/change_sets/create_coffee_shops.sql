create table if not exists coffee_shop
(
    id SERIAL PRIMARY KEY,
    establishment CHARACTER VARYING(30),
    description CHARACTER VARYING(30),
    response CHARACTER VARYING(30),
    rating INTEGER
);