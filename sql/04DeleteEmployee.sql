-- Delete ALLLL!!! row from Employee table where the jobtitle was null
DELETE FROM "EMPLOYEE"
 WHERE jobtitle IS NULL;

SELECT * FROM "EMPLOYEE" WHERE jobtitle IS NULL