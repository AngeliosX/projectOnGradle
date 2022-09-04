create table if not exists coffee_shops_employees
(
    id SERIAL PRIMARY KEY,
    shops INTEGER,
    employee CHARACTER VARYING(30)
);