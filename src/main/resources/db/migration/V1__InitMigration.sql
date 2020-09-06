
create table customers
(
    id          bigint,
    telegramId  bigint not null,
    yearOfBirth date,
    gender      genderType,
    points      int,
    updatedAt   timestamp,
    createdAt   timestamp

);

CREATE TYPE genderType AS ENUM ('MALE','FEMALE','UNKNOWN')