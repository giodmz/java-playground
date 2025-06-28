Serve para criar colunas únicas, porém diferente do PRIMARY KEY ela pode ser definida em quantas colunas forem necessárias, além de não permitir que sejam inseridos dados repetidos em uma tabela

> Sintaxe

CREATE TABLE CarteiraMotorista (
    ID INT NOT NULL,
    Nome VARCHAR(255) NOT NULL,
    Idade INT CHECK ( Idade >= 18),
    CodigoCNH INT NOT NULL UNIQUE
);

> Nesse exemplo o CodigoCNH não poderá ter valores repitidos