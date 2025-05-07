package com.example.persistence.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnectionUtility {
  private static String url;
  private static String username;
  private static String password;

  static {
    try (InputStream input = PostgresConnectionUtility.class.getClassLoader().getResourceAsStream("db-local.properties")) {
      Properties props = new Properties();
      props.load(input);
      url = System.getenv(props.getProperty("db.url.env.key"));
      username = System.getenv(props.getProperty("db.username.env.key"));
      password = System.getenv(props.getProperty("db.password.env.key"));
    }
    catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("failed to load database properties", e);
    }
  }

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, username, password);
  }
}
