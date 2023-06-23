#  gooPet

## Introdução
O sistema gooPet tem como finalidade auxiliar no processo de gestão em uma empresa de PetShop, com os dados de compras e agendamentos a serem realizados.

## Instalação
- Ter o SQL Server Management Studio versão 19+;
- Criar um banco de dados de nome `gooPet` e os schemas `auth` e `com`, as demais necessidades de banco são gerenciadas pelo Hibernate;
- Efetuar o download ZIP do projeto, verificar se a versão do java é compatível com a máquina, caso negativo modificar no arquivo pom.xml;
- Adicionar a dependência AbsoluteLayout-RELEASE65.jar.

## Como utilizar
- O programa inicializa na janela de login, caso o usuário seja Administrador é direcionado para a janela de gestão de produtos, se não é direcionado para a janela shopping.
- A criação dos primeiros usuários pode ser feita rodando o teste `createDadosBasicos`, este é responsável pela criação de usuários e grupos de usuários `Administrador` e `Client`.
- A janela de Gestão de Produtos possibilidade gerenciar todos os produtos da aplicação, adicionar, editar e remover;
- A janela Usuários possibilida gerenciar os usuários e grupos cadastrados na aplicaçaõ, adicionar, editar e remover;
- A janela Shopping viabiliza que o cliente adicione produtos ao seu carrinho;
- A janela Carrinho garante que o usuário possa gerenciar seu carrinho e fechar a compra, gerando um novo carrinho.

## Funcionalidades
- Cadastros:
  - Gerenciar Produto;
  - Gerenciar Grupo de Usuário;
  - Gerenciar Usuários.
- Compras;
  - Gerenciar Carrinho:
  - Realizar pedido.

## Em Desenvolvimento
- Visualizar outros carinhos:
  - Possibilitar visualizar carrinhos já concluídos de compras passadas na tela `Carrinho`.
- Agendamento;
  - Possibilitar agendar horários de atendimento na tela `Agenda`.

## Referências:

#### Framework Hibernate:
1. [https://hibernate.org](https://hibernate.org)
#### JDBC para SQLServer:
2. [https://learn.microsoft.com/pt-br/sql/connect/jdbc/deploying-the-jdbc-driver?view=sql-server-ver16](https://learn.microsoft.com/pt-br/sql/connect/jdbc/deploying-the-jdbc-driver?view=sql-server-ver16)
#### SQL Server Management Studio:
3. [https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver16](https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver16)
