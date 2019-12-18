package com.epam.training.test_backend.framework;

import java.util.Random;
import java.util.UUID;

public class RandomUtils {

  private RandomUtils() {
    throw new UnsupportedOperationException("This is a Util class!");
  }

  public static String getRandomUserName() {
    return ("testName-" + UUID.randomUUID().toString().replaceAll("-", "")).toLowerCase();
  }

  public static int getRandomAccountNumber() {
    return new Random().nextInt(900000);
  }

}
