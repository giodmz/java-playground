/*
Inner join é utilizado para juntar informações entre 
tabelas

Cliente         | Endereco
----------------|----------------
ClientId        | EnderecoId
Nome            | Rua
EnderecoId      | Cidade
*/

SELECT C.ClienteId, C.Nome, E.Rua, E.Cidade
FROM Cliente C
INNER JOIN Endereco E ON E.EnderecoId = C.EnderecoId


-- Resultado:
-- |2| Bruno | Rua Norte | São Paulo |
/*
*/

-- Exemplo:
SELECT p.BusinessEntityID, p.FirstName, p.LastName, pe.EmailAddress
FROM Person.Person as P
INNER JOIN Person.EmailAddress PE on p.BusinessEntityID = pe.BusinessEntityID;

/*
Busca pelo nome dos produtos e as informações de suas
subcategorias
ListPrice, Nome do Produto, Nome da Subcategoria
*/

SELECT TOP 10 *
FROM Production.Product;

SELECT TOP 10 * 
FROM Production.ProductSubcategory;

/*
Fazendo essa busca é possível perceber que a coluna
em comum é ProductSubcategoryID, então a busca vai
ser baseado nela
*/

SELECT pr.ListPrice, pr.Name, pc.Name
FROM Production.Product Pr
INNER JOIN Production.ProductSubcategory PC on
PC.ProductSubcategoryID = pr.ProductSubcategoryID;

-- Para juntar todos os dados de uma tabela sem filtro:
SELECT TOP 10 *
FROM Person.BusinessEntityAddress BA
INNER JOIN Person.Address PA ON PA.AddressID = BA.AddressID;
-- Caso não passe a informação no SELECT, ele vai simplesmente juntar tudo.

/*
Exemplo 1:
Extraindo as informações BusinessEntityID, Name,
PhoneNumberTypeID e PhoneNumber das tabelas:
*/
SELECT TOP 10 *
FROM Person.PhoneNumberType;

SELECT TOP 10 *
FROM Person.PersonPhone;

-- Comando SQL:
SELECT pp.PhoneNumber, pn.Name, pn.PhoneNumberTypeID, pp.BusinessEntityID
FROM Person.PersonPhone pp 
INNER JOIN Person.PhoneNumberType pn on
pp.PhoneNumberTypeID = pn.PhoneNumberTypeID;


/*
Exemplo 2:
Extraindo as informações AddressID, City,
StateProvinceID e o nome do estado das tabelas:
*/
SELECT TOP 10 *
FROM Person.StateProvince;

SELECT TOP 10 *
FROM Person.Address;

-- Comando SQL:
SELECT pa.AddressID, pa.City, ps.StateProvinceID, ps.Name
FROM Person.Address pa
INNER JOIN Person.StateProvince ps on
pa.StateProvinceID = ps.StateProvinceID;