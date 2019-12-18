package com.epam.training.test_backend.model;

import com.epam.training.test_backend.framework.CreateJSONBody;

public class Player extends CreateJSONBody {

  private Integer id;
  private String username;
  private String password;
  private String name;
  private String accountNumber;
  private String dateOfBirth;
  private Integer balance = 0;
  private String currency;
  private Integer version = 0;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return username;
  }

  public void setUserName(String userName) {
    this.username = userName;
  }
  
  public String getPassword() {
    return username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getBalance() {
    return balance;
  }

  public void setBalance(Integer balance) {
    this.balance = balance;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  private Player() {

  }

  public static class Builder {

    private Integer id;
    private String userName;
    private String password;
    private String name;
    private String accountNumber;
    private String dateOfBirth;
    private Integer balance = 0;
    private String currency;
    private Integer version = 0;

    public Builder(int id) {
      this.id = id;
    }

    public Builder withUserName(String userName) {
      this.userName = userName;
      return this;
    }

    public Builder withPassword(String password) {
      this.password = password;
      return this;
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
      return this;
    }

    public Builder withDateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    public Builder withBalance(int balance) {
      this.balance = balance;
      return this;
    }

    public Builder withCurrency(String currency) {
      this.currency = currency;
      return this;
    }

    public Builder withVersion(int version) {
      this.version = version;
      return this;
    }

    /**
     * Builds the player.
     *
     * @return the player
     */
    public Player build() {
      Player player = new Player();
      player.id = this.id;
      player.username = this.userName;
      player.password = this.password;
      player.name = this.name;
      player.accountNumber = this.accountNumber;
      player.dateOfBirth = this.dateOfBirth;
      player.balance = this.balance;
      player.currency = this.currency;
      player.version = this.version;

      return player;
    }

  }

}
