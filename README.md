# MobileDeApplication Microservice 

This MobileDeApplication is responsible for managing ad and customers. It uses Java 8 and Spring boot framework for REST API.


## Getting Started

The swagger Url is http://localhost:8080/mobileDeApp/swagger-ui.html.
The H2 database is available on - http://localhost:8080/h2-console // User Name and Password is both admin.

### Prerequisites

	JDK 8 or above, 
	Spring Boot,
	Maven,
	GIT.


### Installing

A step by step series of examples that tell you how to get a development environment running,

	1. Go to the project directory and run 'mvn clean install' to build the project and download dependencies.
	
	2. Import the project in local IDE, i.e. Eclipse or Spring Tool Suite.
	
	3. Define a "LOG_DIR" and Run the application -> mvn spring-boot:run
	
	4. Check the rest APIs via swagger.
	
	http://localhost:8080/mobileDeApp/swagger-ui.html
	
	Sample JSON for create a customer entry 
		{
			"companyName": "ABC GmbH",
			"email": "admin@abc.com",
			"firstName": "Abc",
			"lastName": "Xyz"
		}
	
	Sample JSON for create an ad entry
		{
			"category": "Car",
			"customerId": 1,
			"description": "test",
			"make": "BMW",
			"model": "S100",
			"price": 0
		}
	
	
	For DB we can check under - http://localhost:8080/h2-console
							Please use - jdbc:h2:mem:mobile-de-db, User Name- admin, Password - admin
							
## Running the tests
	
	Running Test command - mvn test
	
## Authors
	* **Swarnava Chakraborty** - *Senior Lead Engineer* - [swarnavac.ju@gmail.com].