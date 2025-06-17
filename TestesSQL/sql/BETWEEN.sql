/*
o between é usado para encontrar valor entre um
valor mínimo e valor máximo

valor BETWEEN mínimo AND máximo;

valor >= mínimo AND valor <= máximo
*/

SELECT *
FROM Production.Product
WHERE ListPrice between 1000 and 1500;

SELECT *
FROM Production.Product
WHERE ListPrice NOT between 1000 and 1500;

SELECT *
FROM HumanResources.Employee
WHERE HireDate BETWEEN '2009/01/01' and '2010/01/01'
ORDER BY HireDate;