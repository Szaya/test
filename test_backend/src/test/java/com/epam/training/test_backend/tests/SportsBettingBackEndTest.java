package com.epam.training.test_backend.tests;

import static org.junit.Assert.assertEquals;

import com.epam.training.test_backend.endpointactions.Events;
import com.epam.training.test_backend.endpointactions.Players;
import com.epam.training.test_backend.framework.BasicTest;
import com.epam.training.test_backend.model.Bet;
import com.epam.training.test_backend.model.Event;
import com.epam.training.test_backend.model.Player;
import groovy.util.logging.Log;

import io.restassured.response.Response;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.skyscreamer.jsonassert.JSONAssert;

public class SportsBettingBackEndTest extends BasicTest {

  public void verifyUserRegistrationTest() throws JSONException {
    Response returnedPlayer = Players.getPlayerById(userId, sessionId);

    Player player = new Player.Builder(Integer.parseInt(userId)).withUserName(userName).withName(TEST_NAME)
        .withAccountNumber(accountNumber).withBalance(BALANCE).withCurrency(HUF_CURRENCY).withPassword(password).build();

    JSONAssert.assertEquals(player.createJSONBodyWithNulls(), returnedPlayer.asString(), true);
  }

  public void modifyUserTest() throws JSONException {
    Player player = new Player.Builder(Integer.parseInt(userId)).withUserName(userName).withName("modifiedNameHere") // modified
        .withAccountNumber(accountNumber).withBalance(42000) // modified
        .withPassword(password).withCurrency(HUF_CURRENCY).build();

    // update the player here!

    Response returnedPlayer = Players.getPlayerById(userId, sessionId);

    player.setVersion(player.getVersion() + 1);

    JSONAssert.assertEquals(player.createJSONBodyWithNulls(), returnedPlayer.asString(), true);
  }

  public void getEventsBetsTest() throws JSONException {
    int actualNumberOfBets = 0;
    int actualNumberOfEvents = 0;

    Response returnedEvents = Events.getEvents(sessionId);

    JSONArray events = new JSONArray(returnedEvents.asString());
    actualNumberOfEvents = events.length();
    
    assertEquals("There must be only one event!", 1, actualNumberOfEvents);

    JSONObject event = (JSONObject) events.get(0);
    String eventID = event.getString("id");
    Response returnedBets = Events.getBetsByEventId(eventID, sessionId);

    JSONArray bets = new JSONArray(returnedBets.asString());
    actualNumberOfBets = bets.length();
    
    assertEquals("There must be two bets!", 2, actualNumberOfBets);
  }

  private void getTime (Integer[] startTime, Integer[] endTime) {
    SimpleDateFormat formatter = new SimpleDateFormat("YYYY:MM:dd");
    String[] date = formatter.format(new Date()).split(":");
    for (int i = 0; i < date.length; i++){
        startTime[i] = Integer.parseInt(date[i]);
        endTime[i] = Integer.parseInt(date[i]);
    }
  }
  
  @Test
  public void homeworkTest  () throws JSONException {
    String title = "Fradi vs UTE";
    String type = "Football Match";
    Integer[] startTime = new Integer[3];
    Integer[] endTime = new Integer[3];
    getTime (startTime, endTime);
             
    Response returnedEvents = Events.getEvents(sessionId);

    Event controllEvent = new Event.Builder(2).
                                            withTitle(title).
                                            withType(type).
                                            withStart(startTime).
                                            withEnd(endTime).
                                            build();
    
    JSONArray events = new JSONArray(returnedEvents.asString());
    JSONObject eventObject = (JSONObject) events.get(0);
    
    
    assertEquals (controllEvent.getId().toString(), eventObject.get("id").toString());
    assertEquals (controllEvent.getTitle(), eventObject.get("title"));
    assertEquals (controllEvent.getType(), eventObject.get("type"));
    
    JSONArray eventStart = eventObject.getJSONArray ("start");
    JSONArray eventEnd = eventObject.getJSONArray ("end");
    Integer[] startController = controllEvent.getStart();
    Integer[] endController = controllEvent.getEnd();
    
    //Year
    assertEquals (startController[0].toString(), eventStart.get(0).toString());
    assertEquals (endController[0].toString(), eventEnd.get(0).toString());
        
    //Month  
    assertEquals (startController[1].toString(), eventStart.get(1).toString());
    assertEquals (endController[1].toString(), eventEnd.get(1).toString()); 
   
    //Day  
    assertEquals (startController[2].toString(), eventStart.get(2).toString());
    assertEquals (endController[2].toString(), eventEnd.get(2).toString());
    
    //check bets-----------------------------------------------------------------------------
    String[] IDs = {
        "15",
        "16"
    };
    String[] descriptions = {
        "Fradi Ute win bet",
        "Fradi Ute goals bet"
    };
    String[] types = {
        "Win bet",
        "All goals bet"
    };
    
    
    Response returnedBets = Events.getBetsByEventId(eventObject.getString("id"), sessionId);
    JSONArray bets = new JSONArray(returnedBets.asString());
    assertEquals (bets.length(), 2);
    
    for (int i = 0; i < bets.length(); ++i) {
        JSONObject firstbet = (JSONObject) bets.get(i);
        assertEquals ("Bet index: " + i, IDs[i], firstbet.getString("id"));
        assertEquals ("Bet index: " + i, descriptions[i], firstbet.getString("description"));
        assertEquals ("Bet index: " + i, types[i], firstbet.getString("type"));
    }
  }
}
