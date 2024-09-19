package examples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.CoreMatchers.equalTo;


public class SpecificationTest {
	
	
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int petId;
	
	
	@BeforeClass
	public void setUp() {
		
		
		//Request Specification
		requestSpec = new RequestSpecBuilder().
				setBaseUri("https://petstore.swagger.io/v2/pet").
				addHeader("Content-Type","application/json").
				build();
				
			
		responseSpec = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectResponseTime(lessThanOrEqualTo(3000L)).
				build();
				
				
				
	
	}
	
	@Test(priority =1)
	public void postRequest() {
		//Create request body
		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id", 772234);
		reqBody.put("name", "Pavan");
		reqBody.put("status", "alive");
		
		//Send request, save response
		Response response = given().
								spec(requestSpec).
								body(reqBody).
								log().all().
							when().
								post();
		
		//Extract the pet id
		petId = response.then().extract().path("id");
		
		//Assertion
		response.then().
					spec(responseSpec).
					body("status", equalTo("alive")).
					log().all();
		
	}
	
	
    @Test(priority=2)
	public void getRequest() {
		
		given().spec(requestSpec).pathParam("petId", petId).log().all().when().get("/{petId}").then().spec(responseSpec).body("status",equalTo("alive")).log().all();
	}
	
    @Test(priority=3)
	public void deleteRequest() {
		
		given().spec(requestSpec).pathParam("petId", petId).log().all().when().delete("/{petId}").then().spec(responseSpec).body("message", equalTo(""+petId)).log().all();
	}
	
	
	
//	POST https://petstore.swagger.io/v2/pet
//		GET https://petstore.swagger.io/v2/pet/{petId}
//		DELETE https://petstore.swagger.io/v2/pet/{petId}
	
	
}
