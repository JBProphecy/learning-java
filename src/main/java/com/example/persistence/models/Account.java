package com.example.persistence.models;

import java.util.UUID;

public class Account
{
  private final UUID id;
  private final String name;
  private final String email;
  private final String password;

  private Account(UUID id, String name, String email, String password) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public static Account generate(String name, String email, String password) {
    return new Account(UUID.randomUUID(), name, email, password);
  }
  
  public static Account construct(UUID id, String name, String email, String password) {
    return new Account(id, name, email, password);
  }

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
