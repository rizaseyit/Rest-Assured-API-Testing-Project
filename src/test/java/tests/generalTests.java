package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class generalTests {

	@Test
	public void firstGeneralTest() {

		Response myResponse = get("https://api.coinstats.app/public/v1/coins?skip=0");

		System.out.println(myResponse.getStatusCode());
		System.out.println(myResponse.getTime());
		System.out.println(myResponse.getBody().asString());
		System.out.print(myResponse.getHeader("content-type"));

		int statusCode = myResponse.getStatusCode();

		Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void secondGeneralTest() {

		baseURI = "https://api.coinstats.app/public/v1";

		given().get("/coins?skip=0&limit=5&currency=EUR").then().statusCode(200).body("coins[1].rank", equalTo(2));
	}

	@Test
	public void thirdGeneralTest() {

		baseURI = "https://api.coinstats.app/public/v1";

		given().get("/coins?skip=0&limit=5&currency=EUR").then().statusCode(200).body("coins[2].name",
				equalTo("Tether"));

	}
}
