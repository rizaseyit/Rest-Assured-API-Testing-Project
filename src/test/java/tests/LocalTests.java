package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class LocalTests {

	@Test
	public void getTest() {

		baseURI = "http://localhost:3000";

		given().get("/users").then().statusCode(200).log().all();
	}

	@Test
	public void postTest() {

		JSONObject postReq = new JSONObject();

		postReq.put("firstName", "Mark");
		postReq.put("lastName", "Markus");

		baseURI = "http://localhost:3000";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(postReq.toJSONString()).when()
				.post("/users").then().statusCode(201).log().all();

	}

	@Test
	public void putTest() {

		JSONObject putReq = new JSONObject();

		putReq.put("firstName", "Nils");
		putReq.put("lastName", "Müller");
		putReq.put("groupId", 2);

		baseURI = "http://localhost:3000";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(putReq.toJSONString()).when()
				.put("/users/4").then().statusCode(200).log().all();
	}

	@Test
	public void patchTest() {

		JSONObject patchReq = new JSONObject();

		patchReq.put("firstName", "Bert");

		baseURI = "http://localhost:3000";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(patchReq.toJSONString()).when()
				.patch("/users/3").then().statusCode(200).log().all();
	}

	public void deleteTest() {

		baseURI = "http://localhost:3000";

		when().delete("users/4").then().statusCode(200);

	}
}
