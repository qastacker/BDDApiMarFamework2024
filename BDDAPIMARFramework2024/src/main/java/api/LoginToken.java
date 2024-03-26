package api;

import java.util.HashMap;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class LoginToken {

	public static String getToken() {

		RestAssured.baseURI = "https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token";
		HashMap<String, Object> ul = new HashMap<String, Object>();
		ul.put("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com");
		ul.put("client_secret", "erZOWM9g3UtwNRj340YYaK_W");
		ul.put("grant_type", "client_credentials");
		ul.put("scope", "trust");

		String response = given().params(ul).when().log().all().post().asString();
		System.out.println(response);
		JsonPath jsonPath = new JsonPath(response);
		String accessToken = jsonPath.getString("access_token");

		return accessToken;

	}
	
//	public static void main(String[] args) {
//		System.out.println(getToken());
//	}
}
