CREATE CAST (varchar AS genderType) WITH INOUT AS IMPLICIT;

create table customers
(
    id          bigserial primary key,
    telegramId  bigint not null,
    yearOfBirth date,
    gender      genderType default 'UNKNOWN',
    points      int        default 0,
    updatedAt   timestamp,
    createdAt   timestamp

);

create unique index customers_id_uindex
    on customers (id);

CREATE SEQUENCE hibernate_sequence START 1;

