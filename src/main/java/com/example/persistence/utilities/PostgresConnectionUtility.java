package com.example.persistence.utilities;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostgresConnectionUtility
{
  private static final Logger logger = LoggerFactory.getLogger(PostgresConnectionUtility.class);

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
      logger.error("Error Getting Postgres Connection", e);
      throw new RuntimeException("Failed to Load Database Properties", e);
    }
  }

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, username, password);
  }
}
