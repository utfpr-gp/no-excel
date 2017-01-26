# no-excel

É um sistema para gerenciamento e controle do saldo pré-carregado por um cliente para consumo de refeições no restaurante universitário da UTFPR-Guarapuava.

O sistema foi inicialmente desenvolvido por duas turmas consecutivas do ano de 2015 da disciplina de PI3 do curso de Tecnologia em Sistemas para Internet da UTFPR de Guarapuava. 

## Funcionalidades Principais
+ Autenticação e autorização de acesso a vários papéis (Administrador, Gerente e Cliente)
+ Operação de inserção de crédito à conta do cliente
+ Operação de débito do saldo como forma de cobrança das refeições
+ Histórico de despesas do cliente
+ Busca do cliente por RA
+ Controle de descontos na refeição de acordo com o perfil do cliente

## Tecnologias
- JSP e Servlets
- JPA (Hibernate)

## Ferramentas
- Eclipse IDE
- Tomcat
- MySQL

## Manual de Execução
+ Clonar o repositório com  `git clone`
+ Criar um novo banco de dados no MySQL com o nome `no_excel`
+ Editar o arquivo `src/META-INF/persistence.xml` com as configurações de acesso ao banco de dados `no_excel`
 - Alterar a propriedade `javax.persistence.jdbc.user` para o usuário correspondente ao MySQL
 - Alterar a propriedade `javax.persistence.jdbc.password` para a senha correspondente ao MySQL
+ Executar o projeto via Eclipse.

## Versão Corrente
0.0.1 - Release de 05/12/2015

 

