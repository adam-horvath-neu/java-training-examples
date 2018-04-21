SELECT "employee_fk", "phone_number"
  FROM "PHONE_NUMBER"

SELECT "employee_fk", COUNT("phone_number") AS num
  FROM "PHONE_NUMBER"
  -- WHERE will filter before GROUP BY
  WHERE "phone_number" NOT LIKE '+111%'
  GROUP BY "employee_fk"
  -- HAVING "is a WHERE" ont the result of GROUP BY
  HAVING "employee_fk" < 50;