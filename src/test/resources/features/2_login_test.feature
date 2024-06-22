#language: pt

@login_page
Funcionalidade: Login

  Cenário: Acesso o meu login
    Dado Navego para "https://bugbank.netlify.app/"
    Quando Preencho Email no campo de "E-mail de Login"
    E Preencho senha no campo de "Senha de login"
    E Clico no botão "Acessar o meu login"