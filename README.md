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

<h4> 1. Inicia a criação do banco de dados: <h4>

````
create database banco_de_dados;
````

<h4> 2. Estabelece um novo usuário: <h4>

````
create user 'springuser'@'%' identified by 'ThePassword';
````
<h4> 3. Concede todos os privilégios ao usuário no recém-criado banco de dados: <h4>

````
grant all on db_example.* to 'springuser'@'%'; 
````