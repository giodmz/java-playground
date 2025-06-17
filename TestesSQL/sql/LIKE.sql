/*
Supondo que é necessário encontrar uma pessoa no banco
de dados com as iniciais 'ovi'. 
Nessa situação que o LIKE é usado

LIKE não é case sensitivy
*/

SELECT *
FROM Person.Person
WHERE FirstName LIKE 'ovi%'
-- a % indica a parte que você não sabe, ou seja a inicial do individuo é ovi


SELECT *
FROM Person.Person
WHERE FirstName LIKE '%to'
-- ja aqui temos apenas a informação das ultimas letras que seriam to


SELECT *
FROM Person.Person
WHERE FirstName LIKE '%essa%'
-- nessa situação vai procurar ambos, ou seja, só sabemos o meio do nome
-- um exemplo que poderia ser encontrado nessa situação: Vanessa


SELECT *
FROM Person.Person
WHERE FirstName LIKE '%ro_'
-- o underline é usado para substituir apenas um caractere
-- ex: vai achar Aaron, porém Aaronson não, já que está pedindoa apenas um caractere
