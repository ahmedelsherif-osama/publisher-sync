# ERP-Shop Bridge

## Overview
The Bridge module is a standalone integration service connecting the **Shop frontend** with the **ERP backend**. It forwards product listing and order creation requests from Shop to ERP, demonstrating microservice-style integration.

## Features
- Expose Shop-style endpoints (/shop/products, /shop/checkout)
- Forward requests to ERP system via REST
- Convert Shop requests into ERP-compatible requests
- Minimal, stateless, fully decoupled

## Tech Stack
- Java 21
- Spring Boot 3.x
- RestTemplate
- Maven

## Setup & Run
1. Configure ERP base URL in `BridgeService` (default: http://localhost:8080/api)
2. Build and run:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Endpoints
| Resource | Endpoint | Method |
|----------|----------|--------|
| Products | /shop/products | GET |
| Product | /shop/products/{id} | GET |
| Checkout | /shop/checkout | POST |

**Example Checkout Request**
```json
{
  "items": [
    {"productId": "uuid1", "quantity": 2},
    {"productId": "uuid2", "quantity": 1}
  ]
}
```
