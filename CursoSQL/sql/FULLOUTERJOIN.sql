/*
Full Outer Join retorna um conjunto de todos os registros
correspondentes da TabelaA e Tabela B quando são iguais.
E além disso, se não houver valores correspondentes ele
simplesmente irá preencher esses valores com "null".
*/

-- Exemplo SQL:
SELECT FROM * TabelaA
FULL OUTER JOIN TabelaB
ON TabelaA.nome = TabelaB.Nome
/*
Esse comando vai retornar tudo que existe na TabelaA,
na TabelB e também tudo que existe em comum entre elas
*/

-- LEFT OUTER JOIN
/*
Left Outer Join retorna um conjunto de todos os registros
da TabelaA e os registros correspondentes (quando disponíveis)
na TabelaB. Se não houver registros correspondentes ele
vai preencher com "null".
Ou seja, ele é um Full Outer Join, porém caso não tenha
dados na TabelaA ele não vai trazer.
*/

-- Exemplo SQL:
SELECT * FROM TabelaA
LEFT JOIN TabelaB
ON TabelaA.Nome = TabelaB.Nome;

/*
Existe também o RIGHT OUTER JOIN, que basicamente apenas
altera o lado, ou seja, caso pegue o exemplo citado acima
ele usaria como base a TabelaB, o conceito não muda,
apenas troca o lado.
*/

/*
Exemplo:
Preciso descobrir quais pessoas tem um cartão de 
credito registrado
*/
SELECT *
FROM Person.Person pp
LEFT JOIN Sales.PersonCreditCard pc
ON pp.BusinessEntityID = pc.BusinessEntityID
WHERE pc.BusinessEntityID IS NULL;
/*
Esse comando vai pegar as tabela, fazer a junção e
retornar quantas pessoas não tem o cartão de crédito
registrado, já que o LEFT JOIN pega as informações
e as coloca como null caso não tenha nada na tabela.
*/