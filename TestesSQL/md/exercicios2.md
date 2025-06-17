1 - Quantos produtos estão cadastrados no sistemas que custam mais do que 1500 dólares?

R:39

SELECT COUNT (ListPrice)
FROM Production.Product
WHERE ListPrice > 1500;
-----------------------------------------------------
2 - Quantas pessoas temos com o sobrenome que inicia com a letra P?

R: 1187
SELECT COUNT (LastName)
FROM Person.Person
WHERE FirstName LIKE 'P%';
-----------------------------------------------------
3 - Em quantas cidades únicas estão cadastrados nossos clientes?

R: 575
SELECT COUNT (DISTINCT City)
FROM Person.Address;
-----------------------------------------------------
4 - Quais são as cidades únicas cadastradas no sistema?

R:
SELECT DISTINCT (City)
FROM Person.Address;
-----------------------------------------------------
5 - Quantos produtos vermelhos tem preço entre 500 a 1000 dólares?

R: 11
SELECT COUNT (ListPrice)
FROM Production.Product
WHERE color = 'red' 
AND ListPrice BETWEEN 500 and 1000; 
-----------------------------------------------------
6 - Quantos produtos cadastrados tem a palavra 'road' no nome deles?

R: 103
SELECT COUNT (*)
FROM Production.Product
WHERE Name LIKE '%road%';
