#language: pt
#order: 2
@login_page
Funcionalidade: Login

  Cenário: Efetura login e Realizar a transferencia
    Dado Navego para "https://bugbank.netlify.app/"
    Quando Preencho o campo "email" do usuário "dataUser_1"
    E Preencho o campo "senha" do usuário "dataUser_1"
    E Clico no botão "Acessar login"
    E Valido se "Nome do usuario" esta na tela de login
    E Valido se "Saldo em conta" esta disponivel
    E Clico no botão "Transferencia"
    E Preencho o campo "conta" do usuário "dataUser_2"
    E Preencho o campo "digito" do usuário "dataUser_2"
    E Informo do "dataUser_1" e preencho o "valor" para fazer "a transferencia"
    E Preencho o campo "descricao" do usuário "dataUser_1"
    E Clico no botão "Transferir agora"
    E Valido se a "Transferencia realizada com sucesso"
#    Então Clico no botão "Sair da conta"
    Então Encerro a sessão