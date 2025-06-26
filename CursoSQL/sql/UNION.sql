/*
O operador UNION é utilizado para combinar dois ou mais
resultados de um SELECT em apenas um resultado

UNION vai remover informações duplicadas, isso pode
ser evitado utilizando o UNION ALL
*/


SELECT coluna1, coluna2
FROM tabela1
UNION
SELECT coluna1, coluna2
FROM tabela2
-- Ela precisa selecionar dados do mesmo tipo nas duas tabelas

-- Exemplo 1:
SELECT FirstName, Title, MiddleName
FROM Person.Person
WHERE Title = 'Mr.'
UNION
SELECT FirstName, Title, MiddleName
FROM Person.Person
WHERE Title = 'A';

-- Exemplo 2:
SELECT PersonType, FirstName
FROM Person.Person
WHERE PersonType = 'EM'
UNION
SELECT PersonType, FirstName
FROM Person.Person
WHERE PersonType = 'IN';