# Projeto de Prática: Padrão de Design Adapter

Este é um projeto simples criado com **Spring Boot** para demonstrar como funciona o padrão de design **Adapter**. A ideia principal é integrar um sistema bancário fictício com dados mockados, sem a necessidade de um banco de dados, e mostrar como o adaptador pode enriquecer os dados de uma API padrão.

## Objetivos

- **Praticar o padrão de design Adapter**: Demonstrar como usar este padrão para adaptar dados entre sistemas.
- **Enriquecer dados**: A API base fornece informações simples sobre contas bancárias, enquanto o adaptador adiciona mais informações para criar um modelo mais rico.
- **Mock de dados**: Utilizar dados simulados em vez de um banco de dados, tornando o projeto leve e de fácil compreensão.

## Arquitetura do Projeto

O projeto está organizado em camadas para manter uma estrutura limpa e modular:

### Estrutura de Pastas

```
src/
 └── main/
      ├── java/
      │    └── com/
      │        └── sirkaue/
      │            └── bankingapiadapter/
      │            ├── controller/
      │            │    └── AccountController.java  # Controlador da API
      │            ├── model/
      │            │    ├── AccountDto.java        # Modelo simples da conta (mock)
      │            │    └── ExternalAccountDetailsDto.java  # DTO com dados externos
      │            ├── service/
      │            │    ├── AccountService.java     # Interface do serviço de conta
      │            │    └── AccountServiceImpl.java # Implementação do serviço de conta
      │            ├── adapter/
      │            │    ├── ExternalBankingAdapter.java  # Interface do Adapter
      │            │    └── ExternalBankingAdapterImpl.java # Implementação do Adapter
      │            └── BankApiAdapterApplication.java  # Classe principal
      └── resources/
           └── application.properties   # Configurações do Spring Boot
```

### Componentes Principais

1. **Controller**:

    - `AccountController`: Exponibiliza as APIs REST para obter informações das contas bancárias.

2. **Model**:

    - `AccountDto`: Representa o modelo padrão da conta bancária com informações básicas como número da conta, titular e saldo.
    - `ExternalAccountDetailsDto`: Um modelo enriquecido com informações adicionais como tipo de conta, última transação, limite de cheque especial, entre outros.

3. **Service**:

    - `AccountService`: Interface que define as operações relacionadas à conta bancária.
    - `AccountServiceImpl`: Implementação da interface com dados mockados.

4. **Adapter**:

    - `ExternalBankingAdapter`: Interface que define o contrato para buscar dados externos.
    - `ExternalBankingAdapterImpl`: Implementação que adapta os dados do modelo padrão para o modelo enriquecido.

5. **Aplicativo Principal**:

    - `BankApiAdapterApplication`: Classe principal que inicializa o aplicativo Spring Boot.

## Endpoints Disponíveis

### 1. Obter todas as contas (Padrão)

- **Endpoint**: `GET /api/accounts`
- **Resposta**:
  ```json
  [
    {
      "accountNumber": "123",
      "accountHolder": "John Doe",
      "balance": 1000.0
    },
    {
      "accountNumber": "456",
      "accountHolder": "Jane Smith",
      "balance": 2500.0
    }
  ]
  ```

### 2. Obter uma conta por número (Padrão)

- **Endpoint**: `GET /api/accounts/{accountNumber}`
- **Resposta**:
  ```json
  {
    "accountNumber": "123",
    "accountHolder": "John Doe",
    "balance": 1000.0
  }
  ```

### 3. Obter detalhes da conta com dados externos (Enriquecidos)

- **Endpoint**: `GET /api/accounts/{accountNumber}/external`
- **Resposta**:
  ```json
  {
    "accountHolder": "John Doe",
    "balance": 1000.0,
    "isActivated": true,
    "accountType": "savings",
    "lastTransactionDate": "2024-01-01",
    "accountStatus": "active",
    "branchCode": "001",
    "currency": "BRL",
    "overdraftLimit": 1000.0,
    "creationDate": "2022-01-01",
    "isBlocked": false
  }
  ```

## Como Executar o Projeto

1. **Pré-requisitos**:

    - Java 17+
    - Maven

2. **Clonar o repositório**:

   ```bash
   git clone https://github.com/sirkaue/banking-api-adapter.git
   ```

3. **Compilar e executar o projeto**:

   ```bash
   mvn spring-boot:run
   ```

4. **Acessar os endpoints**:

    - Abra um cliente REST (como Postman ou Insomnia) ou use o navegador.
    - Utilize os endpoints descritos acima.

## Conclusão

Este projeto é um exemplo prático de como aplicar o padrão **Adapter** em uma aplicação com Spring Boot. Ele demonstra como enriquecer os dados de uma API básica com informações adicionais provenientes de uma fonte externa, simulada neste caso por dados mockados.

Sinta-se à vontade para expandir este projeto, adicionando novas funcionalidades, integrações reais ou persistência com banco de dados!

