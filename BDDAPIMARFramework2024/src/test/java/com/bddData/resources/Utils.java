package com.bddData.resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
	//RequestSpecification req;


	public RequestSpecification requestSpecification() throws Exception {

		//if (req == null) {

			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			//RestAssured.baseURI = "https://rahulshettyacademy.com";
			//getGlobalValue("baseURL")
			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
			return req;
//		}
//		return req;
	}

	public static String getGlobalValue(String key) throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\bddData\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}

}
