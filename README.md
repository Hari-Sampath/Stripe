# Stripe

A Spring Boot backend that integrates with the [Stripe](https://stripe.com) payments platform. It uses Spring Security for authentication and authorization, Spring Data JPA (Java Persistence API) with PostgreSQL for storage, and Spring Mail for email notifications.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 4.1.0 |
| Web | Spring Web MVC (Model-View-Controller) |
| Security | Spring Security |
| Persistence | Spring Data JPA (Java Persistence API) + PostgreSQL |
| Payments | `stripe-java` 33.1.1 |
| Email | Spring Boot Starter Mail |
| Boilerplate reduction | Lombok |
| Developer tooling | Spring Boot DevTools |
| Build tool | Maven (via the included Maven Wrapper) |

---

## Features

<!-- Replace with the features you have actually built. Examples: -->

- Stripe payment integration (for example, Checkout Sessions, Payment Intents, or webhooks)
- Secured endpoints using Spring Security
- Persistence of payment/order data in PostgreSQL
- Email notifications (for example, payment receipts or confirmations)

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or later
- PostgreSQL (running locally or hosted)
- A Stripe account and API keys from the [Stripe Dashboard](https://dashboard.stripe.com/apikeys) (use **test mode** keys during development)
- An SMTP (Simple Mail Transfer Protocol) account for sending email (for example, Gmail app password, Mailtrap, or SendGrid)

### 1. Clone the repository

```bash
git clone https://github.com/Hari-Sampath/Stripe.git
cd Stripe
```

### 2. Create the database

```sql
CREATE DATABASE stripe_db;
```

### 3. Configure the application

Create or edit `src/main/resources/application.properties`. Use environment variables for secrets rather than hard-coding them.

```properties
# Server
server.port=8080

# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/stripe_db
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Mail
spring.mail.host=smtp.example.com
spring.mail.port=587
spring.mail.username=${MAIL_USERNAME}
spring.mail.password=${MAIL_PASSWORD}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# Stripe (property names may differ in your code; match what your config class reads)
stripe.api.key=${STRIPE_SECRET_KEY}
stripe.webhook.secret=${STRIPE_WEBHOOK_SECRET}
```

Set the environment variables before running:

```bash
export DB_USERNAME=postgres
export DB_PASSWORD=your_password
export MAIL_USERNAME=you@example.com
export MAIL_PASSWORD=your_app_password
export STRIPE_SECRET_KEY=sk_test_...
export STRIPE_WEBHOOK_SECRET=whsec_...
```

### 4. Run the application

```bash
# macOS / Linux
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

The server starts at `http://localhost:8080`.

### 5. Build and test

```bash
./mvnw clean package   # build the JAR (Java Archive)
./mvnw test            # run tests
```

---

## Testing Stripe Webhooks Locally

Install the [Stripe CLI](https://docs.stripe.com/stripe-cli) (Command Line Interface) and forward events to your local server:

```bash
stripe login
stripe listen --forward-to localhost:8080/<your-webhook-endpoint>
```

Copy the `whsec_...` signing secret it prints into `STRIPE_WEBHOOK_SECRET`.

---

## API Endpoints

<!-- Fill in with your real controllers. -->

| Method | Endpoint | Description | Auth required |
|---|---|---|---|
| `POST` | `/...` | ... | ... |

---

## Project Structure

```
Stripe/
├── .mvn/wrapper/      # Maven Wrapper configuration
├── src/
│   ├── main/
│   │   ├── java/      # Application source code
│   │   └── resources/ # Configuration (application.properties)
│   └── test/          # Tests
├── mvnw, mvnw.cmd     # Maven Wrapper scripts
└── pom.xml            # Maven dependencies and build config
```

---

## Security Notes

- Never commit real Stripe keys, database passwords, or SMTP credentials. Keep them in environment variables or an untracked config file.
- Use Stripe **test mode** keys (`sk_test_...`) until you are ready for production.
- Always verify webhook signatures before trusting an incoming Stripe event.

---

## Roadmap

- [ ] Add API documentation (for example, with OpenAPI / Swagger)
- [ ] Add integration tests for the payment flow
- [ ] Add Docker / Docker Compose setup for the app and PostgreSQL
- [ ] Add CI (Continuous Integration) with GitHub Actions

---

## Author

**Hari Sampath** — [@Hari-Sampath](https://github.com/Hari-Sampath)

## License

No license has been specified yet. Add a `LICENSE` file (for example, MIT) to define how others may use this project.
