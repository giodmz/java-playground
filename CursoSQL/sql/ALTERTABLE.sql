/*
ALTER TABLE altera a estrutura de uma tabela
*/

-- Sintaxe:
ALTER TABLE nomeDaTabela
ACAO


/*
Exemplos do que pode ser feito usando o ALTER TABLE:
- Adicionar, remover ou alterar uma coluna
- Definir valores padrão para uma coluna
- Adicionar ou remover restrições de colunas
- Renomear uma tabela
*/

-- Teste em uma nova tabela:

-- Criação da tabela:
CREATE TABLE Youtube (
ID INT PRIMARY KEY,
Nome VARCHAR(150) NOT NULL UNIQUE,
Categoria VARCHAR(150) NOT NULL,
DataCriacao DATETIME NOT NULL
)

-- Nova coluna:
ALTER TABLE Youtube
ADD Ativo BIT;

-- Alterando o limite de caracteres no VARCHAR
ALTER TABLE Youtube
ALTER COLUMN Categoria VARCHAR(300) NOT NULL;

-- Alterando o nome de uma tabela:
-- Sintaxe:
EXEC sp_RENAME 'nomeTabela.nomeColunaAtual', 'nomeColunaNova', 'COLUMN'
-- Exemplo na tabela:
EXEC sp_RENAME 'Youtube.Nome', 
'nomeCanal', 'COLUMN';
