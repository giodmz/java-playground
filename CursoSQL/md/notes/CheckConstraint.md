Restrições de valores que podem ser inseridos em uma coluna de uma tabela em banco de dados quando estiver criando uma tabela nova

# Sintaxe:
CREATE TABLE CarteiraMotorista (
    ID INT NOT NULL,
    Nome VARCHAR(255) NOT NULL,
    Idade INT CHECK (Idade >= 18) -> Validação
);

> Ao tentar adicionar o seguinte comando na query
 INSERT INTO CarteiraMotorista (ID, Nome, Idade)
 VALUES (
 1,
 'Marcelo',
 17
 );
 > Que em teoria colocaria os valores nela, irá retornar um erro impedindo, já que na validação a idade tem de ser maior ou igual a 18


# Outros exemplos:
CREATE TABLE AptoAVotar (
    ID INT NOT NULL,
    Nome VARCHAR(255) NOT NULL,
    Idade INT CHECK (Idade >= 18)
);

CREATE TABLE MeiaEntrada (
    ID INT NOT NULL,
    Nome VARCHAR(255) NOT NULL,
    Idade INT NOT NULL,S
    Estudante VARCHAR(13) CHECK (Estudante == 'Universitario');
);