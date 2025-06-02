package com.example.persistence.models;

import java.util.UUID;

import com.example.utils.Base62;

public class Account
{
  // INSTANCE VARIABLES
  private String id;
  private String name;
  private String email;
  private String password;

  /**
   * private constructor for the Account class
   * @param id the id for an account
   * @param name the name for an account
   * @param email the email for an account
   * @param password the password for an account
   */
  private Account(
    String id,
    String name,
    String email,
    String password
  ) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  /**
   * public constructor to create a new account and generate an id
   * @param name the name for an account
   * @param email the email for an account
   * @param password the password for an account
   * @return an instance of the Account class
   */
  public static Account generate(
    String name,
    String email,
    String password
  ) {
    return new Account(Base62.encode(UUID.randomUUID()), name, email, password);
  }

  /**
   * public constructor to load an existing account from the database
   * @param id the id for an account
   * @param name the name for an account
   * @param email the email for an account
   * @param password the password for an account
   * @return an instance of the Account class
   */
  public static Account construct(
    String id,
    String name,
    String email,
    String password
  ) {
    return new Account(id, name, email, password);
  }

  // GETTER METHODS
  public String getID() { return this.id; }
  public String getName() { return this.name; }
  public String getEmail() { return this.email; }
  public String getPassword() { return this.password; }

  @Override
  public String toString() {
    return
      "Account{" +
      "id='" + this.id + "', " +
      "name='" + this.name + "'}"
    ;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) { return true; }
    if (object == null || this.getClass() != object.getClass()) { return false; }
    Account account = (Account) object;
    return this.id.equals(account.id);
  }

  @Override
  public int hashCode() { return this.id != null ? id.hashCode() : 0; }
}
