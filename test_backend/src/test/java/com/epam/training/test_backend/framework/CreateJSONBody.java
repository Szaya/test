package com.epam.training.test_backend.framework;

import com.google.gson.GsonBuilder;

public class CreateJSONBody {

  public String createJSONBody() {
    return (new GsonBuilder()).create().toJson(this);
  }

  public String createJSONBodyWithNulls() {
    return (new GsonBuilder()).serializeNulls().create().toJson(this);
  }

}
