 #language: pt
 #order: 3
 @receive_cash_page
 Funcionalidade: Efetura login e a Receber o saldo de transferencia

   Cenário: Acesso no login e validar o extrato bancário se a receber saldo.
     Dado Navego para a "BugBank" configurada
     Quando Preencho o campo "email" do usuário "dataUser_2"
     E Preencho o campo "senha" do usuário "dataUser_2"
     E Clico no botão "Acessar login"
     E Armazeno o nome do "dataUser_2" e valido se "nome_do_usuario_na_tela_de_login"
     E Armazeno o valor do "dataUser_2" e valido se "saldo_em_conta"
     E Clico no botão "Extrato"
     E Armazeno o valor do "dataUser_2" e valido se "recebe_transferencia_de_saldo"
     E Clico no botão "Sair"
     Então Encerro a sessão