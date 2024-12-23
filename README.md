# Real-Time Messaging System

Um sistema de troca de mensagens em tempo real com suporte a WebSocket, Kafka e gerenciamento de salas de chat.

## Funcionalidades Principais

1. **Troca de Mensagens em Tempo Real**
   - Envio e recebimento instantâneo de mensagens entre usuários conectados via WebSocket.
   - Suporte a:
     - Mensagens privadas (um-para-um).
     - Mensagens em grupo (um-para-muitos).

2. **Conexão WebSocket**
   - Estabelecimento de conexões WebSocket para comunicação bidirecional em tempo real.

3. **Publicação e Consumo com Kafka**
   - Publicação de mensagens recebidas pelo WebSocket em um tópico Kafka.

4. **Gerenciamento de Salas**
   - Criação e gerenciamento de salas de chat (grupos de usuários).
   - Associação de mensagens a uma sala específica.

5. **Histórico de Mensagens**
   - Armazenamento de mensagens em um banco de dados para recuperação posterior.

---

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para o backend.
- **Spring WebSocket**: Para comunicação bidirecional em tempo real.
- **Apache Kafka**: Para publicação e consumo assíncrono de mensagens.
- **Spring Data MongoDB**: Para integração com o MongoDB.
- **MongoDB**: Banco de dados NoSQL para armazenamento de mensagens.
- **Docker**: Gerenciamento de contêineres para facilitar o desenvolvimento e a implantação.
