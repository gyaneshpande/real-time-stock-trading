# **Real-Time Stock Trading Platform**

Welcome to the backend of **TradeStream**, a real-time stock trading platform designed to handle high-frequency trading with scalability and efficiency. This project leverages modern technologies to provide a robust foundation for real-time financial transactions.

## **Table of Contents**

- [Project Overview](#project-overview)
- [Architecture](#architecture)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Setup Instructions](#setup-instructions)
- [API Endpoints](#api-endpoints)
- [Future Enhancements](#future-enhancements)

## **Project Overview**

TradeStream is a backend application built using Spring Boot that supports real-time stock trading functionalities. It is designed to be scalable and efficient, utilizing Kafka for data streaming and PostgreSQL for persistent storage.

## **Architecture**

The backend architecture is designed for scalability and real-time processing:

```plaintext
+---------------------+       +---------------------+
|    REST API         | <---->|   Spring Boot       |
| (User & Portfolio)  |       |   Application       |
+---------------------+       +---------------------+
        ^                           ^
        |                           |
        v                           v
+---------------------+      +--------------------+
|     Kafka Producer  | ---> |     Kafka Cloud    |
| (Stock Price Fetch) |      |   (Confluent)      |
+---------------------+      +--------------------+
        ^                           
        |                           
        v                           
+---------------------+      
| External Stock API  |
| (finnhub) |
+---------------------+
```

## **Features**

- User Account Management: Create and manage user accounts securely.

- Portfolio Management: Track user portfolios with real-time updates.
- Transaction Processing: Handle buy/sell transactions efficiently.
- Real-Time Stock Prices: Fetch and stream stock prices using Kafka.
- Scalable Architecture: Designed to handle high-frequency trading with low latency.

## **Tech Stack**

- Backend: Java, Spring Boot
- Database: PostgreSQL
- Messaging: Apache Kafka (Confluent Cloud)
- External APIs: Finnhub for stock prices

## **Setup Instructions**

### *Prerequisites*
- Java 17 or higher
- PostgreSQL installed locally or accessible via cloud
- Apache Maven for building the project
- Access to Confluent Cloud for Kafka
## **Installation Steps**

1. Clone the Repository
```bash
git clone https://github.com/yourusername/tradestream-backend.git
cd tradestream-backend
```

2. Configure PostgreSQL
- Create a database named tradestream.
- Update application.properties with your PostgreSQL credentials:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/tradestream
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
```


3. Configure Kafka
Set up your Confluent Cloud account and create a Kafka cluster.
Update application.properties with your Kafka configurations:
```
spring.kafka.bootstrap-servers=your-confluent-cloud-broker-url
spring.kafka.consumer.group-id=tradestream-group
```

4. Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

5. Verify Setup
- Ensure the application starts successfully and connects to both PostgreSQL and Kafka.

API Endpoints
User Management
Create User: POST /api/users
Request Body: { "username": "user", "password": "pass" }
Portfolio Management
Get Portfolio: GET /api/portfolio/{userId}
Returns the user's current stock holdings.
Transactions
Create Transaction: POST /api/transactions
Request Body: { "userId": 1, "stockSymbol": "AAPL", "quantity": 10, "type": "BUY" }


## **Future Enhancements**
- Frontend Development with Phoenix LiveView
- Order Matching Engine Implementation
- Real-Time Notifications via WebSockets
- Integration with Redis for Caching
- Enhanced Security Features