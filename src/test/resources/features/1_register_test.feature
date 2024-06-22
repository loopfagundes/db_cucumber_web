#language: pt

@register_page
Funcionalidade: Cadastro

  Cenário: Faço cadastro conta com saldo no BugBank
    Dado Navego para "https://bugbank.netlify.app/"
    Quando Clico no botão "Registrar"
    Então Preencho E-mail do usuario no campo de "E-mail"
    E Preencho o meu nome no campo de "Nome"
    E Preencho a senha do usuario no campo de "Senha"
    E Preencho a senha novamente do usuario no campo "Confirmação senha"
    E Clico no botao "Conta com saldo"
    E Clico no botão "Cadastrar"
    E Armazeno o numero da conta do usuario
    Então Clico no botão "Fechar"
    Quando Preencho Email no campo de "E-mail de Login"
    E Preencho senha no campo de "Senha de login"
    E Clico no botão "Acessar o meu login"
    E Valido se "Meu nome" esta na tela de login
    E Valido se "Saldo em conta" esta disponivel
    Então Clico no botão "Sair da conta"