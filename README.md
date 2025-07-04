
# 🎓 School Microservices Project

Ce projet est une application scolaire basée sur une architecture microservices, développée en Java avec Spring Boot. Il gère la gestion des enseignants, des élèves et des classes via des services REST distincts.

---

## 🧱 Architecture globale

```plaintext
school/
├── teacher/        # Microservice de gestion des enseignants
├── student/        # Microservice de gestion des élèves
├── school-class/   # Microservice de gestion des classes
├── gateway/        # API Gateway
├── eureka-server/  # Service Eureka
└── ...
```

Chaque service est indépendant, expose sa propre API REST, et communique via HTTP.

---

## 🚀 Lancement des services

### ⚙️ Prérequis
- Java 21

### ▶️ Démarrage manuel

```bash

git clone https://github.com/Tony-Noa/School.git
cd School
```

- Veuillez démarrer tous les services via votre IDE (ex:Intellij IDEA).
- Assurez-vous que tous les services soit connecté à la base de données dans le `application.properties`.
- Assurez-vous que tous les services ont leur propre port défini dans `application.properties`.

---

## 📘 API Documentation

Chaque microservice expose une API REST standard :

---

### 👨‍🏫 Teacher Service

**Base URL** : `/teachers`

| Method | Endpoint       | Request Body                                 | Response |
|--------|----------------|----------------------------------------------|----------|
| GET    | `/`            | —                                            | Liste des enseignants |
| GET    | `/{id}`        | —                                            | Détails d’un enseignant |
| POST   | `/`            | `{ "first_name", "last_name", "birthdate" }` | Enseignant créé |
| PUT    | `/{id}`        | `{ "first_name", "last_name", "birthdate" }` | Enseignant mis à jour |
| DELETE | `/{id}`        | —                                            | Message de confirmation |

---

### 👩‍🎓 Student Service

**Base URL** : `/students`

| Method | Endpoint       | Request Body                                      | Response |
|--------|----------------|---------------------------------------------------|----------|
| GET    | `/`            | —                                                 | Liste des élèves |
| GET    | `/{id}`        | —                                                 | Détails d’un élève |
| POST   | `/`            | `{ "first_name", "last_name", "birthdate" }`      | Élève créé |
| PUT    | `/{id}`        | `{ "first_name", "last_name", "birthdate" }`      | Élève mis à jour |
| DELETE | `/{id}`        | —                                                 | Message de confirmation |

---

### 🏫 Class Service

**Base URL** : `/classes`

| Method | Endpoint       | Request Body                                | Response |
|--------|----------------|---------------------------------------------|----------|
| GET    | `/`            | —                                           | Liste des classes |
| GET    | `/{id}`        | —                                           | Détails d’une classe |
| POST   | `/`            | `{ "students": "...", "teacher": "..." }`   | Classe créée |
| PUT    | `/{id}`        | `{ "students": "...", "teacher": "..." }`   | Classe mise à jour |
| DELETE | `/{id}`        | —                                           | Message de confirmation |

---

## Axe d'amélioration 
- Finir le service Matière (Subject)
- Réaliser le service Note (Note)

---

## 🧑‍💻 Auteurs

Développé par :
- [Tony](https://github.com/tonyl59)
- [Noa](https://github.com/NScelles)

