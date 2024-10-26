# Weather Monitoring




 Prerequisites:
 
Java 11 or higher

Maven (for Spring Boot project management)

Node.js and npm (for React)

MySQL (optional if using persistent storage, or H2 for in-memory storage)

Openweathermap (Sign in)







 1: Clone the Repository
 
 2: Set Up the Backend (Spring Boot)
   Install Dependencies:
   <dependencies>
    <!-- Spring Boot Starter for Web and REST APIs -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter for JPA (Data Access) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Database Driver (MySQL or H2) -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Optional Lombok Dependency -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.20</version>
        <scope>provided</scope>
    </dependency>
</dependencies>

3. Sign in to the Openweathermap and API key is generated , enter in application.properties file in backend.
     example
      openweathermap.api.key=api key
      openweathermap.api.url=https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}

4.Configure Database Connection

5.Run the Spring Boot Application

6. Set Up the Frontend (React)
   
7. Install Dependencies: Use npm to install all necessary packages (e.g., Axios)

8. Update API Base URL

9. Run the React Application

10. Verify the Application
   Open the Application: In your browser, go to http://localhost:3000 to interact with the React frontend.
   Backend API Testing: You can also test backend endpoints directly using a tool like Postman to verify the rule creation, listing, and evaluation functionalities.





