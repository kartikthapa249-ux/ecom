# E-Commerce Product Management System

A full-stack web application for managing an online store's product catalog. The backend is built with **Spring Boot** and exposes REST APIs, and the **React** frontend consumes them to provide a simple product management interface.

## Features

- Add, view, update, and delete products (full CRUD)
- RESTful API design with proper HTTP methods and status codes
- Persistent storage using MySQL through Spring Data JPA / Hibernate
- React frontend connected to the backend APIs
- Layered architecture (Controller → Service → Repository)

## Tech Stack

| Layer      | Technology                                   |
|------------|----------------------------------------------|
| Backend    | Java, Spring Boot, Spring MVC                |
| Data       | Spring Data JPA, Hibernate, MySQL            |
| Frontend   | React, HTML, CSS                             |
| Tools      | Git, GitHub, Postman, Maven                  |

## Project Structure

```
ecom/
├── backend/            # Spring Boot application
│   └── src/main/java/...
│       ├── controller/
│       ├── service/
│       ├── repository/
│       └── model/
└── frontend/           # React application
    └── src/
```

## Getting Started

### Prerequisites

- JDK 17 or later
- Maven
- MySQL 8+
- Node.js and npm

### Backend

1. Clone the repository
   ```bash
   git clone https://github.com/kartikthapa249-ux/ecom.git
   cd ecom
   ```
2. Create a MySQL database
   ```sql
   CREATE DATABASE ecom_db;
   ```
3. Update `src/main/resources/application.properties`
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ecom_db
   spring.datasource.username=YOUR_USERNAME
   spring.datasource.password=YOUR_PASSWORD
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Run the application
   ```bash
   mvn spring-boot:run
   ```
   The API starts at `http://localhost:8080`.

### Frontend

```bash
cd frontend
npm install
npm start
```
The app opens at `http://localhost:3000`.

## API Endpoints

| Method | Endpoint          | Description            |
|--------|-------------------|------------------------|
| GET    | `/products`       | Get all products       |
| GET    | `/products/{id}`  | Get a product by ID    |
| POST   | `/products`       | Add a new product      |
| PUT    | `/products/{id}`  | Update a product       |
| DELETE | `/products/{id}`  | Delete a product       |

> Adjust the paths above to match your controller mappings.

## Future Improvements

- User authentication and role-based access (Spring Security + JWT)
- Search, filtering, and pagination
- Product image upload
- Shopping cart and order management

## Author

**Kartik Thapa**
GitHub: [kartikthapa249-ux](https://github.com/kartikthapa249-ux)
