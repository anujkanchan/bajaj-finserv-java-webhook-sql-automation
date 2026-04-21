# 🚀 Bajaj Finserv Java Webhook SQL Automation

## 📌 Project Overview

This Spring Boot application is built as part of the Bajaj Finserv API challenge.

On startup, the application:

* Sends a POST request to generate a webhook
* Receives a webhook URL and JWT token
* Solves a SQL-based problem
* Stores the final SQL solution
* Sends the solution securely back to the webhook using JWT authentication

---

## ⚙️ Tech Stack

* Java 17+
* Spring Boot
* Maven
* REST API (RestTemplate)
* SQL
* JWT Authentication

---

## 🔥 Key Features

* ✔ Automatic webhook generation on application startup
* ✔ Secure API communication using JWT token
* ✔ Dynamic SQL problem-solving logic
* ✔ Structured request/response handling using DTOs
* ✔ Final solution submission to webhook endpoint

---

## 🧠 System Flow

1. Spring Boot application starts
2. API call is made to generate webhook
3. Response returns:

   * Webhook URL
   * Access Token (JWT)
4. Application processes SQL challenge
5. Final SQL query is generated
6. Solution is sent to webhook URL using JWT authentication
7. API returns success response

---

## 🔁 Workflow Diagram

Startup → Generate Webhook → Receive Token → Solve SQL → Send Response → Success

---

## 🚀 How to Run the Project

### 1. Clone Repository

```bash
git clone https://github.com/anujkanchan/webhookapp.git
cd webhookapp
```

### 2. Build and Run

```bash
mvn clean install
mvn spring-boot:run
```

---

## ✅ Sample Response

```json
{
  "success": true,
  "message": "Webhook processed successfully"
}
```

---

## 👨‍💻 Author

**Anuj Ganesh Kanchan**
Java Backend Developer | Spring Boot Enthusiast
