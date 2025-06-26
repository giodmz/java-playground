/*
O GROUP BY divide o resultado da pesquisa em grupos

Para cada grupo que você aplicar uma função de
agregação, por exemplo:
- calcular a soma de itens
- contar o número de itens naquele grupo
*/

SELECT coluna1, funcaoAgregacao (coluna2)
FROM nomeDaTabela
GROUP BY coluna1;

-- Exemplo:

-- Busca o ID 9
SELECT SpecialOfferID, UnitPrice
FROM Sales.SalesOrderDetail
WHERE SpecialOfferID = 9;

-- Somas os preços usando o GROUP BY de cada ID
SELECT SpecialOfferID, SUM(UnitPrice) AS "Soma"
FROM Sales.SalesOrderDetail
GROUP BY SpecialOfferID;

/*
Ele agrupa os e soma todos aqueles que tem um
ID igual
*/

-- Supondo que eu queira saber quantos de cada produto foi vendido até hoje
-- Agrupa pelo ProductId
SELECT ProductId, COUNT(ProductId) AS "Contagem"
FROM Sales.SalesOrderDetail
GROUP BY ProductID;

-- Supondo que eu queira saber quanto nomes de cada nome está cadastrado no banco de dados
-- Vai contar quantas vezes aparece cada um desses nomes
SELECT FirstName, COUNT (FirstName) AS "Contagem"
FROM Person.Person
GROUP BY FirstName;

-- Na tabela de Production.Product eu quero saber a média de preço para os produto que são prata
SELECT color, AVG (ListPrice) AS "avg_silver"
FROM Production.Product
WHERE Color = 'Silver'
GROUP BY Color;