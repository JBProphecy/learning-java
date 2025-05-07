package com.example.persistence.models;

public class Account {
  private String id;
  private String name;
  private String email;
  private String password;

  // Constructor
  public Account(String id, String name, String email, String password) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  // Getters
  public String getID() { return this.id; }
  public String getName() { return this.name; }
  public String getEmail() { return this.email; }
  public String getPassword() { return this.password; }

  // Setters
  public void setID(String id) { this.id = id; }
  public void setName(String name) { this.name = name; }
  public void setEmail(String email) { this.email = email; }
  public void setPassword(String password) { this.password = password; }

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
