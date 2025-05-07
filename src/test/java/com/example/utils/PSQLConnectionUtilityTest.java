package com.example.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.example.persistence.utils.PostgresConnectionUtility;

public class PSQLConnectionUtilityTest
{
  @Test
  public void getConnection_Test01() {
    try {
      Connection connection = PostgresConnectionUtility.getConnection();
      assertNotNull(connection);
      assertTrue(connection.isValid(2));
    }
    catch (SQLException e) {
      fail("database connection failed: " + e.getMessage());
    }
  }
}
