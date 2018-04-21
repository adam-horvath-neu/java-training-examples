-- add phone number to Géza (id:5)
INSERT INTO "PHONE_NUMBER"(
            "employee_fk", "phone_number")
    VALUES (5, '+36123456');

-- add an other phone number to Géza
INSERT INTO "PHONE_NUMBER"(
            "employee_fk", "phone_number")
            -- Query the id of that employee whos name 'like' Géza
    VALUES ((SELECT id FROM "EMPLOYEE" WHERE name LIKE 'Géza'), '+36654321');

SELECT * FROM "PHONE_NUMBER" 