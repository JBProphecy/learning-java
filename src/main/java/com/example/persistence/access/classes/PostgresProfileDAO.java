package com.example.persistence.access.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.persistence.access.interfaces.ProfileDAI;
import com.example.persistence.models.Profile;
import com.example.persistence.utilities.PostgresConnectionUtility;

public class PostgresProfileDAO implements ProfileDAI
{
  private static final Logger logger = LoggerFactory.getLogger(PostgresProfileDAO.class);
  
  private static final String REGISTER_PROFILE = """
    INSERT INTO profiles (id, name, username, password, accountID, profilePictureURL)
    VALUES (?, ?, ?, ?, ?, ?);
    """
  ;

  @Override
  public boolean registerProfile(Profile profile) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(REGISTER_PROFILE);
    ) {
      statement.setString(1, profile.getID());
      statement.setString(2, profile.getName());
      statement.setString(3, profile.getUsername());
      statement.setString(4, profile.getPassword());
      statement.setString(5, profile.getAccountID());
      statement.setString(6, profile.getProfilePictureURL());
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Registering Profile", e);
      return false;
    }
  }

  private static final String GET_PROFILE_BY_ID = """
    SELECT id, name, username, password, accountID, profilePictureURL
    FROM profiles
    WHERE id = ?;
    """
  ;

  @Override
  public Profile getProfileByID(String id) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(GET_PROFILE_BY_ID);
    ) {
      statement.setObject(1, id);
      try (ResultSet rs = statement.executeQuery()) {
        if (!rs.next()) { return null; }
        else {
          return Profile.construct(
            rs.getString("id"),
            rs.getString("name"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("accountID"),
            rs.getString("profilePictureURL")
          );
        }
      }
    }
    catch (SQLException e) {
      logger.error("Error Getting Profile by ID", e);
      return null;
    }
  }

  private static final String GET_PROFILE_BY_USERNAME = """
    SELECT id, name, username, password, accountID
    FROM profiles
    WHERE username = ?;
    """
  ;

  @Override
  public Profile getProfileByUsername(String username) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(GET_PROFILE_BY_USERNAME);
    ) {
      statement.setString(1, username);
      try (ResultSet rs = statement.executeQuery()) {
        if (!rs.next()) { return null; }
        else {
          return Profile.construct(
            rs.getString("id"),
            rs.getString("name"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("accountID"),
            rs.getString("profilePictureURL")
          );
        }
      }
    }
    catch (SQLException e) {
      logger.error("Error Getting Profile by Username", e);
      return null;
    }
  }

  private static final String UPDATE_NAME = """
    UPDATE profiles
    SET name = ?
    WHERE id = ?;
    """
  ;
  
  @Override
  public boolean updateName(String id, String name) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(UPDATE_NAME);
    ) {
      statement.setString(1, name);
      statement.setString(2, id);
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Updating Profile Name", e);
      return false;
    }
  }

  private static final String DELETE_PROFILE = """
    DELETE FROM profiles
    WHERE id = ?;
    """
  ;

  @Override
  public boolean deleteProfile(String id) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(DELETE_PROFILE);
    ) {
      statement.setString(1, id);
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Deleting Profile", e);
      return false;
    }
  }
}
