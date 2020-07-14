# csv-to-rest-reader
This application provides a REST API endpoint.

## Cloning
To clone the application run the following command:

<code>git clone https://github.com/EdsonFilho/spring-boot-rest-api.git</code>

## Testing
To run the integration tests run the following command:

<code>mvn test</code> 

## Runing
To build the application run the following command:

<code>mvn clean package</code>

After running this command, a file called spring-boot-rest-api-0.0.1-SNAPSHOT.jar will be created on the /target directory.

To run the application run the following command:

<code>java -jar target/spring-boot-rest-api-0.0.1-SNAPSHOT.jar</code>

Than the endpoint REST API will become available on the address http://localhost:8080.

## Resources
####City
The city can be accessed calling this endPoint:
 
<code>http://localhost:8080/city/</code>

####Customer
The customer can be accessed calling this endPoint:
 
<code>http://localhost:8080/customer/</code>


