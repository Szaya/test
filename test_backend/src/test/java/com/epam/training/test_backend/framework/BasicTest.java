package com.epam.training.test_backend.framework;

import com.epam.training.test_backend.endpointactions.Authorization;
import com.epam.training.test_backend.model.RegistrationRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;

public abstract class BasicTest {

  private static final Logger logger = LogManager.getLogger("com.epam.training.test_backend.framework.BasicTest");

  public static final int BALANCE = 16000;
  public static final String HUF_CURRENCY = "HUF";
  public static final String TEST_NAME = "testName";
  public static final String ID = "id";
  public static final String password = "Secret1234";

  public static String userName;
  public static String accountNumber;
  public static String sessionId;
  public static String userId;

  @BeforeClass
  public static void setup() {
    userName = RandomUtils.getRandomUserName();
    accountNumber = String.valueOf(RandomUtils.getRandomAccountNumber());

    RegistrationRequest userRegistration = new RegistrationRequest.Builder().withAccountNumber(accountNumber)
        .withBalance(String.valueOf(BALANCE)).withCurrency(HUF_CURRENCY).withName(TEST_NAME).withPassword(password)
        .withUserName(userName).build();

    Response registrationResponse = Authorization.registration(userRegistration);
    userId = registrationResponse.jsonPath().getString(ID);

    logger.info("The registration is successfully executed. Username: {}, password: {}", userName, password);

    Response loginResult = Authorization.login(userName, password);

    sessionId = loginResult.sessionId();
  }

  static {
    RestAssured.baseURI = "http://localhost:8080/sportsbetting-web/";
  }

}
