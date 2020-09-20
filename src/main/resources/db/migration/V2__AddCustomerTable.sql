create table customers
(
    id          bigserial primary key,
    telegramId  bigint                    not null,
    yearOfBirth date,
    gender      varchar default 'UNKNOWN' not null,
    points      int     default 0         not null,
    updatedAt   timestamp,
    createdAt   timestamp
);

create unique index customers_id_uindex
    on customers (id);

CREATE SEQUENCE hibernate_sequence START 1;

