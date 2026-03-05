# API Gateway Microservices Project

## Overview

This project demonstrates a **microservices architecture using Spring Boot and Spring Cloud Gateway**.
The **API Gateway** acts as a single entry point for all client requests and routes them to appropriate backend microservices.

The system also implements **JWT-based authentication** and **Redis-based rate limiting** to secure APIs and prevent abuse.

---

## Architecture

Client → API Gateway → Microservices

Services included in the architecture:

* **API Gateway** – Handles routing, authentication, filtering, and rate limiting
* **User Service** – Manages user-related APIs
* **Order Service** – Manages order-related APIs

---

## Tech Stack

* **Java 17**
* **Spring Boot**
* **Spring Cloud Gateway**
* **Spring Security**
* **JWT Authentication**
* **Redis (Rate Limiting)**
* **REST APIs**
* **Maven**

---

## Features

* Centralized **API Gateway**
* **JWT-based authentication**
* **Redis-based rate limiting**
* **Custom request filters**
* **Centralized exception handling**
* **Microservices communication through Gateway**
* Secure backend services

---

## Project Structure

```
api-gateway-microservices
│
├── api-gateway
│   ├── config
│   ├── controller
│   ├── filter
│   ├── service
│   ├── util
│   └── ApiGatewayApplication.java
│
├── user-service
│
├── order-service
│
└── pom.xml
```

---

## API Flow

1. Client sends request to **API Gateway**
2. Gateway validates **JWT token**
3. Gateway applies **rate limiting using Redis**
4. Request is forwarded to appropriate microservice

Example:

```
Client Request → API Gateway → User Service / Order Service
```

---

## API Endpoints

### User Service

```
GET /users
```

Example request through gateway:

```
http://localhost:8080/users
```

---

### Order Service

```
GET /orders
```

Example request through gateway:

```
http://localhost:8080/orders
```

---

## Running the Project

### 1. Start Redis

Make sure Redis is running:

```
redis-server
```

---

### 2. Start Microservices

Run the services in this order:

```
User Service   → Port 8081
Order Service  → Port 8082
API Gateway    → Port 8080
```

---

### 3. Access APIs via Gateway

Example requests:

```
http://localhost:8080/users
http://localhost:8080/orders
```

---

## Rate Limiting

The API Gateway implements **Redis-based rate limiting**.

Rules:

```
Maximum 10 requests per minute per user
```

If exceeded:

```
HTTP 429 – Too Many Requests
```

---

## Security

Authentication is implemented using **JWT tokens**.

Steps:

1. Generate token
2. Send token in request header

Example header:

```
Authorization: Bearer <JWT_TOKEN>
```

---

## Future Improvements

* Service Discovery (Eureka)
* Config Server
* Distributed Logging
* Docker Deployment
* Kubernetes Support

---

## Author

**Shobhit Maurya**

B.Tech – Computer Science & Engineering
Backend Developer | Java | Spring Boot | Microservices

GitHub:
https://github.com/shobhit-maurya-dev
