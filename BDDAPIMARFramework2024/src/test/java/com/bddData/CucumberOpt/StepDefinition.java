package com.bddData.CucumberOpt;

import java.util.ArrayList;
import java.util.List;

import com.bddData.resources.TestDataBuild;
import com.bddData.resources.Utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class StepDefinition extends Utils {

	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	TestDataBuild data = new TestDataBuild();

	@Given("Add place payload")
	public void add_place_payload() {

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		res = given().spec(requestSpecification()).body(data.addPlacePayload());
	}

	@When("Usercalls {string} with post request")
	public void usercalls_with_post_request(String string) {
		response = res.when().post("/maps/api/place/add/json").then().spec(resspec).extract().response();
	}

	@Then("User should get api response call with status code {int}")
	public void user_should_get_api_response_call_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
		
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expValue) {
		String responseString = response.asString();
		JsonPath js = new JsonPath(responseString);
		assertEquals(js.get(keyValue).toString(), expValue);
		System.out.println(responseString);
	}
}
