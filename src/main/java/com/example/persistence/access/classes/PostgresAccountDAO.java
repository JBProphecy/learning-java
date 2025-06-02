package com.example.persistence.access.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.persistence.access.interfaces.AccountDAI;
import com.example.persistence.models.Account;
import com.example.persistence.utilities.PostgresConnectionUtility;

public class PostgresAccountDAO implements AccountDAI
{
  private static final Logger logger = LoggerFactory.getLogger(PostgresAccountDAO.class);

  private static final String REGISTER_ACCOUNT = """
    INSERT INTO accounts (id, name, email, password)
    VALUES (?, ?, ?, ?);
    """
  ;

  @Override
  public boolean registerAccount(Account account) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(REGISTER_ACCOUNT);
    ) {
      statement.setString(1, account.getID());
      statement.setString(2, account.getName());
      statement.setString(3, account.getEmail());
      statement.setString(4, account.getPassword());
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Registering Account", e);
      return false;
    }
  }

  private static final String GET_ACCOUNT_BY_ID = """
    SELECT id, name, email, password
    FROM accounts
    WHERE id = ?;
    """
  ;

  @Override
  public Account getAccountByID(String id) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(GET_ACCOUNT_BY_ID);
    ) {
      statement.setObject(1, id);
      try (ResultSet rs = statement.executeQuery()) {
        if (!rs.next()) { return null; }
        else {
          return Account.construct(
            rs.getString("id"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("password")
          );
        }
      }
    }
    catch (SQLException e) {
      logger.error("Error Getting Account by ID", e);
      return null;
    }
  }

  private static final String GET_ACCOUNT_BY_EMAIL = """
    SELECT id, name, email, password
    FROM accounts
    WHERE email = ?;
    """
  ;

  @Override
  public Account getAccountByEmail(String email) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(GET_ACCOUNT_BY_EMAIL);
    ) {
      statement.setString(1, email);
      try (ResultSet rs = statement.executeQuery()) {
        if (!rs.next()) { return null; }
        else {
          return Account.construct(
            rs.getString("id"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("password")
          );
        }
      }
    }
    catch (SQLException e) {
      logger.error("Error Getting Account by Email", e);
      return null;
    }
  }

  private static final String UPDATE_NAME = """
    UPDATE accounts
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
      logger.error("Error Updating Account Name", e);
      return false;
    }
  }

  private static final String DELETE_ACCOUNT = """
    DELETE FROM accounts
    WHERE id = ?;
    """
  ;

  @Override
  public boolean deleteAccount(String id) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(DELETE_ACCOUNT);
    ) {
      statement.setString(1, id);
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Deleting Account", e);
      return false;
    }
  }
}
