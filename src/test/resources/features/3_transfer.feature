#language: pt
#order: 3
@transfer_page
Funcionalidade: Realizada a transferencia de saldo para outro usuario.

  Cenário: Fazer a transferencia de saldo.
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