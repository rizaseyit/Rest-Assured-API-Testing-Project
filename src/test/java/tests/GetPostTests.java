package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetPostTests {

	@Test
	public void test_GET() {

		baseURI = "https://api.restful-api.dev";

		given().get("/objects").then().statusCode(200).body("id", hasItems("1", "3"));

	}

	@Test
	public void test_POST() {

		Map<String, Object> myMap = new HashMap<String, Object>();

		JSONObject postReq = new JSONObject(myMap);

		postReq.put("name", "Jerry");
		postReq.put("id", "555");

		System.out.println(postReq.toJSONString());

		baseURI = "https://reqres.in/api";

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(postReq.toJSONString()).when().post("/users").then().statusCode(201).log().all();

	}
}
