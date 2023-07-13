package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestsOnLocalAPI {

	@Test
	public void get() {
		
		baseURI = "http://localhost:3000/";
		
		given().
			get("/users").
		then().
			statusCode(200).
			log().
			all();
	}
	
	@Test
	public void post() {
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("firstName", "Pooja");
		jsonObject.put("lastName", "Barot");
		jsonObject.put("subjectID", 1);
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(jsonObject.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().
			all();
	}
	
	@Test
	public void put() {
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("firstName", "Ketki");
		jsonObject.put("lastName", "Barot");
		jsonObject.put("subjectID", 1);
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(jsonObject.toJSONString()).
		when().
			put("/users/4").
		then().
			statusCode(200).
			log().
			all();
	}
	
	@Test
	public void patch() {
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("lastName", "Brahmbhatt");
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(jsonObject.toJSONString()).
		when().
			patch("/users/5").
		then().
			statusCode(200).
			log().
			all();
	}
	
	@Test
	public void delete() {
		
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/6").
		then().
			statusCode(200).
			log().
			all();
	}
}
