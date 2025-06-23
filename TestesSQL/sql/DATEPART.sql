/*
É basicamente um DateFormat só que no SQL, serve para
extrair informações de colunar que estão no formato de data

https://learn.microsoft.com/pt-br/sql/t-sql/functions/datepart-transact-sql?view=sql-server-ver16
*/

-- Exemplo:
SELECT SalesOrderId, DATEPART(month, OrderDate) AS Month
FROM Sales.SalesOrderHeader;

SELECT SalesOrderId, DATEPART(year, OrderDate) AS Year
FROM Sales.SalesOrderHeader;

SELECT SalesOrderId, DATEPART(day, OrderDate) AS Day
FROM Sales.SalesOrderHeader;

-- Exemplo 2:
SELECT AVG(TotalDue) AS Average, DATEPART(month, OrderDate) as Month
FROM Sales.SalesOrderHeader
GROUP BY DATEPART(month, OrderDate)
ORDER BY Month;