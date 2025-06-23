/*
SELF JOIN é usado para procurar informações e filtrar
informações que estão na mesma tabela
*/

-- Exemplo 1: 
-- Eu quero todos os clientes que moram na mesma região
SELECT A.ContactName, A.Region, B.ContactName, B.Region
FROM Customers A, Customers B
WHERE A.Region = B.Region;

-- Exemplo 2:
-- Eu quero encontrar nome e data de contratação de todos os funcionários que foram contratados no mesmo ano
SELECT A.FirstName, A.HireDate, B.FirstName, B.HireDate
FROM Employees A, Employees B
WHERE DATEPART(YEAR, A.HireDate) = DATEPART(YEAR, B.HireDate);

-- Exemplo 3 (DSF):
-- Eu quero saber na tabela detalhe do pedido quais produtos tem o mesmo percentual de desconto
SELECT A.ProductID, A.Discount, B.ProductID, B.Discount
FROM [Order Details] A, [Order Details] B
WHERE A.Discount = B.Discount;