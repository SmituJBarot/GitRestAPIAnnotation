package tests;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC002 {

	//GET & POST Test Examples
	
	@Test
	public void testForGET() {
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			body("data[4].first_name", equalTo("George")).
		body("data.first_name", hasItems("George", "Rachel")).log().all();
	}
	
	@Test
	public void testForPOST() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Smitu");
		map.put("Job", "QA Testing");
		
		System.out.println(map);
		
		JSONObject jsonObject = new JSONObject(map);
		System.out.println(jsonObject);
		
		baseURI = "https://reqres.in/api";
		
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON)
		.accept(ContentType.JSON).
		body(jsonObject.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
}
