# Message Exchange System

Este repositório contém um sistema distribuído de troca de mensagens desenvolvido com **Java**, **Spring Boot**, **MongoDB**, **Kafka**, **Consul**, **Docker**, **Kong** e **OpenFeign**. O sistema utiliza uma arquitetura baseada em microsserviços para processamento e entrega de mensagens, com foco em escalabilidade e eficiência.

---

## **Funcionalidades Principais**

- **Troca de Mensagens:** Processamento e entrega de mensagens entre diferentes serviços.
- **Persistência de Dados:** Armazenamento das mensagens e seus metadados em um banco de dados MongoDB.
- **Comunicação Assíncrona:** Integração com Apache Kafka para troca de mensagens entre microsserviços.
- **Service Discovery:** Uso do Consul para registro e descoberta de serviços.
- **API Gateway:** Kong como gateway para gerenciar chamadas de API.
- **Chamadas HTTP:** OpenFeign para comunicação eficiente entre microsserviços.
- **Docker:** Contêinerização dos serviços para simplificar a implantação.

---

## **Tecnologias Utilizadas**

### **Backend**
- **Java 17**
- **Spring Boot 3.x**
  - Spring Web
  - Spring Data MongoDB
  - Spring Cloud (Consul, OpenFeign)
  - Spring Kafka

### **Infraestrutura**
- **MongoDB:** Banco de dados NoSQL para persistência.
- **Apache Kafka:** Plataforma de streaming para troca de mensagens.
- **Consul:** Registro e descoberta de serviços.
- **Kong:** API Gateway para gerenciamento de endpoints.
- **Docker:** Contêineres para todos os serviços.
