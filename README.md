# Smart Home IoT Monitoring and Automation System

## Overview

A Java-based smart home monitoring and automation system that simulates sensor readings, monitors environmental conditions, and automatically controls devices based on predefined rules.

## Features

* Simulated temperature, humidity, and motion sensor readings
* Automatic fan control based on temperature and humidity
* Automatic light control based on motion detection
* High-temperature and high-humidity alerts
* Sensor data storage using MySQL and JDBC
* REST-style API for retrieving the latest sensor reading and recent history
* Web dashboard with live sensor updates

## Technologies Used

* Java
* MySQL
* JDBC
* Java HTTP Server
* HTML, CSS, and JavaScript
* Postman (for API testing)

## Architecture

Simulated Sensors → Java Application → Automation Logic → MySQL → REST API → Web Dashboard

## API Endpoints

| Method | Endpoint               | Description                             |
| ------ | ---------------------- | --------------------------------------- |
| GET    | `/api/sensors/latest`  | Retrieves the latest sensor reading     |
| GET    | `/api/sensors/history` | Retrieves the five most recent readings |
| GET    | `/`                    | Opens the web dashboard                 |

## Running the Project

1. Install Java and MySQL.
2. Create a MySQL database named `smart_home`.
3. Create the `sensor_data` table required by the application.
4. Configure the database connection in `Main.java` and `SimpleApiServer.java`.
5. Compile the Java source files with the MySQL Connector/J library.
6. Run `Main` to generate sensor readings and save them to MySQL.
7. Run `SimpleApiServer` in a separate terminal.
8. Open `http://localhost:8080/` in a browser.

## Note

The current implementation uses simulated sensor data. It is designed so that a real IoT device or external sensor API can be integrated later.

## Future Improvements

* Integrate real IoT sensor data
* Add device-control endpoints
* Improve error handling and API validation
* Migrate to Spring Boot and PostgreSQL
