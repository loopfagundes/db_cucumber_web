#language: pt
#order: 1
@register_page
Funcionalidade: Cadastrar duas contas com saldos.

  Cenário: Faço cadastro um primeiro usuario no BugBank
    Dado Navego para a "BugBank" configurada
    Quando Clico no botão "Registrar"
    E Preencho o campo "email" do usuário "dataUser_1"
    E Preencho o campo "nome" do usuário "dataUser_1"
    E Preencho o campo "senha" do usuário "dataUser_1"
    E Preencho o campo "confirmar_senha" do usuário "dataUser_1"
    E Clico no botão "Conta com saldo" com javascript
    E Clico no botão "Cadastrar" com javascript
    E Armazeno o "Numero da conta", dados "dataUser_1", "conta" e "digito"
    Então Clico no botão "Fechar o modal"

  @register_page
  Cenário: Faço cadastro um segundo usuario no BugBank
    Dado Navego para a "BugBank" configurada
    Quando Clico no botão "Registrar"
    E Preencho o campo "email" do usuário "dataUser_2"
    E Preencho o campo "nome" do usuário "dataUser_2"
    E Preencho o campo "senha" do usuário "dataUser_2"
    E Preencho o campo "confirmar_senha" do usuário "dataUser_2"
    E Clico no botão "Conta com saldo" com javascript
    E Clico no botão "Cadastrar" com javascript
    E Armazeno o "Numero da conta", dados "dataUser_2", "conta" e "digito"
    Então Clico no botão "Fechar o modal"