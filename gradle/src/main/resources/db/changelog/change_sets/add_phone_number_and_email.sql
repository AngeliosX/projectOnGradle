alter table coffee_shop
    add if not exists phone_number varchar(15),
    add if not exists email varchar(50);