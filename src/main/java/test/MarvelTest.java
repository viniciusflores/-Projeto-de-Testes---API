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
}
