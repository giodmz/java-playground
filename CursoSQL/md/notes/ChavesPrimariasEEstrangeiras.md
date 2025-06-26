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

## Observações
* A tabela que contém a chave estrangeira é chamada de tabela referênciadora ou tabela filho. Já a tabela na qual a chave estrangeira é referênciada é chamada de tabela referênciada ou tabela pai.

* Uma tabela pode ter mais de uma chave estrangeira dependendo do seu relacionamento com as outras tabelas

## Regras
* No SQL Server você define uma chave estrangeira utilizando um "Foreign Key Constraint" (Restrição de Chave Estrangeira)
* Uma restrição de chave estrangeira indica que os valores em uma coluna ou grupo de colunas na tabela filho correspondem aos valores na tabela pai
* É possível entender que uma chave estrangeira mantém a "integridade referencial"