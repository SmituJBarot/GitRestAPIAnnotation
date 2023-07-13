package tests;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC003 {

	//PUT, PATCH & DELETE Examples
	
	@Test
	public void testForPUT() {
		
		JSONObject jsonObject = new JSONObject();
		System.out.println(jsonObject);
		
		jsonObject.put("name", "Jaldip");
		jsonObject.put("Job", "Engineer");
		
		baseURI = "https://reqres.in/api";
		
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON)
		.accept(ContentType.JSON).
		body(jsonObject.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void testForPATCH() {
		
		JSONObject jsonObject = new JSONObject();
		System.out.println(jsonObject);
		
		jsonObject.put("name", "Chandrika");
		jsonObject.put("Job", "Labour Contractor");
		
		baseURI = "https://reqres.in";
		
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON)
		.accept(ContentType.JSON).
		body(jsonObject.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void testForDELETE() {
		
		baseURI = "https://reqres.in";
		
		when().
			delete("/api/users/2").
		then().
			statusCode(204).
			log().all();
	}
}
