package com.epam.training.test_backend.model;

import com.epam.training.test_backend.framework.CreateJSONBody;

public class Bet extends CreateJSONBody {
    private Integer id;
    private String description;
    private String type;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
    
    
  public static class Builder {
    private Integer id;
    private String description;
    private String type;

    public Builder(int id) {
      this.id = id;
    }

    public Builder withDescription(String description) {
      this.description = description;
      return this;
    }

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public Bet build() {
      Bet bet = new Bet();
      bet.id = this.id;
      bet.description = this.description;
      bet.type = this.type;

      return bet;
    }

  }
}
