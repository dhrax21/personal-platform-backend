# 🚀 Personal Platform Backend Dhrax

A **production-ready Spring Boot backend** built to power a personal portfolio platform with **secure authentication**, **admin-only APIs**, and **public content support**.

This project demonstrates **real-world backend engineering practices**, not tutorial-level code.

---

## ✨ Key Highlights

- 🔐 **JWT Authentication (HTTP-Only Cookies)**
- 🛡️ **Spring Security 6 (Stateless, Filter-based)**
- 👤 **Admin & Public API Separation**
- 🧩 **Clean, Scalable Architecture**
- 🗄️ **MySQL + JPA (Hibernate)**
- ⚙️ **Environment-based Secret Management**
- 📦 **Maven-based Build**

---

## 🧠 Why This Project Matters

Most portfolio projects stop at CRUD.

This backend goes further by implementing:
- Proper **stateless authentication**
- Secure **cookie-based JWT handling**
- Custom **security filter chains**
- Real **production-style configuration**

These are the exact patterns used in **modern SaaS and enterprise systems**.

---

## 🏗️ Architecture Overview

```text
com.dhrax.platform
├── config        → Security & application configuration
├── controller
│   ├── admin     → Protected admin APIs
│   └── publicapi → Publicly accessible APIs
├── entity        → JPA entities
├── repository    → Data access layer
├── security      → JWT utilities & filters
└── dto           → Request/response DTOs
