# BookMyShow Low-Level Design (LLD)

(Its a very common LLD interview question, so I hope it helps)

## Overview
This project is a low-level design (LLD) implementation of a movie booking system similar to BookMyShow. It includes core functionalities such as ticket booking, user management, movie ratings, and show management. The system is built using an in-memory H2 database but can be easily connected to MySQL or any other relational database.

## Features Implemented

1. **User Management**
    - User sign-up
    - User login

2. **Show Management**
    - Add a show

3. **Ticket Booking System**
    - Book a ticket (with concurrency handling)

4. **Ratings & Reviews**
    - Rate a movie
    - Get the average rating of a movie

## Prerequisites
- Java (JDK 11 or later)
- Spring Boot
- H2 Database (default) / MySQL (optional)
- Maven / Gradle

## Setup & Running the Application

1. **Clone the Repository:**
   ```sh
   git clone https://github.com/rupdeep2275/BookMyShowLLD.git
   ```

2. **Open in any IDE which supports Spring Boot Applications (preferably Intellij IDEA)**

3. **Run the Application**



## API Endpoints

### 1. User Management
- **Sign Up:**
  ```http
  POST /book-my-show/user/sign-up
  ```
  **Request Body:**
  ```json
  {
    "username": "john_doe",
    "password": "password123",
    "email":  "johndoe69@gmail.com"
  }
  ```

- **Login:**
  ```http
  POST /book-my-show/user/login
  ```

### 2. Show Management
- **Add a Show:**
  ```http
  POST /book-my-show/show/add
  ```

### 3. Ticket Booking
- **Book a Ticket:** (Handles concurrency to prevent double booking)
  ```http
  POST /book-my-show/ticket/book
  ```

### 4. Ratings & Reviews
- **Rate a Movie:**
  ```http
  POST /book-my-show/rating/rate
  ```

- **Get Average Rating of a Movie:**
  ```http
  GET /book-my-show/rating/{movieId}/rate
  ```

## Database Schema
The system consists of the following database entities:
- **BaseModel**
- **City**
- **Feature**
- **Movie**
- **Rating**
- **Screen**
- **ScreenStatus**
- **Seat**
- **SeatStatus**
- **SeatType**
- **SeatTypeShow**
- **Show**
- **ShowSeat**
- **Theatre**
- **Ticket**
- **TicketStatus**
- **UserType**
- **User**

Movies and shows **must be added to the database** before other functionalities (except user management) can work.

## Design Patterns
The current core functionalities implemented so far primarily follow the **MVC (Model-View-Controller) pattern** for structuring the application. Additionally, Spring Boot inherently follows the **Singleton pattern** for managing beans and services.

1. **Factory Pattern** – Used for creating different user types (Admin, Customer) or ticket types (Standard, VIP).
2. **Observer Pattern** – Handles notifications (SMS/Email) when a ticket is booked or canceled.
3. **Strategy Pattern** – Enables flexible payment methods (Credit Card, UPI, PayPal).

## Future Enhancements
- Implement payment gateway integration
- Introduce role-based access control (RBAC)
- Implement caching for performance improvement

## Contributing
Feel free to fork this repository and submit pull requests for improvements.
