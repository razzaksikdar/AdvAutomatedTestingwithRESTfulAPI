package com.qa.PostmanOmdb;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class TestSuit {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	@Test
	public void exampleRestTestWhichShould200() {
	    RestAssured.given()
	    .contentType(ContentType.JSON)
	    .when()
	        .get("http://www.omdbapi.com/?apikey=e78cd603&t=IT&Y=2017")
	    .then().body("Rated", equalTo("R"));
	    
	    request = RestAssured.given().contentType(ContentType.JSON);
	    response = request.when().get("http://www.omdbapi.com/?apikey=e78cd603&t=IT&Y=2017");
	    System.out.println(response.prettyPrint());
	    
	}

	@Test
	public void checkFilmTitle() {
		
	   RestAssured.given()
	    .contentType(ContentType.JSON)
	    .when()
	        .get("http://www.omdbapi.com/?apikey=e78cd603&t=IT&Y=2017")
	    .then().body("Title", equalTo("It"));
	   
	   
	}
	

	
}
