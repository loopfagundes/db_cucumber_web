#language: pt
#order: 3
  @login_page
  Funcionalidade: Efetura login e Receber o saldo de transferencia

    Cenário: Acesso no login e validar extrato se receber o saldo.
      Dado Navego para a "BugBank" configurada
      Quando Preencho o campo "email" do usuário "dataUser_2"
      E Preencho o campo "senha" do usuário "dataUser_2"
      E Clico no botão "Acessar login"
      E Armazeno as informações do "dataUser_2" e valido se "nome_do_usuario_na_tela_de_login"
      E Armazeno as informações do "dataUser_2" e valido se "saldo_em_conta"
      Então Encerro a sessão