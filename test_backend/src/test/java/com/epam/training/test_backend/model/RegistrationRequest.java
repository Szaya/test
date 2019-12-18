package com.epam.training.test_backend.model;

import com.epam.training.test_backend.framework.CreateJSONBody;

public class RegistrationRequest extends CreateJSONBody {

  private String accountNumber;
  private String balance;
  private String currency;
  private String dateOfBirth;
  private String name;
  private String password;
  private String userName;

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getBalance() {
    return balance;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  private RegistrationRequest() {

  }

  public static class Builder {

    private String accountNumber;
    private String balance;
    private String currency;
    private String dateOfBirth;
    private String name;
    private String password;
    private String userName;

    public Builder withAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
      return this;
    }

    public Builder withBalance(String balance) {
      this.balance = balance;
      return this;
    }

    public Builder withDateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withPassword(String password) {
      this.password = password;
      return this;
    }

    public Builder withUserName(String userName) {
      this.userName = userName;
      return this;
    }

    public Builder withCurrency(String currency) {
      this.currency = currency;
      return this;
    }

    /**
     * Builds the request.
     *
     * @return the registration request
     */
    public RegistrationRequest build() {
      RegistrationRequest request = new RegistrationRequest();
      request.accountNumber = this.accountNumber;
      request.balance = this.balance;
      request.currency = this.currency;
      request.dateOfBirth = this.dateOfBirth;
      request.name = this.name;
      request.password = this.password;
      request.userName = this.userName;

      return request;
    }

  }

}
