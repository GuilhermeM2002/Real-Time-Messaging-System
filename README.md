# Real-Time Messaging System

A real-time messaging system with support for WebSocket, Kafka, and chat room management.

## Main Features

1. **Real-Time Messaging**
   - Instant sending and receiving of messages between users connected via WebSocket.
   - Supports:
     - Private messages (one-to-one).
     - Group messages (one-to-many).

2. **WebSocket Connection**
   - Establishment of WebSocket connections for real-time bidirectional communication.

3. **Kafka Publishing and Consumption**
   - Publishing messages received via WebSocket to a Kafka topic.

4. **Room Management**
   - Creation and management of chat rooms (user groups).
   - Association of messages with a specific room.

5. **Message History**
   - Storage of messages in a database for later retrieval.

---

## Technologies Used

- **Spring Boot**: Main backend framework.
- **Spring WebSocket**: For real-time bidirectional communication.
- **Apache Kafka**: For asynchronous message publishing and consumption.
- **Spring Data MongoDB**: For MongoDB integration.
- **MongoDB**: NoSQL database for message storage.
- **Docker**: Container management to facilitate development and deployment.
