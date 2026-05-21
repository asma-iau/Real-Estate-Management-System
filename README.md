# Real Estate Management System

A comprehensive desktop application for managing real estate operations including properties, clients, agents, owners, and transactions.

---

## Description

The Real Estate Management System is a Java-based desktop application developed to help real estate offices organize and manage their data efficiently. The system eliminates manual record-keeping issues by providing a digital platform to store, retrieve, update, and manage properties, clients, agents, owners, and transactions. The application features user authentication, CRUD operations, data export capabilities, and an intuitive graphical interface built with Java Swing.

---

## Getting Started

### Dependencies

- Java JDK 8 or higher
- MySQL Server (MySQL Workbench)
- MySQL JDBC Driver
- NetBeans IDE (recommended) or any Java IDE

### Installing

1. **Clone the repository** from GitHub:
   ```bash
   git clone https://github.com/yourusername/realestate-management.git
   ```

2. **Open MySQL** and create the database:
   ```sql
   CREATE DATABASE realestatemangmentsystem;
   ```

3. **Create the required tables** (USERS, CLIENT, AGENT, OWNER, PROPERTY, TRANSACTION)

4. **Open the project** using NetBeans or your preferred IDE

5. **Update database credentials** in `DatabaseConnect.java`:
   ```java
   DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/realestatemangmentsystem",
       "your_username",
       "your_password"
   );
   ```

6. **Add MySQL Connector JAR** to your project classpath

### Executing program

1. **Run** the `Realestatemanager.java` file
2. **Create a new account** using the "CREATE ACCOUNT" button
3. **Log in** with your credentials
4. **Use the dashboard** to manage:
   - Properties (Add, View, Update, Delete)
   - Clients
   - Agents
   - Owners
   - Transactions (Export to text file)



---


## Authors

Contributors names:

- **Ghala Mousa Alotaibi**
- **Asma Alshamrani** 
- **Ritaj Alsubaie** 
- **Shahad Alshammari** 

---

## Version History

- **1.0** (Current Release)
  - Initial Release
  - Complete CRUD operations for all entities
  - User authentication system
  - Transaction export feature
  - GUI built with Java Swing
  - MySQL database integration

---


## Acknowledgments

Inspiration, code snippets, etc.:

- [Java Swing Documentation](https://docs.oracle.com/javase/tutorial/uiswing/)
- [MySQL JDBC Tutorial](https://dev.mysql.com/doc/connector-j/en/)
- [GitHub README Template](https://gist.github.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc)
- Course instructors: Ms. Hanan, Ms. Nora

---

## System Features

| Feature | Description |
|---------|-------------|
| 🔐 Login/Register | User authentication with validation |
| 🏘️ Properties | Add, view, update, delete (Villa/Apartment/Land) |
| 👤 Clients | Store name, phone, email |
| 👨‍💼 Agents | Store name, supervisor ID |
| 👑 Owners | Store contact details |
| 💰 Transactions | Record sales + export to `.txt` |

---

## Technologies Used

- Java
- Java Swing
- MySQL
- JDBC
- NetBeans IDE
- GitHub
