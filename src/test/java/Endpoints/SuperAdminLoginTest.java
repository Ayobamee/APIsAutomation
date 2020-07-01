package Endpoints;
import io.restassured.RestAssured;
//import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;

//import io.restassured.response.Response;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
//import ResponseCodeValidator.ResponseGetSamantha;
import java.io.IOException;
import java.util.Properties;

//import org.testng.Assert;
//import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import Payloads.AddCardPayload;
//import Payloads.CreateClusterPayload;
//import Payloads.LoginPayload;
import Payloads.SuperAdmnLoginPayload;
//import Resources.AddCardResource;
//import Payloads.UpdateClusterPayload;
//import Resources.AllClustersResource;
//import Resources.DeleteClustersResource;
//import Resources.DeleteClustersResource;
//import Resources.HsBoxResource;
//import Resources.LoginResource;
import Resources.SuperAdminLoginResource;




public class SuperAdminLoginTest {
	
	
   // Open the environment properties file
	Properties prop = new Properties();
	@BeforeTest 
	public void getData () throws IOException {
		 FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Environment\\enviro.properties");
        prop.load(fis);
	}

	
	
	
	// This test is to ensure that a cluster can be created and deleted.
	
	@Test

	public void SuperAdminLogin ()  {
				
// Open the baseURL		
RestAssured.baseURI = prop.getProperty("BaseURL");

	Response res =	given().
				
		
	//Input the header
		header("Content-Type", "application/json").
		
	//Input the Login Payload
		body(SuperAdmnLoginPayload.SuperAdLoginDetails()).
		

		when().
		
		//Input the resource
		post(SuperAdminLoginResource.SuperAdLogin()).
		
		//Run an assertion
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		
	
		
		//extract response of body
		extract().response();
	
	
	//Display the response body
	
	String responseString = res.asString();
	System.out.println(responseString);
	


	
	}

}
