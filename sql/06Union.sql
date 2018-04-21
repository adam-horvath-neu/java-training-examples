-- Make the union of those two table
SELECT "employee_fk", "phone_number"  FROM "PHONE_NUMBER"
UNION
SELECT "employee_fk", email FROM "EMAIL";

-- ERROR:  each UNION query must have the same number of columns
SELECT "employee_fk", "phone_number"  FROM "PHONE_NUMBER"
UNION
SELECT email FROM "EMAIL";

-- The "missing" column will be null -> the union can run
SELECT "employee_fk", "phone_number"  FROM "PHONE_NUMBER"
UNION
SELECT null, email FROM "EMAIL";