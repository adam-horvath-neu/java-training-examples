-- Insert Zsolt into Employee table (id will be the genareted by definition of sequence)
INSERT INTO "EMPLOYEE"(
            name, age, jobtitle)
    VALUES ('Zsolt', 35, 'supervisor');

-- insert István int Employee table (age will be default: 18)
INSERT INTO "EMPLOYEE"(
            id, name, jobtitle)
    VALUES (123, 'István', 'developer');

-- insert Arnold into Employee table (id will be the incremented one, age default: 18, job title: null)
INSERT INTO "EMPLOYEE"(
            name)
    VALUES ('Arnold');

-- query all data from Employee table
SELECT * FROM "EMPLOYEE"

-- filtered for jobtitle where the jobtitle is null
SELECT * FROM "EMPLOYEE" WHERE jobtitle IS NULL