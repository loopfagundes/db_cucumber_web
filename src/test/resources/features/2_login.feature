#language: pt
#order: 2
@login_page
Funcionalidade: Efetura Login e realizada a transferencia de saldo para outro usuario.

  Cenário: Acessar no login do usuario e fazer a transferencia de saldo.
    Dado Navego para a "BugBank" configurada
    Quando Preencho o campo "email" do usuário "dataUser_1"
    E Preencho o campo "senha" do usuário "dataUser_1"
    E Clico no botão "Acessar login"
    E Armazeno o nome do "dataUser_1" e valido se "nome_do_usuario_na_tela_de_login"
    E Armazeno o valor do "dataUser_1" e valido se "saldo_em_conta"
    E Clico no botão "Transferencia"
    E Preencho o campo "conta" do usuário "dataUser_2"
    E Preencho o campo "digito" do usuário "dataUser_2"
    E Informo do "dataUser_1" e preencho o "valor" no campo "de transferencia"
    E Preencho o campo "descricao" do usuário "dataUser_1"
    E Clico no botão "Transferir agora"
    E Valido se a "Transferencia realizada com sucesso"
    E Clico no botão "Fechar o modal"
    E Clico no botão "Voltar o meu login"
    E Armazeno o valor do "dataUser_1" e valido se "resto_saldo_em_conta"
    Então Clico no botão "Sair da conta"