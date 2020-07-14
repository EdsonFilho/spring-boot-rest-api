# csv-to-rest-reader
This application provides a REST API endpoint for City and Customer.

The actions supported are:
* Include city
* Include customer
* Find city by name
* Find city by state
* Find customer by name
* Find city by id
* Delete customer
* Update customer

The City entity contains two attributes: name and state, both are strings.

<code>
{
    "id": 2,
    "name": "cidade",
    "state": "SC"
}
</code>

The Customer entity contains five attributes: name, gender, birthdate, age and city.

<code>
{
    "id": 3, 
    "name": "ReNamed Customer",
    "gender": "M",
    "birthdate": "12/25/2020",
    "age": "10",
    "city": {
        "id": 1,
        "name": "cidade",
        "state": "SC"
    }
}
</code>

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


