package test.testtAPI;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private final String BASE_URL = "http:................";
	private Response response;
	private JsonPath jPath = null;
	
	
	@Given("set endpoint to url and call API with Get http request")
	public void getCalltoURL() throws URISyntaxException {
	System.out.println("&&&&&&&&&&&&&&&");
	//RestAssured.baseURI = BASE_URL;
	response = RestAssured.given().given().when().get(new URI("https://63d348c98d4e68c14ea88c57.mockapi.io/todos"));
	
	jPath = new JsonPath(response.asString());
	
	System.out.println("RESPONSE BODY : " + response.asPrettyString());
	
	System.out.println("**********************");
	
	
	
	}

	@Then("the API call is success with statusCode")
	public void validateStatusCode (){
	Assert.assertEquals("Status code is not validate as expected", 200, response.then().extract().statusCode());
	
	jPath = new JsonPath(response.asString());
	
	//get value of last name in 3 object 
    String country= jPath.get("todo[1]");
    System.out.println("^^^^^^^^^^^^^^   Second Country : " + country);
    
	
	}
	
	@Then("validate the total number of ids as 10")
	public void numberOfIDs() {
		List<String> idList = jPath.get("id");
		
		Assert.assertEquals(10, idList.size());
		System.out.println("############     ID LIST SIZE : " + idList.size());
		
		List<Map<String, Object>> mapList = response.as(List.class);
		
		for(int i=0; i<mapList.size(); i++) {
			System.out.println("________________________________      MAP ( " + i + ") : " + mapList.get(i));
			
			
			if (mapList.get(i).get("id").toString().equals("1")) {
			Map<String, Object> map = mapList.get(i);
			System.out.println("############     FIRST MAP : " + map.toString());
			System.out.println("%%%%%%%%%%%%%%    FIRST MAP TODO : " + map.get("todo").toString());
			}
		}
		
		
	}
}
