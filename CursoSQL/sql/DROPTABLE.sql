/*
Serve para dropar (excluir) uma tabela do banco de
dados
*/

-- Sintaxe:
DROP TABLE nomeDaTabela

-- Só se pode dropar tabela que não são referenciadas por outras

-- Exemplo:
DROP TABLE ErrorLog;

/*
Para dropar apenas os dados de uma tabela e não ela
em si, é utilziado o TRUNCATE

Exemplo:
*/
TRUNCATE TABLE Person.Password;
