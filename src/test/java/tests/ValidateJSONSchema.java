package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import io.restassured.module.jsv.*;
import org.testng.annotations.Test;

public class ValidateJSONSchema {
	
	@Test
	public void test_GET() {

		baseURI = "https://api.restful-api.dev";

		given().get("/objects").then().assertThat()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("mySchema.json"))
		.statusCode(200);

	}

}
