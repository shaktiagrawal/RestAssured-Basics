package runner;

import org.json.simple.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestRunner {
	@Test
	public void Test() {
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification request = RestAssured.given();
//Get Request
		given().
		param("page", "2").
		when().get("api/users").then().assertThat().statusCode(200);


		String status = given().
				param("page", "2").
				when().get("api/users").body().asString();
		System.out.println(status);

//Post Request
		JSONObject requestParam = new JSONObject();
		requestParam.put("name", "Shakt");
		requestParam.put("Job", "MD");
		request.body(requestParam.toJSONString());
		Response response = request.post("api/users");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		System.out.println(response.body().asString());

	}
}
