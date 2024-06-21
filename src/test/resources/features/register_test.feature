#language: pt

@register_page
Funcionalidade: Cadastro

  @register_page
  Cenário: Faço cadastro conta com saldo no BugBank
    Dado Navego para "https://bugbank.netlify.app/"
    Quando Clico no botão "Registrar"
    Então Preencho E-mail do usuario no campo de "E-mail"
    E Preencho o nome do usuario no campo de "Nome"
    E Preencho a senha do usuario no campo de "Senha"
    E Preencho a senha novamente do usuario no campo "Confirmação senha"
    E Clico a botao "Conta com saldo"
    E Clico no botão "Cadastrar"
    E Armazeno o numero da conta do usuario
    Então Clico no botão "Fechar"

#  @register_page
#  Cenário: Faço cadastro conta com saldo no BugBank
#    Dado Navego para "https://bugbank.netlify.app/"
#    Quando Clico no botão "Registrar"
#    Então Preencho E-mail do segundo usuario no campo de "E-mail"