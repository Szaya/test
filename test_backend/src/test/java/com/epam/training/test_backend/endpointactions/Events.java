package com.epam.training.test_backend.endpointactions;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

import io.restassured.response.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Events {

  private static final Logger logger = LogManager.getLogger("com.epam.training.test_backend.endpointactions.Events");

  private static final String LOAD_EVENTS_ENDPOINT = "loadEvents";
  private static final String LOAD_BETS_ENDPOINT = "loadBets";

  public static Response getEvents(String sessionId) {
    logger.info("GET {}", LOAD_EVENTS_ENDPOINT);
    return given().contentType(ContentType.JSON).sessionId(sessionId).get(LOAD_EVENTS_ENDPOINT)
    	.then().statusCode(200).extract().response();
  }

  public static Response getBetsByEventId(String eventId, String sessionId) {
    logger.info("POST {} {}", LOAD_BETS_ENDPOINT, eventId);
    return given().contentType(ContentType.URLENC).sessionId(sessionId).formParam("eventId", eventId).post(LOAD_BETS_ENDPOINT)
     .then().statusCode(200).extract().response();
  }

}
