# INSERT INTO
É usado quando se já possui uma tabela e se quer inserir dados nela

1. Adicionar informações a uma tabela:
INSERT INTO nomeTabela(coluna1, coluna2, ...)
VALUES(valor1, valo2, ...)
VALUES(valor1, valo2, ...)
VALUES(valor1, valo2, ...)

2. Inserir informações de uma tabela em outra:
INSERT INTO tabelaA (coluna1)
SELECT coluna2
FROM tabelaB

# Exemplo 1:
INSERT INTO Aula(ID, Nome)
VALUES
(2, 'Aula 2'),
(3, 'Aula 3'),
(4, 'Aula 4');

SELECT * INTO 
tabelaNova FROM Aula;

# Desafio:
CREATE TABLE Curso (
CursoID INT PRIMARY KEY,
Nome VARCHAR(150),
Aulas INT DEFAULT 0
);

SELECT *
FROM Curso;

INSERT INTO Curso (CursoID, Nome, Aulas)
VALUES
(1, 'sql1', 1),
(2, 'sql2', 4),
(3, 'sql3', 8);

CREATE TABLE VideoAula (
VideoAulaID INT PRIMARY KEY,
Duracao FLOAT DEFAULT 0
);

INSERT INTO VideoAula (VideoAulaID, Duracao)
VALUES
(1, 30.0);

SELECT *
FROM VideoAula;