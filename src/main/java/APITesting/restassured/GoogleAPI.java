package APITesting.restassured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GoogleAPI {
	
	
	@BeforeClass
	public void setup()
	{
		RestAssured.baseURI="https://maps.googleapis.com/";
	}
	
	@Test
	public void firstapitest()
	{
		given().
				param("location","-33.8670522,151.1957362").
				param("radius","500").
				param("key","AIzaSyDhW22stNMNNRF1Xr5GL2XfRky965ixImc").
				
		when().
				get("maps/api/place/nearbysearch/json").
				
		then().
				assertThat().statusCode(200).and().
				contentType(ContentType.JSON).and().
				header("x-frame-options","SAMEORIGIN").and().
				body("results[0].name",equalTo("Sydney"));
		
		
	}

}
