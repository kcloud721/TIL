/*
1. RDBMS

2.SQL
    - DQL, DDL, DMl, DCL, TCL

3. DQL
 - Function, Group, JOIN, Sub Query
 
 4. DDL 
  -CREATE, DROP, ALTER
  
  5. DML
   - INSERT, DELETE, UPDATE
   
6. TCL
    - commin, rollback

7. Sequence
8. RANK

*/
SELECT ENAME, SAL, RANK
FROM(
    SELECT ENAME, SAL, RANK() OVER (ORDER BY SAL DESC) AS RANK
    FROM EMP)
WHERE RANK < 5;