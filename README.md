# Instruções para utilização
- Versão mínima do MySQL 5.6 é necessária.
- Aproximadamente 15 minutos são requeridos.
- Utilize um editor de texto ou IDE de sua preferência.
- Java na versão 17 ou posterior é obrigatório.
- Certifique-se de ter Gradle 7.5+ ou Maven 3.5+ instalados.

#### A importação do código para a IDE pode ser feita nos seguintes ambientes:

- Ferramenta Spring Tool Suite (STS)
- IntelliJ IDEA
- VSCode
#### Procedimento para Configuração do Banco de Dados
Execute as instruções SQL abaixo para realizar a configuração do banco de dados:

````
create database db_example; -- Inicia a criação do banco de dados
````
````
create user 'springuser'@'%' identified by 'ThePassword'; -- Estabelece um novo usuário
````
````
grant all on db_example.* to 'springuser'@'%'; -- Concede todos os privilégios ao usuário no recém-criado banco de dados
````