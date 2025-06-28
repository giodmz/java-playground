É utilizado quando precisamos que um campo não possar ter um valor NULL, ou seja, alguma informação tem que ser passada.

> Sintaxe

CREATE TABLE CarteiraMotorista (
    ID INT NOT NULL,
    Nome VARCHAR(255) NOT NULL,
    Idade INT CHECK ( Idade >= 18)
)

> Nesse exemplo, toda carteira precisar um ID e um Nome para entrar na tabela