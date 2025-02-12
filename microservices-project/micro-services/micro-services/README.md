# 🛒 Online Shopping Microservices

## 📌 Introdução
Este projeto é uma aplicação de compras online baseada em **arquitetura de microserviços**, implementando conceitos modernos como **descoberta de serviço**, **configuração centralizada**, **rastreamento distribuído**, **mensageria** e **segurança com Keycloak**.

## 🏗️ Arquitetura
O sistema é composto pelos seguintes microserviços:

### 1️⃣ **Product Service (Catálogo de Produtos)**
- Gerencia a criação e listagem de produtos.
- Atua como um catálogo de produtos para os clientes.

### 2️⃣ **Order Service (Serviço de Pedidos)**
- Gerencia pedidos dos clientes.
- Interage com o **Inventory Service** para verificar a disponibilidade de produtos.
- Aciona o **Notification Service** após um pedido ser confirmado.

### 3️⃣ **Inventory Service (Serviço de Estoque)**
- Controla a disponibilidade de produtos no estoque.
- Atualiza o estoque quando um pedido é realizado.
- Interage com o **Order Service** para validar pedidos.

### 4️⃣ **Notification Service (Serviço de Notificação)**
- Envia notificações (e-mail, SMS, push) após um pedido ser confirmado.
- Processa eventos assincronamente via mensageria.

## 🔗 Comunicação entre os microserviços
### 🔹 **Síncrona (REST API)**
- O **Order Service** chama o **Inventory Service** para verificar a disponibilidade de um produto antes de confirmar o pedido.

### 🔹 **Assíncrona (Mensageria - Kafka/RabbitMQ)**
- O **Order Service** publica um evento de "pedido criado".
- O **Inventory Service** escuta esse evento e atualiza o estoque.
- O **Notification Service** escuta o evento e dispara uma notificação ao usuário.

## 🛠️ Tecnologias Utilizadas
- **Spring Boot** - Para desenvolvimento dos microserviços.
- **Spring Cloud** - Para configuração centralizada, descoberta de serviço e resiliência.
- **Eureka** - Para Service Discovery.
- **Kafka / RabbitMQ** - Para comunicação assíncrona.
- **Zipkin / Jaeger** - Para rastreamento distribuído.
- **Elasticsearch + Kibana + Logstash (ELK)** - Para logging centralizado.
- **Keycloak** - Para autenticação e segurança.
- **PostgreSQL / MySQL** - Banco de dados para persistência.
- **Docker & Kubernetes** - Para conteinerização e orquestração.

## 🚀 Fluxo do Pedido
1. O cliente faz um pedido no **Order Service**.
2. O **Order Service** consulta o **Inventory Service** para verificar se o produto está em estoque (REST API).
3. Se o produto estiver disponível, o pedido é criado e o estoque é atualizado.
4. O **Order Service** publica um evento no Kafka/RabbitMQ.
5. O **Notification Service** recebe o evento e envia uma notificação ao usuário.

## 📂 Estrutura do Projeto
```plaintext
/online-shopping-microservices
│── product-service
│── order-service
│── inventory-service
│── notification-service
│── api-gateway
│── discovery-server
│── config-server
│── logs-monitoring
│── docker-compose.yml
```

## 📌 Como Executar
### 📍 Requisitos
- Docker e Docker Compose
- Java 17+
- Maven

### 📍 Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/online-shopping-microservices.git
   cd online-shopping-microservices
   ```
2. Inicie os containers:
   ```bash
   docker-compose up -d
   ```
3. Acesse os serviços:
   - API Gateway: `http://localhost:8080`
   - Eureka Dashboard: `http://localhost:8761`
   - Keycloak: `http://localhost:8180`

## 📌 Contribuição
Sinta-se à vontade para abrir issues e enviar PRs! 😃

## 📄 Licença
MIT License.
