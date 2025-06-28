/*
O VIEW permite criar tabelas para consulta onde é
utilizada outras tabelas como base para criar uma nova
tabela de pesquisa com apenas dados específicos que
serão extraídos dela. É comumente usada para relatórios.
*/

-- Sintaxe
CREATE VIEW [Pessoas Simplificado] AS
SELECT FirstName, MiddleName, LastName
FROM Person.Person
WHERE Title = 'Ms.'