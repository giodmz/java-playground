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
-----------------------------------------------------
3 - Quais foram as 10 vendas que no total tiveram os maiores valores de venda (line total) por produto do maior valor para o menor

R:
SELECT TOP 10 ProductId, sum(LineTotal) 
FROM Sales.SalesOrderDetail
GROUP BY ProductID
ORDER BY sum(LineTotal) desc;
-----------------------------------------------------
4 - Quantos produtos e qual a quantidade média de produtos temos cadastrados nas nossas ordem serviço (WorkOrder), agrupados por productId

R:

SELECT ProductId, COUNT (ProductId) as "count",
avg (OrderQty) as "media"
FROM Production.WorkOrder
GROUP BY ProductID;
-----------------------------------------------------
5 - Estamos querendo identificar as provincias (stateProvinceId) com o maior número de cadastros no sistema, então é preciso encontrar quais províncias (stateProvinceId) estão registradas no banco de dados mais de 1000 vezes

R:
SELECT StateProvinceID, COUNT (StateProvinceID) AS "count"
FROM Person.Address
GROUP BY StateProvinceID
HAVING COUNT (StateProvinceId) > 1000;
-----------------------------------------------------
6 - Sendo que se trata de uma multinacional os gerentes querem saber quais produtos (productId) não estão trazendo em média no mínimo 1 milhão em todas de vendas (LineTotal)

R:
SELECT ProductID, COUNT (LineTotal),
avg (LineTotal) AS "avg"
FROM Sales.SalesOrderDetail
GROUP BY ProductID
HAVING avg (LineTotal) < 1000000;
