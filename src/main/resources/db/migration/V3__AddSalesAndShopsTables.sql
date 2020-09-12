CREATE CAST (varchar AS reasonType) WITH INOUT AS IMPLICIT;

create table shops
(
    id      serial not null primary key,
    address varchar
);

create unique index shops_id_uindex on shops (id);



create table sales
(
    id         bigint         not null primary key,
    customerId int            not null
        constraint sales_customers_id_fk
            references customers,
    shopId     bigint         not null
        constraint visits_shops_id_fk
            references shops (id),
    paid       decimal(12, 3) not null,
    reason     reasonType     not null,
    createdAt  timestamptz    not null
);

create unique index sales_id_uindex on sales (id);