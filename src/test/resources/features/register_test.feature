#language: pt

@register_page
Funcionalidade: BugBank cadastrar duas contas dos usuarios.

  @primerira_conta
  Cenário: Faço cadastro no BugBank
    #Cadastrar primeiro conta do usuario.
    Dado Navego para "https://bugbank.netlify.app/"
    Quando Clico no botão "Registrar"
    Então Preencho E-mail do usuario no campo de "E-mail"
    E Preencho o nome do usuario no campo de "Nome"
    E Preencho a senha do usuario no campo de "Senha"
    E Preencho a senha do usuario no campo de "Confirmação senha"
    E Clico no elemento "Conta com saldo"
    E Clico no botão "Cadastrar"
    E Armazeno o numero da conta do usuario
    Então Clico no botão "Fechar"
