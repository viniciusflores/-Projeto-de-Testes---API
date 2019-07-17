package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import core.BaseTest;

public class MarvelTest extends BaseTest {
	@Test
	public void shouldValidateLimitItems() {
		given()
			.queryParam("limit", "1000000")
		.when()
			.get("/characters")
		.then()
			.statusCode(409)
			.body("status", is("You may not request more than 100 items."))
		;
	}
	
	@Test
	public void mustValidateNumberOfWolveriniMagazines() {
		int idWolverine = given()
			.queryParam("name", "Wolverine")
		.when()
			.get("/characters")
		.then()
			.statusCode(200)
			.extract().path("data.results[0].id")
		;
		
		given()
		.when()
			.get("/characters/"+idWolverine+"/comics")
		.then()
			.statusCode(200)
			.body("data.total", is(2348))
		;
	}
}
