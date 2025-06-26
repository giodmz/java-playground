# Create Table

Principais tipo de restrições que podem ser aplicadas:
NOT NULL - Não permite nulos
UNIQUE - Não permite valores duplicados em uma mesma coluna
PRIMARY KEY - NOT NULL + UNIQUE
FOREIGN KEY - Identifica unicamente uma linha em outra tabela
CHECK - Força uma condição específica em um coluna
DEFAULT - Força um valor padrão quando nenhum valor é passado

## Exemplo 1:
CREATE TABLE Canal (
CanalID int Primary Key,
Nome varchar(150) not null,
Inscritos INT DEFAULT 0,
DataDeCriacao DATETIME not null,
);


## Exemplo 2:
CREATE TABLE Video (
VideoID INT PRIMARY KEY,
Nome VARCHAR(150) not null,
Visualizacoes INT DEFAULT 0,
Likes INT DEFAULT 0,
Deslikes INT DEFAULT 0,
Duracao INT not null,
CanalID INT FOREIGN KEY REFERENCES Canal(CanalID)
);

# Exercício:
-> Crie 2 tabelas que tenham relacionamento uma com a outra

R:
CREATE TABLE Estante (
EstanteID INT PRIMARY KEY,
Posicao VARCHAR(150) not null,
LivrosComportados INT DEFAULT 0
);

CREATE TABLE Livro (
LivroID INT PRIMARY KEY,
Nome VARCHAR(100) not null,
Paginas INT DEFAULT 0,
EstanteID INT FOREIGN KEY REFENCER Estante(EstanteID)
);

