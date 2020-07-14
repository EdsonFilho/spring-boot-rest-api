package br.com.eacf;

import br.com.eacf.service.CustomerService;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.event.annotation.PrepareTestInstance;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerCityApplicationTests {

	@LocalServerPort
	private int port;

	// Cadastro de cidade
	@Test
	@Order(1)
	public void saveCity() {
		String requestBody = "{\n" +
				"        \"name\": \"Added City\",\n" +
				"        \"state\": \"state\"\n" +
				"    }";

		given()
				.port(port)
				.when()
				.contentType(ContentType.JSON)
				.body(requestBody)
				.post("/city/")
				.then()
				.assertThat()
				.statusCode(200)
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("Added City"));
	}

	// Cadastro de cliente
	@Test
	@Order(2)
	public void testSaveCustomer() {

		String requestBody = "{\n" +
				"        \"name\": \"Added Customer\",\n" +
				"        \"gender\": \"M\",\n" +
				"        \"birthdate\": \"01/01/2020\",\n" +
				"        \"age\": 10,\n" +
				"        \"city\": {\n" +
				"        	\"id\": 1\n" +
				"        }\n" +
				"    }";

		given()
				.port(port)
				.when()
				.contentType(ContentType.JSON)
				.body(requestBody)
				.post("/customer/")
				.then()
				.assertThat()
				.statusCode(200)
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("Added Customer"));
	}

	// Consultar cidade pelo nome
	@Test
	@Order(3)
	public void findCityByName() {

		given()
				.port(port)
				.when()
				.get("/city/name/Added City")
				.then()
				.assertThat()
				.statusCode(200)
				.body("size()", equalTo(1));
	}

	// Consultar cidade pelo estado
	@Test
	@Order(4)
	public void findCityByState() {

		given()
				.port(port)
				.when()
				.get("/city/state/state")
				.then()
				.assertThat()
				.statusCode(200)
				.body("size()", equalTo(1));
	}


	// Consultar cliente pelo nome
	@Test
	@Order(5)
	public void findCustomerByName() {

		given()
				.port(port)
				.when()
				.get("/customer/name/Added Customer")
				.then()
				.assertThat()
				.statusCode(200)
				.body("size()", equalTo(1));
	}

	// Consultar cliente pelo nome
	@Test
	@Order(6)
	public void findCustomerById() {

		given()
				.port(port)
				.when()
				.get("/customer/2")
				.then()
				.assertThat()
				.statusCode(200)
				.body("id", Matchers.notNullValue());
	}

	// Remover cliente
	@Test
	@Order(8)
	public void deleteCustomerById() {

		given()
				.port(port)
				.when()
				.delete("/customer/2")
				.then()
				.assertThat()
				.statusCode(200);

		given()
				.port(port)
				.when()
				.get("/customer/")
				.then()
				.assertThat()
				.statusCode(200)
				.body("size()", equalTo(0));
	}

	//Alterar o nome do cliente
	@Test
	@Order(7)
	public void changeCustomersName() {
		String requestBody = "{\n" +
				"        \"name\": \"ReNamed Customer\",\n" +
				"        \"gender\": \"M\",\n" +
				"        \"birthdate\": \"01/01/2020\",\n" +
				"        \"age\": 10,\n" +
				"        \"city\": {\n" +
				"        	\"id\": 1\n" +
				"        }\n" +
				"    }";

		given()
				.port(port)
				.when()
				.contentType(ContentType.JSON)
				.body(requestBody)
				.put("/customer/2")
				.then()
				.assertThat()
				.statusCode(200)
				.body("id", equalTo(2))
				.body("name", equalTo("ReNamed Customer"));

		given()
				.port(port)
				.when()
				.get("/customer/name/ReNamed Customer")
				.then()
				.assertThat()
				.statusCode(200)
				.body("size()", equalTo(1));
	}

}
