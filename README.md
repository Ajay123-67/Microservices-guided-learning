# Microservices Guided Learning

## Overview

This project demonstrates the development of a basic **Microservices Architecture** using Spring Boot.

The project currently contains three services:

* **User Service** – Manages user information.
* **Order Service** – Manages order information and communicates with User Service.
* **API Gateway** – Provides a single entry point for clients and routes requests to the appropriate microservice.

## Architecture

```text
                    Client
                      |
                      v
               +--------------+
               |  API Gateway |
               |    :8080     |
               +--------------+
                 /          \
                /            \
               v              v
      +---------------+   +---------------+
      |  User Service |   | Order Service |
      |     :8081     |   |     :8082     |
      +---------------+   +---------------+
                               |
                               | REST API
                               v
                       +---------------+
                       |  User Service |
                       +---------------+
```

## Services

### 1. User Service

**Port:** `8081`

Responsible for managing user details.

Example endpoint:

```text
GET /users/{id}
```

Example:

```text
GET http://localhost:8081/users/1
```

Response:

```json
{
  "id": 1,
  "name": "Ajay",
  "email": "ajay@gmail.com"
}
```

### 2. Order Service

**Port:** `8082`

Responsible for managing orders.

Example endpoint:

```text
GET /order/{id}
```

Example:

```text
GET http://localhost:8082/order/101
```

The Order Service communicates with the User Service to retrieve user information.

### 3. API Gateway

**Port:** `8080`

The API Gateway acts as the single entry point for clients.

Gateway routes:

| Request     | Destination          |
| ----------- | -------------------- |
| `/users/**` | User Service `8081`  |
| `/order/**` | Order Service `8082` |

Example:

```text
GET http://localhost:8080/users/1
```

is routed to:

```text
http://localhost:8081/users/1
```

And:

```text
GET http://localhost:8080/order/101
```

is routed to:

```text
http://localhost:8082/order/101
```

## Technologies Used

* Java 17+
* Spring Boot
* Spring Cloud Gateway
* Spring Web / REST API
* Maven
* Git & GitHub

## Project Structure

```text
microservices-guided-learning/
│
├── Api-gateway/
│   ├── src/
│   ├── pom.xml
│   └── application.yml
│
├── user-service/
│   ├── src/
│   └── pom.xml
│
├── order-service/
│   ├── src/
│   └── pom.xml
│
└── README.md
```

## Running the Project

Start the services in the following order:

### User Service

```text
Port: 8081
```

### Order Service

```text
Port: 8082
```

### API Gateway

```text
Port: 8080
```

All three services should be running before testing the Gateway.

## Testing

### Direct User Service

```powershell
curl.exe http://localhost:8081/users/1
```

### Direct Order Service

```powershell
curl.exe http://localhost:8082/order/101
```

### User Service Through Gateway

```powershell
curl.exe http://localhost:8080/users/1
```

### Order Service Through Gateway

```powershell
curl.exe http://localhost:8080/order/101
```

## Key Microservices Concepts

### Service-to-Service Communication

The Order Service communicates with the User Service through a REST API instead of directly accessing the User Service's data.

### API Gateway

The Gateway provides a single entry point for clients and forwards requests to the appropriate service.

### Service Boundaries

Each microservice has its own responsibility:

* User Service → User management
* Order Service → Order management
* API Gateway → Request routing

### Database Ownership

Each service should own and manage its own data. Other services should access that data through APIs rather than directly accessing another service's database.

## Current Progress

* [x] User Service
* [x] Order Service
* [x] User Service API testing
* [x] Order Service API testing
* [x] Service-to-service communication
* [x] API Gateway setup
* [x] Gateway routing configuration
* [x] Gateway request testing

## Future Improvements

The project can be extended with:

* Service Discovery
* Centralized Configuration
* Payment Service
* Authentication and Authorization
* Resilience and fault tolerance
* Distributed tracing
* Centralized logging
* Containerization using Docker

## Author

**Ajay**

## Repository

This project is maintained as part of the Microservices Guided Learning project.
