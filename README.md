# Microservices-guided-learning
# Microservices Architecture: User Service and Order Service
## Project Overview
This project is developed using **Microservices Architecture** with two independent services:
1. **User Service**
2. **Order Service**
Each service is responsible for a specific business capability and can be developed, deployed, and scaled independently
# Architecture
                    Client
                      │
                      ▼
              ┌───────────────┐
              │  User Service │
              └───────────────┘
                      │
                      │ User Information
                      │
                      ▼
              ┌────────────────┐
              │  Order Service │
              └────────────────┘
The application is divided into two services with clear responsibilities and boundaries.
# User Service
## Responsibility
The **User Service** is responsible for managing user-related operations.
Its responsibilities may include:
* User Registration
* User Login
* User Management
* User Profile Management
* User Authentication
* User Validation
The User Service owns user-related business logic and data.
User Service
     │
     ├── Controller
     ├── Service
     ├── Repository
     ├── Entity
     ├── DTO
     └── Database
#Order Service
## Responsibility
The **Order Service** is responsible for managing order-related operations.
Its responsibilities may include:
* Creating Orders
* Retrieving Orders
* Updating Order Status
* Cancelling Orders
* Order History
* Order Management
The Order Service owns order-related business logic and data.
Order Service
     │
     ├── Controller
     ├── Service
     ├── Repository
     ├── Entity
     ├── DTO
     └── Database

# Communication Between Services

The **Order Service** may need user information when processing an order.

Instead of directly accessing the User Service database, services communicate through APIs.
Client
   │
   ▼
Order Service
   │
   │ HTTP Request
   ▼
User Service
Example:
Order Service
      │
      │ GET User Details
      ▼
User Service
      │
      ▼
User Database
This keeps the services independent.
#  Service Boundaries
A service boundary defines what responsibility belongs to each microservice.
## User Service Boundary
The User Service is responsible only for user-related functionality.
User Service
✓ User Registration
✓ User Login
✓ User Details
✓ User Authentication
✓ User Management
The User Service should not contain order-related business logic.
## Order Service Boundary
The Order Service is responsible only for order-related functionality.
Order Service
✓ Create Order
✓ Retrieve Order
✓ Update Order
✓ Cancel Order
✓ Manage Order Status
The Order Service should not manage user authentication or user profile logic.
# Database Boundaries
In a microservices architecture, each service should ideally manage its own database.
User Service
     │
     ▼
User Database


Order Service
     │
     ▼
Order Database
The Order Service should not directly access the User Service database.

❌ Incorrect:
Order Service
      │
      ▼
User Database
✅ Correct:
Order Service
      │
      │ API Request
      ▼
User Service
      │
      ▼
User Database
This principle is called **Database Per Service**.
#  Monolithic Architecture

In a **Monolithic Architecture**, all modules are developed and deployed as a single application.
For example
Application

├── User Module
├── Order Module
├── Controller
├── Service
└── Database
All components run together as one application.
# Microservices Architecture

In this project, the application is divided into separate services.
Microservices System

├── User Service
│      └── User Database
│
└── Order Service
       └── Order Database
Each service is independent and focuses on a specific business responsibility.

# Monolithic vs Microservices

| Feature         | Monolithic Architecture  | Microservices Architecture                 |
| --------------- | ------------------------ | ------------------------------------------ |
| Application     | Single application       | Multiple independent services              |
| Deployment      | Single deployment        | Each service can be deployed independently |
| Codebase        | Usually one project      | Multiple projects                          |
| Scaling         | Scale entire application | Scale individual services                  |
| Database        | Usually shared           | Separate database per service              |
| Communication   | Internal method calls    | REST APIs or messaging                     |
| Complexity      | Lower                    | Higher                                     |
| Fault Isolation | Limited                  | Better isolation                           |

# Benefits of Microservices

## 1. Independent Development

The User Service and Order Service can be developed separately.
Developer A → User Service

Developer B → Order Service
## 2. Independent Deployment

Each service can be deployed separately.
Update User Service
       │
       ▼
Deploy User Service Only

The Order Service does not need to be redeployed.
## 3. Independent Scaling

If the Order Service receives more traffic, only that service can be scaled.
High Order Traffic
       │
       ▼
Scale Order Service
## 4. Clear Business Responsibilities

Each service has a specific responsibility.
User Service  → User Management

Order Service → Order Management
This makes the system easier to organize as the application grows.
#  Microservices Trade-Offs

Microservices also introduce additional complexity.

## 1. Network Communication

Services communicate through the network.
Order Service
      │
      │ HTTP Request
      ▼
User Service
Network problems can cause:

* Timeouts
* Connection failures
* Service unavailability
## 2. Distributed System Complexity
Unlike a monolithic application, multiple applications must be managed.

For example:
User Service
     │
     ├── Configuration
     ├── Deployment
     └── Database


Order Service
     │
     ├── Configuration
     ├── Deployment
     └── Database

## 3. Data Consistency
Each service manages its own data.
Therefore, maintaining consistency between services can be more challenging than using a single shared database.
## 4. Debugging Complexity
A request may travel between multiple services.
Client
   │
   ▼
Order Service
   │
   ▼
User Service
Debugging requires tracking requests across services.
# Why Microservices Were Used
The application was divided into **User Service** and **Order Service** to demonstrate:
* Separation of responsibilities
* Independent services
* Clear service boundaries
* Service-to-service communication
* Independent deployment
* Independent scalability
# Conclusion
This project demonstrates a simple Microservices Architecture consisting of two independent services:
User Service
      +
Order Service
The **User Service** is responsible for user-related functionality, while the **Order Service** is responsible for order-related functionality.

This separation creates clear business boundaries and allows each service to evolve independently.

Although microservices provide benefits such as independent deployment and scalability, they also introduce challenges such as network communication, distributed system complexity, and data consistency.

> **The goal of this project is to demonstrate how a monolithic application can be separated into independent microservices with clearly defined responsibilities and boundaries.**
