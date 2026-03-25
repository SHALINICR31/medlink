# MedLink - Medication & Prescription Tracker

> A full-stack mobile application for medication tracking and prescription management connecting patients with their doctors.

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-green)
![React Native](https://img.shields.io/badge/React%20Native-0.73.2-lightgrey)
![MongoDB](https://img.shields.io/badge/MongoDB-Atlas-brightgreen)

---

## 🎯 Overview

**MedLink** helps patients manage medications effectively while enabling doctors to monitor adherence and health outcomes through real-time tracking and smart insights.

## ✨ Key Features

### For Patients
- 📱 Track daily medication intake
- ⏰ Smart push notification reminders
- 💊 Manage prescriptions and dosages
- 📊 View adherence statistics and health insights
- 🏥 Monitor vital signs (BP, heart rate, glucose)

### For Doctors
- 👥 Monitor all patient profiles
- 📈 Real-time adherence dashboards
- 💉 Create and manage prescriptions
- 🔔 Alerts for non-adherent patients
- 📊 Patient health metrics tracking

## 🚀 Tech Stack

**Frontend:** React Native 0.73.2, Expo 54, React Navigation  
**Backend:** Spring Boot 3.2.0, Java 17, Spring Security, JWT  
**Database:** MongoDB Atlas / Local MongoDB

## 📁 Project Structure

```
medlink/
├── backend/                    # Spring Boot Backend
│   ├── src/main/
│   │   ├── java/com/medlink/tracker/
│   │   │   ├── controller/     # REST API endpoints
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── DoctorController.java
│   │   │   │   ├── MedicationController.java
│   │   │   │   ├── PatientController.java
│   │   │   │   ├── PrescriptionController.java
│   │   │   │   └── VitalSignController.java
│   │   │   ├── model/          # Data models
│   │   │   │   ├── User.java
│   │   │   │   ├── Patient.java
│   │   │   │   ├── Doctor.java
│   │   │   │   ├── Medication.java
│   │   │   │   ├── Prescription.java
│   │   │   │   ├── VitalSign.java
│   │   │   │   └── IntakeLog.java
│   │   │   ├── repository/     # Database layer
│   │   │   ├── service/        # Business logic
│   │   │   ├── security/       # JWT & Security config
│   │   │   └── exception/      # Exception handling
│   │   └── resources/
│   │       └── application.properties
│   └── pom.xml                 # Maven dependencies
│
├── frontend/                   # React Native App
│   ├── src/
│   │   ├── components/         # Reusable UI components
│   │   ├── screens/
│   │   │   ├── auth/           # Login/Register screens
│   │   │   ├── patient/        # Patient screens
│   │   │   ├── doctor/         # Doctor screens
│   │   │   └── SplashScreen.js
│   │   ├── navigation/         # App navigation
│   │   ├── services/           # API services
│   │   ├── context/            # React Context providers
│   │   ├── hooks/              # Custom React hooks
│   │   ├── config/             # Configuration files
│   │   └── utils/              # Helper functions
│   ├── App.js                  # Main entry point
│   └── package.json
│
└── README.md
```

---

## 📦 Prerequisites

- Node.js v18+
- Java JDK 17
- MongoDB (Atlas or local)
- Expo CLI (`npm install -g expo-cli`)

## 🔧 Installation

### Backend Setup
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### Frontend Setup
```bash
cd frontend
npm install
npm start
```


**Local MongoDB:**
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/medlink
```

## ▶️ Running the App

1. **Start Backend:** `cd backend && mvn spring-boot:run`
2. **Start Frontend:** `cd frontend && npm start`
3. **Run on device:** Press `a` for Android or `i` for iOS in Expo CLI

## 🌐 API Endpoints
### Authentication Endpoints

| Method | Endpoint | Description | Body |
|--------|----------|-------------|------|
| POST | `/api/auth/register` | Register new user | `{email, password, role, name}` |
| POST | `/api/auth/login` | User login | `{email, password}` |
| GET | `/api/auth/me` | Get current user | Header: `Authorization: Bearer <token>` |

### Patient Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/patients` | Get all patients (Doctor only) |
| GET | `/api/patients/:id` | Get patient by ID |
| PUT | `/api/patients/:id` | Update patient info |
| GET | `/api/patients/:id/adherence` | Get patient adherence rate |
| GET | `/api/patients/:id/vitals` | Get patient vital signs |

### Medication Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/medications` | Get all medications |
| GET | `/api/medications/:id` | Get medication by ID |
| POST | `/api/medications` | Create new medication |
| PUT | `/api/medications/:id` | Update medication |
| DELETE | `/api/medications/:id` | Delete medication |
| POST | `/api/medications/:id/log` | Log medication intake |

### Prescription Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/prescriptions` | Get all prescriptions |
| GET | `/api/prescriptions/patient/:patientId` | Get patient's prescriptions |
| POST | `/api/prescriptions` | Create prescription (Doctor only) |
| PUT | `/api/prescriptions/:id` | Update prescription |
| DELETE | `/api/prescriptions/:id` | Delete prescription |

### Vital Sign Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/vitals` | Get all vital signs |
| GET | `/api/vitals/patient/:patientId` | Get patient's vitals |
| POST | `/api/vitals` | Record vital sign |
| PUT | `/api/vitals/:id` | Update vital sign |
| DELETE | `/api/vitals/:id` | Delete vital sign |

### Doctor Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/doctors` | Get all doctors |
| GET | `/api/doctors/:id` | Get doctor by ID |
| GET | `/api/doctors/:id/patients` | Get doctor's patients |
| PUT | `/api/doctors/:id` | Update doctor info |

---

## 🔒 Security

### Authentication Flow
1. User registers/logs in with email and password
2. Backend validates credentials and generates JWT token
3. Token is stored in AsyncStorage on the device
4. All subsequent requests include token in Authorization header
5. JWT filter validates token on each request

### Password Requirements
- Minimum 6 characters
- Stored as BCrypt hash
- Never stored in plain text

### JWT Configuration
- **Expiration**: 24 hours (86400000 ms)
- **Secret**: Configurable in application.properties
- **Header Format**: `Authorization: Bearer <token>`

---


### Patient View
- **Dashboard**: View today's medications, adherence score, quick stats
- **Medication List**: Active medications with dosage and timing
- **Log Intake**: Simple interface to record medication consumption
- **Insights**: Charts showing adherence trends over time

### Doctor View
- **Dashboard**: Overview of all patients with adherence categorization
- **Patient Details**: Individual patient metrics and history
- **Prescription Management**: Create and edit prescriptions
- **Alerts Section**: Notifications for patients needing attention

---
## 🛠️ Development

**Build Backend JAR:**
```bash
cd backend
mvn clean package
java -jar target/tracker-1.0.0.jar
```

**Build Mobile App:**
```bash
cd frontend
expo build:android  # or expo build:ios
```

## 📄 License

MIT License - see LICENSE file

---
## 🙏 Acknowledgments

- Built with ❤️ using Spring Boot and React Native
- Special thanks to the open-source community
  
---

 <div align="center">

⭐ Star this repo if you find it helpful!

</div>
