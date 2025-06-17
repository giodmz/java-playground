/*
MIN MAX SUM AVG

Funções de agregação que agregam ou combinam dados
de uma tabela em um único resultado
*/

SELECT TOP 10 SUM (linetotal) AS "Soma"
FROM Sales.SalesOrderDetail;

SELECT TOP 10 MIN (linetotal) AS "Mínimo"
FROM Sales.SalesOrderDetail

SELECT TOP 10 MAX (linetotal) AS "Máximo"
FROM Sales.SalesOrderDetail

SELECT TOP 10 AVG (linetotal) AS "Média"
FROM Sales.SalesOrderDetail


-- AS define um apelido para a tabela