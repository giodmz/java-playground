/*
O HAVING é usado juntamente com o GROUP BY para filtrar
resultados de um agrupamento

-> é um WHERE para dados agrupados
*/

SELECT coluna1, funcaoAgregacao(coluna2)
FROM nomeDaTabela
GROUP BY coluna1
HAVING condicao;

/*
Diferença entre o HAVING e o WHERE:
O GROUP BY é aplicado depois que os dados ja foram 
agrupados, enquanto o WHERE é aplicado antes dos
dados serem agrupados
*/

-- Ex: Quais os nomes no sistema tem uma ocorrência maior que 10x?

SELECT FirstName, COUNT(FirstName) AS "quantidade"
FROM Person.Person
GROUP BY FirstName
HAVING COUNT (FirstName) > 10;
-- HAVING só pode ser usado depois que os dados forem agrupados


-- Ex2: Produtos que no total de vendas estão entre 162k e 500k

SELECT ProductID, sum(LineTotal) as "total"
FROM Sales.SalesOrderDetail
GROUP BY ProductId
HAVING sum(LineTotal) between 162000 and 500000;


/*
Usando WHERE e HAVING na mesma pesquisa

Ex: Quais nomes no sistema tem uma ocorrência maior
do que 10 vezes, porém somente onde o título é "Mr."
*/

SELECT FirstName, COUNT(FirstName) AS "quantidade"
FROM Person.Person
WHERE Title = 'Mr.'
GROUP BY FirstName
HAVING COUNT (FirstName) > 10;