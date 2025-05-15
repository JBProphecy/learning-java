package com.example.persistence.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.persistence.interfaces.ProfileDAI;
import com.example.persistence.models.Profile;
import com.example.persistence.utils.PostgresConnectionUtility;

public class PostgresProfileDAO implements ProfileDAI
{
  private static final Logger logger = LoggerFactory.getLogger(PostgresProfileDAO.class);
  
  private static final String REGISTER_PROFILE = """
    INSERT INTO profiles (id, name, username, password)
    VALUES (?, ?, ?, ?);
    """;
  public boolean registerProfile(Profile profile) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(REGISTER_PROFILE);
    ) {
      statement.setObject(1, profile.getID());
      statement.setString(2, profile.getName());
      statement.setString(3, profile.getUsername());
      statement.setString(4, profile.getPassword());
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Registering Profile", e);
      return false;
    }
  }

  private static final String GET_PROFILE_BY_ID = """
    SELECT id, name, username, password
    FROM profiles
    WHERE id = ?;
    """;
  public Profile getProfileByID(UUID id) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(GET_PROFILE_BY_ID);
    ) {
      statement.setObject(1, id);
      try (ResultSet rs = statement.executeQuery()) {
        if (!rs.next()) { return null; }
        else {
          return new Profile(
            (UUID) rs.getObject("id"),
            rs.getString("name"),
            rs.getString("username"),
            rs.getString("password")
          );
        }
      }
    }
    catch (SQLException e) {
      logger.error("Error Getting Profile", e);
      return null;
    }
  }

  private static final String UPDATE_NAME_BY_ID = """
    UPDATE profiles
    SET name = ?
    WHERE id = ?;
    """;
  public boolean updateNameByID(UUID id, String name) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(UPDATE_NAME_BY_ID);
    ) {
      statement.setString(1, name);
      statement.setObject(2, id);
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Updating Name by ID", e);
      return false;
    }
  }

  private static final String UPDATE_NAME_BY_USERNAME = """
    UPDATE profiles
    SET name = ?
    WHERE username = ?;
    """;
  public boolean updateNameByUsername(String username, String name) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(UPDATE_NAME_BY_USERNAME);
    ) {
      statement.setString(1, name);
      statement.setString(2, username);
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Updating Name by Username", e);
      return false;
    }
  }

  private static final String DELETE_PROFILE_BY_ID = """
    DELETE FROM profiles
    WHERE id = ?;
    """;
  public boolean deleteProfileByID(UUID id) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(DELETE_PROFILE_BY_ID);
    ) {
      statement.setObject(1, id);
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Deleting Profile by ID", e);
      return false;
    }
  }

  private static final String DELETE_PROFILE_BY_USERNAME = """
    DELETE FROM profiles
    WHERE username = ?;
    """;
  public boolean deleteProfileByUsername(String username) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(DELETE_PROFILE_BY_USERNAME);
    ) {
      statement.setString(1, username);
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Deleting Profile by Username", e);
      return false;
    }
  }
}
