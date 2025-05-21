package com.example.data.access.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.data.access.interfaces.ProfileDAI;
import com.example.data.models.Profile;
import com.example.data.utilities.PostgresConnectionUtility;

public class PostgresProfileDAO implements ProfileDAI
{
  private static final Logger logger = LoggerFactory.getLogger(PostgresProfileDAO.class);
  
  private static final String REGISTER_PROFILE = """
    INSERT INTO profiles (id, name, username, password, accountID)
    VALUES (?, ?, ?, ?, ?);
    """
  ;
  private static final String GET_PROFILE_BY_ID = """
    SELECT id, name, username, password, accountID
    FROM profiles
    WHERE id = ?;
    """
  ;
  private static final String GET_PROFILE_BY_USERNAME = """
    SELECT id, name, username, password, accountID
    FROM profiles
    WHERE username = ?;
    """
  ;
  private static final String UPDATE_NAME = """
    UPDATE profiles
    SET name = ?
    WHERE id = ?;
    """
  ;
  private static final String DELETE_PROFILE = """
    DELETE FROM profiles
    WHERE id = ?;
    """
  ;

  @Override
  public boolean registerProfile(Profile profile) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(REGISTER_PROFILE);
    ) {
      statement.setObject(1, profile.getID());
      statement.setString(2, profile.getName());
      statement.setString(3, profile.getUsername());
      statement.setString(4, profile.getPassword());
      statement.setObject(5, profile.getAccountID());
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Registering Profile", e);
      return false;
    }
  }

  @Override
  public Profile getProfileByID(UUID id) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(GET_PROFILE_BY_ID);
    ) {
      statement.setObject(1, id);
      try (ResultSet rs = statement.executeQuery()) {
        if (!rs.next()) { return null; }
        else {
          return Profile.construct(
            (UUID) rs.getObject("id"),
            rs.getString("name"),
            rs.getString("username"),
            rs.getString("password"),
            (UUID) rs.getObject("accountID")
          );
        }
      }
    }
    catch (SQLException e) {
      logger.error("Error Getting Profile by ID", e);
      return null;
    }
  }

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
            (UUID) rs.getObject("id"),
            rs.getString("name"),
            rs.getString("username"),
            rs.getString("password"),
            (UUID) rs.getObject("accountID")
          );
        }
      }
    }
    catch (SQLException e) {
      logger.error("Error Getting Profile by Username", e);
      return null;
    }
  }
  
  @Override
  public boolean updateName(UUID id, String name) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(UPDATE_NAME);
    ) {
      statement.setString(1, name);
      statement.setObject(2, id);
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Updating Profile Name", e);
      return false;
    }
  }

  @Override
  public boolean deleteProfile(UUID id) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(DELETE_PROFILE);
    ) {
      statement.setObject(1, id);
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Deleting Profile", e);
      return false;
    }
  }
}
