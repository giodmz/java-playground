1 - Preciso saber quantas pessoas tem o mesmo MiddleName agrupadas pelo MiddleName

R:
SELECT MiddleName, COUNT (MiddleName) AS "contagem"
FROM Person.Person
GROUP BY MiddleName;
-----------------------------------------------------
2 - Preciso saber em média qual é quantidade que cada produto é vendido na loja

R:
SELECT ProductID, AVG (OrderQty) as "Media"
FROM Sales.SalesOrderDetail
GROUP BY ProductId;