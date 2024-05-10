# Deal Importer

## Overview
The Deal Importer project is a Java application that provides functionality for importing deal data into a database. It includes classes for dealing with deals, validating deal data, and managing database operations. The project aims to provide a reliable and efficient way to import deal data while ensuring data integrity and consistency.

## Technologies Used
- Java
- MySQL
- Maven
- Docker

## Setup
To set up the Deal Importer project, follow these steps:

1. Clone the project repository from GitHub.
2. Install Java, Maven, and Docker if not already installed.
3. Set up a MySQL database and create a `deals` table with the following schema:

   ```sql
   CREATE TABLE deals (
       deal_unique_id VARCHAR(255) PRIMARY KEY,
       from_currency_iso_code VARCHAR(3) NOT NULL,
       to_currency_iso_code VARCHAR(3) NOT NULL,
       deal_timestamp BIGINT NOT NULL,
       deal_amount DOUBLE NOT NULL
   );
Update the database.properties file in the src/main/resources directory with your database connection details:
makefile
'''
url=jdbc:mysql://localhost:3306/ClusteredDH_Db
user=ClusteredDH
password=ClusteredDH
---

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
