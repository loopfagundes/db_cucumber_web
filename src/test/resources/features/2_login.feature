 #language: pt
 #order: 2
 @login_page
 Funcionalidade: Efetura Login primeiro usuario.

   Cenário: Acessar no login do usuario e fazer a transferencia de saldo.
     Dado Navego para a "BugBank" configurada
     Quando Preencho o campo "email" do usuário "dataUser_1"
     E Preencho o campo "senha" do usuário "dataUser_1"
     E Clico no botão "Acessar login"
     E Armazeno o nome do "dataUser_1" e valido se "nome_do_usuario_na_tela_de_login"
     Então Armazeno o valor do "dataUser_1" e valido se "saldo_em_conta"