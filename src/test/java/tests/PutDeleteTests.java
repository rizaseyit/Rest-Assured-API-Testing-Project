package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutDeleteTests {

	@Test
	public void putTest() {
		Map<String, Object> myMap = new HashMap<String, Object>();

		JSONObject postReq = new JSONObject(myMap);

		postReq.put("name", "Jerry");
		postReq.put("id", "555");

		System.out.println(postReq.toJSONString());

		baseURI = "https://reqres.in/api";

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(postReq.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();
	}

	@Test
	public void deleteTest() {

		baseURI = "https://reqres.in/api";

		when().delete("/users/2").then().statusCode(204).log().all();
	}

}
