#language: pt

@register_page
Funcionalidade: Realizar Transferência entre Contas
  1. Acessar o site https://bugbank.netlify.app/
  2. Criar duas contas com Saldo e salvar os seus dados.
  3. Acessar uma conta e realizar uma transferência de valor para outra.
  4. Validar a saída e entrada de valores das contas envolvidas

  Cenário: Faço cadastro dois usuarios no BugBank
    Dado Navego para "https://bugbank.netlify.app/"
    Quando Clico no botão "Registrar"
    Então Preencho E-mail do usuario no campo de "E-mail"
    E Preencho o nome do usuario no campo de "Nome"
    E Preencho a senha do usuario no campo de "Senha"
    E Preencho a senha novamente do usuario no campo "Confirmação senha"
    E Clico no elemento "Conta com saldo"
    E Clico no botão "Cadastrar"
    E Armazeno o numero da conta do usuario
    Então Clico no botão "Fechar"

    Dado Navego para "https://bugbank.netlify.app/"
    Quando Clico no botão "Registrar"
    Então Preencho E-mail do segundo usuario no campo de "E-mail"