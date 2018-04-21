-- Roll back by user
-- Start a new transaction
BEGIN;
-- 3 rows
SELECT * FROM "EMPLOYEE";

INSERT INTO "EMPLOYEE" (name) VALUES ('Árpád');
-- 4 rows
SELECT * FROM "EMPLOYEE";
-- The database state will be the same what was before the transaction has benn started
ROLLBACK; 
-- 3 rows (Árpád is not in the table)
SELECT * FROM "EMPLOYEE";



-- Roll back by error
-- 4 rows
SELECT * FROM "EMPLOYEE";
BEGIN;
INSERT INTO "EMPLOYEE" (name) VALUES ('Mari');
-- 5 rows
SELECT * FROM "EMPLOYEE";
INSERT INTO "PHONE_NUMBER" VALUES ((SELECT id FROM "EMPLOYEE" WHERE name = 'Mari'), nonexistingcolumn);
-- transaction is interrupted by an error 
SELECT * 
FROM "EMPLOYEE" emp 
left join "PHONE_NUMBER" pn ON pn.employee_fk = emp.id;
-- rollback
ROLLBACK;
-- 4 rows
SELECT * FROM "EMPLOYEE";



-- Commit the transaction
-- 4 rows
SELECT * FROM "EMPLOYEE";
BEGIN;
INSERT INTO "EMPLOYEE" (name) VALUES ('Mari');
INSERT INTO "PHONE_NUMBER" VALUES ((SELECT id FROM "EMPLOYEE" WHERE name = 'Mari'), '+36304569387');
-- 5 rows
SELECT * 
FROM "EMPLOYEE" emp 
left join "PHONE_NUMBER" pn ON pn.employee_fk = emp.id;
-- commit
COMMIT;
-- result
SELECT * 
FROM "EMPLOYEE" emp 
left join "PHONE_NUMBER" pn ON pn.employee_fk = emp.id;
