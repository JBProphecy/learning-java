package com.example.persistence.models;

import java.util.UUID;

public class Account
{
  private final UUID id;
  private final String name;
  private final String email;
  private final String password;

  // Constructor (generate ID)
  public Account(String name, String email, String password) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.email = email;
    this.password = password;
  }
  
  // Constructor (provide ID)
  public Account(UUID id, String name, String email, String password) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  // Getters
  public UUID getID() { return this.id; }
  public String getName() { return this.name; }
  public String getEmail() { return this.email; }
  public String getPassword() { return this.password; }

  @Override
  public String toString() {
    return
      "Account{" +
      "id='" + this.id + "', " +
      "name='" + this.name + "'}";
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
