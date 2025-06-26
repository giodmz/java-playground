/*
É possível fazer operações matemáticas pelo SQL, é
basicamente a mesma coisa que em qualquer linguagem,
alguns exemplos:
*/

-- Soma
SELECT UnitPrice + LineTotal
FROM Sales.SalesOrderDetail;

-- Subtração
SELECT UnitPrice - LineTotal
FROM Sales.SalesOrderDetail;

-- Multiplicação
SELECT UnitPrice * LineTotal
FROM Sales.SalesOrderDetail;

-- Divisão
SELECT UnitPrice / LineTotal
FROM Sales.SalesOrderDetail;

-- Média
SELECT AVG(LineTotal)
FROM Sales.SalesOrderDetail;

-- Soma
SELECT SUM(LineTotal)
FROM Sales.SalesOrderDetail;

-- Valor mínimo
SELECT MIN(LineTotal)
FROM Sales.SalesOrderDetail;

-- Valor máximo
SELECT MAX(LineTotal)
FROM Sales.SalesOrderDetail;

-- Arredondamento (nesse caso seria precisão de 2 casas decimais)
SELECT ROUND(LineTotal, 2)
FROM Sales.SalesOrderDetail;

-- Raiz quadrada (square root)
SELECT SQRT(LineTotal)
FROM Sales.SalesOrderDetail;

/*
Existem outros tipos de operações, mas para encontrar
é só pesquisar no google que tem tudo
*/
