package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetPostExamples {
	
	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George", "Rachel"));
	}
	
	@Test
	public void testPost() {
		
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "Teacher");
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201);
	}

}
