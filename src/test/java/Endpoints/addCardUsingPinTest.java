package Endpoints;
import io.restassured.RestAssured;
//import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

//import io.restassured.response.Response;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
//import ResponseCodeValidator.ResponseGetSamantha;
import java.io.IOException;
import java.util.Properties;

//import org.testng.Assert;
//import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import Payloads.AddCard3DSecurePayload;
import Payloads.AddCardWithPinPayload;
//import Payloads.AddCardPayload;
import Payloads.Login3DPayload;
//import Payloads.CreateClusterPayload;
//import Payloads.LoginPayload;
//import Resources.AddCardResource;
import Resources.AddCardWithPinResource;
//import Payloads.UpdateClusterPayload;
//import Resources.AllClustersResource;
//import Resources.DeleteClustersResource;
//import Resources.DeleteClustersResource;
//import Resources.HsBoxResource;
import Resources.LoginResource;




public class addCardUsingPinTest {
	
	
   // Open the environment properties file
	Properties prop = new Properties();
	@BeforeTest 
	public void getData () throws IOException {
		 FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Environment\\enviro.properties");
        prop.load(fis);
	}

	
	
	
	// This test is to ensure that a cluster can be created and deleted.
	
	@Test

	public void addCardWithPin ()  {
				
// Open the baseURL		
RestAssured.baseURI = prop.getProperty("BaseURL");

	Response res =	given().
				
		
	//Input the header
		header("Content-Type", "application/json").
		
	//Input the Login Payload
		body(Login3DPayload.LoginDetails()).
		

		when().
		
		//Input the resource
		post(LoginResource.Login()).
		
		//Run an assertion
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		
	
		
		//extract response of body
		extract().response();
	
	
	//Display the response body
	
	String responseString = res.asString();
	System.out.println(responseString);
	
	//Extract bearer token
JsonPath js = new JsonPath(responseString);
	
	String token = js.get("token");
	
	System.out.println(token);
	
	
	
	//Open the Add 3D Card endpoint
	RestAssured.baseURI = prop.getProperty("BaseURL");
	
	Response res1 =	given().
			
			//authenticate the bearer token
			auth().oauth2(token).
			
			header("Content-Type", "application/json").
			
			//Insert payload
			
			body(AddCardWithPinPayload.CardDetails()).
			

			when().
			
			//Input the resource
			
			post(AddCardWithPinResource.Card()).
			
			//Run the assertion
			
			then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
			
			body("message", equalTo("V-COMP")).and().
			
			extract().response();
		
		
		//Display the response body
		
		String responseString2 = res1.asString();
		System.out.println(responseString2);
		
		
	
	}

}
