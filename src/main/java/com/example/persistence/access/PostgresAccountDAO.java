package com.example.persistence.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.persistence.interfaces.AccountDAI;
import com.example.persistence.models.Account;
import com.example.persistence.utils.PostgresConnectionUtility;

public class PostgresAccountDAO implements AccountDAI {
  private static final String INSERT_ACCOUNT = """
    INSERT INTO accounts (name, email, password)
    VALUES (?, ?, ?);
    """;
  private static final String DELETE_ACCOUNT_BY_EMAIL = """
    DELETE FROM accounts
    WHERE email = ?;
    """;
  private static final String CHANGE_NAME_BY_ID = """
    UPDATE accounts
    SET name = ?
    WHERE id = ?;
    """;
  private static final String CHANGE_NAME_BY_EMAIL = """
    UPDATE accounts
    SET name = ?
    WHERE email = ?;
    """;
  
  public boolean changeNameByID(String id, String name) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(CHANGE_NAME_BY_ID);
    ) {
      statement.setString(1, name);
      statement.setString(2, id);
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) { e.printStackTrace(); return false; }
  }

  public boolean changeNameByEmail(String email, String name) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(CHANGE_NAME_BY_EMAIL);
    ) {
      statement.setString(1, name);
      statement.setString(2, email);
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) { e.printStackTrace(); return false; }
  }
  
  public boolean insertAccount(Account account) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(INSERT_ACCOUNT);
    ) {
      statement.setString(1, account.getName());
      statement.setString(2, account.getEmail());
      statement.setString(3, account.getPassword());
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) { e.printStackTrace(); return false; }
  }

  public boolean deleteAccountByEmail(String email) {
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(DELETE_ACCOUNT_BY_EMAIL);
    ) {
      statement.setString(1, email);
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) { e.printStackTrace(); return false; }
  }
}
