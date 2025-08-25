# 📘 English Vocabulary API

A simple REST API built with **Spring Boot** to help you practice and learn English vocabulary (words and phrases) while learning Java.

---

## 🚀 Features
- Add new English words or phrases with translations.
- Retrieve all stored vocabulary entries.
- Search vocabulary by ID.
- Update existing words or phrases.
- Delete words or phrases you no longer need.
- Returns confirmation messages after saving, updating, or deleting.
- Uses **Spring Boot, Spring Data JPA, and H2 Database**.

---

## 🛠️ Technologies
- Java 17+
- Spring Boot 3+
- Spring Web
- Spring Data JPA
- H2 Database

---

## 📂 Project Structure

```
src/main/java/com/example/vocabulary/
│── entities/        # Entity classes
│── repositories/    # JPA repositories
│── services/        # Business logic
│── controllers/     # REST controllers
```

---

## ⚙️ Configuration

By default, the project uses an in-memory **H2 database**.  
You can access it at:  
👉 `http://localhost:8080/h2-console`  
(JDBC URL: `jdbc:h2:mem:testdb`)

`application.properties`:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

---

## 📌 API Endpoints

### ➕ Add a new word/phrase
`POST /api/vocabulary`

Request body:
```json
{
  "wordOrPhrase": "How are you?",
  "translation": "Como você está?",
  "example": "Hello John, how are you?",
  "referenceLink": "https://www.youtube.com/watch?v=abc123"
}
```

Response:
```json
"✅ Word/Phrase saved successfully with ID: 1"
```

---

### 📖 List all vocabulary
`GET /api/vocabulary`

Response:
```json
[
  {
    "id": 1,
    "wordOrPhrase": "How are you?",
    "translation": "Como você está?",
    "example": "Hello John, how are you?",
    "referenceLink": "https://www.youtube.com/watch?v=abc123"
  }
]
```

---

### 🔍 Find by ID
`GET /api/vocabulary/{id}`

Response if found:
```json
{
  "id": 1,
  "wordOrPhrase": "How are you?",
  "translation": "Como você está?",
  "example": "Hello John, how are you?",
  "referenceLink": "https://www.youtube.com/watch?v=abc123"
}
```

Response if not found:
```json
"⚠️ Word/Phrase not found with ID: 99"
```

---

### 🔄 Update word/phrase
`PUT /api/vocabulary/{id}`

Request body:
```json
{
  "wordOrPhrase": "Good evening",
  "translation": "Boa noite",
  "example": "Good evening, everyone!",
  "referenceLink": "https://example.com/good-evening"
}
```

Response:
```json
"🔄 Word/Phrase updated successfully with ID: 1"
```

---

### ❌ Delete
`DELETE /api/vocabulary/{id}`

Response if deleted:
```json
"🗑️ Word/Phrase deleted successfully with ID: 1"
```

Response if not found:
```json
"⚠️ Word/Phrase not found with ID: 99"
```

---

## 📷 Screenshot

<p align="center">
  <img src="https://github.com/joaopauloleitecosta/vocabulary/blob/main/api.png" width="300" alt="GET request">
</p>

---

## ▶️ Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/joaopauloleitecosta/vocabulary.git
   cd vocabulary
   ```

2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

3. The API will be available at:
   👉 `http://localhost:8080/api/vocabulary`

---

## 🎯 Future Improvements
- Add categories (verbs, nouns, phrases, etc.)
- Track learning progress
- Add difficulty levels (easy, medium, hard)
- Provide random word/phrase quizzes

---
