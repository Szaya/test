package com.epam.training.test_backend.endpointactions;

import static io.restassured.RestAssured.given;

import com.epam.training.test_backend.model.RegistrationRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Authorization {

  private static final Logger logger = LogManager
      .getLogger("com.epam.training.test_backend.endpointactions.Authorization");

  private static final String REGISTRATION_ENDPOINT = "registration";
  private static final String LOGIN_ENDPOINT = "login";

  private static final String USERNAME = "username";
  private static final String PASSWORD = "password";

  /**
   * Registers.
   *
   * @param request the request
   * @return the response
   */
  public static Response registration(RegistrationRequest request) {
    logger.info("POST {} {}", REGISTRATION_ENDPOINT, request.createJSONBodyWithNulls());
    return given().contentType(ContentType.JSON).body(request).post(REGISTRATION_ENDPOINT).then().statusCode(200)
        .extract().response();
  }

  /**
   * Logins.
   *
   * @param userName the user name
   * @param password the password
   * @return the response
   */
  public static Response login(String userName, String password) {
    logger.info("POST {} {} {}", LOGIN_ENDPOINT, userName, password);
    return given().params(USERNAME, userName, PASSWORD, password).post(LOGIN_ENDPOINT)
        .then().statusCode(302).extract().response();
  }

}
