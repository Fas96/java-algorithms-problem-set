## EMPLOYEES Table ID, name salary and Branch ID

## get sum of employees salary for each branch
SELECT BRANCH_ID, SUM(SALARY) FROM EMPLOYEES GROUP BY BRANCH_ID ASC ;