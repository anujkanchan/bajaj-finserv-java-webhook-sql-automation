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


Actual Steps :


# 🚀 Bajaj Finserv Webhook SQL Automation (Spring Boot)

## 📌 Project Overview

This project is a Spring Boot application that:

* Generates a webhook using an API
* Receives an access token
* Solves a SQL query
* Submits the result automatically via REST API

---

## 🛠️ Tech Stack

* Java 17+
* Spring Boot
* Maven
* RestTemplate
* SQL

---

## ⚙️ Step-by-Step Flow

### 1️⃣ Project Setup (Spring Initializer)

Create project using:

* Spring Boot Starter Web
* Maven Project
* Java 17+

Import into IDE (IntelliJ / Eclipse)

---

### 2️⃣ Project Structure

src/main/java/com/example/demo
├── DemoApplication.java
└── service
└── ApiService.java

---

### 3️⃣ Dependency Injection Setup

* Use constructor-based injection for RestTemplate
* Define RestTemplate bean in main class

---

### 4️⃣ API Flow (Auto Execution on Startup)

#### 🔹 Step 1: Generate Webhook

POST:
https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA

Response:

* Webhook URL
* Access Token

---

#### 🔹 Step 2: Solve SQL Problem

Write SQL query based on:

* Employee data
* Salary
* Department
* Filtering & sorting logic

---

#### 🔹 Step 3: Submit Answer

POST to webhook URL

Headers:
Authorization: <accessToken>

Body: <final SQL query>

---

## ▶️ How to Run Project

### 1. Build Project

mvn clean install

### 2. Run Application

mvn spring-boot:run

---

## ✅ Final Output

* ✔ Webhook URL generated
* ✔ Access token received
* ✔ SQL query submitted successfully
* ✔ Response: "success": true

---

## 🎯 Key Features

* REST API integration using Spring Boot
* Constructor-based Dependency Injection
* Fully automated workflow
* Real-time SQL query submission

---

## 🏁 Learning Outcomes

* Real-world API handling
* Spring Boot architecture
* SQL optimization
* Debugging & backend flow

---

## 👨‍💻 Author

**Anuj Ganesh Kanchan**

---

## 🔥 Conclusion

A complete end-to-end Spring Boot automation project that integrates API + SQL + backend processing into a real-world workflow.

