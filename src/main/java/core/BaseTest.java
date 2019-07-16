package core;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

public class BaseTest implements Constants {
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = APP_BASE_URL;
		RestAssured.port = APP_PORT;
		RestAssured.basePath = APP_BASE_PATH;

		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.addHeader("Referer", "https://developer.marvel.com/docs");
		reqBuilder.setContentType(APP_CONTENT_TYPE);
		reqBuilder.addQueryParam("apikey", "817e03fbcfbb53dafb799415338848be");
		RestAssured.requestSpecification = reqBuilder.build();

		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
		RestAssured.responseSpecification = resBuilder.build();

		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}
}
