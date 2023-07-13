package tests;

import org.testng.Assert;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


public class TC001 {
	
	//GET Test Examples
	
	@Test
	public void getTest() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Not get status code 200");
	}
	
	@Test
	public void getTestwithRestAPISite() {
		baseURI = "https://reqres.in";
		given().
		get("api/users?page=2").
		then().
		statusCode(200).
		body("data.id[1]", equalTo(8))
		.log().all();
	}
}
