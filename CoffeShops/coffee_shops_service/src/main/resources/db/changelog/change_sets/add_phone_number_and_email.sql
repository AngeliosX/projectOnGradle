alter table coffee_shop
    add if not exists phone_number CHARACTER VARYING(15),
    add if not exists email CHARACTER VARYING(50);