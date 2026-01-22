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

Personal Platform – Full-Stack Web Application
🔗 Frontend: https://personal-platform-frontend.pages.dev

🔗 Backend: https://personal-platform-backend.onrender.com

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

com.dhrax.platform
├── config        → Security & application configuration
├── controller
│   ├── admin     → Protected admin APIs
│   └── publicapi → Publicly accessible APIs
├── entity        → JPA entities
├── repository    → Data access layer
├── security      → JWT utilities & filters
└── dto           → Request/response DTOs


## 🧠 Engineering Trade-offs

Some deliberate choices made in this project:

- JWT over session-based auth → better scalability
- Cookie-based auth over Authorization header → better browser security
- Manual security configuration over defaults → clarity and control
- MySQL over NoSQL → relational consistency for structured data

These trade-offs were chosen intentionally, not by accident.


## 🧑‍💼 Recruiter Summary

This project demonstrates:

- Strong understanding of backend security
- Practical Spring Boot & Spring Security experience
- Ability to design real-world authentication systems
- Clean, maintainable code organization
- Production-oriented mindset

It is designed to reflect how backend engineers work in professional teams.

## 📅 Roadmap

- [x] Secure authentication system
- [ ] Blog management APIs
- [ ] Portfolio / project showcase APIs
- [ ] Public SEO-friendly endpoints
- [ ] Swagger / OpenAPI documentation
- [ ] Frontend integration
- [ ] CI/CD pipeline

The project is actively evolving.


here I focussed on:
- Why I chose stateless JWT authentication
- How Spring Security filters work internally
- How cookies improve frontend security
- How the architecture supports future growth
- Real-world issues encountered and solved

This project reflects practical learning, not tutorial copying.


