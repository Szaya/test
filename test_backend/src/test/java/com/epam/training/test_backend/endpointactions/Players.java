package com.epam.training.test_backend.endpointactions;

import static io.restassured.RestAssured.given;

import com.epam.training.test_backend.model.Player;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Players {

  private static final Logger logger = LogManager.getLogger("com.epam.training.test_backend.endpointactions.Players");

  private static final String PLAYERS_ENDPOINT = "players/{id}";
  private static final String UPDATE_PLAYER_ENDPOINT = "updatePlayer";

  /**
   * Gets the player by id.
   *
   * @param id the id
   * @return the player by id
   */
  public static Response getPlayerById(String id, String sessionId) {
    logger.info("GET {} {}", PLAYERS_ENDPOINT, id);
    return given().contentType(ContentType.JSON).sessionId(sessionId).pathParam("id", id).get(PLAYERS_ENDPOINT)
    	.then().statusCode(200).extract().response();
  }

  /**
   * Updates player.
   *
   * @param player the player
   * @return the response
   */
  // should be made by students
  public static Response updatePlayer(Player player, String sessionId) {
    logger.info("POST {} {}", UPDATE_PLAYER_ENDPOINT, player.createJSONBodyWithNulls());
    //here comes the restAssured solution to update the player
    return null;
  }

}
