1) A equipe de marketing precisa de fazer uma pesquisa
sobre nomes mais comuns de seus clientes e precisa de
nome e sobrenome de todos os clientes cadastrados no Sistema

R:
SELECT FirstName, LastName
FROM Person.Person;
-----------------------------------------------------
2) Quantos sobrenomes únicos temos na 
tabela Person.Person?

R: 1206 
SELECT DISTINCT LastName
FROM Person.Person;
-----------------------------------------------------
3) a) A equipe de produção de produtos precisa do nome de todas
as peças que pesam mais que 500kg, mas não mais que 700kg

R:
SELECT *
FROM Production.Product
WHERE Weight > 500 and Weight < 700;
-----------------------------------------------------
b) Foi pedido pelo marketing uma relação de todos os empregados que são
casados e são assalariados

R:
SELECT *
FROM HumanResources.Employee
WHERE MaritalStatus = 'M' and SalariedFlag = 1;
-----------------------------------------------------
c) Um usuário chamado Peter Krebs está devendo um pagamento, consiga o
email dele

R: peter0@adventure-works.com
SELECT *
FROM Person.Person
WHERE FirstName = 'Peter' and LastName = 'Krebs';

SELECT * 
FROM Person.EmailAddress
WHERE BusinessEntityID = 26;
-----------------------------------------------------
4) a) Quantos produtos estão cadastrados na tabela
de produtos

R: 504
SELECT COUNT(*)
FROM Production.Product;
-----------------------------------------------------
b) Quantos tamanhos de produtos estão cadastrados
na tabela

R: 211
SELECT COUNT(Size)
FROM Production.Product;
-----------------------------------------------------
c) Quantos tamanhos diferentes de produtos estão
cadastrados na tabela

R: 18
SELECT COUNT(DISTINCT Size)
FROM Production.Product;
-----------------------------------------------------
5) Obter o ProductId dos 10 produtos mais caros cadastrados
no sistema listando do mais caro para o mais barato

R:
SELECT TOP 10 *
FROM Production.Product
ORDER BY ListPrice desc;