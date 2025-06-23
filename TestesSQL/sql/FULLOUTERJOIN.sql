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
-- Isso vai retornar os nomes nas tabelas