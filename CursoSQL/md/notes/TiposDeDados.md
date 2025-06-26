Tipos principais:
1. Booleanos
2. Caracteres
3. Números
4. Temporais

# Booleanos
Por padrão ele é inicializado como nulo e pode receber tanto 1 ou 0
BIT

# Caracteres
1. Tamanho fixo -> CHAR (Permite inserir até uma quantidade fixa de caracteres e sempre ocupa todo o espaço reservado 10/50)
2. Tamanho variável -> VARCHAR ou NVARCHAR (Permite inserir até uma quantidade que for definida, porém só usa o espaço que for preenchido 10/50)

# Números
### Valores Exatos
1. TINYINT - (Não tem valor fracionado, apenas inteiro)
2. SMALLINT - Mesma coisa porém com um limite maior
3. INT - Mesma coisa porém com um limite maior
4. BIGINT - Mesma coisa porém com um limite maior
5. NUMERIC ou DECIMAL - Valores exatos, porém permite ter partes fracionadas, que também pode ser específicada a precisão e a escala (escala é o número de digitos na parte fracional)

### Valores Aproximados
1. REAL - Tem precisão aproximada de até 15 digitos
2. FLOAT - Mesmo conceito do REAL

### Temporais
1. DATE - Armazena data no formado yyyy/mm/dd
2. DATETIME - Armazena data e horas no formado yyyy/mm/dd:hh:mm:ss
3. DATETIEM2 - Data e horas com adição de milissegundos no formato yyyy/mm/dd:hh:mm:ss:sssssss
4. SMALLDATETIME - Data e hora, porém respeitando o limite entre "1900-01-01:00:00:00" até "2079-06-06:23:59:59"
5. TIME - Horas, minutos, segundos e milisegundos, respeitando o limite de "00:00:00.0000000" até "23:59:59.9999999"
6. DATETIMEOFFSET - Permite armazenar  informações de data e hora incluindo o fuso horário