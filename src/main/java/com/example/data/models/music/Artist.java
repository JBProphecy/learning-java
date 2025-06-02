package com.example.data.models.music;

import java.util.UUID;

public class Artist
{
  // Instance Variables
  private final UUID id;
  private final String name;
  private final String username;

  /**
   * private constructor for the Artist class
   * @param id the id of an artist
   * @param name the name of an artist
   * @param username the username of an artist
   */
  private Artist(
    UUID id,
    String name,
    String username
  ) {
    this.id = id;
    this.name = name;
    this.username = username;
  }

  /**
   * public constructor for an existing artist
   * @param id the id of an artist
   * @param name the name of an artist
   * @param username the username of an artist
   * @return an instance of the Artist class
   */
  public static Artist construct(
    UUID id,
    String name,
    String username
  ) {
    return new Artist(id, name, username);
  }

  // Getter Methods
  public UUID getID() { return this.id; }
  public String getName() { return this.name; }
  public String getUsername() { return this.username; }

  @Override
  public String toString() {
    return
      "Artist{" +
      "id='" + this.id + "', " +
      "name='" + this.name + "', " +
      "username='" + this.username + "'}"
    ;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) { return true; }
    if (object == null || this.getClass() != object.getClass()) { return false; }
    Artist artist = (Artist) object;
    return this.id.equals(artist.id);
  }

  @Override
  public int hashCode() { return this.id != null ? id.hashCode() : 0; }
}
