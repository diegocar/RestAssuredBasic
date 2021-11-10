package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutPatchDeleteExamples {
	
	@Test
	public void testPut() {
		
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200);		
	}
	
	@Test
	public void testPatch() {
		
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/2").
		then().
			statusCode(200);		
	}
	
	@Test
	public void testDelete() {
		
		baseURI = "https://reqres.in/api";			
		when().
			delete("/users/2").
		then().
			statusCode(204);		
	}
}
