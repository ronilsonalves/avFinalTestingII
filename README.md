# Projeto Final TestingII

Este projeto consiste na entrega de uma suíte de testes automatizados utilizando o Selenium e a validação dos endpoints
da API usando o RestAssured.

## Integrantes
- [Henrique Tebet ](https://github.com/henriquetebet)
- [Ronilson Alves](https://github.com/ronilsonalves)

## Objetivo
Criar um projeto completo de Testes Automatizados utilizando Java e Selenium, com Suítes, Tags, e Reports,
validando também uma API RestAssured. _E pra finalizar faremos uma integração com Jenkins (opcional)._

### Especificações
#### Site a ser testado:
- [ParaBank](https://www.saucedemo.com/)
#### Pré-condições:
- Abrir o site
#### Título do Caso de Teste:
- Criar um projeto completo de Testes Automatizados utilizando Java e Selenium, com Suítes, Tags, e Reports,
validando também uma API RestAssured. E pra finalizar faremos uma integração com Jenkins (opcional)

#### Testes Front-end:
- [x] Realizar o registro no site.
- [x] Realizar a abertura de uma nova conta.
- [x] Acessar a visão geral das contas
- [x] Realizar a transferência de valores entre contas.
- [x] Visualizar as atividades da conta (todos os meses)

#### Testes API Rest do Back-end:
- [x] Validação de status code 200 para todas as etapas de Testes Front-end.
  - [x] Registro URL: https://parabank.parasoft.com/parabank/register.htm
  - [x] Abertura de nova conta URL: https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=12545&newAccountType=1&fromAccountId=xxxxx
  - [x] Visão geral das contas URL: https://parabank.parasoft.com/parabank/overview.htm
  - [x] Transferir Fundos URL: https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccountId=13566&toAccountId=13677&amount=xxxxx
  - [x] Atividades da conta (todos od meses) URL: https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13566/transactions/month/All/type/All

#### _Opcional_: Integração com Jenkins
  - [ ] Adicione o seu código a um repositório Github para integrá-lo ao Jenkins e criar o Job Pipeline
  - [x] Criar repositório no Github
  - [ ] Criar Job Pipeline no Jenkins