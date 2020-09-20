INSERT INTO shops (address)
values ('Dobryninskaya street d.35');
INSERT INTO shops (address)
values ('Novinki street d.93');
INSERT INTO shops (address)
values ('Chesmenskaya street d.9');
INSERT INTO customers (telegramid, yearofbirth, gender, points, updatedat, createdat)
values (3921, '1994-03-12', 'FEMALE', 14, now(), now() - INTERVAL '45 DAY'),
       (9299, '2001-01-01', 'MALE', 10, now(), now() - INTERVAL '40 DAY'),
       (91983, '1998-10-10', 'MALE', 3, now(), now() - INTERVAL '10 DAY'),
       (5161, '1985-12-12', 'UNKNOWN', 0, now(), now()),
       (592341, '1985-12-12', 'UNKNOWN', 0, now(), now()),
       (912498, '2002-01-20', 'MALE', 5, now(), now() - INTERVAL '15 DAY');

INSERT INTO sales (customerid, shopid, paid, reason, createdat)
values (1, 1, 10.20, 'SALE', now() - INTERVAL '1 DAY'),
       (1, 2, 10, 'SALE', now() - INTERVAL '7 DAY'),
       (1, 3, 2.21, 'SALE', now() - INTERVAL '10 DAY'),
       (1, 1, 26.45, 'SALE', now() - INTERVAL '14 DAY'),
       (1, 1, 10.20, 'SALE', now() - INTERVAL '16 DAY'),
       (1, 2, 10, 'SALE', now() - INTERVAL '18 DAY'),
       (1, 3, 2.21, 'SALE', now() - INTERVAL '20 DAY'),
       (1, 1, 10.20, 'SALE', now() - INTERVAL '25 DAY'),
       (1, 2, 10.22, 'SALE', now() - INTERVAL '29 DAY'),
       (1, 3, 2.21, 'SALE', now() - INTERVAL '32 DAY'),
       (1, 1, 10.20, 'SALE', now() - INTERVAL '35 DAY'),
       (1, 2, 10.99, 'SALE', now() - INTERVAL '37 DAY'),
       (1, 3, 2.21, 'SALE', now() - INTERVAL '40 DAY'),
       (1, 3, 10.20, 'SALE', now() - INTERVAL '44 DAY'),
       (2, 3, 34.33, 'SALE', now() - INTERVAL '2 DAY'),
       (2, 2, 12.83, 'SALE', now() - INTERVAL '4 DAY'),
       (2, 1, 8.10, 'SALE', now() - INTERVAL '6 DAY'),
       (2, 3, 34.33, 'SALE', now() - INTERVAL '8 DAY'),
       (2, 2, 12.83, 'SALE', now() - INTERVAL '10 DAY'),
       (2, 1, 8.10, 'SALE', now() - INTERVAL '12 DAY'),
       (2, 3, 34.33, 'SALE', now() - INTERVAL '14 DAY'),
       (2, 2, 12.13, 'SALE', now() - INTERVAL '30 DAY'),
       (2, 1, 1.10, 'SALE', now() - INTERVAL '33 DAY'),
       (2, 1, 3.10, 'SALE', now() - INTERVAL '38 DAY'),
       (3, 2, 12.22, 'SALE', now() - Interval '3 DAY'),
       (3, 2, 10.5, 'SALE', now() - Interval '5 DAY'),
       (3, 2, 8.05, 'SALE', now() - Interval '7 DAY'),
       (6, 2, 32.11, 'SALE', now() - INTERVAL '14 DAY'),
       (6, 1, 32.11, 'SALE', now() - INTERVAL '14 DAY'),
       (6, 2, 32.11, 'SALE', now() - INTERVAL '14 DAY'),
       (6, 1, 32.11, 'SALE', now() - INTERVAL '14 DAY'),
       (6, 2, 32.11, 'SALE', now() - INTERVAL '14 DAY'),
       (6, 1, 32.11, 'SALE', now() - INTERVAL '14 DAY')
;

