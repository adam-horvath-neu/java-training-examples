-- add email address to Géza
insert into "EMAIL"
values((SELECT id FROM "EMPLOYEE" WHERE name LIKE 'Géza'), 'geza@training.hu');

-- add email address to Zsolt
insert into "EMAIL"
values((SELECT id FROM "EMPLOYEE" WHERE name LIKE 'Zsolt'), 'zsolt@training.hu');


SELECT * FROM "EMAIL" 