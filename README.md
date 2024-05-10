# Deal Importer

## Overview
The Deal Importer project is a Java application that provides functionality for importing deal data into a database. It includes classes for dealing with deals, validating deal data, and managing database operations. The project aims to provide a reliable and efficient way to import deal data while ensuring data integrity and consistency.

## Technologies Used
- Java
- MySQL
- Maven
- Docker

## Classes and Packages
### Deal Class
Represents a deal with properties such as dealUniqueId, fromCurrencyISOCode, toCurrencyISOCode, dealTimestamp, and dealAmount.
Includes constructors, getters, and setters.
### DealDAO Class
Manages database operations for deals, including saving deals to the database and checking for duplicate deals.
### DealValidator Class
Validates deals before saving them, checking for null or empty fields, duplicate deal IDs, and valid ISO codes.
### Database Schema
```
Deals Table:
deal_unique_id (VARCHAR)
from_currency_iso_code (VARCHAR)
to_currency_iso_code (VARCHAR)
deal_timestamp (BIGINT)
deal_amount (DOUBLE)
```

## Setup
To set up the Deal Importer project, follow these steps:

1. Clone the project repository from GitHub.
2. Install Java, Maven, and Docker if not already installed.
3. Set up a MySQL database and create a `deals` table with the following schema:
Change the username and password to your desired info.

```
CREATE DATABASE IF NOT EXISTS ClusteredDH_Db;
   USE ClusteredDH_Db;

CREATE TABLE IF NOT EXISTS deals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    deal_unique_id VARCHAR(255) UNIQUE NOT NULL,
    from_currency_iso_code VARCHAR(3) NOT NULL,
    to_currency_iso_code VARCHAR(3) NOT NULL,
    deal_timestamp BIGINT NOT NULL,
    deal_amount DOUBLE NOT NULL
);


CREATE USER 'ClusteredDH'@'localhost' IDENTIFIED BY 'ClusteredDH';

GRANT ALL PRIVILEGES ON ClusteredDH_Db.* TO 'ClusteredDH'@'localhost';

```
  
Update the database.properties file in the src/main/resources directory with your database connection details:

```
url=jdbc:mysql://localhost:3306/ClusteredDH_Db
user=ClusteredDH
password=ClusteredDH
```

Build and run the project using IntelliJ IDEA or any Java IDE.
Or you can use the Docker file.

## Future Improvements
Some possible future improvements for the Deal Importer project include:

Adding support for more advanced validation rules, such as checking deal amounts against exchange rates.
Implementing a web interface or API for importing deals, allowing for easier integration with other systems.
Enhancing the logging and error handling to provide more detailed information in case of failures.
Improving the performance of deal validation and database operations, especially for large volumes of data.

## Conclusion
The Deal Importer project provides a solid foundation for importing deal data into a database. With its flexible design and extensible architecture, it can be easily adapted to fit various business requirements. By following the setup instructions and considering future improvements, this project can serve as a reliable solution for managing deal data effectively.
