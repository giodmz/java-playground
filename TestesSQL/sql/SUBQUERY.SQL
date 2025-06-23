/*
SUBQUERY ou SUBSELECT
Basicamente é um SELECT dentro de um SELECT

Exemplo:
Monte um relatório de todos os produtos cadastrados
que tem preço de venda acima da média
*/

-- Comando sem SUBQUERY
SELECT AVG(ListPrice)
FROM Production.Product;

SELECT *
FROM Production.Product
WHERE ListPrice > 438.66

-- Comando com SUBQUERY:
SELECT *
FROM Production.Product
WHERE ListPrice > (SELECT AVG(ListPrice)
FROM Production.Product);
/*
Obs: o resultado é dinâmico, ou seja, caso a tabela
for alterada o resultado também será, coisa que não
aconteceria no comando sem SUBQUERY, tornando assim
essa uma opção bem mais segura.
*/

-- Exemplo 2:
-- Preciso saber o nome dos meus funcionários que tem o cargo de 'Design Engineer'
SELECT FirstName
FROM Person.Person
WHERE BusinessEntityID IN (
SELECT BusinessEntityID FROM HumanResources.Employee
WHERE JobTitle = 'Design Engineer');

-- Também é possível executar a mesma ação utilizando um JOIN
SELECT p.FirstName
FROM Person.Person p
INNER JOIN HumanResources.Employee e 
ON p.BusinessEntityID = e.BusinessEntityID
AND e.JobTitle = 'Design Engineer';
-- Quando acontece isso você pode ir pelo que tiver a melhor performance

-- Exemplo 3 (DSF):
-- Encontre todos os endereços que estão no estado de 'Alberta'
SELECT *
FROM Person.Address
WHERE StateProvinceID IN (
SELECT StateProvinceID FROM Person.StateProvince
WHERE Name = 'Alberta');