# Chave Primária
-> Uma chave primária é basicamente uma coluna ou grupo de colunas, usada para identificar unicamente uma linha em uma tabela.
-> É possível criar chaves primárias através de restrições (constraints), que são regras definidas quando se cria uma coluna. Assim é criado um índice único para a coluna ou grupo de colunas

Exemplo:

CREATE TABLE nome_Tabela{
    nomeColuna tipoDeDados PRIMARY KEY
    nomeColuna tipoDeDados ...
}

# Chave Estrangeira
-> Uma chave estrangeira é uma coluna ou grupo de colunas em uma tabela que identifica unicamente uma linha em outra tabela, ou seja, ela é definida em uma tabela onde ela é apenas referência e não possui todos os seus dados contidos na mesma.
-> Então uma chave estrangeira é simplesmente uma coluna ou grupo de colunas que é uma chave primária em outra tabela