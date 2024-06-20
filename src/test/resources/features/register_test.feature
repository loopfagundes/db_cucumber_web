#language: pt

@register_page
Funcionalidade: BugBank cadastrar duas contas dos usuarios.

  @primerira_conta
  Cenário: Faço cadastro no BugBank
    #Cadastrar primeiro conta do usuario.
    Dado Navego para "https://bugbank.netlify.app/"
    Quando Clico no botão "Registrar"
