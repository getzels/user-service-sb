Application Properties
The following properties are used in the application:

bash
Copy code
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Flyway configuration
# Change the location of the migration scripts if needed
spring.flyway.locations=classpath:/db/migration
spring.flyway.baseline-on-migrate=true
The spring.datasource properties are used to configure the H2 in-memory database that is used by the application. The spring.h2.console.enabled property enables the H2 console which can be accessed by navigating to http://localhost:<port>/h2-console.

The spring.flyway properties are used to configure Flyway for database migration.

Database Migration
The database migration is handled by Flyway. The migration scripts are located in src/main/resources/db/migration. The first migration script is named V1__inicial_db_structure.sql. It contains the SQL commands for creating the initial database schema.

Build Configuration
The build configuration is defined in build.gradle.kts.

The application is built using the org.springframework.boot plugin. The io.spring.dependency-management plugin is used to manage the version of the Spring dependencies.

The application uses the following dependencies:

spring-boot-starter-data-jdbc - for database access
spring-boot-starter-web - for web and RESTful APIs
lombok - for reducing boilerplate code
h2 - for in-memory database
flyway-core - for database migration
UserService
The UserRepositoryImpl class implements the UserRepository interface and provides methods for querying the database for users with departments.

UserController
The UserController class provides a RESTful API for retrieving users with departments. The API is exposed at /user and returns a JSON array of User objects.

Running the Application
To run the application, execute the following command:

bash
Copy code
./gradlew bootRun
The application will start on port 8080.

To access the H2 console, navigate to http://localhost:8080/h2-console. The console requires a JDBC URL of jdbc:h2:mem:testdb, username of sa, and password of blank.

Running Unit Tests
To run the unit tests, execute the following command:

bash
Copy code
./gradlew test
The tests are located in the src/test directory. The UserRepositoryImplTest class tests the UserRepositoryImpl class.
