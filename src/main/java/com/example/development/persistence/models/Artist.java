package com.example.development.persistence.models;

public class Artist
{
  // INSTANCE VARIABLES
  private final String id;
  private final String name;
  private final String username;

  /**
   * private constructor for the Artist class
   * @param id the id for an artist
   * @param name the name for an artist
   * @param username the username for an artist
   */
  private Artist(
    String id,
    String name,
    String username
  ) {
    this.id = id;
    this.name = name;
    this.username = username;
  }

  /**
   * public constructor to load an existing artist from the database
   * @param id the id for an artist
   * @param name the name for an artist
   * @param username the username for an artist
   * @return an instance of the Artist class
   */
  public static Artist construct(
    String id,
    String name,
    String username
  ) {
    return new Artist(id, name, username);
  }

  // GETTER METHODS
  public String getID() { return this.id; }
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
