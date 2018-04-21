SELECT 
  "EMPLOYEE".name, 
  "PHONE_NUMBER"."phone_number" AS "Telefonszam"

FROM 
  "EMPLOYEE", 
  "PHONE_NUMBER"
WHERE 
  "PHONE_NUMBER"."employee_fk" = "EMPLOYEE".id;


SELECT 
  emp.name, 
  pn.phone_number AS "Telefonszam"
FROM 
  "EMPLOYEE" emp 
  inner join "PHONE_NUMBER" pn on pn.employee_fk = emp.id

-- insert two new record with one command
INSERT INTO "PHONE_NUMBER" ("employee_fk", "phone_number") VALUES
    ((SELECT id FROM "EMPLOYEE" WHERE name LIKE 'Zsolt'), '+366543333'),
	((SELECT id FROM "EMPLOYEE" WHERE name LIKE 'István'), '+366542222');

-- show all rows from Employee even if there is no phonenumber for him/her
SELECT *
	FROM "EMPLOYEE"
	LEFT JOIN "PHONE_NUMBER" ON "PHONE_NUMBER"."employee_fk" = "EMPLOYEE".id

-- Cartesian square of the two table
SELECT *
	FROM "EMPLOYEE"
	CROSS JOIN "PHONE_NUMBER"


SELECT 
  emp.name, 
  pn.phone_number AS "Telefonszam",
  em.email as "Email cím"
FROM 
  "EMPLOYEE" emp 
  inner join "PHONE_NUMBER" pn on pn.employee_fk = emp.id
  inner join "EMAIL" em on em.employee_fk = emp.id;
