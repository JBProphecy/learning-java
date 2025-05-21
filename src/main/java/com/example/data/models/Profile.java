package com.example.data.models;

import java.util.UUID;

public class Profile
{
  private final UUID id;
  private final String name;
  private final String username;
  private final String password;
  private final UUID accountID;

  private Profile(UUID id, String name, String username, String password, UUID accountID) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
    this.accountID = accountID;
  }

  public static Profile generate(String name, String username, String password, UUID accountID) {
    return new Profile(UUID.randomUUID(), name, username, password, accountID);
  }

  public static Profile construct(UUID id, String name, String username, String password, UUID accountID) {
    return new Profile(id, name, username, password, accountID);
  }

  public UUID getID() { return this.id; }
  public String getName() { return this.name; }
  public String getUsername() { return this.username; }
  public String getPassword() { return this.password; }
  public UUID getAccountID() { return this.accountID; }

  @Override
  public String toString() {
    return
      "Profile{" +
      "id='" + this.id + "', " +
      "name='" + this.name + "'}";
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) { return true; }
    if (object == null || this.getClass() != object.getClass()) { return false; }
    Profile profile = (Profile) object;
    return this.id.equals(profile.id);
  }

  @Override
  public int hashCode() { return this.id != null ? id.hashCode() : 0; }
}
