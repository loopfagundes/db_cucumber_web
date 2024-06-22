#language: pt

@register_page
Funcionalidade: Cadastrar duas contas com saldos.
                Realizar Transferência entre Conta.

  Cenário: Faço cadastro conta com saldo no BugBank
    Dado Navego para "https://bugbank.netlify.app/"
    Quando Clico no botão "Registrar"
    Então Preencho o meu E-mail no campo de "E-mail"
    E Preencho o meu nome no campo de "Nome"
    E Preencho a minha senha no campo de "Senha"
    E Preencho a minha senha novamente no campo "Confirmação senha"
    E Clico no botao "Conta com saldo"
    E Clico no botão "Cadastrar"
    E Armazeno o Numero da conta
    Então Clico no botão "Fechar o modal"

    #Registrar segundo usuario
    Quando Clico no botão "Registrar"
    Então Preencho o "E-mail" no campo de email
    E Preencho o "Nome" no campo de nome
    E Preencho a "Senha" no campo
    E Preencho a "Confirmação senha" novamente no campo
    E Clico no botao "Conta com saldo"
    E Clico no botão "Cadastrar"
    E Armazeno o numero da conta do usuario
    Então Clico no botão "Fechar o modal"

    #Tela de Login
    Quando Preencho Email no campo de "E-mail de Login"
    E Preencho senha no campo de "Senha de login"
    E Clico no botão "Acessar o meu login"
    E Valido se "Meu nome" esta na tela de login
    E Valido se "Saldo em conta" esta disponivel
    # <--- continua fazer a transferir antes de sair da conta --->
    Então Clico no botão "Sair da conta"