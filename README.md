# MedLink - Medication & Prescription Tracker

> A full-stack mobile application for medication tracking and prescription management connecting patients with their doctors.

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-green)
![React Native](https://img.shields.io/badge/React%20Native-0.73.2-lightgrey)
![MongoDB](https://img.shields.io/badge/MongoDB-Atlas-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![License](https://img.shields.io/badge/License-MIT-blue)

---

## Overview

**MedLink** is a comprehensive healthcare management platform that helps patients manage medications effectively while enabling doctors to monitor adherence and health outcomes through real-time tracking and AI-powered insights. The application bridges the gap between patients and healthcare providers by providing a seamless interface for medication management, prescription tracking, and vital signs monitoring.

## Key Features

### For Patients
- Track daily medication intake with easy-to-use interface
- Smart push notification reminders for medication schedules
- Manage prescriptions, dosages, and refills
- View adherence statistics and personalized health insights
- Monitor vital signs (Blood Pressure, Heart Rate, Glucose levels)
- Mobile-first design for on-the-go access

### For Doctors
- Monitor all patient profiles from a centralized dashboard
- Real-time adherence dashboards with visual analytics
- Create and manage electronic prescriptions
- Automated alerts for non-adherent patients requiring intervention
- Patient health metrics tracking with historical trends
- Advanced search and filtering capabilities

## Tech Stack

### Frontend
- **Framework:** React Native 0.73.2 with Expo SDK 54
- **Navigation:** React Navigation 6.x
- **State Management:** React Context API
- **UI Components:** Custom components with modern design system
- **HTTP Client:** Axios for API communication

### Backend
- **Framework:** Spring Boot 3.2.0
- **Language:** Java 17
- **Security:** Spring Security with JWT authentication
- **Validation:** Hibernate Validator

### Database
- **Database:** MongoDB (Atlas cloud or local instance)
- **ODM:** Spring Data MongoDB

### Development Tools
- **IDE:** IntelliJ IDEA / VS Code
- **Build Tool:** Maven
- **Version Control:** Git
- **API Testing:** Postman / Insomnia

## Project Structure

```
medlink-project/
├── backend/                          # Spring Boot Backend
│   ├── src/main/java/com/medlink/tracker/
│   │   ├── controller/               # REST API endpoints
│   │   │   ├── AuthController.java
│   │   │   ├── ChatBotController.java
│   │   │   ├── DoctorController.java
│   │   │   ├── MedicationController.java
│   │   │   ├── PatientController.java
│   │   │   ├── PrescriptionController.java
│   │   │   └── VitalSignController.java
│   │   ├── dto/                      # Data Transfer Objects
│   │   ├── exception/                # Exception handling
│   │   ├── model/                    # Data models
│   │   ├── repository/               # Database layer
│   │   ├── security/                 # JWT & Security config
│   │   ├── service/                  # Business logic
│   │   └── MedlinkApplication.java
│   └── pom.xml                       # Maven dependencies
│
├── frontend/                         # React Native App
│   ├── src/
│   │   ├── components/               # Reusable UI components
│   │   ├── screens/                  # Application screens
│   │   ├── navigation/               # App navigation
│   │   ├── services/                 # API services
│   │   ├── context/                  # React Context providers
│   │   └── utils/                    # Helper functions
│   ├── App.js                        # Main entry point
│   └── package.json
│
└── README.md
```

---

## 📋 Prerequisites

Before you begin, ensure you have the following installed:

- **Node.js** v18+ and npm
- **Java JDK** 17 or higher
- **MongoDB** (Atlas cloud instance or local installation)
- **Expo CLI** (`npm install -g expo-cli`)
- **Maven** (for building the backend)
- **Git** (for version control)

## 🔧 Installation & Setup

### 1️⃣ Backend Setup

**Step 1: Clone and navigate to backend directory**
```bash
cd medlink-project/backend
```

**Step 2: Install dependencies**
```bash
mvn clean install
```

**Step 3: Configure database connection**
Edit `src/main/resources/application.properties`:

**For MongoDB Atlas:**
```properties
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster.mongodb.net/medlink?retryWrites=true&w=majority
spring.data.mongodb.database=medlink
```

**For Local MongoDB:**
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/medlink
spring.data.mongodb.database=medlink
```

**Step 4: Configure JWT secret** (optional, default is provided)
```properties
jwt.secret=your-secret-key-here
jwt.expiration=86400000
```

**Step 5: Run the backend server**
```bash
mvn spring-boot:run
```

The backend will start on `http://localhost:8080`

### 2️⃣ Frontend Setup

**Step 1: Navigate to frontend directory**
```bash
cd medlink-project/frontend
```

**Step 2: Install dependencies**
```bash
npm install
```

**Step 3: Configure environment variables**
Create a `.env` file in the frontend root:
```env
API_URL=http://localhost:8080/api
```

**Step 4: Start the development server**
```bash
npm start
# or
expo start
```

Scan the QR code with Expo Go app on your mobile device, or press:
- `a` - Run on Android emulator
- `i` - Run on iOS simulator
- `w` - Run in web browser

## Running the Application

### Quick Start Guide

**1. Start the Backend Server**
```bash
cd medlink-project/backend
mvn spring-boot:run
```

**2. Start the Frontend Development Server**
```bash
cd medlink-project/frontend
npm start
```

**3. Run on Your Device/Emulator**
- Press `a` for Android emulator
- Press `i` for iOS simulator (Mac only)
- Scan QR code with Expo Go app for physical device

## API Endpoints

### Authentication & Authorization

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/api/auth/register` | Register a new user (patient/doctor) | `{email, password, role, name}` |
| POST | `/api/auth/login` | User login and receive JWT token | `{email, password}` |
| GET | `/api/auth/me` | Get current authenticated user | Header: `Authorization: Bearer <token>` |

### Patient Management

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| GET | `/api/patients` | Get all patients | Doctor only |
| GET | `/api/patients/:id` | Get specific patient by ID | Authenticated |
| PUT | `/api/patients/:id` | Update patient information | Patient/Doctor |
| GET | `/api/patients/:id/adherence` | Get patient's medication adherence rate | Doctor only |
| GET | `/api/patients/:id/vitals` | Get patient's vital signs history | Doctor only |

### Medication Management

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| GET | `/api/medications` | Get all medications | Authenticated |
| GET | `/api/medications/:id` | Get specific medication details | Authenticated |
| POST | `/api/medications` | Create new medication | Patient/Doctor |
| PUT | `/api/medications/:id` | Update medication information | Patient/Doctor |
| DELETE | `/api/medications/:id` | Delete a medication | Patient/Doctor |
| POST | `/api/medications/:id/log` | Log medication intake | Patient only |
| GET | `/api/medications/patient/:patientId` | Get patient's medications | Doctor only |

### Prescription Management

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| GET | `/api/prescriptions` | Get all prescriptions | Doctor only |
| GET | `/api/prescriptions/patient/:patientId` | Get prescriptions for a specific patient | Doctor only |
| POST | `/api/prescriptions` | Create a new prescription | Doctor only |
| PUT | `/api/prescriptions/:id` | Update prescription details | Doctor only |
| DELETE | `/api/prescriptions/:id` | Delete a prescription | Doctor only |

### Vital Signs Tracking

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| GET | `/api/vitals` | Get all vital sign records | Doctor only |
| GET | `/api/vitals/patient/:patientId` | Get patient's vital signs | Doctor/Patient |
| POST | `/api/vitals` | Record new vital sign measurement | Patient only |
| PUT | `/api/vitals/:id` | Update vital sign record | Patient only |
| DELETE | `/api/vitals/:id` | Delete vital sign record | Patient only |

### Doctor Management

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| GET | `/api/doctors` | Get all doctors | Authenticated |
| GET | `/api/doctors/:id` | Get doctor details by ID | Authenticated |
| GET | `/api/doctors/:id/patients` | Get all patients under a doctor | Doctor only |
| PUT | `/api/doctors/:id` | Update doctor information | Doctor only |

### Chatbot Integration

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| POST | `/api/chat` | Send message to health chatbot | Authenticated |
| GET | `/api/chat/history` | Get chat conversation history | Authenticated |



---

## Security & Authentication

### Authentication Flow

1. **Registration/Login:** User provides email and password
2. **Token Generation:** Backend validates credentials and generates JWT token
3. **Token Storage:** Token is securely stored in AsyncStorage on the device
4. **Request Headers:** All API requests include token in `Authorization` header
5. **Token Validation:** JWT filter validates token on each protected endpoint

### Password Security

- Minimum 6 characters required
- Encrypted using BCrypt hashing algorithm
- Never stored or transmitted in plain text


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

### Special Thanks
- The open-source community for incredible tooling
- Mentors and advisors for guidance

---


<div align="center">

### Made with ❤️ by the MedLink Team

**If you find this project helpful, please consider giving it a star! ⭐**

[Report Bug](https://github.com/medlink/medlink/issues) · [Request Feature](https://github.com/medlink/medlink/issues)

</div>
