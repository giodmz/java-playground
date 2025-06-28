/*
Update serve para atualizar dados no banco de dados
*/

UPDATE nomeTabela
SET coluna1 = valor1
    coluna2 = valor2
WHERE condicao
-- SE NÃO PASSAR O WHERE ALTERA TODO O BANCO DE DADOS

-- Exemplo:
SELECT *
FROM Aula;

UPDATE Aula
SET Nome = 'TesteUpdate';

UPDATE Aula
SET Nome = 'MudancaUnica'
WHERE ID = 3;