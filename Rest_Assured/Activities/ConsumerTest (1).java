package liveProject;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.head;
import static org.hamcrest.Matchers.equalTo;


@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
	
	// Set the headers
	Map<String, String> headers = new HashMap<String, String>();
	
	
	
	//Create the contract(Pact)
	@Pact(consumer = "UserConsumer", provider="userProvider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		
		//Set the headers
		headers.put("Content-Type","application/json");
		
		//Create the request and Response Body
		DslPart requestResponseBody = new PactDslJsonBody().
				numberType("id", 1234).
				stringType("firstName","Pavan").
				stringType("lastName","Chowdary").
				stringType("email","PavanChowdary@gmail.com");
		
		
		//Create the contract
		return builder.given("POST Request").
				uponReceiving("request to create user").
					method("POST").
					path("/api/users").
					headers(headers).
					body(requestResponseBody).
				willRespondWith().
					status(201).
					body(requestResponseBody).
				toPact();
		
	}

	
	
/*	@Pact(consumer = "userConsumer", provider="userProvider")
	public RequestResponsePact createGetPact(PactDslWithProvider builder) {
		
		//Set the headers
		headers.put("Content-Type","Application/json");
		
		//Create the request and Response Body
		
		
		
		//Create the contract
		return builder.given("GET Request").
				uponReceiving("request to GET user details").
					method("GET").
					headers(headers).					
					pathFromProviderState("/api/users/{userid}", "/api/users/19")
				willRespondWith().
					status(201).
					body(ResponseBody).
				toPact();
		
	}*/
	
	
	
	//consumer test with mock provider
	@Test
	@PactTestFor(providerName="userProvider", port="8282")
	public void postRequestTest() {
		//Create a request body
		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id", 1);
		reqBody.put("firstName","PAVANKUMAR");
		reqBody.put("lastName","Chowdary");
		reqBody.put("email","PAVANKUMARChowdary@gmail.com");
		//send a request, get response, assert response
		given().
			baseUri("http://localhost:8282/api/users").
			headers(headers).
			body(reqBody).log().all().
		when().
			post().	
		then().
			statusCode(201).
			body("id", equalTo(1234)).
		   	log().all();
		
	}




	

}
