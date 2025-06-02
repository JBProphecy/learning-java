package com.example.persistence.models;

import java.util.UUID;

import com.example.utils.Base62;

public class Profile
{
  // INSTANCE VARIABLES
  private final String id;
  private final String name;
  private final String username;
  private final String password;
  private final String accountID;
  private final String profilePictureURL;

  /**
   * private constructor for the Profile class
   * @param id the id for a profile
   * @param name the name for a profile
   * @param username the username for a profile
   * @param password the password for a profile
   * @param accountID the account ID for a profile
   */
  private Profile(
    String id,
    String name,
    String username,
    String password,
    String accountID,
    String profilePictureURL
  ) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
    this.accountID = accountID;
    this.profilePictureURL = profilePictureURL;
  }

  /**
   * public constructor to create a new profile and generate an ID
   * @param name the name for a profile
   * @param username the username for a profile
   * @param password the password for a profile
   * @param accountID the account ID for a profile
   * @return an instance of the Profile class
   */
  public static Profile generate(
    String name,
    String username,
    String password,
    String accountID,
    String profilePictureURL
  ) {
    return new Profile(Base62.encode(UUID.randomUUID()), name, username, password, accountID, profilePictureURL);
  }

  /**
   * public constructor to load an existing profile from the database
   * @param id the id for a profile
   * @param name the name for a profile
   * @param username the username for a profile
   * @param password the password for a profile
   * @param accountID the account ID for a profile
   * @return an instance of the Profile class
   */
  public static Profile construct(
    String id,
    String name,
    String username,
    String password,
    String accountID,
    String profilePictureURL
  ) {
    return new Profile(id, name, username, password, accountID, profilePictureURL);
  }

  // GETTER METHODS
  public String getID() { return this.id; }
  public String getName() { return this.name; }
  public String getUsername() { return this.username; }
  public String getPassword() { return this.password; }
  public String getAccountID() { return this.accountID; }
  public String getProfilePictureURL() { return this.profilePictureURL; }

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
