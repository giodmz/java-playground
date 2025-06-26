/*
Existem várias operações que podem ser feitas para a
manipulação de strings, são basicamente formas de
buscar os dados, como por exemplo, colocando nome e
sobrenome em uma só coluna, deixando todos os caractéres
em maiúsculo ou minúsculo e vários outros outros.

Sumário completo:
https://learn.microsoft.com/en-us/sql/t-sql/functions/string-functions-transact-sql?view=sql-server-ver17
*/

-- O retorna será: Nome Sobrenome, *com o espaço entre eles*
SELECT CONCAT(FirstName,' ', LastName)
FROM Person.Person;

-- Retorna em UpperCase e LowerCase respectivamente
SELECT UPPER(FirstName), LOWER (FirstName)
FROM Person.Person;

-- Conta o número de caractéres do dado pedido
SELECT LEN(FirstName)
FROM Person.Person;

-- Extrai caractéres de uma string
SELECT FirstName, SUBSTRING(FirstName, 1, 3)
FROM Person.Person
/*
Nesse caso ele pega do nome do primeiro até o terceiro caractér
Ou seja o retorno será por exemplo:

FirstName | SubString |
----------------------|
Syed      | Sye       |
Chatherine| Cat       |
Hazem     | Haz       |
*/

-- Substitui algo na string
SELECT ProductNumber, REPLACE (ProductNumber, '-', '#')
FROM Production.Product;
/*
Nesse caso ele vai substituir o "-" pelo "#":

ProductNumber | SubString |
--------------------------|
AR-5368       | AR#5368   |
BA-7885       | BA#7885   |
HJ-9996       | HJ#9996   |
*/

-- Exercício: testar todos os comandos
-- R:
SELECT CONCAT(JobTitle, ' | ', LoginID)
FROM HumanResources.Employee;

SELECT UPPER(JobTitle), LOWER(JobTitle)
FROM HumanResources.Employee;

SELECT LEN(NationalIDNumber)
FROM HumanResources.Employee;

SELECT JobTitle, SUBSTRING(JobTitle, 1, 5)
FROM HumanResources.Employee;


