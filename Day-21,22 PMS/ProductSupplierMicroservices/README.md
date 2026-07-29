# ProductSupplierMicroservices

A complete Spring Boot Microservices project demonstrating a Product–Supplier domain using:
- **Java 21** | **Spring Boot 3.2.5** | **Spring Cloud 2023.0.1**
- **Eureka** Service Registry | **Spring Cloud Gateway** | **OpenFeign**
- **Spring Data JPA** | **MySQL** | **Lombok** | **Validation**

---

## Project Structure

```
ProductSupplierMicroservices/
│
├── pom.xml                          ← Parent POM
│
├── service-registry/                ← Eureka Server (port 8761)
│   ├── pom.xml
│   └── src/main/java/com/company/serviceregistry/
│       └── ServiceRegistryApplication.java
│
├── api-gateway/                     ← API Gateway (port 8080)
│   ├── pom.xml
│   └── src/main/java/com/company/apigateway/
│       └── ApiGatewayApplication.java
│
├── supplier-service/                ← Supplier Service (port 8081)
│   ├── pom.xml
│   └── src/main/java/com/company/supplierservice/
│       ├── SupplierServiceApplication.java
│       ├── controller/SupplierController.java
│       ├── service/SupplierService.java
│       ├── service/SupplierServiceImpl.java
│       ├── repository/SupplierRepository.java
│       ├── entity/Supplier.java
│       ├── dto/SupplierDTO.java
│       ├── exception/SupplierNotFoundException.java
│       ├── exception/DuplicateSupplierException.java
│       ├── exception/GlobalExceptionHandler.java
│       └── config/DataInitializer.java
│
└── product-service/                 ← Product Service (port 8082)
    ├── pom.xml
    └── src/main/java/com/company/productservice/
        ├── ProductServiceApplication.java
        ├── controller/ProductController.java
        ├── service/ProductService.java
        ├── service/ProductServiceImpl.java
        ├── repository/ProductRepository.java
        ├── entity/Product.java
        ├── dto/ProductDTO.java
        ├── dto/SupplierDTO.java
        ├── dto/ProductResponseDTO.java
        ├── client/SupplierClient.java
        ├── exception/ProductNotFoundException.java
        ├── exception/SupplierNotFoundException.java
        ├── exception/SupplierServiceDownException.java
        ├── exception/DuplicateProductException.java
        ├── exception/InvalidProductDataException.java
        ├── exception/InvalidSupplierIdException.java
        ├── exception/GlobalExceptionHandler.java
        └── config/DataInitializer.java
```

---

## Service Ports

| Service          | Port | URL                         |
|------------------|------|-----------------------------|
| service-registry | 8761 | http://localhost:8761        |
| api-gateway      | 8080 | http://localhost:8080        |
| supplier-service | 8081 | http://localhost:8081        |
| product-service  | 8082 | http://localhost:8082        |

---

## Prerequisites

- Java 21 (or 17)
- Maven 3.8+
- MySQL 8.x running on localhost:3306
- MySQL user: `root` / password: `root` (update in application.yml if different)

---

## Database Setup

The `createDatabaseIfNotExist=true` flag in the JDBC URL auto-creates the databases.
Alternatively, run the SQL scripts manually:

```sql
-- For supplier-service
source supplier-service/src/main/resources/supplier_db.sql

-- For product-service
source product-service/src/main/resources/product_db.sql
```

---

## How to Run

**Start services in this exact order:**

### 1. service-registry
```bash
cd service-registry
mvn spring-boot:run
```
Dashboard → http://localhost:8761

### 2. api-gateway
```bash
cd api-gateway
mvn spring-boot:run
```

### 3. supplier-service
```bash
cd supplier-service
mvn spring-boot:run
```

### 4. product-service
```bash
cd product-service
mvn spring-boot:run
```

---

## API Endpoints

All requests can go through the **API Gateway** on port **8080**, or directly to each service.

### Supplier Service

| Method | URL (via Gateway)                          | Description           |
|--------|--------------------------------------------|-----------------------|
| POST   | `http://localhost:8080/api/suppliers`       | Add supplier          |
| GET    | `http://localhost:8080/api/suppliers`       | Get all suppliers     |
| GET    | `http://localhost:8080/api/suppliers/{id}`  | Get supplier by ID    |
| PUT    | `http://localhost:8080/api/suppliers/{id}`  | Update supplier       |
| DELETE | `http://localhost:8080/api/suppliers/{id}`  | Delete supplier       |

### Product Service

| Method | URL (via Gateway)                                    | Description                     |
|--------|------------------------------------------------------|---------------------------------|
| POST   | `http://localhost:8080/api/products`                  | Add product                     |
| GET    | `http://localhost:8080/api/products`                  | Get all products                |
| GET    | `http://localhost:8080/api/products/{id}`             | Get product by ID               |
| PUT    | `http://localhost:8080/api/products/{id}`             | Update product                  |
| DELETE | `http://localhost:8080/api/products/{id}`             | Delete product                  |
| GET    | `http://localhost:8080/api/products/supplier/{sid}`   | Get products by supplier ID     |
| GET    | `http://localhost:8080/api/products/{id}/supplier`    | Get product with supplier info  |

---

## Sample Request Bodies

### Add Supplier
```json
POST /api/suppliers
{
  "supplierName": "ABC Technologies",
  "city": "Chennai"
}
```

### Add Product
```json
POST /api/products
{
  "productName": "Laptop",
  "price": 65000.00,
  "quantity": 20,
  "supplierId": 1
}
```

### ProductResponseDTO (product with supplier)
```json
GET /api/products/1/supplier
{
  "productId": 1,
  "productName": "Laptop",
  "price": 65000.0,
  "quantity": 20,
  "supplier": {
    "supplierId": 1,
    "supplierName": "ABC Technologies",
    "city": "Chennai"
  }
}
```

---

## Sample Data (Pre-loaded on Startup)

### Suppliers
| ID | Name              | City       |
|----|-------------------|------------|
| 1  | ABC Technologies  | Chennai    |
| 2  | Global Traders    | Bangalore  |
| 3  | Tech World        | Hyderabad  |

### Products
| ID | Name      | Price   | Qty | Supplier |
|----|-----------|---------|-----|----------|
| 1  | Laptop    | 65000   | 20  | 1        |
| 2  | Mouse     | 700     | 100 | 1        |
| 3  | Keyboard  | 1200    | 50  | 2        |

---

## Exception Handling

| Exception                  | HTTP Status       | Trigger                            |
|----------------------------|-------------------|------------------------------------|
| ProductNotFoundException   | 404 Not Found     | Product ID doesn't exist           |
| SupplierNotFoundException  | 404 Not Found     | Supplier ID doesn't exist          |
| SupplierServiceDownException | 503 Unavailable | Feign cannot reach supplier-service|
| DuplicateProductException  | 409 Conflict      | Product name already exists        |
| InvalidProductDataException| 400 Bad Request   | Invalid product fields             |
| InvalidSupplierIdException | 400 Bad Request   | supplierId is null/negative/zero   |
| Validation errors          | 400 Bad Request   | @Valid constraint violations       |
| Database errors            | 503 Unavailable   | DB connection failure              |

---

## Architecture

```
Client
  │
  ▼
[API Gateway :8080]
  │            │
  ▼            ▼
[supplier-service :8081]   [product-service :8082]
  │            │                    │
  ▼            │           [SupplierClient (Feign)]
[supplier_db]  │                    │
               │              calls /api/suppliers/{id}
               │                    │
               └────────────────────┘
                      via Eureka
                [service-registry :8761]
```
