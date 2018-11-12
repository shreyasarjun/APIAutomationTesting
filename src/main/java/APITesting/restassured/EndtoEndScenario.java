package APITesting.restassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.sun.javafx.binding.SelectBinding.AsString;

import APITesting.restassured.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import sun.util.logging.resources.logging;


public class EndtoEndScenario extends ReusableMethods {
	
	// This test case covers post,grab the response and perform delete operation\
	
	@Test
	public void endtoend() throws Exception
	{
		readpropertyfile();
		System.out.println(prop.getProperty("HOST"));
		System.out.println(prop.getProperty("KEY"));
		RestAssured.baseURI=prop.getProperty("HOST");
		
		
		Response res=given().
				queryParam("key",prop.getProperty("KEY")).
				body(ReusableMethods.GenerateStringFRomResource("C:\\APITesting\\restassured\\src\\test\\java\\APITesting\\restassured\\PostRequest.json")).
				
				
		when().
				post(Resources.postRes()).
		
		then().
				assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
				body("status",equalTo("OK")).
		
		extract().response();
		        JsonPath js=ReusableMethods.rawtoJSON(res);
				String placeid=js.get("place_id");
				System.out.println(placeid);
				
		given().
				queryParam("key",prop.getProperty("KEY")).
				body("{"+
						  "\"place_id\": \""+placeid+"\""+
						"}").
		when().
				post(Resources.deleteRes()).
		then().
				assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK"));
		
	}
	
	


}
