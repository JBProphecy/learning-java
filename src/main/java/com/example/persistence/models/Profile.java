package com.example.persistence.models;

import java.util.UUID;

public class Profile
{
  private final UUID id;
  private final String name;
  private final String username;
  private final String password;

  // Constructor (generate ID)
  public Profile(String name, String username, String password) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.username = username;
    this.password = password;
  }

  // Constructor (provide ID)
  public Profile(UUID id, String name, String username, String password) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
  }

  // Getters
  public UUID getID() { return this.id; }
  public String getName() { return this.name; }
  public String getUsername() { return this.username; }
  public String getPassword() { return this.password; }

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
